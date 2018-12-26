package finleap.weather.model;

public class ResultBuilder {

	private ResultDTO dto;
	
	public ResultBuilder(){
		this.dto = new ResultDTO();
	}

	public ResultBuilder setMinAvg(Double temp) {
		this.dto.setMinAvg(temp);
		return this;
	}
	
	public ResultBuilder setMaxAvg(Double temp) {
		this.dto.setMaxAvg(temp);
		return this;
	}
	
	public ResultBuilder setPressureAvg(Double pressure) {
		this.dto.setPressureAvg(pressure);
		return this;
	}
	
	public ResultBuilder setcity(String city) {
		this.dto.setCity(city);
		return this;
	}
	
	public ResultBuilder setUnit(String unit) {
		this.dto.setUnit(unit);
		return this;
	}
	
	public ResultBuilder setDays(Integer days) {
		this.dto.setDays(days);
		return this;
	}
	
	public ResultBuilder setErrorMessage(String errorMessage) {
		this.dto.setErrorMessage(errorMessage);
		return this;
	}
	
	public ResultBuilder getDefault() {
		this.dto.setPressureAvg(1000.0D);
		this.dto.setMinAvg(1.0D);
		this.dto.setMaxAvg(10.0D);
		this.dto.setCity("Berlin");
		this.dto.setDays(3);
		this.dto.setUnit("metric");
		this.dto.setErrorMessage(null);
		return this;
	}
	
	public ResultDTO get() {
		return this.dto;
	}
}

