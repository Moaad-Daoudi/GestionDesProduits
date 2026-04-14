package ma.ensah.dao;

import ma.ensah.model.User;

public interface IUser {
	void save(User user);
	User findByEmail(String email);
}
