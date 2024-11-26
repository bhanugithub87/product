package com.photon.product.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.photon.product.exception.ProductNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {
	
	@ExceptionHandler({ProductNotFoundException.class})
	public ProblemDetail handleProductNotFoundException(ProductNotFoundException ex) {
		log.info("AppExceptionHandler.handleProductNotFoundException()");
		return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
	}

}
