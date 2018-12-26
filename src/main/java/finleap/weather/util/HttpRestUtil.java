package finleap.weather.util;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import finleap.weather.exception.WeatherApiException;

public class HttpRestUtil {
	
	public String get(String url) throws WeatherApiException {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return result;
		} catch (HttpClientErrorException e) {
			throw new WeatherApiException(e.getMessage());
		}
	}
}
