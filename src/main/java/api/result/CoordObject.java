package api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordObject {
	@JsonProperty("lon")
	private float lon;
	@JsonProperty("lat")
	private float lat;

	public CoordObject() {
		super();
	}

	public float getLon() {
		return lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "CoordObject [lon=" + lon + ", lat=" + lat + "]";
	}

}
