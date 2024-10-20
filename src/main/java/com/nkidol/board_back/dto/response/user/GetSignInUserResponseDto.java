package com.nkidol.board_back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nkidol.board_back.common.ResponseCode;
import com.nkidol.board_back.common.ResponseMessage;
import com.nkidol.board_back.dto.response.ResponseDto;
import com.nkidol.board_back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetSignInUserResponseDto extends ResponseDto{
    
    private String email;
    private String nickname;
    private String profileImage;
    
    private GetSignInUserResponseDto (UserEntity entity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = entity.getEmail();
        this.nickname = entity.getNickname();
        this.profileImage = entity.getProfileImage();
    }
    
    public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity entity) {
        GetSignInUserResponseDto result = new GetSignInUserResponseDto(entity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
