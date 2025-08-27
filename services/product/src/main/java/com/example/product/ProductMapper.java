package com.example.product;


import com.example.category.Category;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        Category category = new Category();
        category.setId(request.getId());

        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setAvailableQuantity(request.getAvailableQuantity());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
