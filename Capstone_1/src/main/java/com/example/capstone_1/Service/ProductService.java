package com.example.capstone_1.Service;


import com.example.capstone_1.Controller.CategoryController;
import com.example.capstone_1.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {

    ArrayList<Product> products = new ArrayList<Product>();
    private final CategoryService categoryService;



    public ArrayList<Product> getProducts() {
        return products;
    }

    public String addProduct(Product product) {
        if (categoryService.existsById(product.getCategoryId())) {
            products.add(product);
            return "true";
        }
        return "Category does not exist";
    }

    public String updateProduct(int id,Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                if (categoryService.existsById(product.getCategoryId())) {
                    products.set(i, product);
                    return "true";
                }
                return "Category does not exist";
            }
        }
        return "Product does not exist";
    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean existsById(int id) {
        return products.stream().anyMatch(product -> product.getId() == id);
    }







}
