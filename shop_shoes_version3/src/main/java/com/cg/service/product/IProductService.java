package com.cg.service.product;

import com.cg.repository.model.Product;
import com.cg.dto.ProductParam;
import com.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {

    List<ProductParam> findAllProductParams();

    Optional<ProductParam> findAllProductParamsById(String id);

    Product create(ProductParam productParam);

    Product doUpdate(ProductParam productParam, String id);
}
