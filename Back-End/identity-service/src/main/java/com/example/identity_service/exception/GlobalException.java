package com.example.identity_service.exception;

import com.example.identity_service.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse(false,ErrorCode.UNCATEGORIZED_EXCEPTION.getCode(), ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage(), ResponseEntity.badRequest().body(exception.getMessage()));
        return ResponseEntity.badRequest().body(apiResponse);
    }
    /*@ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiRespone> handlingRuntimeException(AppException exception){
       ApiRespone apiRespone = new ApiRespone();
       ErrorCode errorCode = exception.getErrorCode();
       apiRespone.setCode(errorCode.getCode());
       apiRespone.setMessage(errorCode.getMessage());
       return ResponseEntity.badRequest().body(apiRespone);
    }*/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidation(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }
}
