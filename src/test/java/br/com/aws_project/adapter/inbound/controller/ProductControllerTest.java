package br.com.aws_project.adapter.inbound.controller;

import br.com.aws_project.adapter.outbound.mapper.ProductModelMapper;
import br.com.aws_project.applications.port.ProductService;
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

import static br.com.aws_project.templates.ProductTemplatTest.ID;
import static br.com.aws_project.templates.ProductTemplatTest.getProducTemplat;
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
@SpringBootTest(classes = ProductController.class)
@ContextConfiguration(
        classes = {
                ModelMapper.class,
                ProductModelMapper.class
        })
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    private final String URL = "/v1/products";


    @Test
    void createProduct() throws Exception {
        var product = getProducTemplat();

        when(productService.createProduct(any())).thenReturn(getProducTemplat());
        mockMvc.perform(post(URL)
                        .contentType(APPLICATION_JSON)
                        .content(JsonMapper.asJsonString(product)))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.value").value(2.222));

        verify(productService, times(1)).createProduct(any());
    }

    @Test
    void getProductFindById() throws Exception {
        when(productService.findProductById(any())).thenReturn(getProducTemplat());
        var url = URL+"/{id}";
        this.mockMvc.perform(get(url,ID)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.value").value(2.222));
    }

    @Test
    void deleteProductById() throws Exception {
        when(productService.findProductById(any())).thenReturn(getProducTemplat());
        var url = URL+"/{id}";
        this.mockMvc.perform(delete(url,ID)
                        .contentType(APPLICATION_JSON))
                .andDo(print());
    }
}