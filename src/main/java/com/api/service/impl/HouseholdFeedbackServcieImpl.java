package com.api.service.impl;

import com.api.dao.THouseholdFeedbackMapper;
import com.api.entity.*;
import com.api.entity.carOwer.HouseholdFeedbackRequest;
import com.api.enums.ActionRspEnum;
import com.api.exception.ActionRspException;
import com.api.service.HouseholdFeedbackServcie;
import com.api.service.PropertyHouseholdInfoService;
import com.api.util.BeanCopyUtil;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdFeedbackServcieImpl implements HouseholdFeedbackServcie {
    private  static final Logger logger= LoggerFactory.getLogger(HouseholdFeedbackServcieImpl.class);
    @Autowired
    private PropertyHouseholdInfoService propertyHouseholdInfoService;
    @Autowired
    private THouseholdFeedbackMapper tHouseholdFeedbackMapper;
    /**
     * 设置查询条件
     * @param tHouseholdFeedback
     * @return
     */
    private THouseholdFeedbackCriteria setCriteria(THouseholdFeedback tHouseholdFeedback){
        THouseholdFeedbackCriteria tHouseholdFeedbackCriteria= new THouseholdFeedbackCriteria();
        if(tHouseholdFeedback!=null){
            THouseholdFeedbackCriteria.Criteria criteria=tHouseholdFeedbackCriteria.createCriteria();
            if(tHouseholdFeedback.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tHouseholdFeedback.getCompanyId());
            }
            if(tHouseholdFeedback.getParkId()!=null){
                criteria.andParkIdEqualTo(tHouseholdFeedback.getParkId());
            }
            if(tHouseholdFeedback.getMemberId()!=null){
                criteria.andMemberIdEqualTo(tHouseholdFeedback.getMemberId());
            }
        }
        return  tHouseholdFeedbackCriteria;
    }
    /**
     * 获取数据总量
     * @param tHouseholdFeedback
     * @return
     */
    private Integer getCount(THouseholdFeedback tHouseholdFeedback){
        Integer total =(int)tHouseholdFeedbackMapper.countByExample(setCriteria(tHouseholdFeedback));
        return total;
    }
    /**
     *查询意见反馈(分页)
     * @param tHouseholdFeedback
     * @param page
     * @param limit
     * @return
     */
    public PageBean<THouseholdFeedback> getHouseholdFeedbackbyPage(THouseholdFeedback tHouseholdFeedback, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<THouseholdFeedback> tHouseholdFeedbacks=getHouseholdFeedback(tHouseholdFeedback);
        Integer countNums =getCount(tHouseholdFeedback);
        PageBean<THouseholdFeedback> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tHouseholdFeedbacks);
        return pageData;
    }
    /**
     * 查询全部意见反馈
     * @return
     */
    public List<THouseholdFeedback> getHouseholdFeedback(THouseholdFeedback tHouseholdFeedback){
        List<THouseholdFeedback> tHouseholdFeedbackList=tHouseholdFeedbackMapper.selectByExample(setCriteria(tHouseholdFeedback));
        return tHouseholdFeedbackList;
    }
    /**
     * 更新意见反馈
     * @param tHouseholdFeedback
     * @return
     */
    public String UpdateHouseholdFeedback(THouseholdFeedback tHouseholdFeedback)
    {
        String result="";
        try{
            if(tHouseholdFeedback.getId()!=null){
                tHouseholdFeedbackMapper.updateByPrimaryKeySelective(tHouseholdFeedback);
            }
            else
            {
                tHouseholdFeedbackMapper.insertSelective(tHouseholdFeedback);
            }
        }
        catch (Exception e)
        {

        }
        result="更新成功";


        return result;
    }
    public String HouseholdFeedback(HouseholdFeedbackRequest householdFeedbackRequest){
        String result="";
        try {
            if(householdFeedbackRequest!=null){
                THouseholdFeedback tHouseholdFeedback=new THouseholdFeedback();
                TPropertyHouseholdInfo tPropertyHouseholdInfo=new TPropertyHouseholdInfo();
                tPropertyHouseholdInfo= (TPropertyHouseholdInfo)BeanCopyUtil.CopyBeanToBean(householdFeedbackRequest,tPropertyHouseholdInfo);
                if(propertyHouseholdInfoService.getPropertyHouseholdInfo(tPropertyHouseholdInfo).size()!=0){
                    tHouseholdFeedback=(THouseholdFeedback)BeanCopyUtil.CopyBeanToBean(householdFeedbackRequest,tHouseholdFeedback);
                    if(UpdateHouseholdFeedback(tHouseholdFeedback).equals("更新成功")){
                        result="接收住户意见反馈成功！";
                    }else{
                        throw  new ActionRspException(ActionRspEnum.HouseholdFeedback_ERROR);
                    }

                }
                else{
                    throw  new ActionRspException(ActionRspEnum.HouseholdFeedback_ERROR);
                }
            }
        }catch (Exception e){
            logger.info("接收住户意见反馈信息失败，失败原因："+e.toString());
            throw  new ActionRspException(ActionRspEnum.HouseholdFeedback_ERROR);
        }
        return result;
    }

    /**
     * 删除意见反馈
     * @param id
     * @return
     */
    public String DeleteHouseholdFeedback(Integer id){
        tHouseholdFeedbackMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 根据ID查询意见反馈
     * @param id
     * @return
     */
    public THouseholdFeedback getHouseholdFeedbackByID(Integer id) {
        return tHouseholdFeedbackMapper.selectByPrimaryKey(id);
    }
}
