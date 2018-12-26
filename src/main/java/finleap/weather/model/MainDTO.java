package finleap.weather.model;

import com.google.gson.annotations.SerializedName;

import finleap.weather.common.CommonDTO;

public class MainDTO extends CommonDTO {
	
	private Double temp;
	@SerializedName("temp_min")
	private Double tempMin;
	@SerializedName("temp_max")
	private Double tempMax;
	private Double pressure;
	
	public MainDTO(){}
	
	public MainDTO(Double temp, Double tempMin, Double tempMax, Double pressure) {
		this.temp = temp;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.pressure = pressure;
	}

	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getTempMin() {
		return tempMin;
	}
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}
	public Double getTempMax() {
		return tempMax;
	}
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pressure == null) ? 0 : pressure.hashCode());
		result = prime * result + ((temp == null) ? 0 : temp.hashCode());
		result = prime * result + ((tempMax == null) ? 0 : tempMax.hashCode());
		result = prime * result + ((tempMin == null) ? 0 : tempMin.hashCode());
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
		if (!(obj instanceof MainDTO)) {
			return false;
		}
		MainDTO other = (MainDTO) obj;
		if (pressure == null) {
			if (other.pressure != null) {
				return false;
			}
		} else if (!pressure.equals(other.pressure)) {
			return false;
		}
		if (temp == null) {
			if (other.temp != null) {
				return false;
			}
		} else if (!temp.equals(other.temp)) {
			return false;
		}
		if (tempMax == null) {
			if (other.tempMax != null) {
				return false;
			}
		} else if (!tempMax.equals(other.tempMax)) {
			return false;
		}
		if (tempMin == null) {
			if (other.tempMin != null) {
				return false;
			}
		} else if (!tempMin.equals(other.tempMin)) {
			return false;
		}
		return true;
	}
	
}
