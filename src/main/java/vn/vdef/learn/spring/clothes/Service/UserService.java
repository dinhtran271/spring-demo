package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.UserRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getUser();

    void deleteUser(Long userNo);

    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
}
