package com.boot.freshvote.repo;

import com.boot.freshvote.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
UserModel findByUsername(String username);

}
