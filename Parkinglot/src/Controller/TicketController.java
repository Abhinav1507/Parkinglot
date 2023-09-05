package Controller;

//import java.util.Date;

import DTO.GenrateTicketRequestDto;
import DTO.GenrateTicketResponseDto;
import DTO.ResponseStatus;
import Exceptions.NoParkingSpotFoundException;
//import Models.Gate;
import Models.Ticket;
//import Models.Vehicle;
import Service.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public GenrateTicketResponseDto generateTicket(GenrateTicketRequestDto genrateTicketRequestDto){
        //business rule
        GenrateTicketResponseDto responseDto = new GenrateTicketResponseDto();
        

        try {
            Ticket ticket = ticketService.generateTicket(genrateTicketRequestDto.getVehicleNumber(), 
            genrateTicketRequestDto.getVehicleType(),genrateTicketRequestDto.getGateId());

            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoParkingSpotFoundException e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setResponseMessage(e.getMessage());
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setResponseMessage(e.getMessage());
        }
        
        return responseDto;
    }
}
