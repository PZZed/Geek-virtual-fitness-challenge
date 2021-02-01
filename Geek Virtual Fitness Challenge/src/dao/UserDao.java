package dao;

import model.User;

public class UserDao extends DAOAbstractFacade<User> {

	public UserDao() {
		super(User.class);
	}

}
