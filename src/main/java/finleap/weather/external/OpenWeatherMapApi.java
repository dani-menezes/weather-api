package finleap.weather.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import finleap.weather.exception.WeatherApiException;
import finleap.weather.model.WeatherDataDTO;
import finleap.weather.util.HttpRestUtil;

@Component
public class OpenWeatherMapApi {
	
	@Value("${api.token}")
	private String appId;
	@Value("${api.version}")
	private String apiVersion;
	@Value("${api.domain}")
	private String openWeatherMapDomain;
	private HttpRestUtil http;
	
	public OpenWeatherMapApi() {
		http = new HttpRestUtil();
	}
	
	public WeatherDataDTO getWeatherData (String city, Integer days, String unit) throws WeatherApiException {
		try {
			String url = String.format("%s/data/%s/forecast?q=%s&cnt=%d&units=%s&APPID=%s", openWeatherMapDomain, apiVersion, city, days, unit, appId);
			String json = http.get(url);
			WeatherDataDTO dto = this.parseForecastJson(json);
			return dto;
		} catch (WeatherApiException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeatherApiException("Error on get API response", e);
		}
	}
	
	public WeatherDataDTO parseForecastJson(String json) {
		WeatherDataDTO dto = new WeatherDataDTO();
		dto = new Gson().fromJson(json, WeatherDataDTO.class);
		return dto;
	}
	
}
