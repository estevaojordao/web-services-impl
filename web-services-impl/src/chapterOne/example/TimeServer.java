package chapterOne.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * A anotação @WebSercice indica que está é a SEI(Interface de Endpoint de Serviço)
 * 
 * A anotação @WebMethod indica que cada método é uma operação de serviço.
 * 
 * A anotação @SAOPBinding impacta na construção por-debaixo-dos-panos do
 * contrato de serviço, o documento WSDL
 * 
 * Sytle.RPC é responsável por simplificar o contrato e tornar a implementação
 * mais facil.
 * 
 * @author Gothicoil
 * 
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface TimeServer {

	@WebMethod
	String getTimeAsString();

	@WebMethod
	long getTimeAsElapsed();
}
