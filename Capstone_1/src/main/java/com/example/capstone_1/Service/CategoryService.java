package com.example.capstone_1.Service;

import com.example.capstone_1.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<Category>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public boolean updateCategory(int id,Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categories.set(i, category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean existsById(int id) {
        return categories.stream().anyMatch(category -> category.getId() == id);
    }
}
