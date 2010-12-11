/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.exception;

/**
 *
 * @author josh
 */
public class UserServiceException extends ServiceException {

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(Throwable e) {
		super(e);
	}

}
