package com.japa.Japa.dataAccess.dao;


import com.japa.Japa.dataAccess.entity.PromotionEntity;
import com.japa.Japa.dataAccess.interfaceDAO.IPromotionDAO;
import com.japa.Japa.dataAccess.repository.PromotionRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.Promotion;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PromotionDAO implements IPromotionDAO {
    private PromotionRepository promotionRepository;
    private ProviderConverter providerConverter;

    public PromotionDAO(PromotionRepository promotionRepository, ProviderConverter providerConverter){
        this.promotionRepository = promotionRepository;
        this.providerConverter = providerConverter;
    }

    public List<Promotion> getPromotions(){
        List<PromotionEntity> promotionEntities = promotionRepository.findAll();
        List<Promotion> promotions = new ArrayList<>();
        for(PromotionEntity promotionEntity : promotionEntities){
            promotions.add(providerConverter.promotionEntityToPromotionModel(promotionEntity));
        }
        return promotions;
    }
}
