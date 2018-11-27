package com.application.communalTrustPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.communalTrustPortal.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
