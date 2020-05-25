package com.api.service.impl;

import com.api.dao.TCompanyMapper;
import com.api.dao.TCompanyUserMapper;
import com.api.entity.TCompany;
import com.api.entity.TCompanyCriteria;
import com.api.entity.TCompanyUser;
import com.api.service.CompanyService;
import com.api.util.MD5Util;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 16:322018-9-14
 * @Modified By:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private  static final Logger logger= LoggerFactory.getLogger(CompanyServiceImpl.class);
    @Autowired
    private TCompanyMapper tCompanyMapper;
    @Autowired
    private TCompanyUserMapper tCompanyUserMapper;
   /* @Autowired
    private CarParkService carParkService;*/
    /**
     * 设置查询条件
     * @param tCompany
     * @return
     */
    private TCompanyCriteria setCriteria(TCompany tCompany){
        TCompanyCriteria tCompanyCriteria= new TCompanyCriteria();
        if(tCompany!=null){
            TCompanyCriteria.Criteria criteria=tCompanyCriteria.createCriteria();
            if(tCompany.getCompanyName()!=null)
            {
                criteria.andCompanyNameLike("%"+tCompany.getCompanyName()+"%");
            }
            if(tCompany.getCompanyType()!=null)
            {
                criteria.andCompanyTypeEqualTo(tCompany.getCompanyType());
            }
            if(tCompany.getStatus()!=null)
            {
                criteria.andStatusEqualTo(tCompany.getStatus());
            }
            if(tCompany.getId()!=null)
            {
                criteria.andIdEqualTo(tCompany.getId());
            }
        }
        return  tCompanyCriteria;
    }
    /**
     * 获取数据总量
     * @param tCompany
     * @return
     */
    private Integer getCount(TCompany tCompany){
        Integer total =(int)tCompanyMapper.countByExample(setCriteria(tCompany));
        return total;
    }
    /**
     *查询物业信息(分页)
     * @param tCompany
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TCompany> getCompanybyPage(TCompany tCompany, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCompany> tCompanyList=getCompany(tCompany);
        Integer countNums =getCount(tCompany);
        PageBean<TCompany> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tCompanyList);
        return pageData;
    }
    /**
     * 查询全部物业信息
     * @return
     */
    public List<TCompany> getCompany(TCompany tCompany){
        List<TCompany> tCompanyList=tCompanyMapper.selectByExample(setCriteria(tCompany));
        return tCompanyList;
    }
    /**
     * 查询是否存在重复物业信息
     * @return
     */
    public List<TCompany> getCompanyDistnict(TCompany tCompany){

        TCompanyCriteria tCompanyCriteria= new TCompanyCriteria();
        if(tCompany!=null){
            TCompanyCriteria.Criteria criteria=tCompanyCriteria.createCriteria();
            if(tCompany.getAccount()!=null)
            {
                criteria.andAccountEqualTo(tCompany.getAccount());
            }
            if(tCompany.getId()!=null)
            {
                criteria.andIdNotEqualTo(tCompany.getId());
            }
        }
        List<TCompany> tCompanyList=tCompanyMapper.selectByExample(tCompanyCriteria);
        return tCompanyList;
    }
    /**
     * 更新物业信息
     * @param tCompany
     * @return
     */
    @PostMapping(value = "/updateComPany")
    public String UpdateComPany(TCompany tCompany)
    {
        logger.info(tCompany.toString());
        String result="";
        try{
            List<TCompany> tCompanyList=getCompanyDistnict(tCompany);
            if(tCompanyList.size()==0){
                //修改
                if(tCompany.getId()!=null){
                    tCompanyMapper.updateByPrimaryKeySelective(tCompany);
                }
                else
                {
                    //新增物业公司信息只可能是系统管理员
                    tCompanyMapper.insertSelective(tCompany);
                    //得到新增后的公司信息
                    TCompany tCompanyRes=getCompanyDistnict(tCompany).get(0);
                    //实例化物业管理员
                    TCompanyUser user=new TCompanyUser();
                    user.setCompanyId(tCompanyRes.getId());
                    user.setRoleId(1);
                    user.setUserName(tCompanyRes.getCompanyName());
                    user.setUserAccout(tCompanyRes.getAccount());
                    user.setPassword(MD5Util.MD5Encode(tCompanyRes.getPassword()));
                    user.setParentUser(0);
                    user.setIsAdmin("0");
                  /*  //查询该物业下所有的车场信息
                    TCompanyPark companyPark=new TCompanyPark();
                    companyPark.setCompanyId(tCompanyRes.getId());
                    String ParkIds="";
                    List<TCompanyPark> tCompanyParkList=carParkService.getCarPark(companyPark);
                    if(tCompanyParkList!=null)
                    {
                        for (TCompanyPark park:tCompanyParkList) {
                            ParkIds+=park.getId()+",";
                        }
                    }
                    user.setParkIds(ParkIds);//管理员拥有该物业下所有的车场权限*/
                    tCompanyUserMapper.insertSelective(user);
                }
                result="更新成功";
            }
            else
            {
                result="更新失败,物业信息重复";

            }
        }
        catch (Exception e)
        {

        }



        return result;
    }

    /**
     * 删除物业信息
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteComPany")
    public String DeleteComPany(Integer id){
        tCompanyMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    @Override
    public TCompany getCompanyById(Integer id) {
        return tCompanyMapper.selectByPrimaryKey(id);
    }
}
