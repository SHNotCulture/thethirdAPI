package com.api.service;

import com.api.entity.TDayOff;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 16:542018-11-6
 * @Modified By:
 */
public interface DayOffService {
    PageBean<TDayOff> getDayOffbyPage(TDayOff tDayOff, Integer page, Integer limit);
    List<TDayOff> getDayOff(TDayOff tDayOff);
    String UpdateDayOff(TDayOff tDayOff);
    String DeleteDayoff(Integer id);
}
