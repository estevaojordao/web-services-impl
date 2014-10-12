package chapterOne.soap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

/**
 * Classe respons�vel por imular um servi�o sendo enviado e consumido.
 * Tem por objetivo montar um envolepe SOAP de envio e de resposta.
 * 
 * @author Gothicoil
 * 
 */
public class DemoSoap {

	
	private static final String LocalName = "TimeRequest";
	private static final String Namespace = "http://ch01/mysoap/";
	private static final String NamespacePrefix = "ms";
	
	private ByteArrayOutputStream out;
	private ByteArrayInputStream in;
	
	public static void main(String[] args) {
		new DemoSoap().request();
	}
	
	/**
	 * M�todo que imula um request a um servi�o pela rede.
	 */
	private void request(){
		try {
			//Cria uma mensagem SOAP para enviar para um strem de sa�da
			SOAPMessage msg = create_soap_message();
			
			//Injetar a informa��o apropriada na mensagem
			// Neste caso, apenas o cabe�alho da mensagem(opcional) � usado e o corpo est� vazio
			
			SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
			SOAPHeader header = envelope.getHeader();
			
			//Adiciona um elemento ao cabe�alho SOAP.
			Name lookup_name = create_qname(msg);
			header.addHeaderElement(lookup_name).addTextNode("time_request");
			
			//Simular o envio da mensagem SOAP ao sistema remoto
			//escrevendo-o em um ByteArrayOutputStream
			out =  new ByteArrayOutputStream();
			msg.writeTo(out);

			trace("The sent SOAP message:", msg);
			
			
			SOAPMessage response = process_request();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	/**
	 * M�todo respons�vel por imular o processamento do servi�o
	 * @return
	 */
	private SOAPMessage process_request() {
		process_incoming_soap();
		coordinate_streams();
		return create_soap_message(in);
	}

	private void process_incoming_soap() {
		try {
			// Copiar stream de output e stream de input para simular
			// streams coordenadas atrav�s de yna cibex�o de rede.
			coordinate_streams();
			
			//Cria a mensagem SOAP "recebida" a partir do stream de entrada...
			SOAPMessage msg =  create_soap_message(in);
			
			// Inspecionar o cabe�alho SOAP para a palavra-chave 'time-request'
			// e processar a solicita��o se a palavra-chave ocorrer.
			Name lookup_name = create_qname(msg);
			
			SOAPHeader header = msg.getSOAPHeader();
			Iterator it = header.getChildElements(lookup_name);
			Node next = (Node) it.next(); 
			
			String value = (next ==  null)? "Error!" : next.getValue();
			
			// Se a mensagem SOAP contiver solicita��o para a hora, criar uma
			// nova mnensagvem SOAP com a hora atual no corpo.
			
			if(value.toLowerCase().contains("time_request")) {
				
				//Extrair o corpo e adicionar a hora atual com um elemento.
				String now = new Date().toString();
				SOAPBody body = msg.getSOAPBody();
				body.addBodyElement(lookup_name).addTextNode(now);
				msg.saveChanges();
				
				//Escrever no stream de sa�da
				msg.writeTo(out);
				trace("The received/processed SOAP message", msg);
			}
		} catch (SOAPException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	private void extract_contents_and_print(SOAPMessage message) {
		try {
			SOAPBody body =  message.getSOAPBody();
			
			Name lookup_name  = create_qname(message);
			Iterator it = body.getChildElements(lookup_name);
			Node next = (Node) it.next();
			
			String value = (next == null) ? "Error!" : next.getValue();
			System.out.println("\n\nReturned from server: " +  value);
		} catch (SOAPException e) {
			System.err.println(e);
		}
	}

	private SOAPMessage create_soap_message(){
		SOAPMessage msg = null;
		try {
			MessageFactory mf = MessageFactory.newInstance();
			msg = mf.createMessage();
			
		} catch (SOAPException e) {
			System.err.println(e);
		}
		return msg;
	}
	
	private SOAPMessage create_soap_message(InputStream in){
		SOAPMessage msg = null;
		try {
			MessageFactory mf = MessageFactory.newInstance();
			// null ignora o cabe�alho MIME
			// in - stream de origem
			msg = mf.createMessage(null, in);
			
		} catch (SOAPException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		return msg;
	}
	
	/**
	 * M�todo respons�vel por criar um QNAME.
	 * 
	 * @param msg
	 * @return
	 */
	private Name create_qname(SOAPMessage msg) {
		Name name = null;
		try {
			SOAPEnvelope envelope =  msg.getSOAPPart().getEnvelope();
			name = envelope.createName(LocalName, NamespacePrefix, Namespace);
		} catch (Exception e) {
			System.err.println(e);
		}
		return name;
	}

	private void trace(String string, SOAPMessage msg) {
		System.out.println("\n");
		System.out.println(string);
		try {
			msg.writeTo(System.out);
		} catch (SOAPException e) {
			System.err.println(e);
		} catch (IOException io) {
			System.err.println(io);
		}
	}
	
	private void coordinate_streams(){
		in = new ByteArrayInputStream(out.toByteArray());
		out.reset();
	}
}
