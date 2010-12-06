/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service;

import com.solairis.yourcarslife.data.domain.User;
import com.solairis.yourcarslife.data.domain.Vehicle;
import com.solairis.yourcarslife.service.exception.VehicleServiceException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josh
 */
public interface VehicleService {

	@Transactional
	public Vehicle getVehicle(long vehicleId) throws VehicleServiceException;

	@Transactional
	public Vehicle getVehicleByNameAndUser(String vehicleName, long userId) throws VehicleServiceException;

	@Transactional
	public List<Vehicle> getVehiclesByUser(User user) throws VehicleServiceException;

}
