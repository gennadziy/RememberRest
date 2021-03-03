package pl.gennadziy.RememberRest.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Data
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long _id;

    private String username;
    private String password;
}
