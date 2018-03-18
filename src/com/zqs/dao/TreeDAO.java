package com.zqs.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zqs.entity.Tree;

/**
 * A data access object (DAO) providing persistence and search support for Tree
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zqs.entity.Tree
 * @author MyEclipse Persistence Tools
 */
public class TreeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TreeDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PATH = "path";
	public static final String PID = "pid";
	public static final String OPEN = "open";

	protected void initDao() {
		// do nothing
	}

	public void save(Tree transientInstance) {
		log.debug("saving Tree instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tree persistentInstance) {
		log.debug("deleting Tree instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tree findById(java.lang.Integer id) {
		log.debug("getting Tree instance with id: " + id);
		try {
			Tree instance = (Tree) getHibernateTemplate().get(
					"com.zqs.entity.Tree", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tree instance) {
		log.debug("finding Tree instance by example");
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
		log.debug("finding Tree instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tree as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findByPid(Object pid) {
		return findByProperty(PID, pid);
	}

	public List findByOpen(Object open) {
		return findByProperty(OPEN, open);
	}

	public List findAll() {
		log.debug("finding all Tree instances");
		try {
			String queryString = "from Tree";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tree merge(Tree detachedInstance) {
		log.debug("merging Tree instance");
		try {
			Tree result = (Tree) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tree instance) {
		log.debug("attaching dirty Tree instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tree instance) {
		log.debug("attaching clean Tree instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TreeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TreeDAO) ctx.getBean("TreeDAO");
	}
}