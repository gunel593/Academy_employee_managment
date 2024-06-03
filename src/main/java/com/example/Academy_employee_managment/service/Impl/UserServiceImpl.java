package com.example.Academy_employee_managment.service.Impl;

import com.example.Academy_employee_managment.Util.JwtProvider;
import com.example.Academy_employee_managment.exception.handler.CommonException;
import com.example.Academy_employee_managment.mapper.UserMapper;
import com.example.Academy_employee_managment.model.dto.request.LoginRequest;
import com.example.Academy_employee_managment.model.dto.request.UserRequest;
import com.example.Academy_employee_managment.model.dto.responce.LoginResponce;
import com.example.Academy_employee_managment.model.dto.responce.UserResponce;
import com.example.Academy_employee_managment.model.entity.User;
import com.example.Academy_employee_managment.mybatis.UserMyBatis;
import com.example.Academy_employee_managment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMyBatis usermybatis;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public UserResponce register(UserRequest userRequest) {
         if (!Objects.equals(userRequest.getPassword(), userRequest.getConfirmPassword())) {
            throw  new CommonException("1001","password not mached", HttpStatus.BAD_REQUEST);
            //   return new UserResponce("Password is not true");
        }
        Optional<User> byUserName = usermybatis.findByUsername(userRequest.getUsername());
        if (byUserName.isPresent()) {
            throw  new CommonException("1002","user dublicated", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        usermybatis.insert(user);
        return new UserResponce("success");
        // String token =jwtProvider.generatedToken(user);
    }

    @Override
    public LoginResponce login(LoginRequest loginRequest) {
        Optional<User> userOptional=getByUsername(loginRequest.getUsername());

        if(userOptional.isEmpty()){
            throw  new CommonException("1000","user not found", HttpStatus.BAD_REQUEST);

            ///    return LoginResponce.withResponce("user is not exists");
        }
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken
                (loginRequest.getUsername(),loginRequest.getPassword());
          authenticationManager.authenticate(authenticationToken);

        String token= jwtProvider.generatedToken(userOptional.get());
        return LoginResponce.withToken(token);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return usermybatis.findByUsername(username);
    }
}
