package com.api.service.impl;


import com.api.dao.TPropertyHouseholdInfoMapper;
import com.api.entity.TPropertyHouseholdInfo;
import com.api.entity.TPropertyHouseholdInfoCriteria;
import com.api.entity.carOwer.HouseholdCheckRequest;
import com.api.enums.ActionRspEnum;
import com.api.exception.ActionRspException;
import com.api.service.PropertyHouseholdInfoService;
import com.api.util.BeanCopyUtil;
import com.api.util.DateUtil;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyHouseholdInfoServiceImpl implements PropertyHouseholdInfoService {
    private  static final Logger logger= LoggerFactory.getLogger(PropertyHouseholdInfoServiceImpl.class);
    @Autowired
    private TPropertyHouseholdInfoMapper tPropertyHouseholdInfoMapper;
    /**
     * 设置查询条件
     * @param tPropertyHouseholdInfo
     * @return
     */
    private TPropertyHouseholdInfoCriteria setCriteria(TPropertyHouseholdInfo tPropertyHouseholdInfo){
        TPropertyHouseholdInfoCriteria tPropertyHouseholdInfoCriteria= new TPropertyHouseholdInfoCriteria();
        if(tPropertyHouseholdInfo!=null){
            TPropertyHouseholdInfoCriteria.Criteria criteria=tPropertyHouseholdInfoCriteria.createCriteria();
            if(tPropertyHouseholdInfo.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tPropertyHouseholdInfo.getCompanyId());
            }
            if(tPropertyHouseholdInfo.getParkId()!=null){
                criteria.andParkIdEqualTo(tPropertyHouseholdInfo.getParkId());
            }
            if(tPropertyHouseholdInfo.getMemberId()!=null){
                criteria.andMemberIdEqualTo(tPropertyHouseholdInfo.getMemberId());
            }

        }
        return  tPropertyHouseholdInfoCriteria;
    }
    /**
     * 获取数据总量
     * @param tPropertyHouseholdInfo
     * @return
     */
    private Integer getCount(TPropertyHouseholdInfo tPropertyHouseholdInfo){
        Integer total =(int)tPropertyHouseholdInfoMapper.countByExample(setCriteria(tPropertyHouseholdInfo));
        return total;
    }
    /**
     *查询住户信息(分页)
     * @param tPropertyHouseholdInfo
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TPropertyHouseholdInfo> getPropertyHouseholdInfobyPage(TPropertyHouseholdInfo tPropertyHouseholdInfo, Integer page, Integer limit){
            PageHelper.startPage(page, limit,"id desc");
        List<TPropertyHouseholdInfo> tPropertyHouseholdInfos=getPropertyHouseholdInfo(tPropertyHouseholdInfo);
        Integer countNums =getCount(tPropertyHouseholdInfo);
        PageBean<TPropertyHouseholdInfo> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tPropertyHouseholdInfos);
        return pageData;
    }
    /**
     * 查询全部住户信息
     * @return
     */
    public List<TPropertyHouseholdInfo> getPropertyHouseholdInfo(TPropertyHouseholdInfo tPropertyHouseholdInfo){
        List<TPropertyHouseholdInfo> tPropertyHouseholdInfos=tPropertyHouseholdInfoMapper.selectByExample(setCriteria(tPropertyHouseholdInfo));
        return tPropertyHouseholdInfos;
    }
    /**
     * 更新住户信息
     * @param tPropertyHouseholdInfo
     * @return
     */
    public String UpdatePropertyHouseholdInfo(TPropertyHouseholdInfo tPropertyHouseholdInfo)
    {
        String result="";
        try{
            if(tPropertyHouseholdInfo.getId()!=null){
                tPropertyHouseholdInfoMapper.updateByPrimaryKeySelective(tPropertyHouseholdInfo);
            }
            else
            {
                tPropertyHouseholdInfoMapper.insertSelective(tPropertyHouseholdInfo);
            }
        }
        catch (Exception e)
        {

        }
        result="更新成功";


        return result;
    }

    /**
     * 接收住户审核信息
     * @param householdCheckRequest
     * @return
     */
    public String HouseholdCheck(HouseholdCheckRequest householdCheckRequest){
        String result="";
        try{
            if(householdCheckRequest!=null){
                TPropertyHouseholdInfo tPropertyHouseholdInfo=new TPropertyHouseholdInfo();
                tPropertyHouseholdInfo= (TPropertyHouseholdInfo)BeanCopyUtil.CopyBeanToBean(householdCheckRequest,tPropertyHouseholdInfo);
                if(getPropertyHouseholdInfo(tPropertyHouseholdInfo).size()==0){
                    tPropertyHouseholdInfo.setIsAuditing(0);
                    tPropertyHouseholdInfo.setCreateTime(DateUtil.getCurrDateTime());
                     if(UpdatePropertyHouseholdInfo(tPropertyHouseholdInfo).equals("更新成功")){
                         result="申请住户审核成功！待审核";
                    }else{
                         throw  new ActionRspException(ActionRspEnum.HouseholdCheck_ERROR);
                     }

                }
                else{
                    throw  new ActionRspException(ActionRspEnum.HouseholdCheck_ERROR);
                }
            }
        }catch (Exception e){
            logger.info("申请住户审核异常,异常原因："+e.toString());
            throw  new ActionRspException(ActionRspEnum.HouseholdCheck_ERROR);
        }
            return  result;
    }

    /**
     * 删除住户信息
     * @param id
     * @return
     */
    public String DeletePropertyHouseholdInfo(Integer id){
        tPropertyHouseholdInfoMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 根据ID查询住户账单
     * @param id
     * @return
     */
    public TPropertyHouseholdInfo getPropertyHouseholdInfoByID(Integer id) {
        return tPropertyHouseholdInfoMapper.selectByPrimaryKey(id);
    }
}
