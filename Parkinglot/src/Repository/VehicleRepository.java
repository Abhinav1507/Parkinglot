package Repository;

import java.util.HashMap;
import java.util.Map;

import Models.Vehicle;

public class VehicleRepository {
    /*we can have DB push the data */
    Map<String,Vehicle> vehicleStore;

    public VehicleRepository(){
        vehicleStore = new HashMap<>();
    }

    public Vehicle getVehiclefromVehicleNumber(String vehicleNumber){
        return vehicleStore.get(vehicleNumber);
    }

    public Vehicle addVehicle(Vehicle vehicle){
        vehicleStore.put(vehicle.getNumber(),vehicle);
        return vehicle;
    }
    


}
