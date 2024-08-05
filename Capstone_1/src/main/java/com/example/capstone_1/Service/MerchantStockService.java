package com.example.capstone_1.Service;

import com.example.capstone_1.Model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    final MerchantService merchantService;

    final ProductService productService;


    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public String addMerchantStock(MerchantStock merchantStock) {
        if (productService.existsById(merchantStock.getProductId())){
            if(merchantService.existsById(merchantStock.getMerchantId())){
                merchantStocks.add(merchantStock);
                return "true";
            }
            return "Merchant does not exist";
        }
        return "Product does not exist";
    }

    public String updateMerchantStock(int id,MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId()==id) {
                if (productService.existsById(merchantStock.getProductId())){
                    if(merchantService.existsById(merchantStock.getMerchantId())){
                        merchantStocks.set(i,merchantStock);
                        return "true";
                    }
                    return "Merchant does not exist";
                }
                return "Product does not exist";
            }
        }
        return "Merchant Stock does not exist";
    }

    public boolean deleteMerchantStock(int id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId()==id) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public String addStock(int productId , int merchantId , int stock){
        if (productService.existsById(productId)){
            if (merchantService.existsById(merchantId)){
                for (MerchantStock merchantStock : merchantStocks) {
                    if (merchantStock.getProductId()==productId&&merchantStock.getMerchantId()==merchantId){
                        merchantStock.setStock(merchantStock.getStock()+stock);
                        return "true";
                    }
                    return "Merchant Stock does not exist";
                }
            }
            return "Merchant does not exist";
        }
        return "Product does not exist";
    }

    public boolean isThereStock(int productId , int merchantId){
        if (productService.existsById(productId)&&merchantService.existsById(merchantId)){
            for (MerchantStock merchantStock : merchantStocks) {
                if (merchantStock.getProductId()==productId&&merchantStock.getMerchantId()==merchantId&&merchantStock.getStock()>0){
                    merchantStock.setStock(merchantStock.getStock()-1);
                    return true;
                }
            }
        }
        return false;
    }


    }




















