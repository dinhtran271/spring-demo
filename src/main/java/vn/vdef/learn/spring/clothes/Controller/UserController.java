package vn.vdef.learn.spring.clothes.Controller;

import vn.vdef.learn.spring.clothes.DTO.Request.UserRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;
import vn.vdef.learn.spring.clothes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("add-user")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.addUser(userRequestDTO);
    }

    @GetMapping("get-user")
    public List<UserResponseDTO> getUser() {
        return userService.getUser();
    }

    @DeleteMapping("delete-user")
    public void deleteUser(@RequestParam Long userNo) {
        userService.deleteUser(userNo);
    }

    @PutMapping("update-user")
    public UserResponseDTO updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(userRequestDTO);
    }
}
