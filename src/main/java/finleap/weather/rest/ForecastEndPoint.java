package finleap.weather.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import finleap.weather.business.OpenWeatherMapBusiness;
import finleap.weather.model.ResultDTO;
import finleap.weather.util.SQLInjectionSafe;

@RestController
public class ForecastEndPoint {
	
	public final String endPoint = "/data";
	public final Integer defaultDays = 3;
	public final String defaultUnit = "metric";
	
	@Autowired
	private OpenWeatherMapBusiness business;
	
	@GetMapping(endPoint+"/")
    public ResponseEntity<ResultDTO> getData(@SQLInjectionSafe @RequestParam("city") String city, @RequestParam(name = "days", required = false) Integer days, @SQLInjectionSafe @RequestParam(name = "unit", required = false) String unit) {
		ResultDTO dto;
		try {
			dto = business.getData(city, days == null? defaultDays: days, unit == null? defaultUnit: unit);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			dto = new ResultDTO(null, null, null, city, defaultDays, defaultUnit, e.getMessage());
			return ResponseEntity.status(500).body(dto);
		}
	}
	
}
