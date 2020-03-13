package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class User {
    public User(){
        this.name="default";
        this.city="Not supported yet";

    }
    public User(String user){
        this.name=user;
        this.city="Not supported yet";
       this.messages=new ArrayList<>();
    }
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String city;

    @Getter @Setter
    private List<Message> messages;

    @Override
    public String toString() {
        String respString=(messages!=null) ?messages.toString():" ";

        return "{" +name + "," +city + "," +"Messages:" +messages.toString() +"}";

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof  User) {
            User another = (User) obj;
            return (another.name == this.name);
        }else{
            return false;
        }
    }
}
