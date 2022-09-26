package br.com.aws_project.applications.service;


import br.com.aws_project.applications.entity.Provider;
import br.com.aws_project.applications.entity.ProviderEvent;
import br.com.aws_project.applications.enumeration.ExceptionCode;
import br.com.aws_project.applications.exception.ResourceNotFoundException;
import br.com.aws_project.applications.port.ProviderRepository;
import br.com.aws_project.applications.port.ProviderSnsEvent;
import br.com.aws_project.applications.port.ProviderService;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.UUID;

@Slf4j
public class ProviderServiceImpl implements ProviderService {

    public ProviderServiceImpl(ProviderRepository providerRepository, ProviderSnsEvent providerSnsEvent) {
        this.providerRepository = providerRepository;
        this.providerSnsEvent = providerSnsEvent;
    }

    private final ProviderRepository providerRepository;
    private final ProviderSnsEvent providerSnsEvent;

    @Override
    public Provider createProvider(Provider provider) {
        provider.setId(UUID.randomUUID().toString());
        log.info("Create provider by [ID={}]", provider.getId());
        return providerRepository.createProvider(provider);
    }

    @Override
    public Provider getProvider(String id) {
        var provider = providerRepository.getProvider(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionCode.PROVIDER_NOT_FOUND, id));
        log.info("Provider name: [name={}]", provider.getName());
        return provider;
    }

    @Override
    public void deleteProviderById(String id) {
        var provider = this.getProvider(id);
        log.info("Delete Provider by [ID={}]", provider.getId());
        providerRepository.deleteProviderById(provider);
        providerSnsEvent.deleteProvider(new ProviderEvent(provider.getId(), provider.getName()));
    }

    @Override
    public Set<Provider> listProvider() {
        log.info("List all Providers");
        return this.providerRepository.listProvider();
    }
}
