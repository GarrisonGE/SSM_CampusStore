package com.garrison.SSM_CampusStore.dto;

import com.garrison.SSM_CampusStore.entity.Product;
import com.garrison.SSM_CampusStore.enums.ProductStateEnum;

import java.util.List;

public class ProductExecution {
    //结果标识符
    private int state;
    //状态标识
    private String stateInfo;
    //商品数量
    private int count;
    //操作的product(增删改商品的时候用)
    private Product product;
    //操作的product list(查询商品列表的时候用）
    private List<Product> productList;

    public ProductExecution(){

    }
    //增删改商品成功的构造器
    public ProductExecution(ProductStateEnum stateEnum, Product product){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.product = product;
    }
    //查询商品列表成功的构造器
    public ProductExecution(ProductStateEnum stateEnum, List<Product> productList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.productList = productList;
    }
    //失败的构造器
    public ProductExecution(ProductStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
