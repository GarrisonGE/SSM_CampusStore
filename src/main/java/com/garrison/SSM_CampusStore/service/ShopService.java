package com.garrison.SSM_CampusStore.service;

import com.garrison.SSM_CampusStore.dto.ImageHolder;
import com.garrison.SSM_CampusStore.dto.ShopExecution;
import com.garrison.SSM_CampusStore.entity.Shop;
import com.garrison.SSM_CampusStore.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    // 添加shop
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail);
    // 查询shop
    public Shop getByShopId(long shopId);
    //更新shop
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
    //根据shopCondition分页返回相应店铺列表
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pagesize);
}
