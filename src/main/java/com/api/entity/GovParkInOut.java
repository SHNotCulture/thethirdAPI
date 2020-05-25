package com.api.entity;

public class GovParkInOut {
    private String id;
    private Integer parkId;
    private Integer carNature;//车主性质（1-会员临停 2-月租车 3-临时车）
    private String inCarPlate;
    private String inTime;
    private Integer inPortId;
    private String inPortName;
    private String inPicPath;
    private String outCarPlate;
    private String outTime;
    private Integer outPortId;
    private String outPortName;
    private String outPicPath;
    private Integer chargeType;//缴费方式（1-电子付费 2-免付费 3-现金）
    private String orderId;
    private Integer ePayType;//电子支付类型1银联权益;2银联卡;3:微信;4支付宝;5无感支付;6云闪付;7etc;8无
    private Double needPay;//应收
    private Double actualPay;//现金
    private Double beforePay;//预缴
    private Double coupon;//代缴
    private Double qpassPay;//聚合
    private String inCarPlateColor;
    private String outCarPlateColor;
    private Integer govInUpFlag;//记录上传标志(1-未上传，2-已上传)
    private Integer govOutUpFlag;//记录上传标志(1-未上传，2-已上传)
    private String occurTime;//记录发生时间

    public String getId() {
        return id;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCarNature() {
        return carNature;
    }

    public void setCarNature(Integer carNature) {
        this.carNature = carNature;
    }

    public String getInCarPlate() {
        return inCarPlate;
    }

    public void setInCarPlate(String inCarPlate) {
        this.inCarPlate = inCarPlate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public Integer getInPortId() {
        return inPortId;
    }

    public void setInPortId(Integer inPortId) {
        this.inPortId = inPortId;
    }

    public String getInPortName() {
        return inPortName;
    }

    public void setInPortName(String inPortName) {
        this.inPortName = inPortName;
    }

    public String getInPicPath() {
        return inPicPath;
    }

    public void setInPicPath(String inPicPath) {
        this.inPicPath = inPicPath;
    }

    public String getOutCarPlate() {
        return outCarPlate;
    }

    public void setOutCarPlate(String outCarPlate) {
        this.outCarPlate = outCarPlate;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getOutPortId() {
        return outPortId;
    }

    public void setOutPortId(Integer outPortId) {
        this.outPortId = outPortId;
    }

    public String getOutPortName() {
        return outPortName;
    }

    public void setOutPortName(String outPortName) {
        this.outPortName = outPortName;
    }

    public String getOutPicPath() {
        return outPicPath;
    }

    public void setOutPicPath(String outPicPath) {
        this.outPicPath = outPicPath;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getePayType() {
        return ePayType;
    }

    public void setePayType(Integer ePayType) {
        this.ePayType = ePayType;
    }

    public Double getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Double needPay) {
        this.needPay = needPay;
    }

    public Double getActualPay() {
        return actualPay;
    }

    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    public Double getBeforePay() {
        return beforePay;
    }

    public void setBeforePay(Double beforePay) {
        this.beforePay = beforePay;
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public Double getQpassPay() {
        return qpassPay;
    }

    public void setQpassPay(Double qpassPay) {
        this.qpassPay = qpassPay;
    }

    public String getInCarPlateColor() {
        return inCarPlateColor;
    }

    public void setInCarPlateColor(String inCarPlateColor) {
        this.inCarPlateColor = inCarPlateColor;
    }

    public String getOutCarPlateColor() {
        return outCarPlateColor;
    }

    public void setOutCarPlateColor(String outCarPlateColor) {
        this.outCarPlateColor = outCarPlateColor;
    }

    public Integer getGovInUpFlag() {
        return govInUpFlag;
    }

    public void setGovInUpFlag(Integer govInUpFlag) {
        this.govInUpFlag = govInUpFlag;
    }

    public Integer getGovOutUpFlag() {
        return govOutUpFlag;
    }

    public void setGovOutUpFlag(Integer govOutUpFlag) {
        this.govOutUpFlag = govOutUpFlag;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime;
    }
}
