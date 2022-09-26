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
    public ProviderDto createClient(@RequestBody @Valid ProviderDto providerDto) {
        var provider = providerService.createProvider(providerModelMapper.toClient(providerDto));
        return providerModelMapper.toClientDto(provider);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProviderDto getClient(@PathVariable String id) {
        var client = providerService.getProvider(id);
        return providerModelMapper.toClientDto(client);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Set<ProviderDto> listClients() {
        var clients = providerService.listProvider();
        return providerModelMapper.toListProviderDto(clients);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable String id) {
        providerService.deleteProviderById(id);
    }


}
