package com.cg.service.product;

import com.cg.exception.DataInputException;
import com.cg.mappers.ProductMapper;
import com.cg.repository.*;
import com.cg.repository.model.*;
import com.cg.dto.ProductParam;
import com.cg.service.category.ICategoryService;
import com.cg.service.color.IColorService;
import com.cg.service.size.ISizeService;
import com.cg.service.upload.IUploadService;
import com.cg.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductMetaRepository productMetaRepository;

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Autowired
    private IProductColorRepository productColorRepository;

    @Autowired
    private IProductSizeRepository productSizeRepository;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IColorService colorService;

    @Autowired
    private ISizeService sizeService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private IUploadService uploadService;

    @Autowired
    private UploadUtils uploadUtils;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<ProductParam> findAllProductParams() {
        return productRepository.getAllProductParams();
    }

    @Override
    public Optional<ProductParam> findAllProductParamsById(String id) {
        return productRepository.getAllProductParamsById(id);
    }

    @Override
    public Product create(ProductParam productParam) {

        Product product = productRepository.save(productMapper.toProduct(productParam));
        ProductMeta productMeta = productMetaRepository.save(productMapper.toProductMeta(productParam));

        Optional<Category> categoryOptional = categoryService.findById(productParam.getCategoryId());
        Optional<Color> colorOptional = colorService.findById(productParam.getColorId());
        Optional<Size> sizeOptional = sizeService.findById(productParam.getSizeId());

        productCategoryRepository.save(productMapper.toProductCategory(categoryOptional.get(), product));
        productColorRepository.save(productMapper.toProductColor(colorOptional.get(), product));
        productSizeRepository.save(productMapper.toProductSize(sizeOptional.get(), product));

        uploadAndSaveProductImage(productParam, product, productMeta);

        return product;
    }


    private void uploadAndSaveProductImage(ProductParam productParam, Product product, ProductMeta productMeta) {
        try {
            Map uploadResult = uploadService.uploadImage(productParam.getFile(), uploadUtils.buildImageUploadParams(productMeta));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            productMeta.setFileName(productMeta.getId() + "." + fileFormat);
            productMeta.setFileUrl(fileUrl);
            productMeta.setFileFolder(UploadUtils.IMAGE_UPLOAD_FOLDER);
            productMeta.setCloudId(productMeta.getFileFolder() + "/" + productMeta.getId());
            productMeta.setProduct(product);
            productMetaRepository.save(productMeta);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }

    @Override
    public Product doUpdate(ProductParam productParam, String id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productOptional.get().setName(productParam.getName());
            productOptional.get().setTitle(productParam.getTitle());
            productOptional.get().setPrice(productParam.getPrice());
            productOptional.get().setQuantity(productParam.getQuantity());
            productOptional.get().setMaterial(productParam.getMaterial());
            productOptional.get().setDescription(productParam.getDescription());

            Product product = productRepository.save(productOptional.get());
            return product;
        }
        return null;
    }
}
