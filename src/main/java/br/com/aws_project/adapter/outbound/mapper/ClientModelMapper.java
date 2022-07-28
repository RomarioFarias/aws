package br.com.aws_project.adapter.outbound.mapper;

import br.com.aws_project.adapter.inbound.dto.ClientDto;
import br.com.aws_project.applications.entity.Provider;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ClientModelMapper {
    private ModelMapper modelMapper;

    public Provider toClient(ClientDto clientDto) {
        return modelMapper.map(clientDto, Provider.class);
    }

    public ClientDto toClientDto(Provider provider) {
        return modelMapper.map(provider, ClientDto.class);
    }



}
