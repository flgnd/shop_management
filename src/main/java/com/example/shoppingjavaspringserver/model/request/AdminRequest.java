package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.AdminEntity;
import com.google.gson.Gson;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
public class AdminRequest {
    String name;
    int phone;
    String userName;
    String pass;
    String registrationDate;
    public AdminEntity toEntity(){
        LocalDateTime dateTime = LocalDateTime.parse(this.getRegistrationDate());
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setName(this.getName());
        adminEntity.setPhone(this.getPhone());
        adminEntity.setPassword(this.getPass());
        adminEntity.setUserName(this.getUserName());
        adminEntity.setRegistrationDate(Timestamp.valueOf(dateTime));
        System.out.println(new Gson().toJson(adminEntity));
        return adminEntity;
    }
}
