package finleap.weather.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import finleap.weather.common.CommonDTO;

public class WeatherDataDTO extends CommonDTO {

	private String cod;
	private Double message;
	private Integer cnt;
	@SerializedName("list")
	private List<DataDTO> datas;
	private CityDTO city;
	
	public WeatherDataDTO(){}
	
	public WeatherDataDTO(String cod, Double message, Integer cnt, List<DataDTO> datas, CityDTO city) {
		this.cod = cod;
		this.message = message;
		this.cnt = cnt;
		this.datas = datas;
		this.city = city;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Double getMessage() {
		return message;
	}

	public void setMessage(Double message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public List<DataDTO> getDatas() {
		return datas;
	}

	public void setDatas(List<DataDTO> datas) {
		this.datas = datas;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cnt == null) ? 0 : cnt.hashCode());
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + ((datas == null) ? 0 : datas.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		if (!(obj instanceof WeatherDataDTO)) {
			return false;
		}
		WeatherDataDTO other = (WeatherDataDTO) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (cnt == null) {
			if (other.cnt != null) {
				return false;
			}
		} else if (!cnt.equals(other.cnt)) {
			return false;
		}
		if (cod == null) {
			if (other.cod != null) {
				return false;
			}
		} else if (!cod.equals(other.cod)) {
			return false;
		}
		if (datas == null) {
			if (other.datas != null) {
				return false;
			}
		} else if (!datas.equals(other.datas)) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		return true;
	}
	
	
}
