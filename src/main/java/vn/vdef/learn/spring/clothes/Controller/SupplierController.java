package vn.vdef.learn.spring.clothes.Controller;

import vn.vdef.learn.spring.clothes.DTO.Request.SupplierRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.SupplierResponseDTO;
import vn.vdef.learn.spring.clothes.Service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("add-supplier")
    public SupplierResponseDTO addSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO) {
        return supplierService.addSupplier(supplierRequestDTO);
    }
}
