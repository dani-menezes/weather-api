package finleap.weather.model;

import finleap.weather.common.CommonDTO;

public class ResultDTO extends CommonDTO {
	
	private Double pressureAvg;
	private Double minAvg;
	private Double maxAvg;
	private String city;
	private Integer days;
	private String unit;
	private String errorMessage;
	
	public ResultDTO(){}
	
	public ResultDTO(Double pressureAvg, Double minAvg, Double maxAvg, String city, Integer days, String unit, String errorMessage) {
		this.pressureAvg = pressureAvg;
		this.minAvg = minAvg;
		this.maxAvg = maxAvg;
		this.city = city;
		this.days = days;
		this.unit = unit;
		this.errorMessage = errorMessage;
	}

	public Double getPressureAvg() {
		return pressureAvg;
	}
	
	public void setPressureAvg(Double pressureAvg) {
		this.pressureAvg = pressureAvg;
	}

	public Double getMinAvg() {
		return minAvg;
	}

	public void setMinAvg(Double minAvg) {
		this.minAvg = minAvg;
	}

	public Double getMaxAvg() {
		return maxAvg;
	}

	public void setMaxAvg(Double maxAvg) {
		this.maxAvg = maxAvg;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((maxAvg == null) ? 0 : maxAvg.hashCode());
		result = prime * result + ((minAvg == null) ? 0 : minAvg.hashCode());
		result = prime * result + ((pressureAvg == null) ? 0 : pressureAvg.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		if (!(obj instanceof ResultDTO)) {
			return false;
		}
		ResultDTO other = (ResultDTO) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (days == null) {
			if (other.days != null) {
				return false;
			}
		} else if (!days.equals(other.days)) {
			return false;
		}
		if (errorMessage == null) {
			if (other.errorMessage != null) {
				return false;
			}
		} else if (!errorMessage.equals(other.errorMessage)) {
			return false;
		}
		if (maxAvg == null) {
			if (other.maxAvg != null) {
				return false;
			}
		} else if (!maxAvg.equals(other.maxAvg)) {
			return false;
		}
		if (minAvg == null) {
			if (other.minAvg != null) {
				return false;
			}
		} else if (!minAvg.equals(other.minAvg)) {
			return false;
		}
		if (pressureAvg == null) {
			if (other.pressureAvg != null) {
				return false;
			}
		} else if (!pressureAvg.equals(other.pressureAvg)) {
			return false;
		}
		if (unit == null) {
			if (other.unit != null) {
				return false;
			}
		} else if (!unit.equals(other.unit)) {
			return false;
		}
		return true;
	}
	
}
