package api.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResult {
	@JsonProperty("visibility")
	private long visibility;
	@JsonProperty("timezone")
	private long timezone;
	@JsonProperty("dt")
	private long dt;
	@JsonProperty("cod")
	private long cod;
	@JsonProperty("id")
	private long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("base")
	private String base;

	@JsonProperty("main")
	private MainObject mainObject;
	@JsonProperty("clouds")
	private CloudsObject cloudsObject;
	@JsonProperty("sys")
	private SysObject sysObject;
	@JsonProperty("coord")
	private CoordObject coordObject;
	@JsonProperty("weather")
	private List<WeatherObject> weatherObject;
	@JsonProperty("wind")
	private WindObject windObject;

	public WeatherResult() {
	}

	public long getVisibility() {
		return visibility;
	}

	public long getTimezone() {
		return timezone;
	}

	public long getDt() {
		return dt;
	}

	public long getCod() {
		return cod;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBase() {
		return base;
	}

	public MainObject getMainObject() {
		return mainObject;
	}

	public CloudsObject getCloudsObject() {
		return cloudsObject;
	}

	public SysObject getSysObject() {
		return sysObject;
	}

	public CoordObject getCoordObject() {
		return coordObject;
	}

	public WindObject getWindObject() {
		return windObject;
	}

	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setMainObject(MainObject mainObject) {
		this.mainObject = mainObject;
	}

	public void setCloudsObject(CloudsObject cloudsObject) {
		this.cloudsObject = cloudsObject;
	}

	public void setSysObject(SysObject sysObject) {
		this.sysObject = sysObject;
	}

	public void setCoordObject(CoordObject coordObject) {
		this.coordObject = coordObject;
	}

	public List<WeatherObject> getWeatherObject() {
		return weatherObject;
	}

	public void setWeatherObject(List<WeatherObject> weatherObject) {
		this.weatherObject = weatherObject;
	}

	public void setWindObject(WindObject windObject) {
		this.windObject = windObject;
	}

	@Override
	public String toString() {
		return "WeatherResult [visibility=" + visibility + ", timezone=" + timezone + ", dt=" + dt + ", cod=" + cod
				+ ", id=" + id + ", name=" + name + ", base=" + base + ", mainObject=" + mainObject + ", cloudsObject="
				+ cloudsObject + ", sysObject=" + sysObject + ", coordObject=" + coordObject + ", weatherObject="
				+ weatherObject + ", windObject=" + windObject + "]";
	}

}
