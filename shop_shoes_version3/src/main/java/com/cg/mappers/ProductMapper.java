package com.cg.mappers;

import com.cg.repository.model.*;
import com.cg.dto.ProductParam;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductParam productParam) {
        return new Product()
                .setId(productParam.getId())
                .setName(productParam.getName())
                .setTitle(productParam.getTitle())
                .setPrice(productParam.getPrice())
                .setMaterial(productParam.getMaterial())
                .setQuantity(productParam.getQuantity())
                .setBestseller(productParam.isBestseller())
                .setHot(productParam.isHot())
                .setStatus(productParam.isStatus())
                .setDescription(productParam.getDescription());
    }

    public ProductMeta toProductMeta(ProductParam productParam) {
        return new ProductMeta()
                .setId(productParam.getProductMetaId())
                .setFileName(productParam.getFileName())
                .setFileFolder(productParam.getFileFolder())
                .setFileUrl(productParam.getFileUrl())
                .setCloudId(productParam.getCloudId());
    }

    public Category toCategory(ProductParam productParam) {
        return new Category()
                .setId(productParam.getCategoryId())
                .setTitle(productParam.getNameCategory());
    }

    public Color toColor(ProductParam productParam) {
        return new Color()
                .setId(productParam.getColorId())
                .setColor(productParam.getColor());
    }

    public Size toSize(ProductParam productParam) {
        return new Size()
                .setId(productParam.getSizeId())
                .setSize(productParam.getSize());
    }

    public ProductCategory toProductCategory(Category category, Product product) {
        return new ProductCategory()
                .setId(new ProductCategoryId(product.getId(),category.getId()))
                .setCategory(category)
                .setProduct(product);
    }

    public ProductColor toProductColor(Color color, Product product) {
        return new ProductColor()
                .setId(new ProductColorId( product.getId(), color.getId()))
                .setColor(color)
                .setProduct(product);
    }

    public ProductSize toProductSize(Size size, Product product) {
        return new ProductSize()
                .setId(new ProductSizeId(product.getId(), size.getId()))
                .setSize(size)
                .setProduct(product);
    }

}
