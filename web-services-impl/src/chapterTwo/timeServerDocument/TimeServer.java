package chapterTwo.timeServerDocument;

import javax.jws.WebMethod;
import javax.jws.WebResult;
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
@SOAPBinding(style = Style.DOCUMENT)
public interface TimeServer {

	@WebMethod
	  //coloca um tag de resposta, defautl é return
	String getTimeAsString();

	@WebMethod
	@WebResult(partName="time_response")
	long getTimeAsElapsed();
}
