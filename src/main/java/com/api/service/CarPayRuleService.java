package com.api.service;

import com.api.entity.TCarPayRule;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 17:492018-9-14
 * @Modified By:
 */
public interface CarPayRuleService {
    PageBean<TCarPayRule> getCarPayRulebyPage(TCarPayRule tCarPayRule, Integer page, Integer limit);
    List<TCarPayRule> getCarPayRule(TCarPayRule tCarPayRule);
    String UpdateCarPayRule(TCarPayRule tCarPayRule);
    String DeleteCarPayRule(Integer id);
    TCarPayRule getCarPayRuleByid(Integer id);
    Integer getCarPayRuleId(Integer parkid, String ruleName);
    TCarPayRule selectByPrimaryKey(Integer id);
}
