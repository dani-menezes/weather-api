package finleap.weather.model;

public class CityBuilder {

	private CityDTO city;
	
	public CityBuilder(){
		this.city = new CityDTO();
	}

	public CityBuilder setId(Long id) {
		this.city.setId(id);
		return this;
	}
	
	public CityBuilder setName(String name) {
		this.city.setName(name);
		return this;
	}
	
	public CityBuilder setCountry(String country) {
		this.city.setCountry(country);
		return this;
	}

	public CityBuilder getDefault() {
		this.city.setId(1L);
		this.city.setName("Berlin");
		this.city.setCountry("DE");
		return this;
	}
	
	public CityDTO get() {
		return this.city;
	}
	
}

