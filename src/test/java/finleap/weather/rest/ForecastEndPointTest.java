package finleap.weather.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import finleap.weather.business.OpenWeatherMapBusiness;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ForecastEndPointTest {
	
    @Autowired
    private MockMvc mvc;

	@Mock
	private OpenWeatherMapBusiness business;
	
	@InjectMocks
	private ForecastEndPoint endPoint;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(endPoint).build();
	}
    
    @Test
    public void test_get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/?city=Berlin").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    
    @Test
    public void test_get_with_days() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/?city=Berlin&days=3").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    
    @Test
    public void test_get_without_city() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
    
    @Test
    public void test_get_with_wrong_days_value() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/data?city=Berlin&days=r").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

}