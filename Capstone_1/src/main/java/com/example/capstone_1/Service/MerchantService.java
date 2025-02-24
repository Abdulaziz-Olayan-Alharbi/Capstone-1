package com.example.capstone_1.Service;

import com.example.capstone_1.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public void addMerchant(Merchant merchant) {
        merchants.add(merchant);
    }

    public boolean updateMerchant(int id,Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId() == id) {
                merchants.set(i, merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(int id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId() == id) {
                merchants.remove(i);
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
                return "can not update status";
            }
        }
        return "Order does not exist";
    }

    public boolean existsById(int id) {
        return merchants.stream().anyMatch(merchant -> merchant.getId() == id);
    }



















}
