package com.watfay.dto.simple;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse {

  private String message;

  private HttpStatus status;
}