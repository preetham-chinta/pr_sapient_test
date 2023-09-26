package com.apps.preetham.api.theatres.ui.model;

import java.util.List;

import com.apps.preetham.api.theatres.dto.RowDTO;
import com.apps.preetham.api.theatres.dto.SeatDTO;
import com.apps.preetham.api.theatres.dto.SeatTypeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SeatAllocationRequest {
    
	private String selectionMode;
    private List<SeatDTO> selectedSeats;
    private List<RowDTO> selectedRows;
    private List<SeatTypeDTO> selectedSeatTypes;
    
    public String getSelectionMode() {
		return selectionMode;
	}
	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}
	public List<SeatDTO> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(List<SeatDTO> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	public List<RowDTO> getSelectedRows() {
		return selectedRows;
	}
	public void setSelectedRows(List<RowDTO> selectedRows) {
		this.selectedRows = selectedRows;
	}
	public List<SeatTypeDTO> getSelectedSeatTypes() {
		return selectedSeatTypes;
	}
	public void setSelectedSeatTypes(List<SeatTypeDTO> selectedSeatTypes) {
		this.selectedSeatTypes = selectedSeatTypes;
	}

    
}





