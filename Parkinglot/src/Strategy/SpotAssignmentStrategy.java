package Strategy;

import java.util.List;

import Models.Gate;
import Models.ParkingSpot;
import Models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType,Gate gate, List<ParkingSpot> parkingSpotList);
}
