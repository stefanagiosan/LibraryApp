package com.ubb.bookapp.dao.mappers;

import com.ubb.bookapp.dao.dto.UserDto;
import com.ubb.bookapp.dao.model.User;

import java.util.List;

public class UserMapper {

    public static UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .cnp(user.getCnp())
                .address(user.getAddress())
                .phone(user.getPhone())
                .type(user.getType())
                .books(BookMapper.mapToDtoList(user.getBooks()))
                .build();
    }

    public static User mapToModel(UserDto user) {
        return User.builder()
                .id(user.id())
                .name(user.name())
                .password(user.password())
                .cnp(user.cnp())
                .address(user.address())
                .phone(user.phone())
                .type(user.type())
                .build();
    }

    public static List<UserDto> mapToDtoList(List<User> users) {
        return users.stream()
                .map(UserMapper::mapToDto)
                .toList();
    }

}
