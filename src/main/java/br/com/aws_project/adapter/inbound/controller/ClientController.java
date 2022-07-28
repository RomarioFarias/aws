package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.inbound.dto.ClientDto;
import br.com.aws_project.adapter.outbound.mapper.ClientModelMapper;
import br.com.aws_project.applications.port.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/clients")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;
    private ClientModelMapper clientModelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createClient(@RequestBody @Valid ClientDto clientDto) {
        var client = clientService.createClient(clientModelMapper.toClient(clientDto));
        return clientModelMapper.toClientDto(client);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable String id) {
        var client = clientService.getClient(id);
        return clientModelMapper.toClientDto(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable String id) {
        clientService.deleteClientById(id);
    }


}
