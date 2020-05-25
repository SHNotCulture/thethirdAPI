package com.api.service;


import com.api.entity.TModuleListNew;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 18:282018-9-14
 * @Modified By:
 */
public interface ModuleListService {
    List<TModuleListNew> getModuleList(TModuleListNew tModuleListNew);
}
