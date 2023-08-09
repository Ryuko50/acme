package org.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String password;
}
