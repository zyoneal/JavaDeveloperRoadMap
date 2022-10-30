package com.viktor.prototype.jpa.controller;

import com.viktor.prototype.jpa.dto.request.ProfileRequestDto;
import com.viktor.prototype.jpa.entity.Profile;
import com.viktor.prototype.jpa.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/addProfile")
    public ResponseEntity<Profile> addProfile(
            @RequestBody final ProfileRequestDto profileRequestDto) {
        Profile addCompany = profileService.addProfile(profileRequestDto);
        return new ResponseEntity<>(addCompany, HttpStatus.OK);
    }

}
