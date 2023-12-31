package com.start.domain_driven_design.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserName name;

    @Embedded
    private UserPhone phone;

    @Embedded
    private UserEmail email;

    @Embedded
    private UserAddress address;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Builder
    public User(UserName name, UserPhone phone, UserEmail email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = UserStatus.ACTIVE;
    }

    public void changePhone(UserPhone phone) {
        this.phone = new UserPhone(phone.getPhoneNumber());
    }

    public void changeEmail(UserEmail email) {
        this.email = new UserEmail(email.getEmail());
    }

    public void changeAddress(UserAddress address) {
        this.address = new UserAddress(address.getStreet(), address.getDetail(), address.getZipCode());
    }
}
