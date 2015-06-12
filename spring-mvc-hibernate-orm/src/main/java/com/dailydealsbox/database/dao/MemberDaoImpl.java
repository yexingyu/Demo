/**
 * 
 */
package com.dailydealsbox.database.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dailydealsbox.database.dao.base.BaseEntityDao;
import com.dailydealsbox.database.model.Member;

/**
 * @author x_ye
 */
@Repository
public class MemberDaoImpl extends BaseEntityDao<Member> implements MemberDao {

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.database.dao.TimoTestDao#save(com.dailydealsbox.database.model.TimoTest)
   */
  @Override
  public void save(Member member) {
    this.persist(member);
  }

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.database.dao.TimoTestDao#findAll()
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Member> all() {
    //return this.getSession().createSQLQuery("select * from members").addEntity(Member.class).list();
    return this.getSession().createCriteria(Member.class).setCacheable(true).list();
    //return this.getSession().createQuery("from Member").setCacheable(true).list();
  }

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.database.dao.TestDao#get(int)
   */
  @Override
  public Member get(int id) {
    return this.get(Member.class, id);
  }

  /*
   * (non-Javadoc)
   * @see com.dailydealsbox.database.dao.AccountsDao#getByAccount(java.lang.String)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Member getByAccount(String account) {
    List<Member> as = getSession().createCriteria(Member.class)
        .add(Restrictions.eq("account", account)).list();
    if (as.size() >= 1) {
      return as.get(0);
    } else {
      return null;
    }
  }
}
