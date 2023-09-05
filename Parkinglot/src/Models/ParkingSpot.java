package Models;

import java.util.List;

public class ParkingSpot extends BaseEntity{
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleTypes;
    private int number;

    public ParkingSpotStatus getParkingSpotStatus(){
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus){
        this.parkingSpotStatus= parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor(){
        return parkingFloor;
    }

    public List<VehicleType> getSupportedVehicleTypes(){
        return supportedVehicleTypes;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number=number;
    }

    

}
