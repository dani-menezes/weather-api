package finleap.weather.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataBuilder {

	private WeatherDataDTO data;
	
	public WeatherDataBuilder(){
		this.data = new WeatherDataDTO();
	}
	
	public WeatherDataBuilder setCod(String cod) {
		this.data.setCod(cod);
		return this;
	}
	
	public WeatherDataBuilder setMessage(Double message) {
		this.data.setMessage(message);
		return this;
	}
	
	public WeatherDataBuilder setCnt(Integer cnt) {
		this.data.setCnt(cnt);
		return this;
	}
	
	public WeatherDataBuilder setDatas(List<DataDTO> datas) {
		this.data.setDatas(datas);
		return this;
	}
	
	public WeatherDataBuilder setCity(CityDTO city) {
		this.data.setCity(city);
		return this;
	}

	public WeatherDataBuilder getDefault() {
		this.data.setCod("200");
		this.data.setMessage(0.0045D);
		this.data.setCnt(3);
		this.data.setCity(new CityBuilder().getDefault().get());
		List<DataDTO> datas = new ArrayList<>();
		DataDTO dataDto1 = new DataBuilder().getDefault().get();
		DataDTO dataDto2 = new DataBuilder().getDefault().setDt(2L).get();
		datas.add(dataDto1);
		datas.add(dataDto2);
		this.data.setDatas(datas);
		return this;
	}
	
	public WeatherDataDTO get() {
		return this.data;
	}
	
}

