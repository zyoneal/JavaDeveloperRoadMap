package com.viktor.prototype.jpa.repository;

import com.viktor.prototype.jpa.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
