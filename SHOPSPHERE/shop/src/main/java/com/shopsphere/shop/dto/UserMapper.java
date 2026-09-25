package com.shopsphere.shop.dto;

import com.shopsphere.shop.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        return new UserDTO(
                user.getId(),
                user.getEmail()
        );
    }
}