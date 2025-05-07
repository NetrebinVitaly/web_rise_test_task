package com.app.testnetrebin.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private String firstName;

    private String lastName;

    private String middleName;

    private boolean isEnabled;

    private List<SubscriptionDto> subscriptions;
}
