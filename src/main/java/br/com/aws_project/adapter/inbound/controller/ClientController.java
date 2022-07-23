package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.outbound.mapper.ClientModelMapper;
import br.com.aws_project.adapter.inbound.dto.ClientDto;
import br.com.aws_project.applications.port.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/clients")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;
    private ClientModelMapper clientModelMapper;

    @PostMapping()
    public ClientDto createClient(@RequestBody @Valid ClientDto clientDto) {
        clientService.createClient(clientModelMapper.getClient(clientDto));
        return null;
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable String id) {
        var client = clientService.getClient(id);
        return clientModelMapper.getClientDto(client);
    }
}
