/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service;

import com.solairis.yourcarslife.data.domain.Vehicle;
import com.solairis.yourcarslife.service.exception.VehicleServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josh
 */
public interface VehicleService {

	@Transactional
	public Vehicle getVehicleByNameAndUser(String vehicleName, long userId) throws VehicleServiceException;

}
