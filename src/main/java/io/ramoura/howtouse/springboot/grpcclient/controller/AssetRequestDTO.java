package io.ramoura.howtouse.springboot.grpcclient.controller;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AssetRequestDTO {
    private String assetId;
    private String ticker;

    private String shortName;

    private String longName;

    private String currencyCode;

}
