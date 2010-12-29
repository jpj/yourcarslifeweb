/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service;

import com.solairis.yourcarslife.data.domain.Vehicle;
import com.solairis.yourcarslife.data.domain.VehicleFuelLog;
import com.solairis.yourcarslife.service.exception.VehicleFuelLogServiceException;
import java.util.List;

/**
 *
 * @author josh
 */
public interface VehicleFuelLogService {

	public List<VehicleFuelLog> getVehicleFuelLogsByVehicle(long vehicleId, long vehicleFuelLogId, int pageNumber, int maxResults) throws VehicleFuelLogServiceException;
	public int getVehicleFuelLogCountByVehicle(long vehicleId) throws VehicleFuelLogServiceException;

}
