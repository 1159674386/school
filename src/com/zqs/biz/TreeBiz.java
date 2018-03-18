package com.zqs.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zqs.dao.TreeDAO;
import com.zqs.entity.Tree;
import com.zqs.entity.Userinfo;


@Service
@Transactional
public class TreeBiz {

	
	@Autowired
	TreeDAO treeDAO;
	
	public List<Tree> selall(Userinfo u){
		 Integer rid = u.getR().getRid();
		 List<Tree> list = new ArrayList<Tree>();
		try {
			Session session = treeDAO.getHibernateTemplate().getSessionFactory().openSession();
			String sql= "select * from tree where treeid in (select treeid from roletree where rid = "+rid+") ";
			SQLQuery query = session.createSQLQuery(sql);               
			query.addEntity(Tree.class);  //返回类型的泛型
			 list = query.list();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ;
		
	}
}
