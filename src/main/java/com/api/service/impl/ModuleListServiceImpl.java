package com.api.service.impl;

import com.api.dao.TModuleListMapper;
import com.api.dao.TModuleListNewMapper;
import com.api.entity.TModuleListNew;
import com.api.entity.TModuleListNewCriteria;
import com.api.service.ModuleListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 18:282018-9-14
 * @Modified By:
 */
@Service
public class ModuleListServiceImpl implements ModuleListService {
    private  static final Logger logger= LoggerFactory.getLogger(ModuleListServiceImpl.class);

    @Autowired
    private TModuleListMapper tModuleListMapper;
    @Autowired
    private TModuleListNewMapper tModuleListNewMapper;

    /**
     * 查询全部页面信息
     * @return
     */
    public List<TModuleListNew> getModuleList(TModuleListNew tModuleListNew){
        logger.info("tModuleListNew:"+tModuleListNew);
        //查询全部车场信息
        TModuleListNewCriteria tModuleListNewCriteria= new TModuleListNewCriteria();
        if(tModuleListNew!=null){
            TModuleListNewCriteria.Criteria criteria=tModuleListNewCriteria.createCriteria();

        }
        List<TModuleListNew> tModuleListNews=tModuleListNewMapper.selectByExample(tModuleListNewCriteria);
        return tModuleListNews;
    }




    /**
     * 根据用户权限查询二级菜单
     * @param pid
     * @param tModuleListNew
     * @return
     */
    public List<TModuleListNew> getModuleListNewForSecond(Integer pid, List<Integer> tModuleListNew){
        TModuleListNewCriteria tModuleListCriteria= new TModuleListNewCriteria();
        TModuleListNewCriteria.Criteria criteria=tModuleListCriteria.createCriteria();
        criteria.andPidEqualTo(pid);
        criteria.andIdIn(tModuleListNew);
        tModuleListCriteria.setOrderByClause("id asc");

        List<TModuleListNew> tModuleLists=tModuleListNewMapper.selectByExample(tModuleListCriteria);
        return tModuleLists;
    }
}
