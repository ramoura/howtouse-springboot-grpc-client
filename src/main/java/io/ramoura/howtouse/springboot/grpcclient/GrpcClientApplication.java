package io.ramoura.howtouse.springboot.grpcclient;

import io.ramoura.api.grpc.v1.PersonRequest;
import io.ramoura.api.grpc.v1.PersonRequestCode;
import io.ramoura.api.grpc.v1.PersonRequestOrBuilder;
import io.ramoura.api.grpc.v1.PersonResponse;
import io.ramoura.howtouse.springboot.grpcclient.grpc.GrpcClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class GrpcClientApplication{

    private final GrpcClient grpcClient;

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        grpcClient.start();
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            try {
//                grpcClient.shutdown();
//            } catch (InterruptedException e) {
//                log.error("Client stoppd with error: {}", e.getMessage());
//            }
//        }));
//        create();
//        Thread.sleep(30_000);
//        create();
//    }


    public void create() {
        var request = PersonRequest
            .newBuilder()
            .setDocument("09244t5464")
            .setName("Nome")
            .build();
        log.info("Request create: {}", request);
        PersonResponse personResponse = grpcClient.getSourceServiceStub().find(PersonRequestCode.newBuilder()
            .setCode("0001")
            .build());
        log.info("Response create: {}", personResponse);

    }
}
