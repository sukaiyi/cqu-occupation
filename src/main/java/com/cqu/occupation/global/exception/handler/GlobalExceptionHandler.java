package com.cqu.occupation.global.exception.handler;

import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.global.exception.exceptions.BusinessException;
import com.cqu.occupation.global.exception.exceptions.code.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sukaiyi
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity handleException(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<>(ResultVO.error(ExceptionCode.OTHER, ex.getMessage()), HttpStatus.OK);
	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public ResponseEntity handleException(HttpServletRequest request, BusinessException ex) {
		return new ResponseEntity<>(ResultVO.error(ex.getCode(), ex.getMessage()), HttpStatus.OK);
	}

}
