package com.api.service.impl;

import com.api.dao.THolidayMapper;
import com.api.entity.THoliday;
import com.api.entity.THolidayCriteria;
import com.api.service.HolidayService;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 16:532018-11-6
 * @Modified By:
 */
@Service
public class HolidayServiceImpl implements HolidayService {
    private  static final Logger logger= LoggerFactory.getLogger(HolidayServiceImpl.class);
    @Autowired
    private THolidayMapper tHolidayMapper;
    /**
     * 设置查询条件
     * @param tHoliday
     * @return
     */
    private THolidayCriteria setCriteria(THoliday tHoliday){
        THolidayCriteria tHolidayCriteria= new THolidayCriteria();
        if(tHoliday!=null){
            THolidayCriteria.Criteria criteria=tHolidayCriteria.createCriteria();
            if(tHoliday.getParkId()!=null){
                criteria.andParkIdEqualTo(tHoliday.getParkId());
            }
        }
        return  tHolidayCriteria;
    }
    /**
     * 获取数据总量
     * @param tHoliday
     * @return
     */
    private Integer getCount(THoliday tHoliday){
        Integer total =(int)tHolidayMapper.countByExample(setCriteria(tHoliday));
        return total;
    }
    /**
     *查询临停缴费信息(分页)
     * @param tHoliday
     * @param page
     * @param limit
     * @return
     */
    public PageBean<THoliday> getHolidaybyPage(THoliday tHoliday, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<THoliday> tHolidayList=getHoliday(tHoliday);
        Integer countNums =getCount(tHoliday);
        PageBean<THoliday> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tHolidayList);
        return pageData;
    }
    /**
     * 查询节假日信息
     * @return
     */
    public List<THoliday> getHoliday(THoliday tHoliday){
        List<THoliday> tHolidayList=tHolidayMapper.selectByExample(setCriteria(tHoliday));
        return tHolidayList;
    }


    /**
     * 更新节假日信息
     * @param tHoliday
     * @return
     */
    public String UpdateHoliday(THoliday tHoliday)
    {
        logger.info(tHoliday.toString());
        if(tHoliday.getId()!=null){
            tHolidayMapper.updateByPrimaryKeySelective(tHoliday);
        }
        else
        {
            tHolidayMapper.insertSelective(tHoliday);
        }
        return "更新成功";
    }

    /**
     * 删除节假日信息
     * @param id
     * @return
     */
    public String DeleteHoliday(Integer id){
        tHolidayMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }
}
