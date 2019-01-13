package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.PromotionDAO;
import com.japa.Japa.model.Promotion;

import java.util.List;

public class PromotionBusiness {
    private PromotionDAO promotionDAO;

    public PromotionBusiness(PromotionDAO promotionDAO){
        this.promotionDAO = promotionDAO;
    }

    public List<Promotion> getPromotions(){
        return promotionDAO.getPromotions();
    }
}
