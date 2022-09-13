package com.cg.controller.restAPI;

import com.cg.exception.DataInputException;
import com.cg.repository.model.Product;
import com.cg.dto.ProductParam;
import com.cg.service.category.ICategoryService;
import com.cg.service.product.IProductService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public ResponseEntity<?> getAllProductParams() {

        List<ProductParam> productParams = productService.findAllProductParams();

        if (productParams.isEmpty()) {
            return new ResponseEntity<>("List products is empty!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(productParams, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> create(@Validated ProductParam productParam, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        try {
            Product createdProduct = productService.create(productParam);

            Optional<ProductParam> productParamOptional = productService.findAllProductParamsById(createdProduct.getId());

            return new ResponseEntity<>(productParamOptional.get(), HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Product creation information is not valid, please check the information again");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<ProductParam> productParam = productService.findAllProductParamsById(id);

        if (productParam.isPresent()) {
            return new ResponseEntity<>(productParam.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Không tìm thấy", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> doUpdate(@Validated @PathVariable String id, @RequestBody ProductParam productParam, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            System.out.println("loi");
            return appUtils.mapErrorToResponse(bindingResult);
        }

        try {
            Product product = productService.doUpdate(productParam, id);
            if (product != null) {
                Optional<ProductParam> productParamOptional = productService.findAllProductParamsById(product.getId());
                return new ResponseEntity<>(productParamOptional.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>("Lỗi không tìm thấy trong data", HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>("Upload không thành công", HttpStatus.BAD_REQUEST);
        }
    }
//
//    public ResponseEntity doDelete(@RequestBody String id) {
//
//        Optional<ProductParam> productParamOptional = productService.findAllProductParamsById(id);
//
//        if(productParamOptional.isPresent()) {
//
//        }
//        return new ResponseEntity("không tìm thấy", HttpStatus.BAD_REQUEST);
//    }


}
