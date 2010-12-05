/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.exception;

/**
 *
 * @author josh
 */
public class ServiceException extends RuntimeException {

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

}
