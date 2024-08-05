package com.example.capstone_1.Service;


import com.example.capstone_1.Model.Coupon;
import com.example.capstone_1.Model.Order;
import com.example.capstone_1.Model.Product;
import com.example.capstone_1.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    ArrayList<User> users = new ArrayList<User>();

    final MerchantStockService merchantStockService;
    final ProductService productService;
    final CouponService couponService;
    final OrderService orderService;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(int id ,User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public String buyProduct(int userId , int productId , int merchantId ) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                for (Product product : productService.getProducts()) {
                    if (product.getId() == productId) {
                        if (users.get(i).getBalance() >= product.getPrice()) {
                            if (users.get(i).getRole().equals("Customer")) {
                                if (merchantStockService.isThereStock(productId, merchantId)) {
                                    users.get(i).setBalance(users.get(i).getBalance() - product.getPrice());
                                    orderService.addOrder(new Order(1, userId, productId, merchantId, "Received"));
                                    return "true";
                                }
                                return "Merchant Stock does not exist";
                            }
                            return "User must be a Customer";
                        }
                        return "User does not have enough balance";
                    }
                    return "Product does not exist";
                }
            }
        }
        return "User not found";
    }


    public String buyProductWithCoupon(int userId , int productId , int merchantId , int couponId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                for (Coupon coupon : couponService.getCoupons()) {
                    if (coupon.getId() == couponId && coupon.getMerchantId() == merchantId && coupon.getProductId() == productId) {
                        for (Product product : productService.getProducts()) {
                            if (product.getId() == productId) {
                                if (users.get(i).getBalance() >= product.getPrice()-((product.getPrice()/100) * coupon.getPercent())) {
                                    if (users.get(i).getRole().equals("Customer")){
                                    if (merchantStockService.isThereStock(productId, merchantId)) {
                                        users.get(i).setBalance(users.get(i).getBalance() - (product.getPrice() - ((product.getPrice() / 100) * coupon.getPercent())));
                                        orderService.addOrder(new Order(1, userId, productId, merchantId, "Received"));
                                        return "true";
                                    }
                                    return "Merchant does not exist";
                                    }
                                    return "User must be a Customer";
                                }
                                return "User does not have enough balance";
                            }
                            return "Product does not exist";
                        }
                    }
                    return "Coupon does not exist";
                }
            }
        }
        return "User not found";
    }

    public boolean existsById(int id) {
        return users.stream().anyMatch(user -> user.getId() == id);
    }






















}
