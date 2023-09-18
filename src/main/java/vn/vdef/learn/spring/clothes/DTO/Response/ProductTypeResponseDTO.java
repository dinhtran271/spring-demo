package vn.vdef.learn.spring.clothes.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeResponseDTO {

    private Long productTypeNo;
    private String productTypeName;
    private List<ProductResponseDTO> productResponseDTOList;
}
