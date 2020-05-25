package com.api.action;

import com.api.entity.MQTTResult.CarFeeRsp;
import com.api.entity.MQTTResult.TheThirdCoupon;
import com.api.service.BusineCouponService;
import com.api.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "inside")
public class insIdeController {

    @Autowired
    private BusineCouponService busineCouponService;

    /**
     * 下发会员优惠
     * @param theThirdCoupon
     * @return
     */
    @PostMapping(value = "/SendTheThirdCoupon")
    public String SendTheThirdCoupon(@RequestBody TheThirdCoupon theThirdCoupon){
        return busineCouponService.SendTheThirdCoupon(theThirdCoupon);
    }

    /**
     * 接收MQTT传过来的计费信息
     * @param carFeeRsp
     * @return
     */
    @PostMapping(value = "/setCarFeeRsp")
    public String setCarFeeRsp(@RequestBody CarFeeRsp carFeeRsp){
        return SessionUtil.setCarFeeRsp(carFeeRsp);
    }
}
