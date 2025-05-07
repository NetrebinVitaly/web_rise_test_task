package com.app.testnetrebin.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Builder.Default
    @Column(name = "is_enabled")
    private boolean isEnabled = true;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<Subscription> subscriptions = new ArrayList<>();
}
