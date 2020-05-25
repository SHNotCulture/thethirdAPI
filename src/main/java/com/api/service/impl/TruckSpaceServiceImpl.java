package com.api.service.impl;

import com.api.dao.TTruckSpaceMapper;
import com.api.entity.TTruckSpace;
import com.api.entity.TTruckSpaceCriteria;
import com.api.service.TruckSpaceService;
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
 * @Date Create in 17:562018-9-14
 * @Modified By:
 */
@Service
public  class TruckSpaceServiceImpl implements TruckSpaceService {
    private  static final Logger logger= LoggerFactory.getLogger(TruckSpaceServiceImpl.class);
    @Autowired
    private TTruckSpaceMapper tTruckSpaceMapper;


    /**
     *设置查询条件
     * @param tTruckSpace
     * @return
     */
    private TTruckSpaceCriteria setCriteria(TTruckSpace tTruckSpace){
        //查询全部车位信息
        TTruckSpaceCriteria tTruckSpaceCriteria= new TTruckSpaceCriteria();
        if(tTruckSpace!=null){
            TTruckSpaceCriteria.Criteria criteria=tTruckSpaceCriteria.createCriteria();
            if(tTruckSpace.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tTruckSpace.getParkId());
            }
            if(tTruckSpace.getParkingState()!=null)
            {
                criteria.andParkingStateEqualTo(tTruckSpace.getParkingState());
            }
            if(tTruckSpace.getParkingSpace()!=null)
            {
                criteria.andParkingSpaceEqualTo(tTruckSpace.getParkingSpace());
            }
            if(tTruckSpace.getCompanyId()!=null)
            {
                criteria.andCompanyIdEqualTo(tTruckSpace.getCompanyId());
            }

        }
        return  tTruckSpaceCriteria;
    }
    /**
     *获取数据总量
     * @param tTruckSpace
     * @return
     */
    private Integer getCount(TTruckSpace tTruckSpace){
        Integer total =(int)tTruckSpaceMapper.countByExample(setCriteria( tTruckSpace));
        return total;
    }
    /**
     * 查询车位信息（分页）
     * @param tTruckSpace
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean<TTruckSpace> getTruckSpacebyPage(TTruckSpace tTruckSpace, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TTruckSpace> tTruckSpaceList=getTruckSpace(tTruckSpace);
        Integer countNums =getCount(tTruckSpace);
        PageBean<TTruckSpace> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tTruckSpaceList);
        return pageData;
    }
    /**
     * 查询车位信息
     * @return
     */
    @Override
    public List<TTruckSpace> getTruckSpace(TTruckSpace tTruckSpace){
        logger.info("tTruckSpace:"+tTruckSpace);
        List<TTruckSpace> tTruckSpaceList=tTruckSpaceMapper.selectByExample(setCriteria(tTruckSpace));
        return tTruckSpaceList;
    }


    /**
     * 更新车位信息
     * @param tTruckSpace
     * @return
     */
    @Override
    public String UpdateTruckSpace(TTruckSpace tTruckSpace)
    {
        logger.info(tTruckSpace.toString());
        if(tTruckSpace.getId()!=null){
            tTruckSpaceMapper.updateByPrimaryKeySelective(tTruckSpace);
        }
        else
        {
            tTruckSpace.setTheirCarPlate(" ");
            tTruckSpace.setUseCarPlate(" ");
            tTruckSpaceMapper.insertSelective(tTruckSpace);
        }
        return "更新成功";
    }

    /**
     * 删除车位信息
     * @param id
     * @return
     */
    @Override
    public String DeleteTruckSpace(Integer id){
        tTruckSpaceMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }


    @Override
    public TTruckSpace selectByPrimaryKey(Integer id) {
        return tTruckSpaceMapper.selectByPrimaryKey(id);
    }
}
