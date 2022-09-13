package com.cg.repository;

import com.cg.repository.model.ProductMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductMetaRepository extends JpaRepository<ProductMeta, String> {
}
