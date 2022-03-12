package com.yundi.userservice.user.model;

import com.yundi.userservice.consumer.UserData;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String name;
    private String lastName;
    private Address address;

    public User(UserData userData) {
        this.username = userData.getUsername();
        this.lastName = userData.getLastName();
        this.name = userData.getName();
        this.email = userData.getEmail();
    }
}
