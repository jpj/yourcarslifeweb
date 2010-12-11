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
	private Integer defaultMaxResults;
	private Integer maxResultsUpperLimit;

	@Override
	@Transactional
	public List<VehicleFuelLog> getVehicleFuelLogsByVehicle(Vehicle vehicle, int pageNumber, int maxResults) throws VehicleFuelLogServiceException {
		List<VehicleFuelLog> vehicleFuelLogs = null;
		maxResults = maxResults < 1 ? this.defaultMaxResults.intValue() : maxResults;
		maxResults = maxResults > this.maxResultsUpperLimit.intValue() ? this.maxResultsUpperLimit.intValue() : maxResults;

		VehicleFuelLogInputData inputData = new VehicleFuelLogInputData();
		inputData.setVehicleId(vehicle.getVehicleId());
		inputData.setMaxRecords(maxResults);
		inputData.setStartRecord(maxResults * (pageNumber - 1));

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

	public void setDefaultMaxResults(Integer defaultMaxResults) {
		this.defaultMaxResults = defaultMaxResults;
	}

	public void setMaxResultsUpperLimit(Integer maxResultsUpperLimit) {
		this.maxResultsUpperLimit = maxResultsUpperLimit;
	}

}
