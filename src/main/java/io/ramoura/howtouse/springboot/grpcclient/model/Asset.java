package io.ramoura.howtouse.springboot.grpcclient.model;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Builder
@Getter
public class Asset {
    @With
    private String assetId;
    private String ticker;

    private String shortName;

    private String longName;

    private String currencyCode;

}
