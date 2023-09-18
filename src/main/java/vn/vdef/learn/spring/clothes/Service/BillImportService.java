package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.BillImportRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.BillImportResponseDTO;

public interface BillImportService {

    BillImportResponseDTO addBillImport(BillImportRequestDTO billImportRequestDTO);
}
