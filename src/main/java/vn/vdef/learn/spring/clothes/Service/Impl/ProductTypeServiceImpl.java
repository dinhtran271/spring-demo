package vn.vdef.learn.spring.clothes.Service.Impl;

import vn.vdef.learn.spring.clothes.Constants.ExceptionConstant;
import vn.vdef.learn.spring.clothes.Convert.ProductTypeConvert;
import vn.vdef.learn.spring.clothes.DTO.Request.ProductTypeRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductTypeResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.ProductType;
import vn.vdef.learn.spring.clothes.Exception.NotFoundException;
import vn.vdef.learn.spring.clothes.Repository.ProductRepository;
import vn.vdef.learn.spring.clothes.Repository.ProductTypeRepository;
import vn.vdef.learn.spring.clothes.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductTypeConvert productTypeConvert;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductTypeResponseDTO addProductType(ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType productType = productTypeConvert.toEntity(productTypeRequestDTO);
        productType = productTypeRepository.save(productType);

        ProductTypeResponseDTO productTypeResponseDTO = productTypeConvert.toDTO(productType);
        return productTypeResponseDTO;
    }

    @Override
    public ProductTypeResponseDTO getProductType(Long id) {
         ProductType productType = productTypeRepository.findById(id).get();
        ProductTypeResponseDTO productTypeResponseDTO = productTypeConvert.toDTO(productType);
         return productTypeResponseDTO;
    }
    @Transactional
    @Override
    public void deleteProductType(Long id) {
        productRepository.deleteProductsById(id);
        productTypeRepository.deleteProductTypeById(id);
    }

    @Override
    public ProductTypeResponseDTO updateProductType(ProductTypeRequestDTO productTypeRequestDTO) {
        if (productTypeRequestDTO.getProductTypeNo() != null) {
            Optional<ProductType> productTypeOptional = productTypeRepository.findById(productTypeRequestDTO.getProductTypeNo());
            if (!productTypeOptional.isPresent()) {
                throw new NotFoundException(ExceptionConstant.PRODUCT_TYPE_IS_NULL);
            }
            ProductType productType = productTypeConvert.toEntity(productTypeRequestDTO);

            ProductTypeResponseDTO productTypeResponseDTO = productTypeConvert.toDTO(productType);
            return productTypeResponseDTO;
        }
        return new ProductTypeResponseDTO();
    }
}
