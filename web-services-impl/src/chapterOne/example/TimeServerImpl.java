package chapterOne.example;

import java.util.Date;

import javax.jws.WebService;

/**
 * SEI - Interface EndPoint do serviçõ
 * 
 * 
 * @author estevao.jordao
 */

@WebService(endpointInterface = "chapterOne.example.TimeServer")
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
