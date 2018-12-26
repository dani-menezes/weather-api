package finleap.weather.model;

public class MainBuilder {

	private MainDTO main;
	
	public MainBuilder(){
		this.main = new MainDTO();
	}

	public MainBuilder setTemp(Double temp) {
		this.main.setTemp(temp);
		return this;
	}
	
	public MainBuilder setTempMin(Double temp) {
		this.main.setTempMin(temp);
		return this;
	}
	
	public MainBuilder setTempMax(Double temp) {
		this.main.setTempMax(temp);
		return this;
	}
	
	public MainBuilder setPressure(Double pressure) {
		this.main.setPressure(pressure);
		return this;
	}
	
	public MainBuilder getDafault() {
		this.main.setPressure(1000D);
		this.main.setTemp(5D);
		this.main.setTempMin(1D);
		this.main.setTempMax(10D);
		return this;
	}
	
	public MainDTO get() {
		return this.main;
	}
	
}

