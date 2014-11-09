package chapterOne.example;

import javax.xml.ws.Endpoint;

public class TimeServerPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9876/ts", new TimeServerImpl());
	}
}
