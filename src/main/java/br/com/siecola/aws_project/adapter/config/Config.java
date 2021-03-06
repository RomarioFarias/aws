package br.com.siecola.aws_project.adapter.config;

import br.com.siecola.aws_project.adapter.outbound.mapper.ClientModelMapper;
import br.com.siecola.aws_project.applications.port.ClientRepository;
import br.com.siecola.aws_project.applications.service.ClientServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class Config {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    ClientServiceImpl clientServiceImpl(ClientRepository clientRepository) {
        return new ClientServiceImpl(clientRepository);
    }

    @Bean
    ClientModelMapper clientModelMapper(ModelMapper modelMapper){
        return new ClientModelMapper(modelMapper);
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
