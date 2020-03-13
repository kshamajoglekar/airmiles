package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class Message {

    public Message(){
        this.message="default";
        this.createdDateTime=LocalDateTime.now();
    }
    public Message(String message){
        this.message=message;
        this.createdDateTime=LocalDateTime.now();
    }

    @Getter
    @Setter
    private String message;

    @Getter @Setter
    private List<Response> responses;

    @Getter @Setter
    private LocalDateTime createdDateTime;

    @Override
    public String toString() {
        String respString=(responses!=null) ?responses.toString():" ";
        return "{"
                + "message:"
                +message
                +", "
                + "createdDateTime:" + createdDateTime
                + ", "
                + "responses:"
               +respString
                +"}";
    }
}
