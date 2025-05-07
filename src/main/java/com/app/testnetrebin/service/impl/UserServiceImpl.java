package com.app.testnetrebin.service.impl;

import com.app.testnetrebin.api.dto.UserDto;
import com.app.testnetrebin.mapper.UserMapper;
import com.app.testnetrebin.model.Subscription;
import com.app.testnetrebin.model.User;
import com.app.testnetrebin.repository.UserRepository;
import com.app.testnetrebin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException(String.format("Пользователь с ID (userId = $s) не найден", userId)));
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .middleName(userDto.getMiddleName())
                .isEnabled(true)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID userId, UserDto userDto) {

        User user = getUserById(userId);
        Optional.ofNullable(userDto.getFirstName()).ifPresent(user::setFirstName);
        Optional.ofNullable(userDto.getLastName()).ifPresent(user::setLastName);
        Optional.of(userDto.isEnabled()).ifPresent(user::setEnabled);

        Optional.ofNullable(userDto.getSubscriptions()).ifPresent(it -> user.setSubscriptions(userMapper.toList(it)));

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = getUserById(userId);
        user.setEnabled(false);

        userRepository.save(user);
    }

    @Override
    public User addSubscription(UUID userId, Subscription subscription) {
        User user = getUserById(userId);

        user.getSubscriptions().add(subscription);
        return userRepository.save(user);
    }

    @Override
    public User removeSubscription(UUID userId, UUID subscriptionId) {
        User user = getUserById(userId);

        Set<Subscription> subscriptions = user.getSubscriptions().stream()
                .filter(it -> !it.getId().equals(subscriptionId))
                .collect(Collectors.toSet());

        user.getSubscriptions().clear();
        user.getSubscriptions().addAll(subscriptions);

        return userRepository.save(user);
    }
}
