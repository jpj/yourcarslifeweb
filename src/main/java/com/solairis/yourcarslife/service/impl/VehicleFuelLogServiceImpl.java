/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.impl;

import com.solairis.yourcarslife.data.dao.VehicleFuelLogDao;
import com.solairis.yourcarslife.data.domain.Vehicle;
import com.solairis.yourcarslife.data.domain.VehicleFuelLog;
import com.solairis.yourcarslife.data.exception.VehicleLogDaoException;
import com.solairis.yourcarslife.data.input.VehicleFuelLogInputData;
import com.solairis.yourcarslife.service.VehicleFuelLogService;
import com.solairis.yourcarslife.service.exception.VehicleFuelLogServiceException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josh
 */
public class VehicleFuelLogServiceImpl implements VehicleFuelLogService {

	private VehicleFuelLogDao vehicleFuelLogDao;

	@Override
	@Transactional
	public List<VehicleFuelLog> getVehicleFuelLogsByVehicle(Vehicle vehicle) throws VehicleFuelLogServiceException {
		List<VehicleFuelLog> vehicleFuelLogs = null;

		VehicleFuelLogInputData inputData = new VehicleFuelLogInputData();
		inputData.setVehicleId(vehicle.getVehicleId());

		try {
			vehicleFuelLogs = this.vehicleFuelLogDao.getVehicleFuelLogs(inputData);
		} catch (VehicleLogDaoException e) {
			throw new VehicleFuelLogServiceException(e);
		}

		return vehicleFuelLogs;
	}

	public void setVehicleFuelLogDao(VehicleFuelLogDao vehicleFuelLogDao) {
		this.vehicleFuelLogDao = vehicleFuelLogDao;
	}

}
