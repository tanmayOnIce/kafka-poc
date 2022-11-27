package in.co.indusnet.kafkademo.entity;

import lombok.Data;

@Data
public class Users {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
