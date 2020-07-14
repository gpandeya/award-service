package com.gp.learn.awardservice.controller;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gp.learn.awardservice.dto.ExceptionDTO;
import com.gp.learn.awardservice.exception.AwardNotFoundException;
import com.gp.learn.awardservice.exception.BadRequestException;

@ControllerAdvice
public class AwardExceptionsCustomHandler extends ResponseEntityExceptionHandler{

	private final boolean includeClientInfo = false;
	private Logger logger = LoggerFactory.getLogger(AwardExceptionsCustomHandler.class);
	
	@ExceptionHandler(value=AwardNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleNotFoundexception(
		AwardNotFoundException exception, WebRequest request){
		
		ExceptionDTO exceptionDTO = new ExceptionDTO(
							exception.getCategory(),exception.getDeatils(),
							request.getDescription(includeClientInfo));
		
		return new ResponseEntity<ExceptionDTO>(exceptionDTO,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public ResponseEntity<ExceptionDTO> handleIllegalArgument(
			IllegalArgumentException exception,WebRequest request){
		
		ExceptionDTO exceptionDTO= new ExceptionDTO(exception.getClass().getSimpleName(),exception.getMessage(),
										request.getDescription(includeClientInfo));
		
		return new ResponseEntity<ExceptionDTO>(exceptionDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=BadRequestException.class)
	public ResponseEntity<ExceptionDTO> handleArugmentValidationException(
			BadRequestException exception, WebRequest request){
		ExceptionDTO exceptionDTO= new ExceptionDTO(
				exception.getCategory(),exception.getDeatils(),
				request.getDescription(includeClientInfo));
		return new ResponseEntity<ExceptionDTO>(exceptionDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> handleAllOtherExceptions(Exception exception, WebRequest request){
		
		logger.error("Exception trace for 'handleAllOtherExceptions' exeption {} ", exception);
		String exceptionDetail =exception.getCause().getCause().getLocalizedMessage();		
//		Throwable exceptionCause = exception.getCause();
//			if(exceptionCause==null) {
//				exceptionDetail = exception.getMessage();
//				break;
//			}else {
//				exceptionCause = exceptionCause.getCause();
//				if(exceptionCause==null) {
//					exceptionDetail = exceptionCause.getMessage();
//					break;
//				}else
//					
//			}
		ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getClass().getSimpleName(),
													exceptionDetail,
													request.getDescription(includeClientInfo));
		
		return new ResponseEntity<ExceptionDTO>(exceptionDTO,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
