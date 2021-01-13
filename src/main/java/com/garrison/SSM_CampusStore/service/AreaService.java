package com.garrison.SSM_CampusStore.service;

import com.garrison.SSM_CampusStore.entity.Area;

import java.util.List;

public interface AreaService {
    public static final String AREALISTKEY="arealist";
    List<Area> getAreaList();
}
