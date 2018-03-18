package com.zqs.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zqs.entity.Roletree;

/**
 * A data access object (DAO) providing persistence and search support for
 * Roletree entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zqs.entity.Roletree
 * @author MyEclipse Persistence Tools
 */
public class RoletreeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RoletreeDAO.class);
	// property constants
	public static final String TREEID = "treeid";
	public static final String RID = "rid";

	protected void initDao() {
		// do nothing
	}

	public void save(Roletree transientInstance) {
		log.debug("saving Roletree instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Roletree persistentInstance) {
		log.debug("deleting Roletree instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Roletree findById(java.lang.Integer id) {
		log.debug("getting Roletree instance with id: " + id);
		try {
			Roletree instance = (Roletree) getHibernateTemplate().get(
					"com.zqs.entity.Roletree", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Roletree instance) {
		log.debug("finding Roletree instance by example");
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
		log.debug("finding Roletree instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Roletree as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTreeid(Object treeid) {
		return findByProperty(TREEID, treeid);
	}

	public List findByRid(Object rid) {
		return findByProperty(RID, rid);
	}

	public List findAll() {
		log.debug("finding all Roletree instances");
		try {
			String queryString = "from Roletree";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Roletree merge(Roletree detachedInstance) {
		log.debug("merging Roletree instance");
		try {
			Roletree result = (Roletree) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Roletree instance) {
		log.debug("attaching dirty Roletree instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Roletree instance) {
		log.debug("attaching clean Roletree instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoletreeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoletreeDAO) ctx.getBean("RoletreeDAO");
	}
}