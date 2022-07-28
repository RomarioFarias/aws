package br.com.aws_project.adapter.outbound.mapper;

import br.com.aws_project.adapter.inbound.dto.ClientDto;
import br.com.aws_project.applications.entity.Client;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ClientModelMapper {
    private ModelMapper modelMapper;

    public Client toClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    public ClientDto toClientDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }



}
