package vn.vdef.learn.spring.clothes.Service.Impl;

import vn.vdef.learn.spring.clothes.Constants.ExceptionConstant;
import vn.vdef.learn.spring.clothes.Convert.RoleConvert;
import vn.vdef.learn.spring.clothes.Convert.UserConvert;
import vn.vdef.learn.spring.clothes.DTO.Request.RoleRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.RoleResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Role;
import vn.vdef.learn.spring.clothes.Entity.User;
import vn.vdef.learn.spring.clothes.Exception.NotFoundException;
import vn.vdef.learn.spring.clothes.Repository.RoleRepository;
import vn.vdef.learn.spring.clothes.Repository.UserRepository;
import vn.vdef.learn.spring.clothes.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleConvert roleConvert;
    private final UserRepository userRepository;
    private final UserConvert userConvert;

    @Override
    public RoleResponseDTO addRole(RoleRequestDTO roleRequestDTO) {
        Role role = roleConvert.toEntity(roleRequestDTO);
        roleRepository.save(role);

        RoleResponseDTO roleResponseDTO = roleConvert.toDTO(role);
        return roleResponseDTO;
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        if (id != null) {
            Optional<Role> roleOptional = roleRepository.findById(id);
            if (!roleOptional.isPresent()) {
                throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
            }
            List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
            List<User> users = userRepository.getUsersByRoleNo(id);
            for (User user : users) {
                UserResponseDTO userResponseDTO = userConvert.toDTO(user);
                userResponseDTO.setRoleName(user.getRole().getRoleName());
                userResponseDTOList.add(userResponseDTO);
            }
            RoleResponseDTO roleResponseDTO = roleConvert.toDTO(roleOptional.get());
            roleResponseDTO.setUserResponseDTOList(userResponseDTOList);
            return roleResponseDTO;
        }
        return new RoleResponseDTO();
    }

    @Override
    public RoleResponseDTO updateRole(RoleRequestDTO roleRequestDTO) {
        if (roleRequestDTO.getRoleNo() != null) {
           Optional<Role> roleGet = roleRepository.findById(roleRequestDTO.getRoleNo());
           if (!roleGet.isPresent()) {
               throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
           }
           Role role = roleConvert.toEntity(roleRequestDTO);
           roleRepository.save(role);

           RoleResponseDTO roleResponseDTO = roleConvert.toDTO(role);
           return roleResponseDTO;
        }
        return new RoleResponseDTO();
    }
}
