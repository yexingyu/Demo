/**
 * 
 */
package com.dailydealsbox.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dailydealsbox.database.model.Member;
import com.dailydealsbox.database.service.MemberService;
import com.dailydealsbox.web.base.BaseResponseData;
import com.dailydealsbox.web.base.ResponseData;

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
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  //@Transactional
  public ResponseData all(@CookieValue(value = "token", required = false) String tokenString) {
    List<Member> members = service.all();
    if (members == null || members.size() == 0) {
      return ResponseData.newInstance(BaseResponseData.STATUS.EMPTY_RESULT, null);
    } else {
      return ResponseData.newInstance(BaseResponseData.STATUS.SUCCESS, members);
    }
  }

}
