package vn.vdef.learn.spring.clothes.Controller;

import vn.vdef.learn.spring.clothes.DTO.Request.ProductRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductResponseDTO;
import vn.vdef.learn.spring.clothes.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("add-product")
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.addProduct(productRequestDTO);
    }

    @GetMapping("get-product")
    public ProductResponseDTO getProduct(@RequestParam Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping ("/delete-product")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("update-product")
    public ProductResponseDTO updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(productRequestDTO);
    }
}
