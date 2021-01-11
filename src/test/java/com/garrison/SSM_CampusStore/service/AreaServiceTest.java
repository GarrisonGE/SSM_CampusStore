package com.garrison.SSM_CampusStore.service;

import com.garrison.SSM_CampusStore.BaseTest;
import com.garrison.SSM_CampusStore.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area>areaList = areaService.getAreaList();
        assertEquals("西苑",areaList.get(0).getAreaName());
    }
}
