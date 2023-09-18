package vn.vdef.learn.spring.clothes.Convert;


import vn.vdef.learn.spring.clothes.DTO.Request.ProductTypeRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductTypeResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Product;
import vn.vdef.learn.spring.clothes.Entity.ProductType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTypeConvert {
    public ProductTypeResponseDTO toDTO(ProductType productType) {
        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();
        productTypeResponseDTO.setProductTypeNo(productType.getProductTypeNo());
        productTypeResponseDTO.setProductTypeName(productType.getProductTypeName());
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for(Product product : productType.getProducts()) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductNo(product.getProductNo());
            productResponseDTO.setProductName(product.getProductName());
            productResponseDTO.setPrice(product.getPrice());

            productResponseDTOList.add(productResponseDTO);
        }
        productTypeResponseDTO.setProductResponseDTOList(productResponseDTOList);
        return productTypeResponseDTO;
    }

    public ProductType toEntity(ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType productType = new ProductType();
        productType.setProductTypeNo(productTypeRequestDTO.getProductTypeNo());
        productType.setProductTypeName(productTypeRequestDTO.getProductTypeName());
        return productType;
    }
}
