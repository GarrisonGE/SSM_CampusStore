package com.garrison.SSM_CampusStore.service.impl;

import com.garrison.SSM_CampusStore.dao.ShopCategoryDao;
import com.garrison.SSM_CampusStore.entity.ShopCategory;
import com.garrison.SSM_CampusStore.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopcategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopcategoryCondition);
    }
}
