package com.yundi.userservice.user.service;
import com.yundi.userservice.domain.model.User;
import com.yundi.userservice.user.dto.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(User user);

    void update(User user);

    void updateEmail(String username, String email);

    User findUserByUsername(String username);

    UserProfileResponse getUserProfileInformation(String username);
}
