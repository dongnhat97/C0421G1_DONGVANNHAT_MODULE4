package com.demo.cartDto;
import com.demo.model.bean.Product;

import java.util.HashMap;
import java.util.Map;
public class CartDto {
    private Map<ProductDto,Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProducts() {
        return productMap;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.productMap = products;
    }
    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto))  {
            Integer value = productMap.get(productDto);
            productMap.put(productDto,value+1);
        }else {
            productMap.put(productDto,1);
        }
    }
}
