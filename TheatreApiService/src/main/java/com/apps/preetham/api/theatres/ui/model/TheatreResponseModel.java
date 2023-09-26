package com.apps.preetham.api.theatres.ui.model;

public class TheatreResponseModel {
    private String theatreId;
    private String userId; 
    private String name;
    private String description;


    public String getTheatreId() {
        return theatreId;
    }


    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }


    public String getUserId() {
        return userId;
    }

   
    public void setUserId(String userId) {
        this.userId = userId;
    }

 
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    
}
