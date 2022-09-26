package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.outbound.mapper.ProviderModelMapper;
import br.com.aws_project.templates.ProviderTemplatTest;
import br.com.aws_project.applications.port.ProviderService;
import br.com.aws_project.utils.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.aws_project.templates.ProviderTemplatTest.getProviderTemplat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableAutoConfiguration(
        exclude = {
                MongoAutoConfiguration.class,
                MongoDataAutoConfiguration.class,
                MongoRepositoriesAutoConfiguration.class
        })
@AutoConfigureMockMvc
@RequiredArgsConstructor
@SpringBootTest(classes = ProviderController.class)
@ContextConfiguration(
        classes = {
                ModelMapper.class,
                ProviderModelMapper.class
        })
class ProviderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProviderService providerService;

    private static final String URL = "/v1/providers";


    @Test
    void createClient() throws Exception {
        var client = getProviderTemplat();

        when(providerService.createProvider(any())).thenReturn(getProviderTemplat());
        mockMvc.perform(post(URL)
                .contentType(APPLICATION_JSON)
                .content(JsonMapper.asJsonString(client)))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("JOAO@GMAIL.COM"));

        verify(providerService, times(1)).createProvider(any());
    }

    @Test
    void getClient() throws Exception {
        when(providerService.getProvider(any())).thenReturn(getProviderTemplat());

        mockMvc.perform(get("/v1/providers/{id}",1)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty());

    }


    @Test
    void deleteClient() throws Exception {

        mockMvc.perform(delete("/v1/providers/{id}",1)
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void listAllProvider() throws Exception {
        when(providerService.listProvider()).thenReturn(ProviderTemplatTest.listAllProvider());

        mockMvc.perform(get(URL)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.size()").isNotEmpty());
    }

//
//        .andExpect(jsonPath("$.message").value("Request fields are invalid"))
//            .andExpect(jsonPath("$.error").isEmpty())
//            .andExpect(jsonPath("$.code").value("API_FIELDS_INVALID"))
//            .andExpect(jsonPath("$.details").isArray());
}