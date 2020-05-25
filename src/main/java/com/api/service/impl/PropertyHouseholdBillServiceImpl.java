package com.api.service.impl;

import com.api.dao.TPropertyHouseholdBillMapper;
import com.api.entity.*;
import com.api.entity.carOwer.HouseholdBillRequest;
import com.api.enums.ActionRspEnum;
import com.api.exception.ActionRspException;
import com.api.service.PropertyHouseholdBillService;
import com.api.util.BeanCopyUtil;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyHouseholdBillServiceImpl implements PropertyHouseholdBillService {
    private  static final Logger logger= LoggerFactory.getLogger(PropertyHouseholdBillServiceImpl.class);
    @Autowired
    private TPropertyHouseholdBillMapper tPropertyHouseholdBillMapper;
    /**
     * 设置查询条件
     * @param tPropertyHouseholdBill
     * @return
     */
    private TPropertyHouseholdBillCriteria setCriteria(TPropertyHouseholdBill tPropertyHouseholdBill){
        TPropertyHouseholdBillCriteria tPropertyHouseholdBillCriteria= new TPropertyHouseholdBillCriteria();
        if(tPropertyHouseholdBill!=null){
            TPropertyHouseholdBillCriteria.Criteria criteria=tPropertyHouseholdBillCriteria.createCriteria();
            if(tPropertyHouseholdBill.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tPropertyHouseholdBill.getCompanyId());
            }
            if(tPropertyHouseholdBill.getParkId()!=null){
                criteria.andParkIdEqualTo(tPropertyHouseholdBill.getParkId());
            }
            if(tPropertyHouseholdBill.getMemberId()!=null){
                criteria.andMemberIdEqualTo(tPropertyHouseholdBill.getMemberId());
            }
            if(tPropertyHouseholdBill.getBillSn()!=null){
                criteria.andBillSnEqualTo(tPropertyHouseholdBill.getBillSn());
            }
        }
        return  tPropertyHouseholdBillCriteria;
    }
    /**
     * 获取数据总量
     * @param tPropertyHouseholdBill
     * @return
     */
    private Integer getCount(TPropertyHouseholdBill tPropertyHouseholdBill){
        Integer total =(int)tPropertyHouseholdBillMapper.countByExample(setCriteria(tPropertyHouseholdBill));
        return total;
    }
    /**
     *查询住户账单(分页)
     * @param tPropertyHouseholdBill
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TPropertyHouseholdBill> getPropertyHouseholdBillbyPage(TPropertyHouseholdBill tPropertyHouseholdBill, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TPropertyHouseholdBill> tPropertyHouseholdBills=getPropertyHouseholdBill(tPropertyHouseholdBill);
        Integer countNums =getCount(tPropertyHouseholdBill);
        PageBean<TPropertyHouseholdBill> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tPropertyHouseholdBills);
        return pageData;
    }
    /**
     * 查询全部住户账单
     * @return
     */
    public List<TPropertyHouseholdBill> getPropertyHouseholdBill(TPropertyHouseholdBill tPropertyHouseholdBill){
        List<TPropertyHouseholdBill> tPropertyHouseholdBills=tPropertyHouseholdBillMapper.selectByExample(setCriteria(tPropertyHouseholdBill));
        return tPropertyHouseholdBills;
    }
    /**
     * 更新住户账单
     * @param tPropertyHouseholdBill
     * @return
     */
    public String UpdatePropertyHouseholdBill(TPropertyHouseholdBill tPropertyHouseholdBill)
    {
        String result="";
        try{
            if(tPropertyHouseholdBill.getId()!=null){
                tPropertyHouseholdBillMapper.updateByPrimaryKeySelective(tPropertyHouseholdBill);
            }
            else
            {
                tPropertyHouseholdBillMapper.insertSelective(tPropertyHouseholdBill);
            }
        }
        catch (Exception e)
        {

        }
        result="更新成功";


        return result;
    }

    /**
     * 接收住户账单支付信息
     * @param householdBillRequest
     * @return
     */
    public String HouseholdBillget(HouseholdBillRequest householdBillRequest){
        String result="";
        try {
         if(householdBillRequest!=null){
             TPropertyHouseholdBill tPropertyHouseholdBill=new TPropertyHouseholdBill();
             tPropertyHouseholdBill= (TPropertyHouseholdBill) BeanCopyUtil.CopyBeanToBean(householdBillRequest,tPropertyHouseholdBill);
             if(getPropertyHouseholdBill(tPropertyHouseholdBill).size()==1){
                 if(UpdatePropertyHouseholdBill(tPropertyHouseholdBill).equals("更新成功")){
                     result="接收住户账单支付信息成功";
                 }
                 else{
                     throw  new ActionRspException(ActionRspEnum.HouseholdBill_ERROR);
                 }
             }else{
                 throw  new ActionRspException(ActionRspEnum.HouseholdBill_ERROR);
             }
         }
        }catch (Exception e){
            logger.info("接收住户账单支付信息失败，失败原因："+e.toString());
            throw  new ActionRspException(ActionRspEnum.HouseholdBill_ERROR);
        }
        return  result;
    }

    /**
     * 删除住户账单
     * @param id
     * @return
     */
    public String DeletePropertyHouseholdBill(Integer id){
        tPropertyHouseholdBillMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 根据ID查询住户账单
     * @param id
     * @return
     */
    public TPropertyHouseholdBill getPropertyHouseholdBillByID(Integer id) {
        return tPropertyHouseholdBillMapper.selectByPrimaryKey(id);
    }
}
