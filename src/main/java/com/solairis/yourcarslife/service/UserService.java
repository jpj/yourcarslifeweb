/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service;

import com.solairis.yourcarslife.data.domain.User;
import com.solairis.yourcarslife.service.exception.UserServiceException;

/**
 *
 * @author josh
 */
public interface UserService {

	public User getUser(long userId) throws UserServiceException;
	public User getUser(String login) throws UserServiceException;
	public void createUser(User user, String password) throws UserServiceException;

}
