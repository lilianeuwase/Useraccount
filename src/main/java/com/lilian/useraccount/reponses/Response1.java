package com.lilian.useraccount.reponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response1 {
    private Integer error;
    private String status;
    private String message;
}