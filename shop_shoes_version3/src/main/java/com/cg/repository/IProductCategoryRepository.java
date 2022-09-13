package com.cg.repository;

import com.cg.repository.model.ProductCategory;
import com.cg.repository.model.ProductCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryId> {
}
