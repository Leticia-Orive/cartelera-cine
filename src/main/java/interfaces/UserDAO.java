package interfaces;

import java.util.List;

import entitis.User;

public interface UserDAO {

	/**
	 * It returns a list of all employees
	 * @return
	 */
	List<User> get();
	
	/**
	 * It returns one user by id
	 * @param id
	 * @return
	 */
	User get(Long id);
	
	/**
	 * It saves an User
	 * @param user
	 * @return true if user is correctly saved or false if there is an error
	 */
	boolean save(User user);
	
	/**
	 * It deletes an user
	 * @param id
	 * @return 
	 */
	boolean delete(Long id);
	
	/**
	 * It updates an user
	 * @param user
	 * @return
	 */
	boolean update(User user);
}
