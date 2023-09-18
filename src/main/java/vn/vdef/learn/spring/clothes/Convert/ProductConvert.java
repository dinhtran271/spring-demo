package vn.vdef.learn.spring.clothes.Convert;

import vn.vdef.learn.spring.clothes.DTO.Request.ProductRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConvert {
    public ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductNo(product.getProductNo());
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setPrice(product.getPrice());
        return productResponseDTO;
    }

    public Product toEntity(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductNo(productRequestDTO.getProductNo());
        product.setProductName(productRequestDTO.getProductName());
        product.setPrice(productRequestDTO.getPrice());

        return product;
    }
}
