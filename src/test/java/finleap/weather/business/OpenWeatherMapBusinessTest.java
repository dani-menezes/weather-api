package finleap.weather.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import finleap.weather.exception.WeatherApiException;
import finleap.weather.external.OpenWeatherMapApi;
import finleap.weather.model.DataBuilder;
import finleap.weather.model.DataDTO;
import finleap.weather.model.MainDTO;
import finleap.weather.model.ResultBuilder;
import finleap.weather.model.ResultDTO;
import finleap.weather.model.WeatherDataBuilder;
import finleap.weather.model.WeatherDataDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherMapBusinessTest {

	@Mock
	private OpenWeatherMapApi api;
	
	@InjectMocks
	private OpenWeatherMapBusiness business;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockMvcBuilders.standaloneSetup(business).build();
	}

	@Test
	public void test_round() throws WeatherApiException {
		Double roundDown = business.round(new Double(11.1111), 2);
		Double roundUp = business.round(new Double(11.1151), 2);

		assertEquals(roundDown, new Double(11.11));
		assertEquals(roundUp, new Double(11.12));
	}

	@Test
	public void test_dataDailyAvg() throws WeatherApiException {
		List<DataDTO> datas = new ArrayList<>();
		MainDTO mainDTO0 = new MainDTO(-2D, -1D, -3D, 1000.0D);
		DataDTO dataDto0 = new DataBuilder().setDt(1L).setMain(mainDTO0).get();
		MainDTO mainDTO1 = new MainDTO(-5D, -2D, -7D, 1003.0D);
		DataDTO dataDto1 = new DataBuilder().setDt(2L).setMain(mainDTO1).get();
		MainDTO mainDTO2 = new MainDTO(5D, 2D, 7D, 999.0D);
		DataDTO dataDto2 = new DataBuilder().setDt(3L).setMain(mainDTO2).get();
		datas.add(dataDto0);
		datas.add(dataDto1);
		datas.add(dataDto2);
		WeatherDataDTO data = new WeatherDataBuilder().setDatas(datas).get();
		ResultDTO responseResult = new ResultBuilder().setPressureAvg(1000.67D).setMinAvg(-0.33D).setMaxAvg(-1D).get();
		ResultDTO requestResult = new ResultDTO();

		business.fillDataDailyAvg(requestResult, data);

		assertEquals(requestResult, responseResult);
	}

	@Test
	public void test_getData() throws WeatherApiException {
		WeatherDataDTO apiDto = new WeatherDataBuilder().getDefault().get();
		ResultDTO result = new ResultBuilder().getDefault().get();
		
		when(api.getWeatherData("Berlin", 3, "metric")).thenReturn(apiDto);
		ResultDTO request = business.getData("Berlin", 3, "metric");
		
		assertEquals(request, result);
	}

}
