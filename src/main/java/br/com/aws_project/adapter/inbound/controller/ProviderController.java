package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.inbound.dto.ProviderDto;
import br.com.aws_project.adapter.outbound.mapper.ProviderModelMapper;
import br.com.aws_project.applications.port.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/v1/clients")
@AllArgsConstructor
public class ProviderController {

    private ProviderService providerService;
    private ProviderModelMapper providerModelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProviderDto createProvider(@RequestBody @Valid ProviderDto providerDto) {
        var provider = providerService.createProvider(providerModelMapper.toProvider(providerDto));
        return providerModelMapper.toProviderDto(provider);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProviderDto getClient(@PathVariable String id) {
        var provider = providerService.getProvider(id);
        return providerModelMapper.toProviderDto(provider);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Set<ProviderDto> listProvider() {
        var listProvider = providerService.listProvider();
        return providerModelMapper.toListProviderDto(listProvider);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProviderById(@PathVariable String id) {
        providerService.deleteProviderById(id);
    }


}
