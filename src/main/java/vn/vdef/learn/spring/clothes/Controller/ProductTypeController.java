package vn.vdef.learn.spring.clothes.Controller;

import vn.vdef.learn.spring.clothes.DTO.Request.ProductTypeRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductTypeResponseDTO;
import vn.vdef.learn.spring.clothes.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @PostMapping("add-product-type")
    public ProductTypeResponseDTO addProductType(@RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        return productTypeService.addProductType(productTypeRequestDTO);
    }

    @GetMapping("get-product-type")
    public ProductTypeResponseDTO getProductType(@RequestParam Long id) {
        return productTypeService.getProductType(id);
    }

    @DeleteMapping("delete-product-type")
    public void deleteProductType(@RequestParam Long id) {
        productTypeService.deleteProductType(id);
    }

    @PutMapping("update-product-type")
    public ProductTypeResponseDTO updateProductType(@RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        return productTypeService.updateProductType(productTypeRequestDTO);
    }
}
