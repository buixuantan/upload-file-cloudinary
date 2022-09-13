package com.cg.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductParam implements Serializable {

    private String id;
    private String name;
    private String title;
    private Double price;
    private String material;
    private int quantity;
    private boolean bestseller;
    private boolean hot;
    private boolean status;
    private String description;

    private Long sizeId;
    private Float size;

    private Long colorId;
    private String color;

    private Long categoryId;
    private String nameCategory;

    private String productMetaId;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String cloudId;

    private MultipartFile file;

    public ProductParam(String id, String name, String title, Double price, String material, int quantity, boolean bestseller, boolean hot, boolean status, String description, Float size, String color, String nameCategory, String productMetaId, String fileName, String fileFolder, String fileUrl) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
        this.material = material;
        this.quantity = quantity;
        this.bestseller = bestseller;
        this.hot = hot;
        this.status = status;
        this.description = description;
        this.size = size;
        this.color = color;
        this.nameCategory = nameCategory;
        this.productMetaId = productMetaId;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
        this.fileUrl = fileUrl;
    }

    public ProductParam(String id, String name,
                        String title, Double price,
                        String material, int quantity,
                        boolean bestseller, boolean hot,
                        boolean status, String description,
                        Long sizeId, Float size,
                        Long colorId, String color,
                        Long categoryId, String nameCategory,
                        String productMetaId, String fileName,
                        String fileFolder, String fileUrl,
                        String cloudId) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
        this.material = material;
        this.quantity = quantity;
        this.bestseller = bestseller;
        this.hot = hot;
        this.status = status;
        this.description = description;
        this.sizeId = sizeId;
        this.size = size;
        this.colorId = colorId;
        this.color = color;
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.productMetaId = productMetaId;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
        this.fileUrl = fileUrl;
        this.cloudId = cloudId;
    }
}
