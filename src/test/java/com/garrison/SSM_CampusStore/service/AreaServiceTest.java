package com.garrison.SSM_CampusStore.service;

import com.garrison.SSM_CampusStore.BaseTest;
import com.garrison.SSM_CampusStore.cache.JedisPoolWriper;
import com.garrison.SSM_CampusStore.cache.JedisUtil;
import com.garrison.SSM_CampusStore.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Autowired
    private CacheService cacheService;
    @Autowired
    public AreaServiceTest(){

    }
    @Test
    public void testGetAreaList(){
        List<Area>areaList = areaService.getAreaList();
        Assert.assertEquals("西苑", ((Area)areaList.get(0)).getAreaName());
        AreaService var10001 = this.areaService;
        this.cacheService.removeFromCache("arealist");
        areaList = this.areaService.getAreaList();
    }
}
