package vn.vdef.learn.spring.clothes.Service.Impl;

import vn.vdef.learn.spring.clothes.Constants.ExceptionConstant;
import vn.vdef.learn.spring.clothes.Convert.UserConvert;
import vn.vdef.learn.spring.clothes.DTO.Request.UserRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Role;
import vn.vdef.learn.spring.clothes.Entity.User;
import vn.vdef.learn.spring.clothes.Exception.NotFoundException;
import vn.vdef.learn.spring.clothes.Repository.OrderProductRepository;
import vn.vdef.learn.spring.clothes.Repository.OrderRepository;
import vn.vdef.learn.spring.clothes.Repository.RoleRepository;
import vn.vdef.learn.spring.clothes.Repository.UserRepository;
import vn.vdef.learn.spring.clothes.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    UserConvert userConvert;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getRoleNo() != null) {
            Optional<Role> role = roleRepository.findById(userRequestDTO.getRoleNo());
            if (!role.isPresent()) {
                throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
            }
            User user = userConvert.toEntity(userRequestDTO);
            user.setAddressShip(userRequestDTO.getAddressShip());
            user.setPassword(userRequestDTO.getPassword());
            user.setRole(role.get());
            user = userRepository.save(user);

            UserResponseDTO userResponseDTO = userConvert.toDTO(user);
            userResponseDTO.setRoleName(user.getRole().getRoleName());
            return userResponseDTO;
        }
        return new UserResponseDTO();
    }

    @Override
    public List<UserResponseDTO> getUser() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setUserNo(user.getUserNo());
            userResponseDTO.setUserName(user.getUserName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }
    @Transactional
    @Override
    public void deleteUser(Long userNo) {
        orderProductRepository.deleteOrderProductsByUserNo(userNo);
        orderRepository.deleteUserByUserNo(userNo);
        userRepository.deleteByUserNo(userNo);
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getUserNo() != null) {
            Optional<User> userOptional = userRepository.findById(userRequestDTO.getUserNo());
            if (!userOptional.isPresent()) {
                throw new NotFoundException(ExceptionConstant.USER_IS_NULL);
            }
            User user = userConvert.toEntity(userRequestDTO);
            user.setPassword(userRequestDTO.getPassword());
            user.setAddressShip(userRequestDTO.getAddressShip());
            userRepository.save(user);

            UserResponseDTO userResponseDTO = userConvert.toDTO(user);
            return userResponseDTO;
        }
        return new UserResponseDTO();
    }
}
