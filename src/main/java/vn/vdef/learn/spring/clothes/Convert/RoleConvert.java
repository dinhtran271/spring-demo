package vn.vdef.learn.spring.clothes.Convert;

import vn.vdef.learn.spring.clothes.DTO.Request.RoleRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.RoleResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConvert {

    public Role toEntity(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleNo(roleRequestDTO.getRoleNo());
        role.setRoleName(roleRequestDTO.getRoleName());
        return role;
    }

    public RoleResponseDTO toDTO(Role role) {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setRoleNo(role.getRoleNo());
        roleResponseDTO.setRoleName(role.getRoleName());
        return roleResponseDTO;
    }
}
