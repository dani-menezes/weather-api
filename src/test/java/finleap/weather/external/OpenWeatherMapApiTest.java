package finleap.weather.external;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import finleap.weather.exception.WeatherApiException;
import finleap.weather.model.CityBuilder;
import finleap.weather.model.CityDTO;
import finleap.weather.model.DataBuilder;
import finleap.weather.model.DataDTO;
import finleap.weather.model.MainBuilder;
import finleap.weather.model.MainDTO;
import finleap.weather.model.WeatherDataDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherMapApiTest {
	
	@Autowired
	private OpenWeatherMapApi api;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_parseForecastJson() throws WeatherApiException {
		String json = "{\"cod\":\"200\",\"message\":0.0391,\"cnt\":3,\"list\":[{\"dt\":1545825600,\"main\":{\"temp\":5.89,\"temp_min\":5.89,\"temp_max\":6.53,\"pressure\":1032.5,\"sea_level\":1038.46,\"grnd_level\":1032.5,\"humidity\":97,\"temp_kf\":-0.64},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.7,\"deg\":286.502},\"rain\":{\"3h\":0.3725},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2018-12-26 12:00:00\"},{\"dt\":1545836400,\"main\":{\"temp\":6.8,\"temp_min\":6.8,\"temp_max\":7.28,\"pressure\":1032.55,\"sea_level\":1038.6,\"grnd_level\":1032.55,\"humidity\":97,\"temp_kf\":-0.48},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.26,\"deg\":295},\"rain\":{\"3h\":0.3075},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2018-12-26 15:00:00\"},{\"dt\":1545847200,\"main\":{\"temp\":7.19,\"temp_min\":7.19,\"temp_max\":7.51,\"pressure\":1033.07,\"sea_level\":1039.07,\"grnd_level\":1033.07,\"humidity\":95,\"temp_kf\":-0.32},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.46,\"deg\":294},\"rain\":{\"3h\":0.305},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2018-12-26 18:00:00\"}],\"city\":{\"id\":2950159,\"name\":\"Berlin\",\"coord\":{\"lat\":52.517,\"lon\":13.3889},\"country\":\"DE\",\"population\":1000000}}";
		WeatherDataDTO dto = api.parseForecastJson(json);
		
		MainDTO main = new MainBuilder().setTemp(5.89D).setTempMin(5.89D).setTempMax(6.53D).setPressure(1032.5D).get();
		DataDTO data = new DataBuilder().setDt(1545825600L).setMain(main).get();
		CityDTO city = new CityBuilder().setId(2950159L).setName("Berlin").setCountry("DE").get();
		
		assertEquals(dto.getCod(), "200");
		assertEquals(dto.getCnt(), new Integer(3));
		assertEquals(dto.getMessage(), new Double("0.0391"));
		assertEquals(dto.getDatas().size(), 3);
		assertEquals(dto.getDatas().get(0), data);
		assertEquals(dto.getCity(), city);
	}
	
	@Test
	public void test_integration_external() throws WeatherApiException {
		WeatherDataDTO dto = api.getWeatherData("Berlin", 3, "metric");
		
		CityDTO city = new CityBuilder().setId(2950159L).setName("Berlin").setCountry("DE").get();
		
		assertEquals(dto.getCod(), "200");
		assertEquals(dto.getCnt(), new Integer(3));
		assertEquals(dto.getDatas().size(), 3);
		assertEquals(dto.getCity(), city);
	}
	
	@Test
	public void test_integration_external_not_found() throws WeatherApiException {
		exceptionRule.expect(WeatherApiException.class);
		exceptionRule.expectMessage("404 Not Found");
		api.getWeatherData("BeloHorizonte", 3, "metric");
	}

}
