package com.viktor.prototype.jpa.service;

import com.viktor.prototype.jpa.dto.request.ProfileRequestDto;
import com.viktor.prototype.jpa.entity.Profile;
import com.viktor.prototype.jpa.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {

    ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional
    @Override
    public Profile addProfile(ProfileRequestDto profileRequestDto) {
        Profile profile = new Profile();
        profile.setStreet(profileRequestDto.getStreet());
        profile.setLanguage(profileRequestDto.getLanguage());
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfile(Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new IllegalArgumentException("couldn't find profile with id " + profileId));
    }

}
