/**
 *
 */
package com.dailydealsbox.database.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dailydealsbox.database.model.Member;

/**
 * @author x_ye
 */
public interface MemberService {
  /**
   * get
   *
   * @param id
   * @return
   */
  public Member get(int id);

  /**
   * getByAccount
   *
   * @param account
   * @return
   */
  public Member getByAccount(String account);

  /**
   * getAll
   *
   * @param pageable
   * @return
   */
  public Page<Member> getAll(Pageable pageable);
}
