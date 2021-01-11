package com.garrison.SSM_CampusStore.service.impl;

import com.garrison.SSM_CampusStore.dao.AreaDao;
import com.garrison.SSM_CampusStore.entity.Area;
import com.garrison.SSM_CampusStore.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
