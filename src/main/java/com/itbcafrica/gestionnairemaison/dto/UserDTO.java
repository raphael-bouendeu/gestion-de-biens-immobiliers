package com.itbcafrica.gestionnairemaison.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long Id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
