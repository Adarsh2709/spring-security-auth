package org.example.Response;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTResponseDto {
    private String accesstoken;
    private String token;
}
