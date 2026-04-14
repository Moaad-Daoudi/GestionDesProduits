package ma.ensah.service;

import ma.ensah.dao.IUser;
import ma.ensah.dao.UserDaoImpl;
import ma.ensah.model.User;

public class UserService {

	private IUser userdao = new UserDaoImpl();
	
	public void register(User user) {
		userdao.save(user);
	}

	public User authenticate(String email, String password) {
		User user = userdao.findByEmail(email);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
