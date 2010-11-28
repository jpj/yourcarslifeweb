/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.impl;

import com.solairis.yourcarslife.data.dao.VehicleDao;
import com.solairis.yourcarslife.data.domain.User;
import com.solairis.yourcarslife.data.domain.Vehicle;
import com.solairis.yourcarslife.data.exception.VehicleDaoException;
import com.solairis.yourcarslife.data.input.VehicleInputData;
import com.solairis.yourcarslife.service.VehicleService;
import com.solairis.yourcarslife.service.exception.VehicleServiceException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author josh
 */
public class VehicleServiceImpl implements VehicleService {

	private VehicleDao vehicleDao;

	@Override
	public Vehicle getVehicleByNameAndUser(String vehicleName, long userId) throws VehicleServiceException {
		Vehicle vehicle = null;
		VehicleInputData inputData = new VehicleInputData();
		inputData.setName(vehicleName);

		User user = new User();
		user.setUserId(userId);

		inputData.setUser(user);

		try {
			List<Vehicle> vehicles = this.vehicleDao.getVehicles(inputData);
			if (vehicles.size() > 1) {
				throw new VehicleServiceException("More than 1 vehicle returned");
			}
			vehicle = vehicles.get(0);
		} catch (VehicleDaoException e) {
			throw new VehicleServiceException(e);
		}
		return vehicle;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

}
