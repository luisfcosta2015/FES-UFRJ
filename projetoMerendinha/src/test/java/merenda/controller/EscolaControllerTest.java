package merenda.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import merenda.Application;
import merenda.config.MvcWebApplicationInitializer;
import merenda.config.SecurityWebApplicationInitializer;
import merenda.config.Seguranca;
import merenda.model.Escola;
import merenda.repository.EscolaRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MvcWebApplicationInitializer.class, SecurityWebApplicationInitializer.class, Seguranca.class})
@SpringBootTest(classes = Application.class)
public class EscolaControllerTest {

	@Mock
	private EscolaRepository escolaRepository;
	
	@InjectMocks
	private EscolaController escolaController;
	
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        
    	mockMvc = MockMvcBuilders.standaloneSetup(escolaController)
    				.setViewResolvers(viewResolver)
    				.build();
    }

    @Test
    public void testListaTodasAsEscolas() throws Exception {
    	
    	List<Escola> escolas = new ArrayList<Escola>();
    	escolas.add(new Escola());
    	escolas.add(new Escola());
    	
    	when(escolaRepository.findAll()).thenReturn(escolas);
    	
    	mockMvc.perform(get("/escolas"))
    		.andExpect(status().isOk())
    		.andExpect(view().name("escolas"))
    		.andExpect(model().attribute("escolas", hasSize(2)));
    }

}
