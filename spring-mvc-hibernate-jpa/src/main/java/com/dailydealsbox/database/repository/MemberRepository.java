/**
 *
 */
package com.dailydealsbox.database.repository;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import com.dailydealsbox.database.model.Member;

/**
 * @author x_ye
 */
public interface MemberRepository extends CrudRepository<Member, Integer> {

  /**
   * findByAccount
   *
   * @param account
   * @return
   */
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
  public Member findByAccount(String account);

  /**
   * findByDeletedOrderByCreatedAtDesc
   *
   * @param deleted
   * @return
   */
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
  public Page<Member> findByDeletedOrderByCreatedAtDesc(boolean deleted, Pageable pageable);
}
