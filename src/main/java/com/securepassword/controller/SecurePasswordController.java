package com.securepassword.controller;

import com.securepassword.dto.SecurePasswordDTO;
import com.securepassword.dto.FailureResponse;
import com.securepassword.service.SecurePasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurePasswordController {

   private final SecurePasswordService passwordService;

    public SecurePasswordController(SecurePasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping(value = "/validate")
    public ResponseEntity<FailureResponse> validatePassowrd(@RequestBody SecurePasswordDTO passwordDTO){

        var failures = passwordService.validatePassword(passwordDTO.password());

        if(failures.isEmpty()){
            return  ResponseEntity.noContent().build();

        }
        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

}
