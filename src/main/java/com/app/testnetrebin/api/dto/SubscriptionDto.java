package com.app.testnetrebin.api.dto;

import com.app.testnetrebin.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionDto {

    private UUID id;

    private SubscriptionService service;

    public enum SubscriptionService{
        YouTube, VK, Yandex, Netflix
    }
}
