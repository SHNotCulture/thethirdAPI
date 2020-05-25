package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TCompanyParkMapper;
import com.api.entity.TCompanyPark;
import com.api.entity.TCompanyParkCriteria;
import com.api.service.CarParkService;
import com.api.util.PageBean;
import com.api.util.StringUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 14:482018-9-14
 * @Modified By:
 */
@Service
public class CarParkServiceImpl  implements CarParkService {
    private  static final Logger logger= LoggerFactory.getLogger(CarParkServiceImpl.class);
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;
    @Autowired
    private CustomizeMapper customizeMapper;

    /**
     * 设置查询条件
     * @param tCompanyPark
     * @return
     */
    private TCompanyParkCriteria setCriteria(TCompanyPark tCompanyPark){
        //查询全部车场信息
        TCompanyParkCriteria tCompanyParkCriteria= new TCompanyParkCriteria();
        if(tCompanyPark!=null){
            TCompanyParkCriteria.Criteria criteria=tCompanyParkCriteria.createCriteria();
            if(tCompanyPark.getParkName()!=null&&tCompanyPark.getParkName()!="")
            {
                criteria.andParkNameLike("%"+tCompanyPark.getParkName()+"%");
            }
            if(tCompanyPark.getCompanyId()!=null&&tCompanyPark.getCompanyId()!=0)
            {
                criteria.andCompanyIdEqualTo(tCompanyPark.getCompanyId());
            }
            if(tCompanyPark.getId()!=null){
                criteria.andIdEqualTo(tCompanyPark.getId());
            }

        }
        return  tCompanyParkCriteria;
    }
    /**
     * 获取数据总量
     * @param tCompanyPark
     * @return
     */
    private Integer getCount(TCompanyPark tCompanyPark){
        Integer total =(int)tCompanyParkMapper.countByExample(setCriteria(tCompanyPark));
        return total;
    }
    /**
     *查询车场信息(分页)
     * @param tCompanyPark
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TCompanyPark> getCarParkbyPage(TCompanyPark tCompanyPark, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCompanyPark> tCompanyParkList=getCarPark(tCompanyPark);
        Integer countNums =getCount(tCompanyPark);
        PageBean<TCompanyPark> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tCompanyParkList);
        return pageData;
    }

    /**
     * 查询车场信息
     * @return
     */
    public List<TCompanyPark> getCarPark(TCompanyPark tCompanyPark){
        List<TCompanyPark> tCompanyParkList=tCompanyParkMapper.selectByExample(setCriteria(tCompanyPark));
        return tCompanyParkList;
    }



    /**
     * 根据数组查询对应车场信息
     * @param ids
     * @return
     */
    public List<TCompanyPark> getCarParkbyIDIn(List<Integer> ids){
        //logger.info("ids:"+ids);
        //查询对应车场信息
        TCompanyParkCriteria tCompanyParkCriteria= new TCompanyParkCriteria();
        TCompanyParkCriteria.Criteria criteria=tCompanyParkCriteria.createCriteria();
        criteria.andIdIn(ids);
        List<TCompanyPark> tCompanyParkList=tCompanyParkMapper.selectByExample(tCompanyParkCriteria);
        return tCompanyParkList;
    }
    /**
     * 更新车场信息
     * @param tCompanyPark
     * @return
     */
    @Transactional
    public String UpdateCarPark(TCompanyPark tCompanyPark)
    {
        logger.info(tCompanyPark.toString());
        if(tCompanyPark.getId()!=null){
            tCompanyParkMapper.updateByPrimaryKeySelective(tCompanyPark);
        }
        else
        {
            tCompanyPark.setApiKey(StringUtil.randomString(32));
            tCompanyPark.setAppId("0");
            tCompanyPark.setAppSecret("0");
            tCompanyPark.setMchId("0");
            tCompanyPark.setMchKey("0");
            tCompanyParkMapper.insertSelective(tCompanyPark);
            Integer id=getCarPark(tCompanyPark).get(0).getId();
            customizeMapper.parkTiggerForInOut(id.toString());
            customizeMapper.parkTiggerForTask(id.toString());
        }
        return "更新成功";
    }
    /**
     * 删除车场信息
     * @param id
     * @return
     */
   public String DeleteCarPark(Integer id){
        tCompanyParkMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }
}
