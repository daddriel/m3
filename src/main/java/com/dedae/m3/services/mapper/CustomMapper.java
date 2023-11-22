package com.dedae.m3.services.mapper;

public interface CustomMapper <DTO, E>{
    DTO toDto(E e);
    E toEntity(DTO dto);
}
