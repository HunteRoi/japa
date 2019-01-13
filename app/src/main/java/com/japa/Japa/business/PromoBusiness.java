package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.PromoDAO;
import com.japa.Japa.model.Promo;

import java.util.List;

public class PromoBusiness {
    private PromoDAO promoDAO;

    public PromoBusiness(PromoDAO promoDAO){
        this.promoDAO = promoDAO;
    }

    public List<Promo> getPromos(String language){
        return promoDAO.getPromos();
    }
}
