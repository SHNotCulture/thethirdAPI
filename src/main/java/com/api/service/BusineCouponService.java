package com.api.service;

import com.api.entity.BusineCouponGetTicketInfo;
import com.api.entity.BusineCouponUpload;
import com.api.entity.MQTTResult.PrePayCoupon;
import com.api.entity.MQTTResult.TheThirdCoupon;

import java.util.Map;

public interface BusineCouponService {
    /**
    * @Description:根据data里的参数查询优惠券详情
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/4/11
    */
    String  getElectronicTicket(BusineCouponGetTicketInfo busineCouponGetTicketInfo);
    /** 
    * @Description: 下发优惠
    * @Param:  
    * @return:  
    * @Author: jin
    * @Date: 2019/4/14 
    */ 
    String transferBusineCoupon(BusineCouponUpload busineCouponUpload);
    String getTBusineTicket(Map mapData);
    /**
     *  获取海口会员优惠并下发
     */
    String SendTheThirdCoupon(TheThirdCoupon theThirdCoupon);

    /**
     *第三方预缴优惠作为会员优惠下发
     * @param prePayCoupon
     * @return
     */
    String SendPrePayCoupon(PrePayCoupon prePayCoupon);

    /**
     * 手动发送代缴优惠任务
     * @param parkId
     * @return
     */
    String SendCoupon(Integer parkId);
}
