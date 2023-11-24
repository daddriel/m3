package com.dedae.m3.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserRolDTO {
    private Integer id;
    private Boolean active;
    private LocalDateTime createdAt;
    private Long userId;
    private Integer rolId;
}
