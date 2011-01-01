/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service.impl;

import com.solairis.yourcarslife.data.dao.VehicleFuelLogDao;
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
	public VehicleFuelLog getVehicleFuelLog(long vehicleFuelLogId) throws VehicleFuelLogServiceException {
		VehicleFuelLog vehicleFuelLog = null;
		try {
			vehicleFuelLog = this.vehicleFuelLogDao.getVehicleFuelLog(vehicleFuelLogId);
		} catch (VehicleLogDaoException e) {
			throw new VehicleFuelLogServiceException(e);
		}
		return vehicleFuelLog;
	}

	@Override
	@Transactional
	public void saveVehicleFuelLog(VehicleFuelLog vehicleFuelLog) throws VehicleFuelLogServiceException {
		try {
			this.vehicleFuelLogDao.saveVehicleFuelLog(vehicleFuelLog);
		} catch (VehicleLogDaoException e) {
			throw new VehicleFuelLogServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<VehicleFuelLog> getVehicleFuelLogsByVehicle(long vehicleId, long vehicleFuelLogId, int pageNumber, int maxResults) throws VehicleFuelLogServiceException {
		List<VehicleFuelLog> vehicleFuelLogs = null;

		VehicleFuelLogInputData inputData = new VehicleFuelLogInputData();
		inputData.setVehicleId(vehicleId);
		inputData.setVehicleFuelLogId(vehicleFuelLogId);
		inputData.setMaxRecords(maxResults);
		inputData.setStartRecord(maxResults * (pageNumber - 1));
		inputData.setActive(true);

		try {
			vehicleFuelLogs = this.vehicleFuelLogDao.getVehicleFuelLogs(inputData);
		} catch (VehicleLogDaoException e) {
			throw new VehicleFuelLogServiceException(e);
		}

		return vehicleFuelLogs;
	}

	@Override
	@Transactional
	public int getVehicleFuelLogCountByVehicle(long vehicleId) throws VehicleFuelLogServiceException {
		int count = 0;

		VehicleFuelLogInputData inputData = new VehicleFuelLogInputData();
		inputData.setVehicleId(vehicleId);
		inputData.setActive(true);
		
		try {
			count = this.vehicleFuelLogDao.getVehicleFuelLogCount(inputData);
		} catch (VehicleLogDaoException e) {
			throw new VehicleFuelLogServiceException(e);
		}
		return count;
	}

	public void setVehicleFuelLogDao(VehicleFuelLogDao vehicleFuelLogDao) {
		this.vehicleFuelLogDao = vehicleFuelLogDao;
	}

}
