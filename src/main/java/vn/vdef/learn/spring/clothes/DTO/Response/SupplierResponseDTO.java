package vn.vdef.learn.spring.clothes.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponseDTO {
    private Long supplierNo;
    private String supplierName;
    private String phoneNumber;
    private String address;
}
