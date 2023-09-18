package vn.vdef.learn.spring.clothes.Controller;

import vn.vdef.learn.spring.clothes.DTO.Request.RoleRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.RoleResponseDTO;
import vn.vdef.learn.spring.clothes.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("add-role")
    public RoleResponseDTO addRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return roleService.addRole(roleRequestDTO);
    }

    @GetMapping("get-role")
    public RoleResponseDTO getRoleById(@RequestParam Long id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("update-role")
    public RoleResponseDTO updateRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return roleService.updateRole(roleRequestDTO);
    }
}
