/**
 *
 */
package com.dailydealsbox.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dailydealsbox.database.model.Member;
import com.dailydealsbox.database.service.MemberService;

/**
 * @author x_ye
 */
@RestController
@RequestMapping("/api/members")
public class MembersController {

  @Autowired
  MemberService service;

  /**
   * all
   *
   * @param pageable
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Page<Member>> all(Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
    Page<Member> members = this.service.getAll(pageable);
    return new ResponseEntity<>(members, HttpStatus.OK);
  }

  /**
   * get
   * 
   * @param id
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public ResponseEntity<Member> get(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
    Member member = this.service.get(id);
    return new ResponseEntity<>(member, HttpStatus.OK);
  }

}
