package com.dedae.m3.dto;

import com.dedae.m3.domain.entities.UserDetail;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createAt;

    private String userDetail;

}
