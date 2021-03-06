package com.graphhopper.jsprit.core.problem.cost;

import com.graphhopper.jsprit.core.problem.driver.Driver;
import com.graphhopper.jsprit.core.problem.solution.route.activity.TourActivity;
import com.graphhopper.jsprit.core.problem.vehicle.Vehicle;

/**
 * Created by schroeder on 23/07/15.
 */
public class WaitingTimeCosts implements VehicleRoutingActivityCosts {

    @Override
    public double getActivityCost(TourActivity tourAct, double arrivalTime, Driver driver, Vehicle vehicle) {
        if (vehicle != null) {
            double waiting = vehicle.getType().getVehicleCostParams().perWaitingTimeUnit * Math.max(0., tourAct.getTheoreticalEarliestOperationStartTime() - arrivalTime);
            double servicing = vehicle.getType().getVehicleCostParams().perServiceTimeUnit * tourAct.getOperationTime();
            return waiting + servicing;
        }
        return 0;
    }

}
