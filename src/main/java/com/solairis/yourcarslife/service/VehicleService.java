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

	public Vehicle getVehicle(long vehicleId) throws VehicleServiceException;

	public Vehicle getVehicleByNameAndUser(String vehicleName, long userId) throws VehicleServiceException;

	public List<Vehicle> getVehiclesByUser(User user) throws VehicleServiceException;

	public Vehicle getVehicleByUserAndVehicleId(User user, long vehicleId) throws VehicleServiceException;

}
