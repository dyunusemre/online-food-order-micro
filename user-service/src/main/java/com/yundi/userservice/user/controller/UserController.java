package com.yundi.userservice.user.controller;

import com.yundi.userservice.common.BaseController;
import com.yundi.userservice.user.dto.UserProfileResponse;
import com.yundi.userservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PutMapping("/update-email")
    public void updateEmail(Authentication authentication, @RequestBody String email) {
        userService.updateEmail(getUsername(authentication), email);
    }

    @PostMapping("/add-address")
    public void addUserAddress() {
        
    }

    @GetMapping("/information")
    public UserProfileResponse getUserInformation(Authentication authentication) {
        return userService.getUserProfileInformation(getUsername(authentication));
    }
}
