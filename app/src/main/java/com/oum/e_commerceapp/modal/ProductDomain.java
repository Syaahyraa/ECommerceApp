package com.oum.e_commerceapp.modal;

import java.io.Serializable;

/**
 * Created by User on 3/15/2018.
 */

public class ProductDomain{

    String productName;
    String productPrice;
    int imageId;

    public ProductDomain(){

    }

    public ProductDomain(String ProductName, String productPrice, int imageId) {
        this.productName = ProductName;
        this.productPrice = productPrice;
        this.imageId = imageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
