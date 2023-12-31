package vn.vdef.learn.spring.clothes.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
    private Long userNo;
    private String userName;
    private Long roleNo;
    private String gender;
    private String addressShip;
    private String password;
}
