/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.exception;

/**
 *
 * @author josh
 */
public class VehicleServiceException extends ServiceException {

	public VehicleServiceException(String message) {
		super(message);
	}

	public VehicleServiceException(Exception e) {
		super(e);
	}

}
