package com.thebinh.controlleradvice;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.MethodArgumentBuilder;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.thebinh.customexeptions.FieldRequiredException;
import com.thebinh.model.ErrorResponseDTO;

@ControllerAdvice
//để khi gặp lỗi, sẽ nhảy vào để xem bạn có xây dựng trường hợp cho nó hay không




public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException( // tên hàm
			ArithmeticException ex, WebRequest request) {
		
		
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
			
			errorResponseDTO.setError(ex.getMessage());
			
			ArrayList<String> details = new ArrayList<>();
			details.add("Số nguyên sao chia được cho số 0");
			errorResponseDTO.setDetail(details);
			
			
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);// trả về client http status
	}
	
	
	
	
	
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldrequiredException(
			FieldRequiredException ex, WebRequest request) {
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
			errorResponseDTO.setError(ex.getMessage());
			ArrayList<String> details = new ArrayList<>();
			details.add("name hoặc numberofbasement đang bị null kìa bạn ơi");
			errorResponseDTO.setDetail(details);
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
	}
	
	
	
	}
