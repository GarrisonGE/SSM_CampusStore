package com.garrison.SSM_CampusStore.service;

import com.garrison.SSM_CampusStore.entity.ProductCategory;
import com.garrison.SSM_CampusStore.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    public static String SCLISTKEY = "shopcategorylist";
    List<ShopCategory> getShopCategoryList(ShopCategory shopcategoryCondition);


}
