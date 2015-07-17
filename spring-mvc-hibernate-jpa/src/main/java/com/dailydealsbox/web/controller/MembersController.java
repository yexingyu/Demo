/**
 * 
 */
package com.dailydealsbox.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dailydealsbox.database.model.Member;
import com.dailydealsbox.database.service.MemberService;
import com.dailydealsbox.web.base.BaseResponseData;
import com.dailydealsbox.web.base.GeneralResponseData;

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
  public GeneralResponseData all() {
    List<Member> members = service.getAll();
    if (members == null || members.size() == 0) {
      return GeneralResponseData.newInstance(BaseResponseData.STATUS.EMPTY_RESULT, null);
    } else {
      return GeneralResponseData.newInstance(BaseResponseData.STATUS.SUCCESS, members);
    }
  }

  /**
   * get
   * 
   * @param id
   * @return
   */
  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public BaseResponseData get(@PathVariable("id") int id) {
    Member member = service.get(id);
    if (member == null) {
      return GeneralResponseData.newInstance(BaseResponseData.STATUS.EMPTY_RESULT, null);
    } else {
      return GeneralResponseData.newInstance(BaseResponseData.STATUS.SUCCESS, member);
    }
  }

}
