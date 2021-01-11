package com.garrison.SSM_CampusStore.dao;

import com.garrison.SSM_CampusStore.BaseTest;
import com.garrison.SSM_CampusStore.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeadLineDaoTest extends BaseTest {
    @Autowired
    private HeadLineDao headLineDao;
    @Test
    public void testQueryHeadLine(){
        HeadLine headLineCondition = new HeadLine();
        List<HeadLine> headLineList = headLineDao.queryHeadLine(headLineCondition);
        assertEquals(4, headLineList.size());
    }

}
