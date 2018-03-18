package com.zqs.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zqs.dao.UserinfoDAO;
import com.zqs.entity.Userinfo;




@Service
@Transactional
public class UserinfoBiz {

	
	@Autowired
	UserinfoDAO userinfoDAO;
	
	//判断登录
	public Userinfo login(Userinfo u){
		
		String uacc = u.getUacc();
		String upwd = u.getUpwd();
		try {
			Session session = userinfoDAO.getHibernateTemplate().getSessionFactory().openSession();
			String sql= "select * from userinfo where uacc = "+uacc+" and upwd = "+upwd ;
			SQLQuery query = session.createSQLQuery(sql);               
			query.addEntity(Userinfo.class);  //返回类型的泛型
			List<Userinfo> list = query.list();
			Iterator<Userinfo> it = list.iterator();
			while(it.hasNext()){
				u = it.next();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	//根据ID获得对象
	public Userinfo findbyid(Integer id){
		
		return  userinfoDAO.findById(id);
		
	}
	
//	public List selgeren(Integer id){
//		List list = new ArrayList();
//		String sql= "select * from userinfo,role,banji where userinfo.rid = role.rid and banji.bid = userinfo.bid and uid = "+id ; 
//		try {
//			Session session = userinfoDAO.getHibernateTemplate().getSessionFactory().openSession();
//			
//			SQLQuery query = session.createSQLQuery(sql);               
//			query.addEntity(Userinfo.class);  //返回类型的泛型
//			list = query.list();
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//		
//	}
	
		public Userinfo selgere(Integer uid){
		
		return  userinfoDAO.findById(uid);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
