package com.go2it.frame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.go2it.frame.config.payload.ApiResponse;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity getHelloWorldMessage() {
        return  ResponseEntity.ok(new ApiResponse(true, "Test passed successfully"));
    }

}
