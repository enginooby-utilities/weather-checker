package api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainObject {
	@JsonProperty("temp")
	private double temp;
	@JsonProperty("temp_min")
	private double temp_min;
	@JsonProperty("feels_like")
	private double feels_like;
	@JsonProperty("temp_max")
	private double temp_max;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("pressure")
	private int pressure;

	public MainObject() {
	}

	public double getTemp() {
		return temp;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getFeels_like() {
		return feels_like ;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public int getHumidity() {
		return humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		return "MainObject [temp=" + temp + ", temp_min=" + temp_min + ", feels_like=" + feels_like + ", temp_max="
				+ temp_max + ", humidity=" + humidity + ", pressure=" + pressure + "]";
	}

}
