package com.api.service.impl;

import com.api.dao.TChargeRuleMapper;
import com.api.entity.TChargeRule;
import com.api.entity.TChargeRuleCriteria;
import com.api.service.ChargeRuleService;
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
 * @Date Create in 18:082018-9-14
 * @Modified By:
 */
@Service
public class ChargeRuleServiceImpl implements ChargeRuleService {
    private  static final Logger logger= LoggerFactory.getLogger(ChargeRuleServiceImpl.class);
    @Autowired
    private TChargeRuleMapper tChargeRuleMapper;
    /**
     * 设置查询条件
     * @param tChargeRule
     * @return
     */
    private TChargeRuleCriteria setCriteria(TChargeRule tChargeRule){
        TChargeRuleCriteria tChargeRuleCriteria= new TChargeRuleCriteria();
        if(tChargeRule!=null){
            TChargeRuleCriteria.Criteria criteria=tChargeRuleCriteria.createCriteria();
            if(tChargeRule.getParkId()!=null){
                criteria.andParkIdEqualTo(tChargeRule.getParkId());
            }
        }
        return  tChargeRuleCriteria;
    }
    /**
     * 获取数据总量
     * @param tChargeRule
     * @return
     */
    private Integer getCount(TChargeRule tChargeRule){
        Integer total =(int)tChargeRuleMapper.countByExample(setCriteria(tChargeRule));
        return total;
    }
    /**
     *查询临停缴费信息(分页)
     * @param tChargeRule
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TChargeRule> getChargeRulebyPage(TChargeRule tChargeRule, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TChargeRule> tChargeRuleList=getChargeRule(tChargeRule);
        Integer countNums =getCount(tChargeRule);
        PageBean<TChargeRule> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tChargeRuleList);
        return pageData;
    }
    /**
     * 查询临停缴费信息
     * @return
     */
    public List<TChargeRule> getChargeRule(TChargeRule tChargeRule){
        logger.info("tChargeRule:"+tChargeRule);
        //查询全部临停缴费信息
        List<TChargeRule> tChargeRuleList=tChargeRuleMapper.selectByExample(setCriteria(tChargeRule));
        return tChargeRuleList;
    }


    /**
     * 更新临停缴费信息
     * @param tChargeRule
     * @return
     */
    public String UpdateChargeRule(TChargeRule tChargeRule)
    {
        logger.info(tChargeRule.toString());
        if(tChargeRule.getId()!=null){
            tChargeRuleMapper.updateByPrimaryKeySelective(tChargeRule);
        }
        else
        {
            tChargeRuleMapper.insertSelective(tChargeRule);
        }
        return "更新成功";
    }

    /**
     * 删除临停缴费信息
     * @param id
     * @return
     */
    public String DeleteChargeRule(Integer id){
        tChargeRuleMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }


}
