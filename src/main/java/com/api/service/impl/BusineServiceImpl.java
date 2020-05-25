package com.api.service.impl;

import com.api.dao.TBusineMapper;
import com.api.dao.TBusinePayMapper;
import com.api.dao.TCompanyParkMapper;
import com.api.entity.*;
import com.api.service.BusineService;
import com.api.service.UserService;
import com.api.util.DateUtil;
import com.api.util.MD5Util;
import com.api.util.PageBean;
import com.api.util.StringUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 17:372018-9-14
 * @Modified By:
 */
@Service
public class BusineServiceImpl implements BusineService {
    private  static final Logger logger= LoggerFactory.getLogger(BusineServiceImpl.class);
    @Autowired
    private TBusineMapper tBusineMapper;
    @Autowired
    private TBusinePayMapper tBusinePayMapper;
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;

    @Autowired
    private UserService userService;

    /**
     * 设置查询条件
     * @param tBusine
     * @return
     */
    private TBusineCriteria setCriteria(TBusine tBusine){
        TBusineCriteria tBusineCriteria= new TBusineCriteria();
        if(tBusine!=null){
            TBusineCriteria.Criteria criteria=tBusineCriteria.createCriteria();
            if(tBusine.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tBusine.getParkId());
            }
            if(tBusine.getBusineName()!=null)
            {
                criteria.andBusineNameLike("%"+tBusine.getBusineName()+"%");
            }
            if(tBusine.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tBusine.getCompanyId());
            }
            if(tBusine.getId()!=null)
            {
                criteria.andIdEqualTo(tBusine.getId());
            }

        }
        return  tBusineCriteria;
    }
    /**
     * 获取数据总量
     * @param tBusine
     * @return
     */
    private Integer getCount(TBusine tBusine){
        Integer total =(int)tBusineMapper.countByExample(setCriteria(tBusine));
        return total;
    }
    /**
     * 查询商户信息(分页)
     * @return
     */
    @Override
    public PageBean<TBusine> getBusinebyPage(TBusine tBusine, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TBusine> tBusineList=getBusine(tBusine);
        Integer countNums =getCount(tBusine);
        PageBean<TBusine> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tBusineList);
        return pageData;
    }
    /**
     * 查询商户信息
     * @return
     */
    @Override
    public List<TBusine> getBusine(TBusine tBusine){
        List<TBusine> tBusineList=tBusineMapper.selectByExample(setCriteria(tBusine));
        return tBusineList;
    }


    /**
     * 更新商户信息
     * @param tBusine
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public String UpdateBusine(TBusine tBusine)
    {
        logger.info(tBusine.toString());
        TCompanyUser tCompanyUser=null;
        if(tBusine.getId()!=null){
            tBusineMapper.updateByPrimaryKeySelective(tBusine);
            TCompanyUser user= new TCompanyUser();
            user.setUserAccout(tBusine.getAccount());
            user.setEntityType(2);
            user.setIsAdmin("3");
            List<TCompanyUser> userList=userService.getCompanyUser(user);
            if(userList.size()>0){
                tCompanyUser=userList.get(0);
            }

        }
        else
        {
            tBusine.setPassword(MD5Util.MD5Encode("123456"));
            tBusineMapper.insertSelective(tBusine);
            tCompanyUser= new TCompanyUser();

        }
        if(tCompanyUser!=null)
        {
            tCompanyUser.setRoleId(0);
            tCompanyUser.setParkIds(tBusine.getParkId().toString());
            tCompanyUser.setUserName(tBusine.getBusineName());
            tCompanyUser.setUserAccout(tBusine.getAccount());
            tCompanyUser.setPassword(tBusine.getPassword());
            tCompanyUser.setCompanyId(tBusine.getCompanyId());
            tCompanyUser.setIsAdmin("3");
            tCompanyUser.setEntityType(2);
            userService.UpdateCompanyUser(tCompanyUser);
        }

        return "更新成功";
    }

    @Override
    public TBusine selectByPrimaryKey(Integer id) {
        return tBusineMapper.selectByPrimaryKey(id);
    }

    /**
     * 商户充值
     * @param tBusinePay
     * @return
     */
    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public String BusineRecharge(TBusinePay tBusinePay, String type){
        String msg = null;
        TCompanyPark tCompanyPark=tCompanyParkMapper.selectByPrimaryKey(tBusinePay.getParkId());
            //更改商户余额
            TBusine tBusine = tBusineMapper.selectByPrimaryKey(tBusinePay.getBusineId());
        if (type.equals("1")) {//充值
            tBusine.setRemark("充值");
            tBusine.setBalance(tBusine.getBalance() + tBusinePay.getActualPay());
            msg = "充值成功";
        }else if (type.equals("0")){//冲正
            tBusine.setRemark("充正");
            tBusine.setBalance(tBusine.getBalance() - tBusinePay.getActualPay());
            tBusinePay.setActualPay(tBusinePay.getActualPay()*(-1));
            tBusinePay.setNeedPay(tBusinePay.getNeedPay()*(-1));
            msg = "充正成功";
        }
            tBusineMapper.updateByPrimaryKeySelective(tBusine);


        //添加充值记录
        tBusinePay.setParkName(tCompanyPark.getParkName());
        tBusinePay.setOrderNumber(StringUtil.RandomOrder());
        tBusinePay.setPayTime(DateUtil.getCurDateTime());
        tBusinePay.setBalance(tBusine.getBalance());
        tBusinePayMapper.insertSelective(tBusinePay);
        return msg;
    }

    /**
     * 删除商户信息
     * @param id
     * @return
     */
    @Override
    public String DeleteBusine(Integer id){
        tBusineMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }
}
