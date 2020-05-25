package com.api.enums;

/**
 * @Author lishuhan
 * @Description:统一返回格式枚举
 * @Date Create in 17:192018-5-9
 * @Modified By:
 */
public enum ActionRspEnum {
    UNKONW_ERROR(-1,"UNKONW_ERROR"),
    SUCCESS(0,"SUCCESS"),
    FORMAT_ERROR(1,"参数格式错误"),
    HTTP_ERROR(2,"上传进出场信息失败"),
    PAY_ERROR(3,"PAY_ERROR"),
    In_ERROR(4,"入场失败,此车牌已入场"),
    Out_ERROR(5,"出场失败,此车牌已出场"),
    Login_ERROR(6,"登录失败,请检查用户名或密码是否正确"),
    Code_ERROR(7,"验证码不正确"),
    Reset_ERROR1(8,"重置密码错误,原始密码不正确"),
    Reset_ERROR2(9,"重置密码错误,二次密码错误"),
    Execl_ERROR(10,"导入execl出错"),
    Execl_ERROR1(11,"导入execl格式出错"),
    SESSION_OUT(12,"Session超时,请重新登录"),
    Permission_ERROR(13,"该物业公司权限不足，请联系管理员"),
    REPETITION_ERROR(14,"车牌已存在"),
    LICENSE_ERROR(15,"key is unlawful"),
    PARK_ERROR(16,"非系统车场"),
    CLOUDDATA_ERROR(17,"cloud传输数据不存在"),
    PARKCAR_ERROR(18,"车牌为月租车，不能下发优惠"),
    QRCODEInvalid_ERROR(19,"优惠失败,该二维码已失效"),
    ExistedCoupon_ERROR(20,"已下发了优惠,此次优惠无效"),
    Free_ERROR(21,"已下发全免优惠，此优惠无效"),
    MoreCoupon_ERROR(22,"已下发更大或相等优惠，此优惠无效"),
    InsufficientTicket_ERROR(23,"余票不足"),
    InsufficientBalance_ERROR(24,"商户余额不足"),
    HouseholdCheck_ERROR(25,"申请住户审核失败"),
    HouseholdBill_ERROR(26,"接收住户账单支付信息失败"),
    HouseholdFeedback_ERROR(27,"接收住户意见反馈失败")
    ;
    private Integer code;
    private String message;

    ActionRspEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
