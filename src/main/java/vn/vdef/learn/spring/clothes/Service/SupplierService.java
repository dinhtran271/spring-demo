package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.SupplierRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.SupplierResponseDTO;

public interface SupplierService {
    SupplierResponseDTO addSupplier(SupplierRequestDTO supplierRequestDTO);
}
