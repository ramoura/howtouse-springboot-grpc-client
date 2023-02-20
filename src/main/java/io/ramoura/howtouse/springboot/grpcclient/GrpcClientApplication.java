package io.ramoura.howtouse.springboot.grpcclient;

import io.ramoura.api.grpc.v1.AssetFindRequest;
import io.ramoura.api.grpc.v1.AssetResponse;
import io.ramoura.howtouse.springboot.grpcclient.grpc.GrpcClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class GrpcClientApplication {

    private final GrpcClient grpcClient;

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }


}
