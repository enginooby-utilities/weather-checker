package api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WindObject {
	@JsonProperty("deg")
	private int deg;
	@JsonProperty("speed")
	private float speed;

	public WindObject() {
		
	}

	public int getDeg() {
		return deg;
	}

	public float getSpeed() {
		return speed;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "WindObject [deg=" + deg + ", speed=" + speed + "]";
	}
	
	
}
