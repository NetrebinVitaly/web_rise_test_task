package com.app.testnetrebin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedSubscription {

    private SubscriptionService service;

    public enum SubscriptionService{
        YouTube, VK, Yandex, Netflix
    }
}
