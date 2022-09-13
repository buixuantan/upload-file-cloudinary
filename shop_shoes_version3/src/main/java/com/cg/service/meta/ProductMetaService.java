package com.cg.service.meta;

import com.cg.repository.IProductMetaRepository;
import com.cg.repository.model.ProductMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductMetaService implements IProductMetaService{

    @Autowired
    private IProductMetaRepository productMetaRepository;

    @Override
    public List<ProductMeta> findAll() {
        return null;
    }

    @Override
    public Optional<ProductMeta> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductMeta save(ProductMeta productMeta) {
        return productMetaRepository.save(productMeta);
    }

    @Override
    public void remove(Long id) {

    }
}
