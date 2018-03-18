package com.zqs.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zqs.entity.Chengji;

/**
 * A data access object (DAO) providing persistence and search support for
 * Chengji entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zqs.entity.Chengji
 * @author MyEclipse Persistence Tools
 */
public class ChengjiDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ChengjiDAO.class);
	// property constants
	public static final String KID = "kid";
	public static final String UID = "uid";
	public static final String SCORE = "score";

	protected void initDao() {
		// do nothing
	}

	public void save(Chengji transientInstance) {
		log.debug("saving Chengji instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Chengji persistentInstance) {
		log.debug("deleting Chengji instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chengji findById(java.lang.Integer id) {
		log.debug("getting Chengji instance with id: " + id);
		try {
			Chengji instance = (Chengji) getHibernateTemplate().get(
					"com.zqs.entity.Chengji", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Chengji instance) {
		log.debug("finding Chengji instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Chengji instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Chengji as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKid(Object kid) {
		return findByProperty(KID, kid);
	}

	public List findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all Chengji instances");
		try {
			String queryString = "from Chengji";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chengji merge(Chengji detachedInstance) {
		log.debug("merging Chengji instance");
		try {
			Chengji result = (Chengji) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chengji instance) {
		log.debug("attaching dirty Chengji instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chengji instance) {
		log.debug("attaching clean Chengji instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ChengjiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ChengjiDAO) ctx.getBean("ChengjiDAO");
	}
}