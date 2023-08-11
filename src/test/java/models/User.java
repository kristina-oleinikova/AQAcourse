package models;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class User {
    @EqualsAndHashCode.Exclude
    private int id;

    private String username;

    @With(AccessLevel.PROTECTED)
    private String password;

    //@ToString.Exclude
    private String email;

    //@ToString.Exclude
    private String code;
}
