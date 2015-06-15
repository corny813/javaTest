package mybatis.dao;

import java.util.List;

import mybatis.entity.User;

public interface UserMapper {

	/**
	 * 根据id查找
	 * @param id
	 */
	public User selectUserById(String id);
	
	public List<User> selectAllUser();
	
	/**
	 * id自增的形式插入
	 * @param name
	 * @param age
	 */
	public void insertUser(User user);
	
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteUserById(String id);

	/**
	 * 根据name删除
	 * @param name
	 */
	public void deleteUserByName(String name);
	
	
	/**
	 * 根据名字来更新年龄
	 * @param user
	 */
	public void updateUserAgeByName(User user);
	
}
