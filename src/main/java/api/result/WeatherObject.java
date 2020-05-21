package api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherObject {
	@JsonProperty("icon")
	private String icon;
	@JsonProperty("description")
	private String description;
	@JsonProperty("main")
	private String main;
	@JsonProperty("id")
	private int id;
	
	public WeatherObject() {
		
	}

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public String getMain() {
		return main;
	}

	public int getId() {
		return id;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeatherObject [icon=" + icon + ", description=" + description + ", main=" + main + ", id=" + id + "]";
	}

}
