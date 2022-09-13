package com.cg.repository;

import com.cg.repository.model.ProductColor;
import com.cg.repository.model.ProductColorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductColorRepository extends JpaRepository<ProductColor, ProductColorId> {
}
