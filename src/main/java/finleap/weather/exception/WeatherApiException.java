package finleap.weather.exception;

public class WeatherApiException extends Exception {

	private static final long serialVersionUID = 7383837609116819621L;

	public WeatherApiException(String message) {
		super(message);
	}
	
	public WeatherApiException(String message, Throwable cause) {
		super(message, cause);
	}


}