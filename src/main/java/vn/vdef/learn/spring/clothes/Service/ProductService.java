package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.ProductRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO getProduct(Long id);

    void deleteProduct(Long id);

    ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO);

}
