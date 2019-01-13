package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.CategoryDAO;
import com.japa.Japa.model.Category;
import java.util.List;

public class CategoryBusiness {
    private CategoryDAO categoryDAO;

    public CategoryBusiness(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getCategories(){
        return  categoryDAO.getCategories();
    }
}
