package com.nkidol.board_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkidol.board_back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String>{
    
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String TelNumber);
    
    UserEntity findByEmail(String email);
}
