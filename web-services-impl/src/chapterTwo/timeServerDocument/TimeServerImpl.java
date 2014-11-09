package chapterTwo.timeServerDocument;

import java.util.Date;

import javax.jws.WebService;

/**
 * SEI - Interface EndPoint do servi��
 * 
 * 
 * @author estevao.jordao
 */

@WebService(endpointInterface = "chapterTwo.timeServerDocument.TimeServer")
public class TimeServerImpl implements TimeServer{

	@Override
	public String getTimeAsString() {
		return new Date().toString();
	}

	@Override
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}
}
