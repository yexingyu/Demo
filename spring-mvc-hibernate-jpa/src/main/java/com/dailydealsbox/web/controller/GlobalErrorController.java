/**
 *
 */
package com.dailydealsbox.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author x_ye
 */
@ControllerAdvice
@RestController
public class GlobalErrorController implements ErrorController {
  private static final String PATH = "/error";

  /**
   * error
   *
   * @return
   */
  @RequestMapping(value = PATH)
  public ResponseEntity<String> error() {
    return new ResponseEntity<>("NOT_FOUND", HttpStatus.NOT_FOUND);
  }

  /**
   * defaultErrorHandler
   *
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> defaultErrorHandler(HttpServletRequest request, Exception e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
   */
  @Override
  public String getErrorPath() {
    return PATH;
  }
}
