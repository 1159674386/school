package com.zqs.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zqs.entity.Kecheng;

/**
 * A data access object (DAO) providing persistence and search support for
 * Kecheng entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zqs.entity.Kecheng
 * @author MyEclipse Persistence Tools
 */
public class KechengDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(KechengDAO.class);
	// property constants
	public static final String KNAME = "kname";

	protected void initDao() {
		// do nothing
	}

	public void save(Kecheng transientInstance) {
		log.debug("saving Kecheng instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Kecheng persistentInstance) {
		log.debug("deleting Kecheng instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kecheng findById(java.lang.Integer id) {
		log.debug("getting Kecheng instance with id: " + id);
		try {
			Kecheng instance = (Kecheng) getHibernateTemplate().get(
					"com.zqs.entity.Kecheng", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Kecheng instance) {
		log.debug("finding Kecheng instance by example");
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
		log.debug("finding Kecheng instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Kecheng as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKname(Object kname) {
		return findByProperty(KNAME, kname);
	}

	public List findAll() {
		log.debug("finding all Kecheng instances");
		try {
			String queryString = "from Kecheng";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Kecheng merge(Kecheng detachedInstance) {
		log.debug("merging Kecheng instance");
		try {
			Kecheng result = (Kecheng) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Kecheng instance) {
		log.debug("attaching dirty Kecheng instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kecheng instance) {
		log.debug("attaching clean Kecheng instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KechengDAO getFromApplicationContext(ApplicationContext ctx) {
		return (KechengDAO) ctx.getBean("KechengDAO");
	}
}