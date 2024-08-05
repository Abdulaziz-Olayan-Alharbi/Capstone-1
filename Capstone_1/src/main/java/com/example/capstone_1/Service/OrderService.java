package com.example.capstone_1.Service;

import com.example.capstone_1.Model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {

    ArrayList<Order> orders = new ArrayList<>();

   // final UserService userService;

    final ProductService productService;

    final MerchantService merchantService;



    public ArrayList<Order> getOrders() {
        return orders;
    }

    public String addOrder(Order order) {
        if (productService.existsById(order.getProductId())) {
            if (merchantService.existsById(order.getMerchantId())){
                orders.add(order);
                return "true";
            }
            return "Merchant does not exist";
        }
        return "Product does not exist";
    }

    public String updateOrder(int id,Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (productService.existsById(order.getProductId())) {
                if (merchantService.existsById(order.getMerchantId())){
                    orders.set(i,order);
                    return "true";
                }
                return "Merchant does not exist";
            }
            return "Product does not exist";
        }
        return "Order does not exist";
    }

    public boolean deleteOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    public String updateStatus(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                if (orders.get(i).getStatus().equals("Received")){
                    orders.get(i).setStatus("Shipping");
                    return "true";
                }
                if (orders.get(i).getStatus().equals("Shipping")){
                    orders.get(i).setStatus("Shipped");
                    return "true";
                }
                return "it is shipped , can nou update status";
            }
        }
        return "Order does not exist";
    }
}
