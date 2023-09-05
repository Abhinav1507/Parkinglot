package Service;

import java.util.List;

import Models.Gate;
import Models.ParkingSpot;
import Models.Vehicle;
import Repository.ParkingLotRepository;
import Strategy.SpotAssignmentStrategy;

public class ParkingLotService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(SpotAssignmentStrategy spotAssignmentStrategy){
        this.spotAssignmentStrategy=spotAssignmentStrategy;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle,Gate gate){
        List<ParkingSpot> parkingSpotLists=parkingLotRepository.getAllParkingSpots();
        return spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(), gate,parkingSpotLists);
    }
}
