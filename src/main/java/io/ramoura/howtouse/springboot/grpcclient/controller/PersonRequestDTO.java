package io.ramoura.howtouse.springboot.grpcclient.controller;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonRequestDTO {
    private String document;
    private String name;
}
