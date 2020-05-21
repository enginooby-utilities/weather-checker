package api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SysObject {
	@JsonProperty("country")
	private String country;
	@JsonProperty("sunrise")
	private long sunrise;
	@JsonProperty("sunset")
	private long sunset;
	@JsonProperty("id")
	private float id;
	@JsonProperty("type")
	private int type;
	
	public SysObject() {
		
	}

	public String getCountry() {
		return country;
	}

	public long getSunrise() {
		return sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	public float getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	public void setId(float id) {
		this.id = id;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SysObject [country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset + ", id=" + id
				+ ", type=" + type + "]";
	}
	
}
