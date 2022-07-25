package com.elotech.testePratico.pessoa;

import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;

@WebMvcTest
public class PessoaControllerTest {

	@Autowired
	private PessoaController pessoaController;
	
	@MockBean
	private PessoaService pessoaService;
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.pessoaController);
	}
	
	@Test
	public void retornarSucesso_listarPessoa() throws ParseException {
		
		when(this.pessoaService.listarPessoaPorId(752L))
		   .thenReturn(new Pessoa(752L, "Maria","189.957.870-66","20/02/2020",null));
		
		RestAssuredMockMvc
		.given()
		    .accept(ContentType.JSON)
		.when()
		     .get("localhost:9095/api/pessoas/{id}",752L)
		.then()
		     .statusCode(HttpStatus.OK.value());
	}
	
}
