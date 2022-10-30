package com.viktor.prototype.jpa.service;


import com.viktor.prototype.jpa.dto.request.ProfileRequestDto;
import com.viktor.prototype.jpa.entity.Profile;

public interface ProfileService {

    Profile addProfile(ProfileRequestDto profileRequestDto);

    Profile getProfile(Long profileId);

}
