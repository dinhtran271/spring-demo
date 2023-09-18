package vn.vdef.learn.spring.clothes.Convert;

import vn.vdef.learn.spring.clothes.DTO.Request.SupplierRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.SupplierResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierConvert {
    public Supplier toEntity(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = new Supplier();
        supplier.setSupplierNo(supplierRequestDTO.getSupplierNo());
        supplier.setSupplierName(supplierRequestDTO.getSupplierName());
        supplier.setPhoneNumber(supplierRequestDTO.getPhoneNumber());
        supplier.setAddress(supplierRequestDTO.getAddress());
        return supplier;
    }
    public SupplierResponseDTO toDTO(Supplier supplier) {
        SupplierResponseDTO supplierResponseDTO = new SupplierResponseDTO();
        supplierResponseDTO.setSupplierNo(supplier.getSupplierNo());
        supplierResponseDTO.setSupplierName(supplier.getSupplierName());
        supplierResponseDTO.setPhoneNumber(supplier.getPhoneNumber());
        supplierResponseDTO.setAddress(supplier.getAddress());
        return supplierResponseDTO;
    }
}
