package chapterOne.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * A anota��o @WebSercice indica que est� � a SEI(Interface de Endpoint de Servi�o)
 * 
 * A anota��o @WebMethod indica que cada m�todo � uma opera��o de servi�o.
 * 
 * A anota��o @SAOPBinding impacta na constru��o por-debaixo-dos-panos do
 * contrato de servi�o, o documento WSDL
 * 
 * Sytle.RPC � respons�vel por simplificar o contrato e tornar a implementa��o
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
