/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.impl;

import com.solairis.yourcarslife.data.dao.UserDao;
import com.solairis.yourcarslife.data.domain.User;
import com.solairis.yourcarslife.data.exception.UserDaoException;
import com.solairis.yourcarslife.service.UserService;
import com.solairis.yourcarslife.service.exception.UserServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josh
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User getUser(long userId) throws UserServiceException {
		User user = null;

		try {
			user = this.userDao.getUser(userId);
		} catch (UserDaoException e) {
			throw new UserServiceException(e);
		}

		return user;
	}

	@Override
	@Transactional
	public User getUser(String login) throws UserServiceException {
		User user = null;
		try {
			user = this.userDao.getUser(login);
		} catch (UserDaoException e) {
			throw new UserServiceException(e);
		}
		return user;
	}

	@Override
	@Transactional
	public void createUser(User user, String password) throws UserServiceException {
		try {
			user.setPassword(this.passwordEncoder.encodePassword(password, null));
			this.userDao.saveUser(user);
		} catch (DataAccessException e) {
			throw new UserServiceException(e);
		} catch (UserDaoException e) {
			throw new UserServiceException(e);
		}
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
