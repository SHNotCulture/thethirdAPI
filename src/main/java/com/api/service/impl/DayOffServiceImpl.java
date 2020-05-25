package com.api.service.impl;

import com.api.dao.TDayOffMapper;
import com.api.entity.TDayOff;
import com.api.entity.TDayOffCriteria;
import com.api.service.DayOffService;
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
 * @Date Create in 16:542018-11-6
 * @Modified By:
 */
@Service
public class DayOffServiceImpl implements DayOffService {
    private  static final Logger logger= LoggerFactory.getLogger(DayOffServiceImpl.class);
    @Autowired
    private TDayOffMapper tDayOffMapper;

    /**
     * 设置查询条件
     * @param tDayOff
     * @return
     */
    private TDayOffCriteria setCriteria(TDayOff tDayOff){
        //查询全部调休日信息
        TDayOffCriteria tDayOffCriteria= new TDayOffCriteria();
        if(tDayOff!=null){
            TDayOffCriteria.Criteria criteria=tDayOffCriteria.createCriteria();
            if(tDayOff.getParkId()!=null){
                criteria.andParkIdEqualTo(tDayOff.getParkId());
            }
        }
        return  tDayOffCriteria;
    }
    /**
     * 获取数据总量
     * @param tDayOff
     * @return
     */
    private Integer getCount(TDayOff tDayOff){
        Integer total =(int)tDayOffMapper.countByExample(setCriteria(tDayOff));
        return total;
    }
    /**
     *查询临停缴费信息(分页)
     * @param tDayOff
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TDayOff> getDayOffbyPage(TDayOff tDayOff, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TDayOff> tDayOffList=getDayOff(tDayOff);
        Integer countNums =getCount(tDayOff);
        PageBean<TDayOff> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tDayOffList);
        return pageData;
    }
    /**
     * 查询调休日信息
     * @return
     */
    public List<TDayOff> getDayOff(TDayOff tDayOff){
        logger.info("tDayOff:"+tDayOff);
        List<TDayOff> tDayOffList=tDayOffMapper.selectByExample(setCriteria(tDayOff));
        return tDayOffList;
    }


    /**
     * 更新调休日信息
     * @param tDayOff
     * @return
     */
    public String UpdateDayOff(TDayOff tDayOff)
    {
        logger.info(tDayOff.toString());
        if(tDayOff.getId()!=null){
            tDayOffMapper.updateByPrimaryKeySelective(tDayOff);
        }
        else
        {
            tDayOffMapper.insertSelective(tDayOff);
        }
        return "更新成功";
    }

    /**
     * 删除调休日信息
     * @param id
     * @return
     */
    public String DeleteDayoff(Integer id){
        tDayOffMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }
}
