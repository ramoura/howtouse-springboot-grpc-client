package io.ramoura.howtouse.springboot.grpcclient.controller;

import io.ramoura.howtouse.springboot.grpcclient.model.Asset;
import io.ramoura.howtouse.springboot.grpcclient.service.AssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Asset create(@RequestBody final AssetRequestDTO dto) {
        return assetService.create(dto);
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Asset find(@PathVariable("code") final String code) {
        return assetService.find(code);
    }
}
