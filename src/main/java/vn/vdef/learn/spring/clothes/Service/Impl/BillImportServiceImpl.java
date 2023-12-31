package vn.vdef.learn.spring.clothes.Service.Impl;

import vn.vdef.learn.spring.clothes.Convert.BillImportConvert;
import vn.vdef.learn.spring.clothes.Convert.ProductConvert;
import vn.vdef.learn.spring.clothes.Convert.SupplierConvert;
import vn.vdef.learn.spring.clothes.Convert.UserConvert;
import vn.vdef.learn.spring.clothes.DTO.Request.BillImportRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Request.ProductRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.BillImportResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.SupplierResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.*;
import vn.vdef.learn.spring.clothes.Service.BillImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.vdef.learn.spring.clothes.Repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillImportServiceImpl implements BillImportService {

    private final BillImportRepository billImportRepository;
    private final BillImportConvert billImportConvert;
    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;
    private final ProductConvert productConvert;
    private final SupplierConvert supplierConvert;
    private final UserConvert userConvert;
    private final ProductRepository productRepository;
    private final BillImportProductRepository billImportProductRepository;

    @Override
    public BillImportResponseDTO addBillImport(BillImportRequestDTO billImportRequestDTO) {
        BillImport billImport = billImportConvert.toEntity(billImportRequestDTO);
        User user = userRepository.getById(billImportRequestDTO.getUserNo());
        billImport.setUser(user);
        Supplier supplier = supplierRepository.getById(billImportRequestDTO.getSupplierNo());
        billImport.setSupplier(supplier);
        billImportRepository.save(billImport);

        List<BillImportProduct> billImportProductList = new ArrayList<>();
        BigDecimal totalBill = BigDecimal.ZERO;
        for (ProductRequestDTO productRequestDTO : billImportRequestDTO.getProductRequestDTOList()) {
            Product product = productConvert.toEntity(productRequestDTO);
            BillImportProduct billImportProduct = new BillImportProduct();
            billImportProduct.setBillImport(billImport);
            billImportProduct.setProduct(product);
            billImportProductList.add(billImportProduct);
            totalBill = totalBill.add(productRepository.getById(productRequestDTO.getProductNo()).getPrice());
        }
        billImport.setTotalBill(totalBill);
        billImportProductRepository.saveAll(billImportProductList);

        BillImportResponseDTO billImportResponseDTO = billImportConvert.toDTO(billImport);
        SupplierResponseDTO supplierResponseDTO = supplierConvert.toDTO(supplier);
        billImportResponseDTO.setSupplierResponseDTO(supplierResponseDTO);
        UserResponseDTO userResponseDTO = userConvert.toDTO(user);
        userResponseDTO.setRoleName(user.getRole().getRoleName());
        billImportResponseDTO.setUserResponseDTO(userResponseDTO);

        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for (BillImportProduct billImportProductGet : billImportProductList) {
            ProductResponseDTO productResponseDTO = productConvert.toDTO(productRepository.getById(billImportProductGet.getProduct().getProductNo()));
            productResponseDTOList.add(productResponseDTO);
        }
        billImportResponseDTO.setProductResponseDTOList(productResponseDTOList);
        billImportResponseDTO.setTotalBill(totalBill);
        return billImportResponseDTO;
    }
}
