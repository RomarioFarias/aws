package br.com.siecola.aws_project.adapter.outbound.mapper;

import br.com.siecola.aws_project.adapter.inbound.dto.ClientDto;
import br.com.siecola.aws_project.applications.entity.Client;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ClientModelMapper {
    private ModelMapper modelMapper;

    public Client getClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

}
