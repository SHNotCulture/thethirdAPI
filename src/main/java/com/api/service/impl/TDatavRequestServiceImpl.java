package com.api.service.impl;

import com.api.dao.TDatavRequestMapper;
import com.api.entity.TDatavRequest;
import com.api.entity.TDatavRequestCriteria;
import com.api.service.TDatavRequestService;
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
public class TDatavRequestServiceImpl implements TDatavRequestService {

    @Autowired
    private TDatavRequestMapper tDatavRequestMapper;

    /**
     *设置查询条件
     * @param tDatavRequest
     * @return
     */
    private TDatavRequestCriteria setCriteria(TDatavRequest tDatavRequest){
        TDatavRequestCriteria tDatavRequestCriteria= new TDatavRequestCriteria();
        List<TDatavRequest> tRolePowerList=new ArrayList<>();
        if(tDatavRequest!=null){
            TDatavRequestCriteria.Criteria criteria=tDatavRequestCriteria.createCriteria();
            if(tDatavRequest.getParkId()!=null){
                criteria.andParkIdEqualTo(tDatavRequest.getParkId());
            }
            if(tDatavRequest.getId()!=null)
            {
                criteria.andIdEqualTo(tDatavRequest.getId());
            }
        }
        return  tDatavRequestCriteria;
    }
    /**
     *获取数据总量
     * @param tDatavRequest
     * @return
     */
    private Integer getCount(TDatavRequest tDatavRequest){
        Integer total =(int)tDatavRequestMapper.countByExample(setCriteria(tDatavRequest));
        return total;
    }
    /**
     * 查询全部信息（分页）
     * @param tDatavRequest
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean<TDatavRequest> getTDatavRequestbyPage(TDatavRequest tDatavRequest, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TDatavRequest> tDatavRequests=getTDatavRequest(tDatavRequest);
        Integer countNums =getCount(tDatavRequest);
        PageBean<TDatavRequest> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tDatavRequests);
        return pageData;
    }
    /**
     * 查询全部信息
     * @param tDatavRequest
     * @return
     */
    @Override
    public List<TDatavRequest> getTDatavRequest(TDatavRequest tDatavRequest){
        List<TDatavRequest> tDatavRequests=tDatavRequestMapper.selectByExample(setCriteria(tDatavRequest));
        return tDatavRequests;
    }
    /**
     * 查询全部信息
     * @param tDatavRequest
     * @return
     */
    @Override
    public String getTDatavRequestForDataV(TDatavRequest tDatavRequest){
        List<TDatavRequest> tDatavRequests=getTDatavRequest(tDatavRequest);
        JSONArray jsonArray = new JSONArray();
        Map map=new HashMap();
        map.put("parkId",tDatavRequests.get(0).getParkId());
        jsonArray.add(map);
        String result= JsonUtil.beanToJson(jsonArray);
        DeleteTDatavRequest(tDatavRequests.get(0).getId());
        return result;
    }
    /**
     * 更新信息
     * @param tDatavRequest
     * @return
     */
    @Override
    public String UpdateTDatavRequest(TDatavRequest tDatavRequest)
    {
        if(tDatavRequest.getId()!=null){
            tDatavRequestMapper.updateByPrimaryKeySelective(tDatavRequest);
        }
        else
        {
            tDatavRequestMapper.insertSelective(tDatavRequest);
        }
        return "更新成功";
    }
    /**
     * 删除信息
     * @param id
     * @return
     */
    @Override
    public String DeleteTDatavRequest(Integer id){
        try {
            tDatavRequestMapper.deleteByPrimaryKey(id);
        }
        catch (Exception e){
            throw  e;
        }
        return "删除成功";
    }

    @Override
    public TDatavRequest selectByPrimaryKey(Integer id) {
        return tDatavRequestMapper.selectByPrimaryKey(id);
    }
}
