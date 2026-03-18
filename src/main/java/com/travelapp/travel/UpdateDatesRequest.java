package com.travelapp.travel;

import java.time.LocalDate;


//HELPER CLASS
public class UpdateDatesRequest {
    private LocalDate startDate;
    private LocalDate returnDate;

    public UpdateDatesRequest(LocalDate startDate, LocalDate returnDate){
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public LocalDate getNewStartDate(){
        return startDate;
    }

    public LocalDate getNewReturnDate(){
        return returnDate;
    }


    public void setStartDate(LocalDate newStartDate){
        this.startDate = newStartDate;

    }

    public void setReturnDate(LocalDate newReturnDate){
        this.returnDate = newReturnDate;
    }
}
