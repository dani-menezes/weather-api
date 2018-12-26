package finleap.weather.common;

import com.google.gson.Gson;

public abstract class CommonDTO {
	
	public abstract int hashCode();
	public abstract boolean equals(Object obj);
	
	public String toString() {
		return new Gson().toJson(this, this.getClass());
	}


}
