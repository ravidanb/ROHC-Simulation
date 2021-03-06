package Layer4;

import org.json.simple.JSONObject;

import Utils.Utils;

public class UDP {
	// SHOULD CHANGE
	/*
	 * private char[] sourcePort=new char[16]; private char[] destPort=new char[16];
	 * private char[] UdpLength=new char[16]; private char[] UdpChecksum=new
	 * char[16]; private String data;
	 */

	private int sourcePort;
	private int destPort;
	private int udpLength;
	private int udpChecksum;
	private String data;

	public UDP(int sourcePort, int destPort, int udpLength, int udpChecksum, String data) {

		setSourcePort(sourcePort);
		setDestPort(destPort);
		setUdpLength(udpLength);
		setUdpChecksum(udpChecksum);
		this.data = data;
	}
	
	
	public UDP(JSONObject json) {

		setSourcePort(((Long) json.get("sourcePort")).intValue());
		setDestPort(((Long) json.get("destPort")).intValue());
		setUdpLength(((Long) json.get("udpLength")).intValue());
		setUdpChecksum(((Long) json.get("udpChecksum")).intValue());
		this.setData((String) json.get("data"));
	}

	public void setSourcePort(int sourcePort) {
		if (sourcePort <= 65535 && sourcePort >= 0)
			this.sourcePort = sourcePort;
	}

	public void setDestPort(int destPort) {
		if (destPort <= 65535 && destPort >= 0)
			this.destPort = destPort;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public int getDestPort() {
		return destPort;
	}

	public int getUdpLength() {
		return udpLength;
	}

	public int getUdpChecksum() {
		return udpChecksum;
	}

	public void setUdpLength(int udpLength) {
		if (udpLength <= 65535 && udpLength >= 0)
			this.udpLength = udpLength;
	}

	public void setUdpChecksum(int udpChecksum) {
		if (udpChecksum <= 65535 && udpChecksum >= 0)
			this.udpChecksum = udpChecksum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {

		JSONObject json = new JSONObject();
		json.put("sourcePort", sourcePort);
		json.put("destPort", destPort);
		json.put("udpLength", udpLength);
		json.put("udpChecksum", udpChecksum);
		json.put("data", data);

		return json.toJSONString();
	}

	public UDP getDifferences(UDP other) {
		if (other == null)
			return null;
		UDP udpToReturn = Utils.getUdpObject();
		udpToReturn.setSourcePort(this.getSourcePort() ^ other.getSourcePort());
		udpToReturn.setDestPort(this.getDestPort() ^ other.getDestPort());
		udpToReturn.setUdpChecksum(this.getUdpChecksum() ^ other.getUdpChecksum());
		udpToReturn.setUdpLength(this.getUdpLength() ^ other.getUdpLength());
		udpToReturn.setData(other.data);
		return udpToReturn;
	}

}
