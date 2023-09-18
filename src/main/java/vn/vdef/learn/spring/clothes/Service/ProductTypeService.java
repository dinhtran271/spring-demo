package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.ProductTypeRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductTypeResponseDTO;

public interface ProductTypeService {
    ProductTypeResponseDTO addProductType(ProductTypeRequestDTO productTypeRequestDTO);
    ProductTypeResponseDTO getProductType(Long id);
    void deleteProductType(Long id);

    ProductTypeResponseDTO updateProductType(ProductTypeRequestDTO productTypeRequestDTO);
}
