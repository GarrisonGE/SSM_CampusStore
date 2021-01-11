package com.garrison.SSM_CampusStore.dao;

import com.garrison.SSM_CampusStore.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    // interface中方法的访问修饰符默认为public，abstract
    List<Area> queryArea();
}
