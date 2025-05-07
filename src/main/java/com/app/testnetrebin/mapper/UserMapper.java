package com.app.testnetrebin.mapper;

import com.app.testnetrebin.api.dto.SubscriptionDto;
import com.app.testnetrebin.api.dto.UserDto;
import com.app.testnetrebin.model.Subscription;
import com.app.testnetrebin.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    SubscriptionDto toDto(Subscription subscription);

    List<SubscriptionDto> toDtoList(List<Subscription> subscriptions);

    Subscription to(SubscriptionDto subscriptionDto);

    List<Subscription> toList(List<SubscriptionDto> subscriptions);
}
