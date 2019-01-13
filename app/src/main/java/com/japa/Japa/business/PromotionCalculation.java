package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.PromoDAO;
import com.japa.Japa.dataAccess.dao.PromotionDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Product;
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

    public void getCartDiscount(Cart cart, String language){
        List<Promo> promos = promoDAO.getPromos(language);
        for(Promo promo : promos) {
            if(cart.getCart().containsKey(promo.getProduct().getId()) && promo.isApplicable()) {
                double discount = (cart.getCart().get(promo.getProduct().getId()).getProduct().getProductPrice()  * promo.getPromotion().getPourcent()) / 100;
                promo.getProduct().setUnitDiscount(discount);
                cart.getCart().get(promo.getProduct().getId()).setUnitDiscount(discount);
            }
        }
    }

    public void getProductDiscount(Product product, String language) {
        List<Promo> promos = promoDAO.getPromos(language);
        for(Promo promo : promos) {
            if (product.getId() == promo.getProduct().getId() && promo.isApplicable()) {
                double discount = (product.getProductPrice() * promo.getPromotion().getPourcent()) / 100;
                promo.getProduct().setUnitDiscount(discount);
                product.setUnitDiscount(discount);
            }
        }
    }

    public void getProductsDiscounts(List<Product> products, String language) {
        for(Product product : products) {
            getProductDiscount(product, language);
        }
    }
}
