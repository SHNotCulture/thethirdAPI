package com.api.service;

import com.api.entity.TTruckSpace;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 17:562018-9-14
 * @Modified By:
 */
public interface TruckSpaceService {
    PageBean<TTruckSpace> getTruckSpacebyPage(TTruckSpace tTruckSpace, Integer page, Integer limit);
    List<TTruckSpace> getTruckSpace(TTruckSpace tTruckSpace);
    String UpdateTruckSpace(TTruckSpace tTruckSpace);
    String DeleteTruckSpace(Integer id);
    TTruckSpace selectByPrimaryKey(Integer id);

}
