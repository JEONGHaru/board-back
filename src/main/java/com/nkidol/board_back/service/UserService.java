package com.nkidol.board_back.service;

import org.springframework.http.ResponseEntity;

import com.nkidol.board_back.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
    
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser (String email);
    
}
