package finleap.weather.model;

public class DataBuilder {

	private DataDTO data;
	
	public DataBuilder(){
		this.data = new DataDTO();
	}

	public DataBuilder setDt(Long dt) {
		this.data.setDt(dt);
		return this;
	}
	
	public DataBuilder setMain(MainDTO mainDto) {
		this.data.setMain(mainDto);
		return this;
	}
	
	public DataBuilder getDefault() {
		this.data.setDt(1L);
		this.data.setMain(new MainBuilder().getDafault().get());
		return this;
	}
	
	public DataDTO get() {
		return this.data;
	}
	
}

