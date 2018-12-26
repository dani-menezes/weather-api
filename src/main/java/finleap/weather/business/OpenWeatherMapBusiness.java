package finleap.weather.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import finleap.weather.exception.WeatherApiException;
import finleap.weather.external.OpenWeatherMapApi;
import finleap.weather.model.ResultDTO;
import finleap.weather.model.WeatherDataDTO;

@Component
public class OpenWeatherMapBusiness {
	
	private final String noDataErrorMsg = "No data for params [city=%s][days=%d][unit=%s]";
	
	@Autowired
	private OpenWeatherMapApi api;
	
	public ResultDTO getData(String city, Integer days, String unit) throws WeatherApiException {
		ResultDTO result = new ResultDTO(null, null, null, city, days, unit, null);
		WeatherDataDTO data = api.getWeatherData(city, days, unit);
		if (data != null && data.getDatas().size() > 0) {
			fillDataDailyAvg(result, data);
			return result;
		} else {
			throw new WeatherApiException(String.format(noDataErrorMsg, city, days, unit));
		}
	}
	
	protected void fillDataDailyAvg(ResultDTO result, WeatherDataDTO apiData) {
		apiData.getDatas().stream().mapToDouble(data -> data.getMain().getPressure()).average().ifPresent(avg -> result.setPressureAvg(round(avg, 2)));
		apiData.getDatas().stream().mapToDouble(data -> data.getMain().getTempMin()).average().ifPresent(avg -> result.setMinAvg(round(avg, 2)));
		apiData.getDatas().stream().mapToDouble(data -> data.getMain().getTempMax()).average().ifPresent(avg -> result.setMaxAvg(round(avg, 2)));
	}
	
	protected Double round(Double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
