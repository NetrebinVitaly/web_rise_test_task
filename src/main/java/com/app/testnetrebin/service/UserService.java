package com.app.testnetrebin.service;

import com.app.testnetrebin.api.dto.UserDto;
import com.app.testnetrebin.model.Subscription;
import com.app.testnetrebin.model.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID userId);

    User createUser(UserDto userDto);

    User updateUser(UUID userId, UserDto userDto);

    void deleteUser(UUID userId);

    User addSubscription(UUID userId, Subscription subscription);

    User removeSubscription(UUID userId, UUID subscriptionId);
}
