/**
 *
 */
package com.dailydealsbox.database.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailydealsbox.database.model.Member;
import com.dailydealsbox.database.repository.MemberRepository;

/**
 * @author x_ye
 */
@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

  @Resource
  private MemberRepository repo;

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.service.MemberService#get(int)
   */
  @Override
  public Member get(int id) {
    return this.repo.findOne(id);
  }

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.service.MemberService#getByAccount(java.lang.String)
   */
  @Override
  public Member getByAccount(String account) {
    return this.repo.findByAccount(account);
  }

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.service.MemberService#getAll()
   */
  @Override
  public Page<Member> getAll(Pageable pageable) {
    return this.repo.findByDeletedOrderByCreatedAtDesc(false, pageable);
  }

}
