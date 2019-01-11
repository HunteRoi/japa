package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.PromoDAO;
import com.japa.Japa.dataAccess.dao.PromotionDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Promo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class PromotionCalculation {

    private PromotionDAO promotionDAO;
    private PromoDAO promoDAO;

    public PromotionCalculation(PromotionDAO promotionDAO, PromoDAO promoDAO){
        this.promotionDAO = promotionDAO;
        this.promoDAO = promoDAO;
    }

    public Cart getCartDiscount(Cart cart, String language){
        List<Promo> promos = promoDAO.getPromos(language);
        Date date = new Date();
        for(Promo promo : promos){
            if(cart.getCart().containsKey(promo.getProduct().getId()) && date.after(promo.getPromotion().getStartDate()) && date.before(promo.getPromotion().getEndDate())){
                double discount = (cart.getCart().get(promo.getProduct().getId()).getProduct().getProductPrice()  * promo.getPromotion().getPourcent()) / 100;
                cart.getCart().get(promo.getProduct().getId()).setUnitDiscount(discount);
            }
        }
        return cart;
    }
}
