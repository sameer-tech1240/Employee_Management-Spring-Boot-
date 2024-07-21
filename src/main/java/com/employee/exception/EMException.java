package com.employee.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EMException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	private HttpStatus httpStatus;

}
