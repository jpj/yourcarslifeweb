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

/**
 *
 * @author josh
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public User getUser(long userId) throws UserServiceException {
		User user = null;

		try {
			user = this.userDao.getUser(userId);
		} catch (UserDaoException e) {
			throw new UserServiceException(e);
		}

		return user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
