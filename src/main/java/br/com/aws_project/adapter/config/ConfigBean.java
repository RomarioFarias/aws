package br.com.aws_project.adapter.config;

import br.com.aws_project.adapter.outbound.mapper.ProviderModelMapper;
import br.com.aws_project.adapter.outbound.mapper.ProductModelMapper;
import br.com.aws_project.applications.port.ProviderRepository;
import br.com.aws_project.applications.port.ProviderSnsEvent;
import br.com.aws_project.applications.port.ProductRepository;
import br.com.aws_project.applications.port.ProviderService;
import br.com.aws_project.applications.service.ProductServiceImpl;
import br.com.aws_project.applications.service.ProviderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ConfigBean {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    ProviderServiceImpl clientServiceImpl(ProviderRepository providerRepository, ProviderSnsEvent providerSnsEvent) {
        return new ProviderServiceImpl(providerRepository, providerSnsEvent);
    }

    @Bean
    ProviderModelMapper clientModelMapper(ModelMapper modelMapper){
        return new ProviderModelMapper(modelMapper);
    }

    @Bean
    ProductModelMapper productModelMapper(ModelMapper modelMapper){
        return new ProductModelMapper(modelMapper);
    }

    @Bean
    ProductServiceImpl productServiceImpl(ProductRepository productRepository, ProviderService providerService){
        return new ProductServiceImpl(productRepository, providerService);
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
