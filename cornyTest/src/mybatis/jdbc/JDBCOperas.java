package mybatis.jdbc;

import java.util.ArrayList;

import mybatis.dao.UserMapper;
import mybatis.entity.User;
import mybatis.util.SqlSessionHelper;

import org.apache.ibatis.session.SqlSession;

public class JDBCOperas {

	public void selectById(String id){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.selectUserById(id);
		System.out.println(user.getName()+","+user.getAge());
		session.close();
	}
	
	public void selectAllUser(){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		ArrayList<User> users = (ArrayList<User>) userMapper.selectAllUser();
		System.out.println(users.size());
		session.close();
	}
	
	public void insertUser(String name,int age){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
//		user.setId(id);
		user.setName(name);
		user.setAge(age);
		userMapper.insertUser(user);
		session.commit();
		System.out.println("id: "+user.getId());
		session.close();
	}
	
	public void deleteUserByName(String name){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.deleteUserByName(name);
		session.commit();
		session.close();
	}
	
	public void updateUserAgeByName(User user){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.updateUserAgeByName(user);
		session.commit();
		session.close();
	}
	
	public static void main(String[] args){
		JDBCOperas jdbc = new JDBCOperas();
//		jdbc.selectById("20");
		jdbc.insertUser("corny", 1);
//		jdbc.selectAllUser();
//		jdbc.deleteUserByName("corny");
//		jdbc.selectAllUser();
//		User user = new User();
//		user.setAge(25);
//		user.setName("corny");
//		jdbc.updateUserAgeByName(user);
		jdbc.selectAllUser();
	}
}
