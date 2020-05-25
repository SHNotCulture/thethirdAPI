package com.api.service.impl;


import com.api.dao.TCarPayRuleMapper;
import com.api.entity.TCarPayRule;
import com.api.entity.TCarPayRuleCriteria;
import com.api.service.CarPayRuleService;
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
 * @Date Create in 17:492018-9-14
 * @Modified By:
 */
@Service
public class CarPayRuleServiceImpl implements CarPayRuleService {
    private  static final Logger logger= LoggerFactory.getLogger(CarPayRuleServiceImpl.class);
    @Autowired
    private TCarPayRuleMapper tCarPayRuleMapper;

    /**
     * 设置查询条件
     * @param tCarPayRule
     * @return
     */
    private TCarPayRuleCriteria setCriteria(TCarPayRule tCarPayRule){
        TCarPayRuleCriteria tCarPayRuleCriteria= new TCarPayRuleCriteria();
        //条件查询
        if(tCarPayRule!=null){
            TCarPayRuleCriteria.Criteria criteria=tCarPayRuleCriteria.createCriteria();
            if(tCarPayRule.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tCarPayRule.getCompanyId());
            }
            if(tCarPayRule.getParkId()!=null){
                criteria.andParkIdEqualTo(tCarPayRule.getParkId());
            }
        }
        return  tCarPayRuleCriteria;
    }
    /**
     * 获取数据总量
     * @param tCarPayRule
     * @return
     */
    private Integer getCount(TCarPayRule tCarPayRule){
        Integer total =(int)tCarPayRuleMapper.countByExample(setCriteria(tCarPayRule));
        return total;
    }
    /**
     * 查询月租缴费信息(分页)
     * @return
     */
    @Override
    public PageBean<TCarPayRule> getCarPayRulebyPage(TCarPayRule tCarPayRule, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCarPayRule> tCarPayRuleList=getCarPayRule(tCarPayRule);
        Integer countNums =getCount(tCarPayRule);
        PageBean<TCarPayRule> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tCarPayRuleList);
        return pageData;
    }
    /**
     * 查询月租缴费信息
     * @return
     */
    @Override
    public List<TCarPayRule> getCarPayRule(TCarPayRule tCarPayRule){
        List<TCarPayRule> tCarPayRuleList=tCarPayRuleMapper.selectByExample(setCriteria(tCarPayRule));
        return tCarPayRuleList;
    }
    /**
     * 更新月租规则
     * @param tCarPayRule
     * @return
     */
    @Override
    public String UpdateCarPayRule(TCarPayRule tCarPayRule)
    {
        logger.info(tCarPayRule.toString());
        if(tCarPayRule.getId()!=null){
            tCarPayRuleMapper.updateByPrimaryKeySelective(tCarPayRule);
        }
        else
        {
            tCarPayRuleMapper.insertSelective(tCarPayRule);
        }
        return "更新成功";
    }

    /**
     * 删除月租规则
     * @param id
     * @return
     */
    @Override
    public String DeleteCarPayRule(Integer id){
        tCarPayRuleMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    @Override
    public TCarPayRule getCarPayRuleByid(Integer id) {
        return tCarPayRuleMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取月租规则id
     * @param parkid
     * @param ruleName
     * @return
     */
    @Override
    public Integer getCarPayRuleId(Integer parkid, String ruleName) {
        TCarPayRuleCriteria tCarPayRuleCriteria= new TCarPayRuleCriteria();
        TCarPayRuleCriteria.Criteria criteria=tCarPayRuleCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkid);
        criteria.andRuleNameLike("%"+ruleName+"%");
        List<TCarPayRule> tCarPayRuleList=tCarPayRuleMapper.selectByExample(tCarPayRuleCriteria);
        return tCarPayRuleList.get(0).getId();
    }

    @Override
    public TCarPayRule selectByPrimaryKey(Integer id) {
        return tCarPayRuleMapper.selectByPrimaryKey(id);
    }
}
