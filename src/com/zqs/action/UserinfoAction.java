package com.zqs.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqs.biz.TreeBiz;
import com.zqs.biz.UserinfoBiz;
import com.zqs.dao.UserinfoDAO;
import com.zqs.entity.Tree;
import com.zqs.entity.Userinfo;


@Controller
public class UserinfoAction {

	@Autowired
	UserinfoBiz userinfoBiz;
    @Autowired
    TreeBiz treeBiz;
	
//	@RequestMapping("userinfo_login.action")
//	public String login(HttpServletRequest request,HttpServletResponse response){
//		String uacc = request.getParameter("user");
//		String upwd = request.getParameter("pwd");
//		Userinfo  userinfo = new Userinfo();
//		 userinfo.setUacc(uacc);
//		 userinfo.setUpwd(upwd);
//	     System.out.println(userinfo);
//		return null ;
//	}
	
	
	@RequestMapping("userinfo_login.action")
	public String login(Userinfo u,HttpServletRequest request){
		 u = userinfoBiz.login(u);
		 Integer uid = u.getUid();
		 //System.out.println(uid);
	     if(uid==null){
	    	
	    	 return "login";
	     }else{
	    	 u = userinfoBiz.findbyid(uid);
	    	 request.getSession().setAttribute("U",u);
	    	System.out.println(u);
	    	 List<Tree> list = treeBiz.selall(u);
	    	// System.out.println(list);
	    	 JSONArray json = JSONArray.fromObject(list);
	    	// System.out.println(json);
	    	 request.setAttribute("json", json);
	    	 return "tree" ;
	     }
		
	}
	
	@RequestMapping("userinfo_selbyid.action")
	public @ResponseBody Map selbyid(HttpServletRequest request){
		 Userinfo u = (Userinfo) request.getSession().getAttribute("U");
		 Integer uid = u.getUid();
		 u = userinfoBiz.selgere(uid);
		 Map<String,Object> map = new HashMap<String, Object>();
         map.put("uid",u.getUid());
         map.put("uname",u.getUname());
         map.put("uage",u.getUage());
         map.put("usex",u.getUsex());
         map.put("uacc",u.getUacc());
         map.put("upwd",u.getUpwd());
         map.put("uaddress",u.getUaddress());
         map.put("rname",u.getR().getRname());
         map.put("bname",u.getB().getBname());
		 return map;
	}
	
}
