package io.ramoura.howtouse.springboot.grpcclient.service;

import io.ramoura.howtouse.springboot.grpcclient.controller.AssetRequestDTO;
import io.ramoura.howtouse.springboot.grpcclient.grpc.GrpcClient;
import io.ramoura.howtouse.springboot.grpcclient.mapper.AssetMapper;
import io.ramoura.howtouse.springboot.grpcclient.model.Asset;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AssetService {

    private final GrpcClient grpcClient;

    public Asset create(final AssetRequestDTO requestDTO) {
        var request = AssetMapper.toRequestCreate(requestDTO);
        log.info("Request create: {}", request.toString());
        return AssetMapper.toAsset(grpcClient.getSourceServiceStub().create(request));
    }

    public Asset find(final String assetId) {
        var result = grpcClient.getSourceServiceStub().find(AssetMapper.toRequestFind(assetId));
        log.info("Result: {}", result.toString());
        return AssetMapper.toAsset(result);
    }
}
