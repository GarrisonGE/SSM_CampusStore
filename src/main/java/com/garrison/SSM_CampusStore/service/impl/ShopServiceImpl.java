package com.garrison.SSM_CampusStore.service.impl;

import com.garrison.SSM_CampusStore.dao.ShopDao;
import com.garrison.SSM_CampusStore.dto.ImageHolder;
import com.garrison.SSM_CampusStore.dto.ShopExecution;
import com.garrison.SSM_CampusStore.entity.Shop;
import com.garrison.SSM_CampusStore.enums.ShopStateEnum;
import com.garrison.SSM_CampusStore.exceptions.ShopOperationException;
import com.garrison.SSM_CampusStore.service.ShopService;
import com.garrison.SSM_CampusStore.util.ImageUtil;
import com.garrison.SSM_CampusStore.util.PageCalculator;
import com.garrison.SSM_CampusStore.util.PathUtil;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail) {
        //空值判断
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息赋初始值
            shop.setEnableStatus(0); // 0 means under audit
            shop.setCreateTime(new Date());
            shop.setLastEditTime((new Date()));
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum <=0){
                throw new ShopOperationException("店铺创建失败"); // RuntimeException 错误才会让事物回滚，exception该执行就执行了
            }else{
                if(thumbnail.getImage() !=null){
                    //存储图片
                    try{
                        addShopImg(shop, thumbnail);
                    }catch(Exception e){
                        throw new ShopOperationException("addShopImg error:" + e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }

        }catch(Exception e){
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK);
    }

    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    @Override
    @Transactional
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            try {
                //1.判断是否要处理图片
                if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    addShopImg(shop, thumbnail);
                }
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            } catch (Exception e) {
                throw new ShopOperationException("modifyShop error:" + e.getMessage());
            }
        }
    }

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pagesize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pagesize);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pagesize);
        int count = shopDao.queryShopCount(shopCondition);
        ShopExecution se = new ShopExecution();
        if(shopList != null){
            se.setShopList(shopList);
            se.setCount(count);
        }else{
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }

    private void addShopImg(Shop shop, ImageHolder thumbnail){
        //获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(thumbnail,dest);
        shop.setShopImg(shopImgAddr);
    }
}
