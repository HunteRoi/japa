package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.PromoEntity;
import com.japa.Japa.dataAccess.repository.PromoRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.Promo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PromoDAO {
    private PromoRepository promoRepository;
    private ProviderConverter providerConverter;

    public PromoDAO(PromoRepository promoRepository, ProviderConverter providerConverter){
        this.promoRepository = promoRepository;
        this.providerConverter = providerConverter;
    }

    public List<Promo> getPromos(String language){
        List<PromoEntity> promoEntities = promoRepository.findAll();
        List<Promo> promos = new ArrayList<>();
        for(PromoEntity promoEntity : promoEntities){
            promos.add(providerConverter.promoEntityToPromoModel(promoEntity, language));
        }
        return promos;
    }
}
