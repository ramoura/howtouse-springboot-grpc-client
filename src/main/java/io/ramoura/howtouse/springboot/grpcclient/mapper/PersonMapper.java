package io.ramoura.howtouse.springboot.grpcclient.mapper;

import io.ramoura.api.grpc.v1.PersonRequest;
import io.ramoura.api.grpc.v1.PersonRequestCode;
import io.ramoura.api.grpc.v1.PersonResponse;
import io.ramoura.howtouse.springboot.grpcclient.controller.PersonRequestDTO;
import io.ramoura.howtouse.springboot.grpcclient.controller.PersonResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMapper {

    public static PersonRequest toRequest(final PersonRequestDTO dto) {
        return PersonRequest
            .newBuilder()
            .setDocument(dto.getDocument())
            .setName(dto.getName())
            .build();
    }

    public static PersonResponseDTO toResponse(final PersonResponse response) {
        return PersonResponseDTO.builder()
            .code(response.getCode())
            .build();
    }

    public static PersonRequestCode toRequest(final String code) {
        return PersonRequestCode
            .newBuilder()
            .setCode(code)
            .build();
    }
}
