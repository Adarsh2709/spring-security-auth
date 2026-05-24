package org.example.Controller;

import lombok.AllArgsConstructor;
import org.example.Response.JWTResponseDto;
import org.example.entities.RefreshToken;
import org.example.model.UserInfoDto;
import org.example.service.JWTService;
import org.example.service.RefreshTokenService;
import org.example.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController
{

    @Autowired
    private JWTService jwtService;

    @Autowired
    private org.example.service.RefreshTokenService refreshTokenService;

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("auth/v1/signup")
    public ResponseEntity signUp(@RequestBody UserInfoDto userInfoDto){
        try{
            Boolean isSignedUp = userDetailService.signupUser(userInfoDto);
            if(Boolean.FALSE.equals(isSignedUp)){
                return new ResponseEntity<>("Already Exist or Invalid Data", HttpStatus.BAD_REQUEST);
            }
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfoDto.getUsername());
            String jwtToken = jwtService.GenerateToken(userInfoDto.getUsername());
            return new ResponseEntity<>(JWTResponseDto.builder().accesstoken(jwtToken).token(refreshToken.getToken()).build(),HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>("Exception in User Service",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}