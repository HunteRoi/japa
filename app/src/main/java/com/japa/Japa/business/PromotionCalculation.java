package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.PromoDAO;
import com.japa.Japa.model.Cart;
import com.japa.Japa.model.Product;
import com.japa.Japa.model.Promo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PromotionCalculation {

    private PromoBusiness promoBusiness;

    public PromotionCalculation(PromoDAO promoDAO){
        promoBusiness = new PromoBusiness(promoDAO);
    }

    public void getCartDiscount(Cart cart, String language){
        List<Promo> promos = promoBusiness.getPromos(language);
        for(Promo promo : promos) {
            if(cart.getCart().containsKey(promo.getProduct().getId()) && promo.isApplicable()) {
                double discount = calculateDiscount(cart.getCart().get(promo.getProduct().getId()).getProduct().getProductPrice(), promo.getPromotion().getPourcent());
                promo.getProduct().setUnitDiscount(discount);
                cart.getCart().get(promo.getProduct().getId()).setUnitDiscount(discount);
            }
        }
    }

    public void getProductDiscount(Product product, String language) {
        List<Promo> promos = promoBusiness.getPromos(language);
        for(Promo promo : promos) {
            if (product.getId() == promo.getProduct().getId() && promo.isApplicable()) {
                double discount = calculateDiscount(product.getProductPrice(), promo.getPromotion().getPourcent());
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

    public double calculateDiscount(double totalPrice, double pourcent){
        return totalPrice * pourcent / 100;
    }
}
