package com.cg.repository;

import com.cg.repository.model.Product;
import com.cg.dto.ProductParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> {

    @Query("select new com.cg.dto.ProductParam (" +
            "p.id, " +
            "p.name, " +
            "p.title, " +
            "p.price, " +
            "p.material," +
            "p.quantity, " +
            "p.bestseller, " +
            "p.hot, " +
            "p.status, " +
            "p.description, " +
            "pro_size.size.id, " +
            "pro_size.size.size," +
            "pro_color.color.id, " +
            "pro_color.color.color," +
            "pro_cat.category.id, " +
            "pro_cat.category.title," +
            "pm.id," +
            "pm.fileName," +
            "pm.fileFolder," +
            "pm.fileUrl," +
            "pm.cloudId" +
            ") from Product p " +
            "join ProductMeta pm on p.id = pm.product.id " +
            "join ProductCategory pro_cat on pro_cat.product.id = p.id " +
            "join ProductSize pro_size on pro_size.product.id = p.id " +
            "join ProductColor pro_color on pro_color.product.id = p.id")
    List<ProductParam> getAllProductParams();

    @Query("select new com.cg.dto.ProductParam (" +
            "p.id, " +
            "p.name, " +
            "p.title, " +
            "p.price, " +
            "p.material," +
            "p.quantity, " +
            "p.bestseller, " +
            "p.hot, " +
            "p.status, " +
            "p.description, " +
            "pro_size.size.id, " +
            "pro_size.size.size," +
            "pro_color.color.id, " +
            "pro_color.color.color," +
            "pro_cat.category.id, " +
            "pro_cat.category.title," +
            "pm.id," +
            "pm.fileName," +
            "pm.fileFolder," +
            "pm.fileUrl," +
            "pm.cloudId" +
            ") from Product p " +
            "join ProductMeta pm on p.id = pm.product.id " +
            "join ProductCategory pro_cat on pro_cat.product.id = p.id " +
            "join ProductSize pro_size on pro_size.product.id = p.id " +
            "join ProductColor pro_color on pro_color.product.id = p.id " +
            "where p.id=:id")
    Optional<ProductParam> getAllProductParamsById(@Param("id") String id);
}
