package br.com.transportadora.resources;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilialResourceTest {

	public WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void Setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void TesteCase01() throws Exception {
		String url = "/service/transportadora";
		FiltroVO filtro = new FiltroVO("São Paulo - SP", "Manaus - MA", new BigDecimal(3875), Prioridade.preco,
				TipoTransporte.aereo);
		this.mvc.perform(get(url).content(asJsonString(filtro))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*@Test
	public void TesteCase02() {
		FiltroVO filtro = new FiltroVO("Florianópolis - SC", "Campinas - SP", new BigDecimal(762), Prioridade.preco,
				TipoTransporte.terrestre);
		FilialResource filialResource = new FilialResource();
		List<FilialVO> filiais = new ArrayList<FilialVO>();
		filiais.addAll(filialResource.melhorFilial(filtro));
		Long idEsperado = (long) 3;
		assertEquals(idEsperado, filiais.get(0).getId());
	}

	@Test
	public void TesteCase03() {
		FiltroVO filtro = new FiltroVO("Salvador - BA", "Belém - PA", new BigDecimal(2018), Prioridade.tempo, null);
		FilialResource filialResource = new FilialResource();
		List<FilialVO> filiais = new ArrayList<FilialVO>();
		filiais.addAll(filialResource.melhorFilial(filtro));
		Long idEsperado = (long) 3;
		assertEquals(idEsperado, filiais.get(0).getId());
	}

	@Test
	public void TesteCase04() {
		FiltroVO filtro = new FiltroVO("São Paulo - SP", "Assunção - PAR", new BigDecimal(1350), Prioridade.tempo,
				null);
		FilialResource filialResource = new FilialResource();
		List<FilialVO> filiais = new ArrayList<FilialVO>();
		filiais.addAll(filialResource.melhorFilial(filtro));
		Long idEsperado = (long) 3;
		assertEquals(idEsperado, filiais.get(0).getId());
	}

	@Test
	public void TesteCase05() {
		FiltroVO filtro = new FiltroVO("Salvador - BA", "Brasília - DF", new BigDecimal(1449), Prioridade.tempo,
				TipoTransporte.terrestre);
		FilialResource filialResource = new FilialResource();
		List<FilialVO> filiais = new ArrayList<FilialVO>();
		filiais.addAll(filialResource.melhorFilial(filtro));
		Long idEsperado = (long) 3;
		assertEquals(idEsperado, filiais.get(0).getId());
	}*/

}