package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.outbound.mapper.ClientModelMapper;
import br.com.aws_project.templates.ClientTemplatTest;
import br.com.aws_project.applications.port.ClientService;
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
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
@SpringBootTest(classes = ClientController.class)
@ContextConfiguration(
        classes = {
                ModelMapper.class,
                ClientModelMapper.class
        })
class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientService clientService;


    @Test
    void createClient() {
        System.out.println("LALA");
    }

    @Test
    void getClient() throws Exception {
        when(clientService.getClient(any())).thenReturn(ClientTemplatTest.getClientTemplat());

        mockMvc.perform(get("/v1/clients/{id}",1)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty());

    }

//
//        .andExpect(jsonPath("$.message").value("Request fields are invalid"))
//            .andExpect(jsonPath("$.error").isEmpty())
//            .andExpect(jsonPath("$.code").value("API_FIELDS_INVALID"))
//            .andExpect(jsonPath("$.details").isArray());
}