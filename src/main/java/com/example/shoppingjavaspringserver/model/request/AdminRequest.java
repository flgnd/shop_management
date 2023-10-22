package com.example.shoppingjavaspringserver.model.request;
import com.example.shoppingjavaspringserver.entities.AdminEntity;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class AdminRequest {
    String name;
    int phone;
    String userName;
    String password;
    //
    Timestamp registrationDate = new Timestamp(System.currentTimeMillis());
    public AdminEntity toEntity(){
       //LocalDateTime dateTime = LocalDateTime.parse(this.getRegistrationDate());
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setName(this.getName());
        adminEntity.setPhone(this.getPhone());
        adminEntity.setPassword(this.getPassword());
        adminEntity.setUserName(this.getUserName());
        adminEntity.setRegistrationDate(this.getRegistrationDate());
        //adminEntity.setRegistrationDate(Timestamp.valueOf(dateTime));
        //System.out.println(new Gson().toJson(adminEntity));
        return adminEntity;
    }
}
