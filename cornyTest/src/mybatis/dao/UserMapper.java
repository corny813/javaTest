package mybatis.dao;

import java.util.List;

import mybatis.entity.User;

public interface UserMapper {

	/**
	 * ����id����
	 * @param id
	 */
	public User selectUserById(String id);
	
	public List<User> selectAllUser();
	
	/**
	 * id��������ʽ����
	 * @param name
	 * @param age
	 */
	public void insertUser(User user);
	
	
	/**
	 * ����idɾ��
	 * @param id
	 */
	public void deleteUserById(String id);

	/**
	 * ����nameɾ��
	 * @param name
	 */
	public void deleteUserByName(String name);
	
	
	/**
	 * ������������������
	 * @param user
	 */
	public void updateUserAgeByName(User user);
	
}
