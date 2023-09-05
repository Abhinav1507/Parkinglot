package Service;

import java.util.Date;

import Exceptions.NoParkingSpotFoundException;
import Models.Gate;
import Models.ParkingSpot;
import Models.Ticket;
import Models.Vehicle;
import Models.VehicleType;
import Repository.TicketRepository;

public class TicketService {
    private VehicleService vehicleService;
    private ParkingLotService parkingLotService;
    private GateService gateService;

    private TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService,
                        GateService gateService, 
                        ParkingLotService parkingLotService,
                        TicketRepository ticketRepository){
        this.vehicleService=vehicleService;
        this.gateService=gateService;
        this.parkingLotService=parkingLotService;
        this.ticketRepository=ticketRepository;
                        }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId)
        throws NoParkingSpotFoundException {
            Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
            if (vehicle==null){
                vehicle=vehicleService.registerVehicle(vehicleNumber, vehicleType);
            }
        
        Gate gate = gateService.getGateUsingId(gateId);
        ParkingSpot parkingSpot = parkingLotService.getParkingSpot(vehicle, gate);

        if(parkingSpot==null){
            throw new NoParkingSpotFoundException("No Parking Spot Available");
        }

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());
        ticket.setParkingSpot(parkingSpot);

        ticketRepository.saveTicket(ticket);

        return ticket;

    }
}

