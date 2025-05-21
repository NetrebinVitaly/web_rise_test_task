package com.app.testnetrebin.controller;

import com.app.testnetrebin.api.UserApi;
import com.app.testnetrebin.api.dto.SubscriptionDto;
import com.app.testnetrebin.api.dto.UserDto;
import com.app.testnetrebin.mapper.UserMapper;
import com.app.testnetrebin.model.User;
import com.app.testnetrebin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> getUserById(UUID userId) {
        User user = userService.getUserById(userId);

        UserDto response = userMapper.toDto(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        User user = userService.createUser(userDto);

        log.info("User created: {}", user.getId());
        UserDto response = userMapper.toDto(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UUID userId, UserDto userDto) {
        User user = userService.updateUser(userId, userDto);

        log.info("User updated: {}", user.getId());
        UserDto response = userMapper.toDto(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID userId) {
        userService.deleteUser(userId);

        log.info("User deleted: {}", userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDto> addUserSubscription(UUID userId, SubscriptionDto subscriptionDto) {
        User user = userService.addSubscription(userId, userMapper.to(subscriptionDto));

        log.info("User subscribed: {}, subscription: {}", user.getId(), subscriptionDto);
        UserDto response = userMapper.toDto(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<SubscriptionDto>> getUserSubscriptions(UUID userId) {
        User user = userService.getUserById(userId);

        List<SubscriptionDto> response = userMapper.toDtoList(user.getSubscriptions());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserDto> deleteUserSubscription(UUID userId, UUID subId) {
        User user = userService.removeSubscription(userId, subId);

        log.info("User delete subscription: {}", subId);
        UserDto response = userMapper.toDto(user);
        return ResponseEntity.ok(response);
    }
}
