package com.garrison.SSM_CampusStore.controller.frontend;

import com.garrison.SSM_CampusStore.entity.Product;
import com.garrison.SSM_CampusStore.service.ProductService;
import com.garrison.SSM_CampusStore.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/frontend")
public class ProductDetailController {
    @Autowired
    private ProductService productService;

    /**
     * 根据前端传过来的productID，获取product详情情况
     * @param request
     * @return
     */
    @RequestMapping(value="/listproductdetailpageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listProductDetailPageInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        //获取前端传过来的product id
        long productId = HttpServletRequestUtil.getLong(request,"productId");
        Product product = null;
        //空值判断
        if(productId != -1){
            //根据productId获取商品信息，包含商品详情图列表
            product = productService.getProductById(productId);
            modelMap.put("product", product);
            modelMap.put("success", true);
        }else{
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty productId");
        }
        return modelMap;
    }
}
