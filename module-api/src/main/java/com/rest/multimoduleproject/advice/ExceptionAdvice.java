package com.rest.multimoduleproject.advice;

import com.rest.multimoduleproject.exception.CUserNotFoundException;
import com.rest.multimoduleproject.exception.CUserSigninFailedException;
import com.rest.multimoduleproject.exception.DataIntegrityViolationException;
import com.rest.multimoduleproject.response.CommonResult;
import com.rest.multimoduleproject.response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    /**
     * 대상자를 찾을 수 없을 때 Exception 처리
     *
     * @param request
     * @param e
     * @return 응답코드
     */
    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        return responseService.getFailResult();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userEmailConstraintException(HttpServletRequest request, DataIntegrityViolationException e) {
        return responseService.getFailResult();
    }

    @ExceptionHandler(CUserSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userSigninFailedException(HttpServletRequest request, CUserSigninFailedException e) {
        return responseService.getFailResult();
    }

}
