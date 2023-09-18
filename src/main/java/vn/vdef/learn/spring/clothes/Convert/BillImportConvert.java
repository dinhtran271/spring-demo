package vn.vdef.learn.spring.clothes.Convert;

import vn.vdef.learn.spring.clothes.DTO.Request.BillImportRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.BillImportResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.BillImport;
import org.springframework.stereotype.Component;

@Component
public class BillImportConvert {
    public BillImport toEntity(BillImportRequestDTO billImportRequestDTO) {
        BillImport billImport = new BillImport();
        billImport.setBillNo(billImportRequestDTO.getBillNo());
        billImport.setContent(billImportRequestDTO.getContent());
        return billImport;
    }

    public BillImportResponseDTO toDTO(BillImport billImport) {
        BillImportResponseDTO billImportResponseDTO = new BillImportResponseDTO();
        billImportResponseDTO.setBillNo(billImport.getBillNo());
        billImportResponseDTO.setContent(billImport.getContent());
        return billImportResponseDTO;
    }
}
