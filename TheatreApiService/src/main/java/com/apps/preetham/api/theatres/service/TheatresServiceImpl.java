package com.apps.preetham.api.theatres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.preetham.api.theatres.data.TheatreEntity;
import com.apps.preetham.api.theatres.dto.RowDTO;
import com.apps.preetham.api.theatres.dto.SeatDTO;
import com.apps.preetham.api.theatres.dto.SeatTypeDTO;
import com.apps.preetham.api.theatres.entity.SeatBooking;
import com.apps.preetham.api.theatres.entity.TheatreSeats;
import com.apps.preetham.api.theatres.repo.SeatBookingRepository;
import com.apps.preetham.api.theatres.repo.TheatreSeatsRepository;
import com.apps.preetham.api.theatres.ui.model.SeatAllocationRequest;

@Service
public class TheatresServiceImpl implements TheatresService{
	
    @Autowired
    private TheatreSeatsRepository theatreSeatsRepository;

    @Autowired
    private SeatBookingRepository seatBookingRepository;

    @Override
    public List<TheatreEntity> getTheatres(String userId) {
        List<TheatreEntity> returnValue = new ArrayList<>();
        
        TheatreEntity theatreEntity = new TheatreEntity();
        theatreEntity.setUserId(userId);
        theatreEntity.setTheatreId("PVR124");
        theatreEntity.setDescription("PVR Cinemas");
        theatreEntity.setId(1L);
        theatreEntity.setName("PVR Prime");
        
        TheatreEntity theatreEntity2 = new TheatreEntity();
        theatreEntity2.setUserId(userId);
        theatreEntity2.setTheatreId("PVR123");
        theatreEntity2.setDescription("PVR Cinemas");
        theatreEntity2.setId(2L);
        theatreEntity2.setName("PVR Central");
        
        returnValue.add(theatreEntity);
        returnValue.add(theatreEntity2);
        
        return returnValue;
    }
    
    @Override
    public List<TheatreSeats> getSeatsForShowtime(Long theatreId, Long showtimeId) {
        return theatreSeatsRepository.findByTheatreId(theatreId);
    }

    public void allocateSeatsForShowtime(Long theatreId, Long showtimeId, SeatAllocationRequest request) {
        List<SeatBooking> bookings = new ArrayList<>();
        List<TheatreSeats> seatsToAllocate = new ArrayList<>();

        switch (request.getSelectionMode()) {
            case "SEAT":
                List<Long> seatIds = request.getSelectedSeats().stream().map(SeatDTO::getSeatId).collect(Collectors.toList());
                seatsToAllocate = theatreSeatsRepository.findByIdIn(seatIds);
                for (TheatreSeats seat : seatsToAllocate) {
                    SeatDTO seatDTO = request.getSelectedSeats().stream().filter(s -> s.getSeatId().equals(seat.getId())).findFirst().orElse(null);
                    if (seatDTO != null) {
                        SeatBooking booking = new SeatBooking();
                        booking.setSeat(seat);
                        booking.setStatus(seatDTO.getStatus());
                        bookings.add(booking);
                    }
                }
                break;
            case "ROW":
                List<String> rows = request.getSelectedRows().stream().map(RowDTO::getRow).collect(Collectors.toList());
                seatsToAllocate = theatreSeatsRepository.findByTheatreIdAndRowIn(theatreId, rows);
                for (TheatreSeats seat : seatsToAllocate) {
                    RowDTO rowDTO = request.getSelectedRows().stream().filter(r -> r.getRow().equals(seat.getRow())).findFirst().orElse(null);
                    if (rowDTO != null) {
                        SeatBooking booking = new SeatBooking();
                        booking.setSeat(seat);
                        booking.setStatus(rowDTO.getStatus());
                        bookings.add(booking);
                    }
                }
                break;
            case "SEAT_TYPE":
                List<String> seatTypes = request.getSelectedSeatTypes().stream().map(SeatTypeDTO::getSeatType).collect(Collectors.toList());
                seatsToAllocate = theatreSeatsRepository.findByTheatreIdAndSeatTypeIn(theatreId, seatTypes);
                for (TheatreSeats seat : seatsToAllocate) {
                    SeatTypeDTO seatTypeDTO = request.getSelectedSeatTypes().stream().filter(st -> st.getSeatType().equals(seat.getSeatType())).findFirst().orElse(null);
                    if (seatTypeDTO != null) {
                        SeatBooking booking = new SeatBooking();
                        booking.setSeat(seat);
                        booking.setStatus(seatTypeDTO.getStatus());
                        bookings.add(booking);
                    }
                }
                break;
        }

        seatBookingRepository.saveAll(bookings);
    }


}
