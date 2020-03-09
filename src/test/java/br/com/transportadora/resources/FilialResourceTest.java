package br.com.transportadora.resources;

import org.junit.Before;
import org.junit.gen5.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.transportadora.model.FiltroVO;
import br.com.transportadora.model.apiEnum.Prioridade;
import br.com.transportadora.model.apiEnum.TipoTransporte;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.math.BigDecimal;


@SpringBootTest
@WebAppConfiguration
public class FilialResourceTest {

	@Autowired
	public WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void Setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void TestCase01() throws Exception {
		String url = "/filial/service/transportadora";
		Setup();
		FiltroVO filtro = new FiltroVO("São Paulo - SP", "Manaus - MA", new BigDecimal(3875), Prioridade.preco,
				TipoTransporte.aereo);
		this.mvc.perform(get(url).content(asJsonString(filtro)).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk());
	}
	
	@Test
	public void TesteCase02() throws Exception {
		String url = "/filial/service/transportadora";
		Setup();
		FiltroVO filtro = new FiltroVO("Florianópolis - SC", "Campinas - SP", new BigDecimal(762), Prioridade.preco,
				TipoTransporte.terrestre);
		this.mvc.perform(get(url).content(asJsonString(filtro))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk());
	}

	@Test
	public void TesteCase03() throws Exception {
		String url = "/filial/service/transportadora";
		Setup();
		FiltroVO filtro = new FiltroVO("Salvador - BA", "Belém - PA", new BigDecimal(2018), Prioridade.tempo, null);
		this.mvc.perform(get(url).content(asJsonString(filtro))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isBadRequest());
	}

	@Test
	public void TesteCase04() throws Exception {
		String url = "/filial/service/transportadora";
		Setup();
		FiltroVO filtro = new FiltroVO("São Paulo - SP", "Assunção - PAR", new BigDecimal(1350), Prioridade.tempo,
				null);
		this.mvc.perform(get(url).content(asJsonString(filtro))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isBadRequest());
	}

	@Test
	public void TesteCase05() throws Exception {
		String url = "/filial/service/transportadora";
		Setup();
		FiltroVO filtro = new FiltroVO("Salvador - BA", "Brasília - DF", new BigDecimal(1449), Prioridade.tempo,
				TipoTransporte.terrestre);
		this.mvc.perform(get(url).content(asJsonString(filtro))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testCase06() throws Exception {
		String url = "/filial/filiais";
		Setup();
		this.mvc.perform(get(url)).andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}