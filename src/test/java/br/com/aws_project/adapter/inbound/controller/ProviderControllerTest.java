package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.outbound.mapper.ProviderModelMapper;
import br.com.aws_project.templates.ClientTemplatTest;
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

    private final String URL = "/v1/clients";


    @Test
    void createClient() throws Exception {
        var client = ClientTemplatTest.getClientTemplat();

        when(providerService.createClient(any())).thenReturn(ClientTemplatTest.getClientTemplat());
        mockMvc.perform(post(URL)
                .contentType(APPLICATION_JSON)
                .content(JsonMapper.asJsonString(client)))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("JOAO@GMAIL.COM"));

        verify(providerService, times(1)).createClient(any());
    }

    @Test
    void getClient() throws Exception {
        when(providerService.getClient(any())).thenReturn(ClientTemplatTest.getClientTemplat());

        mockMvc.perform(get("/v1/clients/{id}",1)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty());

    }


    @Test
    void deleteClient() throws Exception {

        mockMvc.perform(delete("/v1/clients/{id}",1)
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

//
//        .andExpect(jsonPath("$.message").value("Request fields are invalid"))
//            .andExpect(jsonPath("$.error").isEmpty())
//            .andExpect(jsonPath("$.code").value("API_FIELDS_INVALID"))
//            .andExpect(jsonPath("$.details").isArray());
}