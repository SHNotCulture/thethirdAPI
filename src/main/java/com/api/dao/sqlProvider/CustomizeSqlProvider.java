package com.api.dao.sqlProvider;

import com.api.entity.BusineCouponGetTicketInfo;
import com.api.entity.ParkCarTask;
import com.api.entity.Shop;
import com.api.entity.TParkInOut;
import com.api.util.DateUtil;
import com.api.util.JsonUtil;
import com.api.util.StringUtil;

/**
 * @ClassName CustomizeSqlProvider
 * @Author jin
 * @Date 2018/9/28 18:52
 **/
public class CustomizeSqlProvider {

    public String selectMonthlyNum(String parkId){
        String sql = "select a.totalCarNo,a.parkingNo,b.*,c.*,d.* from \n" +
                "(select IFNULL(SUM(length(car_plate) + 1 - length(REPLACE (car_plate, ',', ''))),0) totalCarNo,IFNULL(SUM(parking_no),0) parkingNo from t_park_car where park_id="+parkId+") a, \n" +
                "(SELECT IFNULL(SUM(parking_no),0) privatapiNo from t_park_car where is_owner=1 and park_id="+parkId+") b,\n" +
                "(select IFNULL(SUM(parking_no),0) pausapiNo from t_park_car WHERE status=2 and park_id="+parkId+")c,\n" +
                "(select IFNULL(SUM(parking_no),0) expiredParkingNo from t_park_car WHERE status=3 and park_id="+parkId+")d";
        return sql.toString();
    }

    public String selectMainNum(String parkId){
        String sql = "select a.monEle,b.monCash,c.temporaryEle,d.temporaryCash,e.yueEle,f.yueCash from\n" +
                "(SELECT IFNULL(SUM(actual_pay),0) monEle FROM t_park_in_out_"+parkId+" where car_nature=2 and charge_type=1 and to_days(out_time) = to_days(now()))a,\n" +
                "(SELECT IFNULL(SUM(actual_pay),0) monCash FROM t_park_in_out_"+parkId+" where car_nature=2 and charge_type=3 and to_days(out_time) = to_days(now()))b,\n" +
                "(SELECT IFNULL(SUM(actual_pay),0) temporaryEle FROM t_park_in_out_"+parkId+" where car_nature=3 and charge_type=1 and to_days(out_time) = to_days(now()))c,\n" +
                "(SELECT IFNULL(SUM(actual_pay),0) temporaryCash FROM t_park_in_out_"+parkId+" where car_nature=3 and charge_type=3 and to_days(out_time) = to_days(now()))d,\n" +
                "(SELECT IFNULL(SUM(actual_pay),0) yueEle FROM t_park_in_out_"+parkId+" where charge_type=1 and DATE_FORMAT(out_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ))e,\n" +
                "(SELECT IFNULL(SUM(actual_pay),0) yueCash FROM t_park_in_out_"+parkId+" where charge_type=3 and DATE_FORMAT(out_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ))f";
        return sql.toString();
    }

    /**
     * 电子报表
     *
     * @return
     */
        public String paymentForDay(){
            StringBuilder sql=new StringBuilder();
            sql.append("insert into t_electron_Payment \n" +
                    " (park_id,create_date,temp_online_total,\n" +
                            "fix_online_actual_total,temp_qPassPay_Total,temp_PrePay_Total,weChat_PrePay_Total,\n" +
                            "alipay_PrePay_Total,third_PrePay_Total,\n" +
                            "monthly_weChat_Total,temp_unionPay_Total,temp_card_Total,\n" +
                            "temp_rights_Total,temp_weChat_Total,temp_alipay_Total)\n" +
                            "select park_id,create_date,temp_online_total,\n" +
                            "fix_online_actual_total,temp_qPassPay_Total,temp_PrePay_Total,weChat_PrePay_Total,\n" +
                            "alipay_PrePay_Total,third_PrePay_Total,\n" +
                            "monthly_weChat_Total,temp_unionPay_Total,temp_card_Total,\n" +
                            "temp_rights_Total,temp_weChat_Total,temp_alipay_Total\n" +
                            "FROM t_park_report where create_date=left(DATE_SUB(curdate(),INTERVAL 1 DAY),10)");
            return sql.toString();
        }
        public String parkTiggerForInOut(String parkId)
        {
            StringBuilder sql=new StringBuilder();
            sql.append("CREATE TABLE t_park_in_out_" +parkId+ " SELECT * FROM t_park_in_out WHERE 1=2;");
            return sql.toString();
        }
        public String parkTiggerForTask(String parkId)
        {
            StringBuilder sql=new StringBuilder();
            sql.append("CREATE TABLE t_task_" +parkId+ " SELECT * FROM t_task WHERE 1=2");
            return sql.toString();
        }
    public String selectHistogram(String parkId, String year, String type){
        String sql= "select month(out_time) as month,sum("+type+")nums from t_park_in_out_"+parkId+" where year(out_time) = "+year+" and "+type+">0 group by month (out_time)";
        return sql.toString();
    }

    public String selectCompanyPark(String parkId){
        String sql = "select (total_parking_space-in_fixprivate_cars-in_fixlots_cars-in_tempcars)totalVacancySpace,park_vacancy_space parkVacancySpace,private_vacancy_space privateVacancySpace,(in_fixprivate_cars+in_tempcars+in_fixlots_cars)inTotle,in_fixprivate_cars inFixprivate,in_fixlots_cars inFixlots,in_tempcars inTemp,incar_count_today inCars,outcar_count_today outCars,noconfirmcar_count_today noconfirmCar  from t_company_park where id="+parkId;
        return sql.toString();
    }

    public String updateCompanyPark(String parkId, String column, Integer msg){
        String sql = "update t_company_park set "+column+"="+msg+" where id="+parkId;
        return sql.toString();
    }

    public String insetParktable(Integer parkId, Integer parkCarId, ParkCarTask parkCarTask, String computerIndex){
        String data = JsonUtil.beanToJson(parkCarTask);
        String tabateName = "t_task_"+parkId;
        String sql = "INSERT INTO "+tabateName+" (park_car_id,task_type,data,pk,task_status,create_time)" +
                " value("+parkCarId+",'mcard_update','"+data+"','"+computerIndex+"','0','"+ DateUtil.getCurDateTime()+"')";
        return sql.toString();
    }


    public String findParkPortInId(String ids){
        String sql = "select * from t_park_port as p where p.id in("+ids+")";
        return sql.toString();
    }

    public String selectCloseParkCar(String closeDays, String payRule, String parkid){
        String sql = "select * from t_park_car where DATEDIFF(end_date,begin_date)<="+closeDays+" and park_id="+parkid+" and pay_rule="+payRule+"";
        return sql.toString();
    }

    public String Resetport(String portids, String ids){
        String sql = "UPDATE t_park_car SET port_id='"+portids+"' where id in ("+ids+")";
        return sql.toString();
    }

    public String getMaturityNo(String parkid){
        String sql = "SELECT COUNT(*) from t_park_car where end_date<=LAST_DAY(now()) and status=1 and park_id="+parkid+"";
        return sql.toString();
    }

    public String selectParkingRecordNum(String parkid){
        String sql = "select needpay_total_today needPay,cashpay_total_today cashPay,prepay_total_today beforePay,behalfpay_total_today coupon,qpasspay_total_today polymerization,localcouponpay_total_today relief from t_company_park where id="+parkid+"";
        return sql.toString();
    }

    /**
     * 查找今日收入
     * @param parkid
     * @return
     */
    public String selectTodayPay(String parkid){
        String sql="select create_date,temp_NeedPay_Total from t_park_report where to_days(create_date) = to_days(now()) and park_id="+parkid+"";
        return sql.toString();
    }

    /**
     * 查找免单车辆数
     * @param parkid
     * @return
     */
    public String selectFreeTotal (String parkid){
        String sql="select free_total from t_park_report where to_days(create_date) = to_days(now()) and park_id="+parkid+"";
        return sql.toString();
    }

    /**
     * 查找今日车流量
     * @param parkid
     * @return
     */
    public String selectTotalNum (String parkid){
        String sql="SELECT a.a+b.b total FROM\n" +
                "(select COUNT(*)a from t_park_in_out_"+parkid+" where to_days(in_time) = to_days(now()))a,\n" +
                "(select COUNT(*)b from t_park_in_out_"+parkid+" where to_days(out_time) = to_days(now()))b";
        return sql.toString();
    }

    /**
     * 查找今日分类型缴费总和
     * @param parkid
     * @return
     */
    public String selectPayByType (String parkid){
        String sql="select IFNULL(w.temp_NeedPay_Total,0)NeedPay,IFNULL(w.free_total,0)free,IFNULL(w.temp_Pay_diff,0)diff,IFNULL(w.temp_BehalfPay_Total,0)BehalfPay,IFNULL(w.temp_qPassPay_Total,0)qPassPay,IFNULL(w.temp_PrePay_Total,0)PrePay,IFNULL(w.temp_coupon_Total,0)coupon from\n" +
                "(select 0 a)q left JOIN\n" +
                "(select 0 a,temp_NeedPay_Total,free_total,temp_Pay_diff,temp_BehalfPay_Total,temp_qPassPay_Total,temp_PrePay_Total,temp_coupon_Total from t_park_report where to_days(create_date) = to_days(now()) and park_id="+parkid+")w ON q.a=w.a";
        return sql.toString();
    }

    /**
     * 查找近七日的车流量
     * @param parkid
     * @return
     */
    public String selectSevenDays (String parkid){
        String sql="select RIGHT(e.date,4)date,(ifnull(e.innum,0)+ifnull(b.outnum,0))num from \n" +
                "(select * from \n" +
                "(select date_format(d.date,'%Y%m%d')date from (select @num:=@num+1,date_format(adddate(DATE_SUB(CURDATE(), INTERVAL 7 DAY), INTERVAL @num DAY),'%Y-%m-%d') as date\n" +
                "from t_dic_qpasspay_type,(select @num:=0) t where adddate(DATE_SUB(CURDATE(), INTERVAL 7 DAY), INTERVAL @num DAY) < date_format(curdate(),'%Y-%m-%d')\n" +
                "order by date)d)c\n" +
                "LEFT JOIN\n" +
                "(select t.intime,COUNT(*)innum from \n" +
                "(select date_format(in_time,'%Y%m%d')intime,date_format(out_time,'%Y%m%d')outtime from t_park_in_out_"+parkid+" where to_days(in_time) >= to_days(now())-6)t\n" +
                "where t.intime is not null\n" +
                "GROUP BY t.intime)a ON c.date=a.intime)e\n" +
                "LEFT JOIN\n" +
                "(select t.outtime,COUNT(*)outnum from \n" +
                "(select date_format(in_time,'%Y%m%d')intime,date_format(out_time,'%Y%m%d')outtime from t_park_in_out_"+parkid+" where to_days(in_time) >= to_days(now())-6)t\n" +
                "where t.outtime is not null\n" +
                "GROUP BY t.outtime)b on e.date=b.outtime ORDER BY e.date";
        return sql.toString();
    }

    public String selectePayType(String parkid){
        String sql="select a.wechat,b.alipay,c.unionPay,d.actualPay,e.etc,f.coupon from\n" +
                "(select \"q\"q,COUNT(*) wechat from t_park_in_out_"+parkid+" where ePayType=3 and to_days(out_time)= to_days(now()))a left join\n" +
                "(select \"q\"q,COUNT(*) alipay from t_park_in_out_"+parkid+" where ePayType=4 and to_days(out_time)= to_days(now()))b on a.q=b.q left join\n" +
                "(select \"q\"q,COUNT(*) unionPay from t_park_in_out_"+parkid+" where ePayType in (1,2,5,6)  and to_days(out_time)= to_days(now()))c on a.q=c.q left join\n" +
                "(select \"q\"q,COUNT(*) actualPay from t_park_in_out_"+parkid+" where actual_pay>0  and to_days(out_time)= to_days(now()))d on a.q=d.q left join\n" +
                "(select \"q\"q,COUNT(*) etc from t_park_in_out_"+parkid+" where ePayType=7  and to_days(out_time)= to_days(now()))e on a.q=e.q left join\n" +
                "(select \"q\"q,COUNT(*) coupon from t_park_in_out_"+parkid+" where localcoupon>0 and to_days(out_time)= to_days(now()))f on a.q=f.q ";
        return sql.toString();
    }

    public String selectCarNum(String parkid){
        String sql="select total_parking_space total,(total_parking_space-in_fixprivate_cars-in_fixlots_cars-in_tempcars)surplus from t_company_park where id="+parkid+"";
        return sql.toString();
    }

    public String selectMainAllNum(String parkid){
        String sql="\n" +
                "select a.overdueNum,b.todayNum,b.CashPay,b.NeedPay,b.free,b.BehalfPay,b.PrePay,b.coupon,b.qPassPay,b.diff,b.fixNeed,b.fixOline,c.wechat wechatNums,c.alipay alipayNums,c.coupon couponNums,c.unionPay unionPayNums,c.actualPay actualPayNums,c.etc etcNums,d.total,d.surplus,e.turnover from\n" +
                "(select \"q\"q, COUNT(*)overdueNum from t_park_car where park_id="+parkid+" and status=3 )a\n" +
                "left join\n" +
                "(select \"q\"q,(incar_count_today+outcar_count_today)todayNum ,localcouponcar_count_today free,needpay_total_today NeedPay,behalfpay_total_today BehalfPay,cashpay_total_today CashPay\n" +
                ",prepay_total_today PrePay,localcouponpay_total_today coupon,qpasspay_total_today qPassPay,(needpay_total_today-behalfpay_total_today-prepay_total_today-localcouponpay_total_today-qpasspay_total_today-cashpay_total_today)diff,monthly_cashpay_today fixNeed,monthly_qpasspay_today fixOline from t_company_park where id="+parkid+")b\n" +
                "on a.q=b.q left join\n" +
                "(select \"q\"q,a.wechat,b.alipay,c.unionPay,d.actualPay,e.etc,f.coupon from (select \"q\"q,COUNT(*) wechat from t_park_in_out_"+parkid+" where ePayType=3 and to_days(out_time)= to_days(now()))a left join\n" +
                "(select \"q\"q,COUNT(*) alipay from t_park_in_out_"+parkid+" where ePayType=4 and to_days(out_time)= to_days(now()))b on a.q=b.q left join\n" +
                "(select \"q\"q,COUNT(*) unionPay from t_park_in_out_"+parkid+" where ePayType in (1,2,5,6)  and to_days(out_time)= to_days(now()))c on a.q=c.q left join\n" +
                "(select \"q\"q,COUNT(*) actualPay from t_park_in_out_"+parkid+" where actual_pay>0  and to_days(out_time)= to_days(now()))d on a.q=d.q left join\n" +
                "(select \"q\"q,COUNT(*) etc from t_park_in_out_"+parkid+" where ePayType=7  and to_days(out_time)= to_days(now()))e on a.q=e.q left join\n" +
                "(select \"q\"q,COUNT(*) coupon from t_park_in_out_"+parkid+" where localcoupon>0 and to_days(out_time)= to_days(now()))f on a.q=f.q)c\n" +
                "on a.q=c.q left join\n" +
                "(select \"q\"q,total_parking_space total,(total_parking_space-in_fixprivate_cars-in_fixlots_cars-in_tempcars)surplus from t_company_park where id="+parkid+")d\n" +
                "on a.q=d.q left join\n" +
                "(select \"q\"q,ROUND((outcar_count_today-incar_count_today)/total_parking_space,4)turnover from t_company_park where id="+parkid+")e\n" +
                "on a.q=e.q";
        return sql.toString();
    }

    public String selectDetail(String parkId, String whereType){
        String sql = "select * from t_park_in_out_"+parkId+" where "+whereType+"";
        return  sql.toString();
    }

    public String selectDetailNum(String parkId, String whereType){
        String sql = "select count(*) from t_park_in_out_"+parkId+" where "+whereType+"";
        return  sql.toString();
    }

    /*public String fuzzyParkCar(String key){
        String sql = "select * from t_park_car where CONCAT(IFNULL(car_plate,0),IFNULL(binding_name,0),IFNULL(address,0),IFNULL(realname,0),IFNULL(car_color,0)) like '%"+key+"%'";
        return  sql.toString();
    }*/

    public String selectPresentCar(String type, String parkId, String andSql){
        String sql = "select "+type+" from \n" +
                "(select * from t_park_in_out_"+parkId+" where in_time is not null and out_time is NULL and in_car_plate!='未识别')a\n" +
                "left join \n" +
                "(SELECT t.* FROM (select * from t_park_in_out_"+parkId+" order by out_time DESC limit 10000000000) t GROUP BY t.in_car_plate)b\n" +
                "on a.in_car_plate=b.in_car_plate\n" +
                "where (a.in_time>b.out_time or b.out_time is NULL) "+andSql;
        return  sql.toString();
    }

    public String selectApikey(String ID){
        String sql = "SELECT a.id, a.key, a.name, a.api_id, a.parkIds FROM t_apikey a WHERE a.api_id = '"+ID+"'";
        return  sql.toString();
    }

    public String insetCouponble(Integer parkId, Shop shop, String computerIndex){
        String data = JsonUtil.beanToJson(shop);
        String tabateName = "t_task_"+parkId;
        String sql = "INSERT INTO "+tabateName+" (park_car_id,task_type,data,pk,task_status,create_time) " +
                "value('0','coupon_update','"+data+"','"+computerIndex+"','0','"+ DateUtil.getCurDateTime()+"')";
        return sql.toString();
    }
    public String selectCouponble(Integer parkId){
        String tabateName = "t_task_"+parkId;
        String sql = "select task_id,park_car_id,task_type,data,pk,task_status,create_time from  "+tabateName+" where task_type='coupon_update'";
        return sql.toString();
    }
    public String DeleteCouponble(Integer parkId,String taskId){
        String tabateName = "t_task_"+parkId;
        String sql = "delete from  "+tabateName+" where task_id="+taskId;
        return sql.toString();
    }

    public String selectComputerIndex(Integer parkId,Integer portType){
        String sql = "select distinct computer_index from t_park_port where park_id="+parkId+" and port_type="+portType+"";
        return  sql.toString();
    }

    public String getAllUnionPayFeeToday(String andSql,String province){
        String sql = "select ifnull(sum(s.unionPayFee),0.00) from t_park_statistics_day s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1  and s.statistic_time=DATE_FORMAT(NOW(),'%Y-%m-%d') "+andSql+"";
        return sql.toString();
    }

    public String getInAndOutVehiclesNums(String andSql){
        String sql = "select ifnull(sum(s.entrance_flow),0)进场车辆,ifnull(sum(s.outbound_flow),0)出场车辆 from t_park_statistics_day s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('贵',p.address)  and s.statistic_time=DATE_FORMAT(NOW(),'%Y-%m-%d') "+andSql+"";
        return sql.toString();
    }

    public String getParkInOut(String time,String andSql,String province){
        String sql = "select * from t_park_in_out_today s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 and occur_time<='"+time+"' "+andSql+" ORDER BY occur_time DESC LIMIT 0,5";
        return sql.toString();
    }

    public String getParkInOutNum(String time,String andSql,String province){
        String sql = "select ifnull(count(1),0) from t_park_in_out_today  s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1  and s.occur_time > (date_add('"+time+"',interval -10 SECOND)) and s.occur_time <='"+time+"' "+andSql+"";
        return sql.toString();
    }

    public String getUnionPayAndTotal(String andSql,String province){
        String sql = "select IFNULL(SUM(s.totalPayFee),0)aims,IFNULL(SUM(s.unionPayFee),0)actual from t_park_statistics s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 "+andSql+"";
        return sql.toString();
    }

    public String getUnionPayTypeNums(String andSql,String province){
        String sql = "select IFNULL(SUM(s.unionPayQRNum),0)银联二维码,IFNULL(SUM(s.unionPayPassNum),0)银联闪付,IFNULL(SUM(s.cloudNum),0)银联无感 from t_park_statistics_day s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 "+andSql+"";
        return sql.toString();
    }

    public String getFreeParkingSpace(String andSql,String province){
        String sql="select IFNULL(SUM(s.park_spaces_free),0) from t_park_statistics s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 "+andSql+"";
        return sql.toString();
    }

    public String getInAndOutVehiclesNumsAll(String andSql,String province){
        String sql = "select ifnull(sum(s.entrance_flow),0)进场车辆,ifnull(sum(s.outbound_flow),0)出场车辆 from t_park_statistics s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 "+andSql+"";
        return sql.toString();
    }

    public String getParkingTurnover(String andSql,String province){
        String sql = "select IFNULL(ROUND(AVG(s.turnover_ave),2),0.00) from t_park_statistics s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 "+andSql+"";
        return sql.toString();
    }

    public String getParkingUsageRate(String andSql,String province){
        String sql = "select IFNULL(ROUND(AVG(s.usage_rate),2),0.00) from t_park_statistics s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 "+andSql+"";
        return sql.toString();
    }

    public String getWeekTurnoverTrend(String andSql){
        String sql="SELECT '车场周转率'as'name',DATE_FORMAT(s.statistic_time,'%m-%d') time,IFNULL(s.turnover_ave,0.00)*100 'value' \n" +
                "from t_park_statistics_day s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('贵',p.address) \n" +
                " AND s.statistic_time>=date_sub(curdate(), interval '7' day) AND s.statistic_time<curdate()\n" +andSql+
                " GROUP BY statistic_time  ";
        return sql.toString();
    }

    public String parkCount(String province){
        String sql = "SELECT count(id) FROM `t_company_park` where LOCATE('"+province+"',address)=1";
        return sql.toString();
    }
    public String parkSpacesSum(String province){
        String sql = "select sum(total_parking_space) as '贵州车位总数' from t_company_park where LOCATE('"+province+"',address)=1";
        return sql.toString();
    }
    public String outboundFlowSum(String province){
        String sql = "select sum(s.outbound_flow) as '车辆总流量' from t_park_statistics  s INNER JOIN t_company_park p ON s.park_id=p.id WHERE LOCATE('"+province+"',p.address)=1 ";
        return sql.toString();
    }
    public String yearsOfTrading(String province){
        String sql = "select (select SUM(s.annual_goals) FROM t_park_statistics s INNER JOIN t_company_park p ON s.park_id=p.id  WHERE LOCATE('"+province+"',p.address)=1) as '所有车场年度交易总额目标笔数',SUM(unionPayNum) as '所有车场历史交易笔数',SUM(s.unionPayFee) as '所有车场历史交易金额' from t_park_statistics_day  s INNER JOIN t_company_park p ON s.park_id=p.id  WHERE LOCATE('"+province+"',p.address)=1 and  LEFT(s.statistic_time,4)=YEAR(CURDATE()) ";
        return sql.toString();
    }
    public String rotationRateOfPark(String province){
        String sql = "SELECT DATE_FORMAT(s.statistic_time,'%m-%d') as statistic_time,AVG(s.turnover_ave)*100 as '所有车场周转率' FROM t_park_statistics_day s INNER JOIN t_company_park p ON s.park_id=p.id  WHERE LOCATE('"+province+"',p.address)=1 and DATEDIFF(s.statistic_time,NOW())<0 AND DATEDIFF(s.statistic_time,NOW())>=-7 GROUP BY s.statistic_time ORDER BY s.statistic_time ASC";
        return sql.toString();
    }
    public String getCoordinate(String province){
        String sql = "select  position_x lat,position_y lng,park_name info from t_company_park WHERE LOCATE('"+province+"',address)=1 and (position_x is NOT null or position_y is not NULL)";
        return sql.toString();
    }
    public String getRecentParkinout(Integer parkId, String inCarPlate,String inTime){
        String sql = "SELECT * FROM t_park_in_out_"+parkId+"  WHERE (out_type = 0 or out_type = 9 or out_type = 11)  and in_car_plate like '%"+inCarPlate+"%' and in_time = '"+inTime+"' limit 1";
        return sql.toString();
    }
    public String getTicketCouponIsUseNum(Integer batchCode){
        String sql = "select case when b.limit_day=0 then 0 else(CASE when (select COUNT(1) from t_ticket_coupon where batch_code="+batchCode+")=0 then 0 ELSE (CASE WHEN (b.limit_day>sum(case when DATE_FORMAT(a.update_time,'%Y%m%d')=DATE_FORMAT(NOW(),'%Y%m%d') THEN 1 else 0 END)) then 0 ELSE 1 END) END)end + \n" +
                "case when b.limit_month=0 then 0 else(CASE when (select COUNT(1) from t_ticket_coupon where batch_code="+batchCode+")=0 then 0 ELSE (CASE WHEN (b.limit_month>sum(case when DATE_FORMAT(a.update_time,'%Y%m')=DATE_FORMAT(NOW(),'%Y%m') THEN 1 else 0 END)) then 0 ELSE 1 END) END)end + \n" +
                "case when b.limit_year=0 then 0 else(CASE when (select COUNT(1) from t_ticket_coupon where batch_code="+batchCode+")=0 then 0 ELSE (CASE WHEN (b.limit_year>sum(case when DATE_FORMAT(a.update_time,'%Y')=DATE_FORMAT(NOW(),'%Y') THEN 1 else 0 END)) then 0 ELSE 1 END) END)end from\n" +
                "(select batch_code,update_time from t_ticket_coupon where batch_code="+batchCode+") a LEFT JOIN (select * from t_busine_ticket where id="+batchCode+") b ON a.batch_code=b.id";
        return sql.toString();
    }
    public String getTBusineTicketExpireSoon(BusineCouponGetTicketInfo busineCouponGetTicketInfo){
        String sql = "select r.id FROM(\n" +
                "SELECT a.*,IFNULL(b.y,0)y,IFNULL(b.m,0)m,IFNULL(b.d,0)d from\n" +
                "(SELECT * from t_busine_ticket where ticket_id="+busineCouponGetTicketInfo.getTicketId()+" and busine_id="+busineCouponGetTicketInfo.getBusineId()+" and ticket_num>0 and expiry_date>NOW()\n" +
                "UNION\n" +
                "SELECT * from t_busine_ticket where ticket_id="+busineCouponGetTicketInfo.getTicketId()+" and busine_id="+busineCouponGetTicketInfo.getBusineId()+" and ticket_num>0 and expiry_date=0)a\n" +
                "LEFT JOIN\n" +
                "(select q.batch_code,q.y,w.m,e.d from\n" +
                "(SELECT batch_code,COUNT(1)y from t_ticket_coupon\n" +
                "where ticket_id="+busineCouponGetTicketInfo.getTicketId()+" and busine_id="+busineCouponGetTicketInfo.getBusineId()+" and DATE_FORMAT(update_time,'%Y')=DATE_FORMAT(NOW(),'%Y')\n" +
                "GROUP BY batch_code)q\n" +
                "LEFT JOIN\n" +
                "(SELECT batch_code,COUNT(1)m from t_ticket_coupon\n" +
                "where ticket_id="+busineCouponGetTicketInfo.getTicketId()+" and busine_id="+busineCouponGetTicketInfo.getBusineId()+" and DATE_FORMAT(update_time,'%m')=DATE_FORMAT(NOW(),'%m')\n" +
                "GROUP BY batch_code)w on q.batch_code=w.batch_code\n" +
                "LEFT JOIN\n" +
                "(SELECT batch_code,COUNT(1)d from t_ticket_coupon\n" +
                "where ticket_id="+busineCouponGetTicketInfo.getTicketId()+" and busine_id="+busineCouponGetTicketInfo.getBusineId()+" and DATE_FORMAT(update_time,'%d')=DATE_FORMAT(NOW(),'%d')\n" +
                "GROUP BY batch_code)e\n" +
                "on  w.batch_code=e.batch_code)b on a.id=b.batch_code)r\n" +
                "where (CASE WHEN limit_day=0 THEN 1=1 ELSE limit_day>d END) and (CASE WHEN limit_month=0 THEN 1=1 ELSE limit_month>m END) and (CASE WHEN limit_year=0 THEN 1=1 ELSE limit_year>y END)\n" +
                "LIMIT 1";
        return sql.toString();
    }
    public String updateBillingStatusByParkIdCarplateInOuttime(TParkInOut tParkInOut){
        String sql = "update t_park_in_out_"+tParkInOut.getParkId()+" set billing_status="+tParkInOut.getBillingStatus()+" where in_car_plate='"+tParkInOut.getInCarPlate()+"' and order_id='"+tParkInOut.getOrderId()+"'";
        return sql.toString();
    }

    public String getGovParkInOut(Integer parkId){
        String sql = "SELECT id,park_id,car_nature,in_car_plate,in_time,in_port_id,in_port_name,in_pic_path,out_car_plate,out_time,out_port_id,out_port_name,out_pic_path,charge_type,order_id,ePayType,need_pay,actual_pay,before_pay,coupon,qpass_pay,in_car_plate_color,out_car_plate_color,gov_in_up_flag,gov_out_up_flag,occur_time" +
                " from t_park_in_out_"+parkId+" WHERE (gov_in_up_flag = 1 AND in_time is not null AND occur_time >='"+ StringUtil.monthDay(-2)+"')\n" +
                " OR (gov_out_up_flag = 1 AND in_time is not null AND out_time is not null AND occur_time >='"+ StringUtil.monthDay(-2)+"')\n" +
                " ORDER BY  occur_time DESC LIMIT 200";
        return sql.toString();
    }

    public String updateGovUpFlag(Integer parkId,String field,String ids){
        String sql = "UPDATE t_park_in_out_"+parkId+" SET "+field+"=2 where id in("+ids+")";
        return sql.toString();
    }

    public String getParkinoutByOrderId(Integer parkId,String orderId){
        String sql = "select * from t_park_in_out_"+parkId+" where order_id='"+orderId+"'";
        return sql.toString();
    }

    public String getTRParkInOut(Integer parkId,String beginDate,String endDate,String limit){
        String sql = "SELECT * from t_park_in_out_"+parkId+" where occur_time BETWEEN '"+beginDate+"' and '"+endDate+"' ORDER BY occur_time "+limit+"";
        return sql.toString();
    }

    public String getTRParkInOutCount(Integer parkId,String beginDate,String endDate){
        String sql = "SELECT count(1) from t_park_in_out_"+parkId+" where occur_time BETWEEN '"+beginDate+"' and '"+endDate+"' ORDER BY occur_time";
        return sql.toString();
    }

}
