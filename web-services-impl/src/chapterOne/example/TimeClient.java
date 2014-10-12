package chapterOne.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Cliente java para o serviço TimeServer.
 * 
 * @author estevao.jordao
 *
 */
public class TimeClient {
	public static void main(String[] args) {
		try {
			//URL do serviço que será acessado
			URL url = new URL("http://127.0.0.1/9876/ts?wsdl");
			
			//Primeiro argumento é a URI -Identificador de Recurso Uniforme
			//Nome do serviço que está sendo publicado no WSDL
			QName qName = new QName("http://example.chapterOne/", "TimeServerImplService");
			
			//Cria uma fabrica para o serviço de acordo com a URI e o serviço que deve ser acessado
			Service service =  Service.create(url, qName);
			
			// Extrai a interface endpoint, o serviço "port"
			TimeServer timeServer =  service.getPort(TimeServer.class);
			System.out.println(timeServer.getTimeAsString());
			System.out.println(timeServer.getTimeAsElapsed());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
