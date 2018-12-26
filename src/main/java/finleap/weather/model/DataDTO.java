package finleap.weather.model;

import finleap.weather.common.CommonDTO;

public class DataDTO extends CommonDTO {
	
	private Long dt;
	private MainDTO main;
	
	public DataDTO(){}
	
	public DataDTO(Long dt, MainDTO main) {
		this.dt = dt;
		this.main = main;
	}

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public MainDTO getMain() {
		return main;
	}

	public void setMain(MainDTO main) {
		this.main = main;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dt == null) ? 0 : dt.hashCode());
		result = prime * result + ((main == null) ? 0 : main.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DataDTO)) {
			return false;
		}
		DataDTO other = (DataDTO) obj;
		if (dt == null) {
			if (other.dt != null) {
				return false;
			}
		} else if (!dt.equals(other.dt)) {
			return false;
		}
		if (main == null) {
			if (other.main != null) {
				return false;
			}
		} else if (!main.equals(other.main)) {
			return false;
		}
		return true;
	}
	
}
