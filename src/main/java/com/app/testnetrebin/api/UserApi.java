package com.app.testnetrebin.api;

import com.app.testnetrebin.api.dto.SubscriptionDto;
import com.app.testnetrebin.api.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface UserApi {

    @GetMapping("/v1/users/{userId}")
    ResponseEntity<UserDto> getUserById(
            @PathVariable UUID userId
    );

    @PostMapping("/v1/users")
    ResponseEntity<UserDto> createUser(
            @RequestBody UserDto userDto
    );

    @PutMapping("/v1/users/{userId}")
    ResponseEntity<UserDto> updateUser(
            @PathVariable UUID userId,
            @RequestBody UserDto userDto
    );

    @DeleteMapping("/v1/users/{userId}")
    ResponseEntity<Void> deleteUser(
            @PathVariable UUID userId
    );

    @PostMapping("/v1/users/{userId}/subscriptions")
    ResponseEntity<UserDto> addUserSubscription(
            @PathVariable UUID userId,
            @RequestBody SubscriptionDto subscriptionDto
    );

    @GetMapping("/v1/users/{userId}/subscriptions")
    ResponseEntity<List<SubscriptionDto>> getUserSubscriptions(
            @PathVariable UUID userId
    );

    @DeleteMapping("/v1/users/{userId}/subscriptions/{subId}")
    ResponseEntity<UserDto> deleteUserSubscription(
            @PathVariable UUID userId,
            @PathVariable UUID subId
    );
}
