package com.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.constant.EMConstant;
import com.employee.vo.ErrorDetailsVO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ EMException.class })
	public ResponseEntity<Object> handleEMException(EMException emException, HttpServletRequest request) {
		ErrorDetailsVO errorDetailsVO = new ErrorDetailsVO();
		errorDetailsVO.setErrorCode(emException.getErrorCode());
		errorDetailsVO.setErrorMessage(emException.getErrorMessage());
		errorDetailsVO.setResult(EMConstant.CALL_RESULT_FAILURE);
		errorDetailsVO.setRequestURI(request.getRequestURI());
		errorDetailsVO.setHttpStatus(emException.getHttpStatus());

		return ResponseEntity.accepted().body(errorDetailsVO);

	}

}
