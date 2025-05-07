package com.app.testnetrebin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {

    private String firstName;

    private String lastName;

    private String middleName;

    private boolean isEnabled;

    private List<UpdatedSubscription> subscriptions;
}
