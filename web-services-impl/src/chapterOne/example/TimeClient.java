package chapterOne.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Cliente java para o servi�o TimeServer.
 * 
 * @author estevao.jordao
 *
 */
public class TimeClient {
	public static void main(String[] args) {
		try {
			//URL do servi�o que ser� acessado
			URL url = new URL("http://127.0.0.1/9876/ts?wsdl");
			
			//Primeiro argumento � a URI -Identificador de Recurso Uniforme
			//Nome do servi�o que est� sendo publicado no WSDL
			QName qName = new QName("http://example.chapterOne/", "TimeServerImplService");
			
			//Cria uma fabrica para o servi�o de acordo com a URI e o servi�o que deve ser acessado
			Service service =  Service.create(url, qName);
			
			// Extrai a interface endpoint, o servi�o "port"
			TimeServer timeServer =  service.getPort(TimeServer.class);
			System.out.println(timeServer.getTimeAsString());
			System.out.println(timeServer.getTimeAsElapsed());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
