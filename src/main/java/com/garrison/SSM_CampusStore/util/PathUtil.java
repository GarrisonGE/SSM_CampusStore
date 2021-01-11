package com.garrison.SSM_CampusStore.util;

public class PathUtil {
        private static String seperator = System.getProperty("file.separator");
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath="";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/projectdev/image/";
        }else{
            basePath = "/Users/jiahaoge/Personal/面试资料/项目笔记/校园商铺项目资料/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/images/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}
