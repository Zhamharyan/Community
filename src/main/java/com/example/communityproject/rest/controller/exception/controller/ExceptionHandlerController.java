package com.example.communityproject.rest.controller.exception.controller;

import com.example.communityproject.service.exception.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = UserNameNotFoundException.class)
    public ResponseEntity<Object> userNameNotFoundException(UserNameNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = InvalidRegisterUserName.class)
    public ResponseEntity<Object> userNameNotFoundHandler(InvalidRegisterUserName e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = InvalidRegisterPassword.class)
    public ResponseEntity<Object> userNameNotFoundHandler(InvalidRegisterPassword e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = InvalidSignInPasswordException.class)
    public ResponseEntity<Object> userNameNotFoundHandler(InvalidSignInPasswordException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<Object> userNameNotFoundHandler(RoleNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = CommunityNotMentionedException.class)
    public ResponseEntity<Object> userNameNotFoundHandler(CommunityNotMentionedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = NoAvailableParkingSpaceException.class)
    public ResponseEntity<Object> userNameNotFoundHandler(NoAvailableParkingSpaceException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = NoSuchCommunityException.class)
    public ResponseEntity<Object> userNameNotFoundHandler(NoSuchCommunityException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = ParkingStartTimeNotMentionedException.class)
    public ResponseEntity<Object> parkingStartTimeNotMentionedException(ParkingStartTimeNotMentionedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = RoleNameNotMentionedException.class)
    public ResponseEntity<Object> roleNameNotMentionedException(RoleNameNotMentionedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = InvalidParkingTimeException.class)
    public ResponseEntity<Object> invalidParkingTimeException(InvalidParkingTimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = InvalidCommunityException.class)
    public ResponseEntity<Object> invalidCommunityException(InvalidCommunityException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = RichMaxSizeOfBookingException.class)
    public ResponseEntity<Object> richMaxSizeOfBookingException(RichMaxSizeOfBookingException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
