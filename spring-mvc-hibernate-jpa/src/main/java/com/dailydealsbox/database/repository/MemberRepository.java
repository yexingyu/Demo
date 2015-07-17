/**
 *
 */
package com.dailydealsbox.database.repository;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import com.dailydealsbox.database.model.Member;

/**
 * @author x_ye
 */
public interface MemberRepository extends CrudRepository<Member, Integer> {

  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
  Member findByAccount(String account);
}
