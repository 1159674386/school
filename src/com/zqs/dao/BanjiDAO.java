package com.zqs.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zqs.entity.Banji;

/**
 * A data access object (DAO) providing persistence and search support for Banji
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zqs.entity.Banji
 * @author MyEclipse Persistence Tools
 */
public class BanjiDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BanjiDAO.class);
	// property constants
	public static final String BNAME = "bname";

	protected void initDao() {
		// do nothing
	}

	public void save(Banji transientInstance) {
		log.debug("saving Banji instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Banji persistentInstance) {
		log.debug("deleting Banji instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Banji findById(java.lang.Integer id) {
		log.debug("getting Banji instance with id: " + id);
		try {
			Banji instance = (Banji) getHibernateTemplate().get(
					"com.zqs.entity.Banji", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Banji instance) {
		log.debug("finding Banji instance by example");
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
		log.debug("finding Banji instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Banji as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBname(Object bname) {
		return findByProperty(BNAME, bname);
	}

	public List findAll() {
		log.debug("finding all Banji instances");
		try {
			String queryString = "from Banji";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Banji merge(Banji detachedInstance) {
		log.debug("merging Banji instance");
		try {
			Banji result = (Banji) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Banji instance) {
		log.debug("attaching dirty Banji instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Banji instance) {
		log.debug("attaching clean Banji instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BanjiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BanjiDAO) ctx.getBean("BanjiDAO");
	}
}