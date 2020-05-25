package com.api.service.impl;

import com.api.dao.TCompanyParkMapper;
import com.api.entity.TCompanyPark;
import com.api.entity.TCompanyParkCriteria;
import com.api.entity.TDatavRequest;
import com.api.service.CompanyParkService;
import com.api.util.JsonUtil;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyParkServiceImpl implements CompanyParkService {
        @Autowired
        private TCompanyParkMapper tCompanyParkMapper;

        /**
         *设置查询条件
         * @param tCompanyPark
         * @return
         */
        private TCompanyParkCriteria setCriteria(TCompanyPark tCompanyPark){
            TCompanyParkCriteria tCompanyParkCriteria= new TCompanyParkCriteria();
            List<TDatavRequest> tRolePowerList=new ArrayList<>();
            if(tCompanyPark!=null){
                TCompanyParkCriteria.Criteria criteria=tCompanyParkCriteria.createCriteria();
                if(tCompanyPark.getId()!=null){
                    criteria.andIdEqualTo(tCompanyPark.getId());
                }
            }
            return  tCompanyParkCriteria;
        }
        /**
         *获取数据总量
         * @param tCompanyPark
         * @return
         */
        private Integer getCount(TCompanyPark tCompanyPark){
            Integer total =(int)tCompanyParkMapper.countByExample(setCriteria(tCompanyPark));
            return total;
        }
        /**
         * 查询全部信息（分页）
         * @param tCompanyPark
         * @param page
         * @param limit
         * @return
         */
        @Override
        public PageBean<TCompanyPark> getTCompanyParkbyPage(TCompanyPark tCompanyPark, Integer page, Integer limit){
            PageHelper.startPage(page, limit,"id desc");
            List<TCompanyPark> tCompanyParks=getTCompanyPark(tCompanyPark);
            Integer countNums =getCount(tCompanyPark);
            PageBean<TCompanyPark> pageData = new PageBean<>(page, limit, countNums);
            pageData.setItems(tCompanyParks);
            return pageData;
        }
        /**
         * 查询全部信息
         * @param tCompanyPark
         * @return
         */
        @Override
        public List<TCompanyPark> getTCompanyPark(TCompanyPark tCompanyPark){
            List<TCompanyPark> tCompanyParks=tCompanyParkMapper.selectByExample(setCriteria(tCompanyPark));
            return tCompanyParks;
        }
        /**
         * 查询车场名称
         * @param parkID
         * @return
         */
        @Override
        public String getCompanyParkName(Integer parkID){
            TCompanyPark tCompanyPark=new TCompanyPark();
            tCompanyPark.setId(parkID);
            List<TCompanyPark> tCompanyParks=getTCompanyPark(tCompanyPark);
            JSONArray jsonArray = new JSONArray();
            Map map=new HashMap();
            map.put("value",tCompanyParks.get(0).getParkName());
            jsonArray.add(map);
            String result= JsonUtil.beanToJson(jsonArray);
            return result;
        }

    @Override
    public Map<String,Object> getParkSpaces(Integer parkId) {
        Map<String,Object> map = new HashMap<String, Object>(2);
        TCompanyPark tCompanyPark = new TCompanyPark();
        tCompanyPark.setId(parkId);
        TCompanyPark tCompanyPark1 = tCompanyParkMapper.selectByExample(setCriteria(tCompanyPark)).get(0);
        Integer parkSpacesTotal=tCompanyPark1.getTotalParkingSpace();

        map.put("parkSpacesTotal",parkSpacesTotal);

        Integer inFixprivateCars=tCompanyPark1.getInFixprivateCars();
        Integer inFixlotsCars=tCompanyPark1.getInFixlotsCars();
        Integer inTempcars=tCompanyPark1.getInTempcars();
        Integer parkSpacesUse=inFixprivateCars+inFixlotsCars+inTempcars;
        Integer parkSpacesFree = parkSpacesTotal-parkSpacesUse;

        map.put("parkSpacesFree",parkSpacesFree);


        map.put("parkSpacesUse",parkSpacesUse);

        String parkAddress = tCompanyPark1.getAddress();
        String positionX = tCompanyPark1.getPositionX();
        String positionY = tCompanyPark1.getPositionY();

        map.put("lng",positionX);


        map.put("lat",positionY);


        map.put("address",parkAddress);

        return map;
    }

    /**
         * 更新信息
         * @param tCompanyPark
         * @return
         */
        @Override
        public String UpdateTCompanyPark(TCompanyPark tCompanyPark)
        {
            if(tCompanyPark.getId()!=null){
                tCompanyParkMapper.updateByPrimaryKeySelective(tCompanyPark);
            }
            else
            {
                tCompanyParkMapper.insertSelective(tCompanyPark);
            }
            return "更新成功";
        }
        /**
         * 删除信息
         * @param id
         * @return
         */
        @Override
        public String DeleteTCompanyPark(Integer id){
            try {
                tCompanyParkMapper.deleteByPrimaryKey(id);
            }
            catch (Exception e){
                throw  e;
            }
            return "删除成功";
        }

        @Override
        public TCompanyPark selectByPrimaryKey(Integer id) {
            return tCompanyParkMapper.selectByPrimaryKey(id);
        }

}
