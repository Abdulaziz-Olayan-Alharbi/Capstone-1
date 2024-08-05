package com.example.capstone_1.Service;

import com.example.capstone_1.Model.Coupon;
import com.example.capstone_1.Model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CouponService {

    ArrayList<Coupon> coupons = new ArrayList<>();

    final MerchantService merchantService;

    final ProductService productService;


    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public String addCoupon(Coupon coupon) {
        if (productService.existsById(coupon.getProductId())){
            if (merchantService.existsById(coupon.getMerchantId())){
                coupons.add(coupon);
                return "true";
            }
            return "Merchant does not exist";
        }
        return "Product does not exist";
    }

    public String updateCoupons(int id,Coupon coupon) {
        for (int i = 0; i < coupons.size(); i++) {
            if (productService.existsById(coupon.getProductId())){
                if (merchantService.existsById(coupon.getMerchantId())){
                    coupons.set(i,coupon);
                    return "true";
                }
                return "Merchant does not exist";
            }
            return "Product does not exist";
        }
        return "Coupon does not exist";
    }

    public boolean deleteCoupon(int id) {
        for (int i = 0; i < coupons.size(); i++) {
            if (coupons.get(i).getId()==id) {
                coupons.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Coupon> getCouponsProduct(int id) {
        ArrayList<Coupon> couponsProduct = new ArrayList<>();
        for (int i = 0; i < coupons.size(); i++) {
            if (coupons.get(i).getProductId()==id) {
                couponsProduct.add(coupons.get(i));
            }
        }
        return couponsProduct;
    }
}
