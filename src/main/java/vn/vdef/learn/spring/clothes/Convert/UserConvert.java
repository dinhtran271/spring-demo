package vn.vdef.learn.spring.clothes.Convert;

import vn.vdef.learn.spring.clothes.DTO.Request.UserRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserNo(user.getUserNo());
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setAddressShip(user.getAddressShip());
        return userResponseDTO;
    }
    public User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserNo(userRequestDTO.getUserNo());
        user.setUserName(userRequestDTO.getUserName());
        user.setGender(userRequestDTO.getGender());
        return user;
    }
}
