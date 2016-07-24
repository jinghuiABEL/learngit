package cn.test.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.test.damain.User;
import cn.test.dao.UserDao;
import cn.test.utils.XmlUtils;





public class UserDaoImpl implements UserDao {
/* (non-Javadoc)
 * @see cn.test.dao.impl.UserDao#add(cn.test.damain.User)
 */
public void  add(User user){
	
  try {
       Document document= XmlUtils.getDocument();
    	Element root=document.getRootElement();
    	Element user_tag=root.addElement("user");
    	user_tag.setAttributeValue("id", user.getId());
    	user_tag.setAttributeValue("username", user.getUsername());
    	user_tag.setAttributeValue("password", user.getPassword());
    	user_tag.setAttributeValue("email", user.getEmail());
    	user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
    	
    	XmlUtils.write2Xml(document);
      } catch (Exception e) {
	  throw new RuntimeException(e);
    }	
}




/* (non-Javadoc)
 * @see cn.test.dao.impl.UserDao#find(java.lang.String, java.lang.String)
 */
public User find(String username,String password){
	
	try {
		Document document= XmlUtils.getDocument();
		
	  Element e= (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
	  
	 if (e==null) {
		return null;
	}
	  User user=new User();
	   String data = e.attributeValue("birthday");
	 if (data==null||data.equals("")) {
		 user.setBirthday(null);
	}else {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-DD");
		user.setBirthday(df.parse(data));
	}
	  
	  user.setEmail(e.attributeValue("email"));
	  user.setId(e.attributeValue("id"));
	  return user;
	  
	 
	 
	} catch (Exception e) {
		
		//return null;
		throw new RuntimeException(e);
	}
	
	
}
//查找注册的用户是否在数据库中存在
/* (non-Javadoc)
 * @see cn.test.dao.impl.UserDao#find(java.lang.String)
 */
public boolean find (String username){
	try {
		Document document= XmlUtils.getDocument();
	   Element e= (Element) document.selectSingleNode("//user[@username='"+username+"' ]");
	   if (e==null) {
		return false;
	}
	 return true;
	} catch (Exception e) {
		
		throw new RuntimeException(e);
	}
	
}

}
