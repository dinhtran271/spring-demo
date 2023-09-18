package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.RoleRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.RoleResponseDTO;

public interface RoleService {
    RoleResponseDTO addRole(RoleRequestDTO roleRequestDTO);
    RoleResponseDTO getRoleById(Long id);
    RoleResponseDTO updateRole(RoleRequestDTO roleRequestDTO);
}
