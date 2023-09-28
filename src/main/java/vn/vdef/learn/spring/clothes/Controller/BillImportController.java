package vn.vdef.learn.spring.clothes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import vn.vdef.learn.spring.clothes.DTO.Request.BillImportRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.BillImportResponseDTO;
import vn.vdef.learn.spring.clothes.Service.BillImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BillImportController {

    @Autowired
    BillImportService billImportService;

    @PostMapping("add-billimport")
    public BillImportResponseDTO addBillImport(@RequestBody BillImportRequestDTO billImportRequestDTO) {
        return billImportService.addBillImport(billImportRequestDTO);
    }
}
