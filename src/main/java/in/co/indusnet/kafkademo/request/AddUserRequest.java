package in.co.indusnet.kafkademo.request;

import lombok.Data;

@Data
public class AddUserRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
