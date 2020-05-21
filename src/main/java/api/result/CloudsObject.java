package api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudsObject {
	@JsonProperty("all")
	private float all;

	public CloudsObject() {

	}

	public float getAll() {
		return all;
	}

	public void setAll(float all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "CloudsObject [all=" + all + "]";
	}

}
