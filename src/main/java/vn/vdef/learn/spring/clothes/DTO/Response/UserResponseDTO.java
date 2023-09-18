package vn.vdef.learn.spring.clothes.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Long userNo;
    private String userName;
    private String roleName;
    private String gender;
    private String addressShip;
}

