package com.nkidol.board_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nkidol.board_back.dto.response.ResponseDto;
import com.nkidol.board_back.dto.response.user.GetSignInUserResponseDto;
import com.nkidol.board_back.entity.UserEntity;
import com.nkidol.board_back.repository.UserRepository;
import com.nkidol.board_back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    
    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        UserEntity entity = null;
        
        try {
            
            entity = userRepository.findByEmail(email);
            if (entity == null) return GetSignInUserResponseDto.notExistUser();
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetSignInUserResponseDto.success(entity);
    }
    
    
    
}
