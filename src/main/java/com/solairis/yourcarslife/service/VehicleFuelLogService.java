/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solairis.yourcarslife.service;

import com.solairis.yourcarslife.data.domain.Vehicle;
import com.solairis.yourcarslife.data.domain.VehicleFuelLog;
import com.solairis.yourcarslife.service.exception.VehicleFuelLogServiceException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josh
 */
public interface VehicleFuelLogService {

	@Transactional
	public List<VehicleFuelLog> getVehicleFuelLogsByVehicle(Vehicle vehicle, int pageNumber) throws VehicleFuelLogServiceException;

}
