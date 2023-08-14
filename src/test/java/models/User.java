package models;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private String username;
    private String password;
}
