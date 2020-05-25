package com.api.service.impl;

import com.api.dao.TRolePowerNewMapper;
import com.api.entity.TRolePower;
import com.api.entity.TRolePowerNew;
import com.api.entity.TRolePowerNewCriteria;
import com.api.service.RolePowerService;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 19:012018-11-6
 * @Modified By:
 */
@Service
public class RolePowerServiceImpl implements RolePowerService {
    @Autowired
    private TRolePowerNewMapper tRolePowerMapper;

    /**
     *设置查询条件
     * @param tRolePower
     * @return
     */
    private TRolePowerNewCriteria setCriteria(TRolePowerNew tRolePower){
        TRolePowerNewCriteria tRolePowerCriteria= new TRolePowerNewCriteria();
        List<TRolePower> tRolePowerList=new ArrayList<>();
            if(tRolePower!=null){
                TRolePowerNewCriteria.Criteria criteria=tRolePowerCriteria.createCriteria();
                criteria.andUserIdNotEqualTo(0);
                if(tRolePower.getCompanyId()!=null){
                    criteria.andCompanyIdEqualTo(tRolePower.getCompanyId());
                }
                if(tRolePower.getId()!=null)
                {
                    criteria.andIdEqualTo(tRolePower.getId());
                }
            }
        return  tRolePowerCriteria;
    }
    /**
     *获取数据总量
     * @param tRolePower
     * @return
     */
    private Integer getCount(TRolePowerNew tRolePower){
        Integer total =(int)tRolePowerMapper.countByExample(setCriteria(tRolePower));
        return total;
    }
    /**
     * 查询全部角色信息（分页）
     * @param tRolePower
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean<TRolePowerNew> getRolePowerbyPage(TRolePowerNew tRolePower, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TRolePowerNew> tRolePowerList=getRolePower(tRolePower);
        Integer countNums =getCount(tRolePower);
        PageBean<TRolePowerNew> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tRolePowerList);
        return pageData;
    }
    /**
     * 查询全部角色信息
     * @param tRolePower
     * @return
     */
    @Override
    public List<TRolePowerNew> getRolePower(TRolePowerNew tRolePower){
        List<TRolePowerNew> tRolePowerList=tRolePowerMapper.selectByExample(setCriteria(tRolePower));
        return tRolePowerList;
    }
    /**
     * 通过ID查询角色信息
     * @param tRolePower
     * @return
     */
    @Override
    public List<TRolePowerNew> getRolePowerById(TRolePowerNew tRolePower){
        TRolePowerNewCriteria tRolePowerCriteria= new TRolePowerNewCriteria();
        List<TRolePowerNew> tRolePowerList=new ArrayList<>();
        try {
            if(tRolePower!=null){
                TRolePowerNewCriteria.Criteria criteria=tRolePowerCriteria.createCriteria();
                if(tRolePower.getCompanyId()!=null){
                    criteria.andCompanyIdEqualTo(tRolePower.getCompanyId());
                }
                if(tRolePower.getId()!=null)
                {
                    criteria.andIdEqualTo(tRolePower.getId());
                }
            }
            tRolePowerList=tRolePowerMapper.selectByExample(tRolePowerCriteria);
        }
        catch (Exception e){
            throw  e;
        }

        return tRolePowerList;
    }
    /**
     * 更新角色信息
     * @param tRolePower
     * @return
     */
    @Override
    public String UpdateRolePower(TRolePowerNew tRolePower)
    {
        if(tRolePower.getId()!=null){
            tRolePowerMapper.updateByPrimaryKeySelective(tRolePower);
        }
        else
        {
            tRolePowerMapper.insertSelective(tRolePower);
        }
        return "更新成功";
    }
    /**
     * 删除角色信息
     * @param id
     * @return
     */
    @Override
    public String DeleteRolePower(Integer id){
        try {
            tRolePowerMapper.deleteByPrimaryKey(id);
        }
        catch (Exception e){
            throw  e;
        }
        return "删除成功";
    }

    @Override
    public TRolePowerNew selectByPrimaryKey(Integer id) {
        return tRolePowerMapper.selectByPrimaryKey(id);
    }
}
