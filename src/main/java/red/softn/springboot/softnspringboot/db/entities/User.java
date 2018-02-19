package red.softn.springboot.softnspringboot.db.entities;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "user_password")
    private String userPassword;
    
    @Column(name = "user_registered")
    private Timestamp userRegistered;
    
    @Column(name = "user_email")
    private String userEmail;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public Timestamp getUserRegistered() {
        return userRegistered;
    }
    
    public void setUserRegistered(Timestamp userRegistered) {
        this.userRegistered = userRegistered;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
