package vn.vdef.learn.spring.clothes.Service.Impl;

import vn.vdef.learn.spring.clothes.Convert.SupplierConvert;
import vn.vdef.learn.spring.clothes.DTO.Request.SupplierRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.SupplierResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Supplier;
import vn.vdef.learn.spring.clothes.Repository.SupplierRepository;
import vn.vdef.learn.spring.clothes.Service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final SupplierConvert supplierConvert;

    @Override
    public SupplierResponseDTO addSupplier(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = supplierConvert.toEntity(supplierRequestDTO);
        supplierRepository.save(supplier);

        SupplierResponseDTO supplierResponseDTO = supplierConvert.toDTO(supplier);
        return supplierResponseDTO;
    }
}
