package com.garrison.SSM_CampusStore.service.impl;

import com.garrison.SSM_CampusStore.dao.HeadLineDao;
import com.garrison.SSM_CampusStore.dao.ShopCategoryDao;
import com.garrison.SSM_CampusStore.entity.HeadLine;
import com.garrison.SSM_CampusStore.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {
        return headLineDao.queryHeadLine(headLineCondition);
    }
}
