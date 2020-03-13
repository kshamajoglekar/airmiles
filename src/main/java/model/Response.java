package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Response {

    public Response(){
        this.response="default";
        this.createdDateTime=LocalDateTime.now();
    }
    public Response(String response){
        this.response=response;
        this.createdDateTime=LocalDateTime.now();
    }

    @Getter
    @Setter
    private String response;

    @Getter
    @Setter
    private LocalDateTime createdDateTime;

    @Override
    public String toString() {
        return "{" + "response:" +response+", "+ "createdDateTime:" +createdDateTime + "}";
    }
}
