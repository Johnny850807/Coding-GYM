
public class WebLink {
	private String url;
	private String protocol;
	private String domain;
	private String port;
	private String address;
	private String parameters;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("URL：" + url).append("\n協定：" + protocol).append("\n網域：" + domain + "\n");
		if (port != null)
			stringBuilder.append("Port：" + port + "\n");
		if (address != null)
			stringBuilder.append("網址：" + address + "\n");	
		if (parameters != null)
			stringBuilder.append("參數列：" + parameters + "\n");	
		return stringBuilder.toString();
	}
}
