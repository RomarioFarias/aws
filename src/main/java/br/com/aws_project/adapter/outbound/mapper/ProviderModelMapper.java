package br.com.aws_project.adapter.outbound.mapper;

import br.com.aws_project.adapter.inbound.dto.ProviderDto;
import br.com.aws_project.applications.entity.Provider;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProviderModelMapper {
    private ModelMapper modelMapper;

    public Provider toProvider(ProviderDto clientDto) {
        return modelMapper.map(clientDto, Provider.class);
    }

    public ProviderDto toProviderDto(Provider Provider) {
        return modelMapper.map(Provider, ProviderDto.class);
    }

    public Set<ProviderDto> toListProviderDto(Set<Provider> listProvider) {
        return listProvider.stream().map(this::toProviderDto).collect(Collectors.toSet());
    }
}
