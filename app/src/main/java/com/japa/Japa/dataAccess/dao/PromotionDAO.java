package com.japa.Japa.dataAccess.dao;


import com.japa.Japa.dataAccess.repository.PromotionRepository;
import com.japa.Japa.model.Promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionDAO {
    private PromotionRepository promotionRepository;

    public PromotionDAO(PromotionRepository promotionRepository){
        this.promotionRepository = promotionRepository;
    }

    public ArrayList<Promotion> getPromotions(){
        ArrayList<Promotion> test = new ArrayList<>();
        return test;
    }
}
