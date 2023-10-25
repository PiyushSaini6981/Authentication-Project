package com.JavaMail.JavaMailSender.exceptions;

import javax.persistence.EntityNotFoundException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.JavaMail.JavaMailSender.responsedto.ApiResponseDTO;

@RestControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<ApiResponseDTO> handleEntityNotFound(EntityNotFoundException ex) {
		 return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO( ex.getMessage()),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Emailnotsend.class)
	public ResponseEntity<ApiResponseDTO> handelEmailnotsend(Emailnotsend ex, WebRequest webrequest) throws Exception{
		return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Emailnotsendwithattachment.class)
	public ResponseEntity<ApiResponseDTO> handelEmailnotsendwithattachment(Emailnotsendwithattachment ex, WebRequest webrequest) throws Exception{
		return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO(ex.getMessage()),HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(EmailVerify.class)
	public ResponseEntity<ApiResponseDTO> handelEmailVerify(EmailVerify ex, WebRequest webrequest) throws Exception{
		return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Verifyotp.class)
	public ResponseEntity<ApiResponseDTO> handelVerifyOTP(Verifyotp ex, WebRequest webrequest) throws Exception{
		return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
