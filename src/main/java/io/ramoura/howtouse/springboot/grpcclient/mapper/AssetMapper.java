package io.ramoura.howtouse.springboot.grpcclient.mapper;

import io.ramoura.api.grpc.v1.AssetCreateRequest;
import io.ramoura.api.grpc.v1.AssetFindRequest;
import io.ramoura.api.grpc.v1.AssetResponse;
import io.ramoura.howtouse.springboot.grpcclient.controller.AssetRequestDTO;
import io.ramoura.howtouse.springboot.grpcclient.model.Asset;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssetMapper {

    public static AssetResponse toResponse(final Asset dto) {
        return AssetResponse
            .newBuilder()
            .setAssetId(dto.getAssetId())
            .setTicker(dto.getTicker())
            .setLongName(dto.getLongName())
            .setShortName(dto.getShortName())
            .setCurrencyCode(dto.getCurrencyCode())
            .build();
    }

    public static Asset toAsset(final AssetResponse response) {
        return Asset.builder()
            .assetId(response.getAssetId())
            .ticker(response.getTicker())
            .longName(response.getLongName())
            .shortName(response.getShortName())
            .currencyCode(response.getCurrencyCode())
            .build();
    }


    public static AssetFindRequest toRequestFind(String assetId) {
        return AssetFindRequest.newBuilder()
            .setAssetId(assetId)
            .build();
    }

    public static AssetCreateRequest toRequestCreate(AssetRequestDTO requestDTO) {
        return AssetCreateRequest.newBuilder()
            .setTicker(requestDTO.getTicker())
            .setLongName(requestDTO.getLongName())
            .setShortName(requestDTO.getShortName())
            .setCurrencyCode(requestDTO.getCurrencyCode())
            .build();
    }
}
