package com.cg.service.product_category;

import com.cg.repository.IProductCategoryRepository;
import com.cg.repository.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService implements IProductCategoryService{

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
