package io.ramoura.howtouse.springboot.grpcclient.grpc;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class GrpcClientRunner{

    @Autowired
    private GrpcClient grpcClient;

    @PostConstruct
    public void run() throws Exception {
        grpcClient.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                grpcClient.shutdown();
            } catch (InterruptedException e) {
                log.error("Client stoppd with error: {}", e.getMessage());
            }
        }));
    }
}
