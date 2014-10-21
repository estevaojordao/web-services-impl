
package chapterOne.team.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Teams", targetNamespace = "http://team.chapterOne/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Teams {


    /**
     * 
     * @param arg0
     * @return
     *     returns chapterOne.team.client.Team
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTeam", targetNamespace = "http://team.chapterOne/", className = "chapterOne.team.client.GetTeam")
    @ResponseWrapper(localName = "getTeamResponse", targetNamespace = "http://team.chapterOne/", className = "chapterOne.team.client.GetTeamResponse")
    @Action(input = "http://team.chapterOne/Teams/getTeamRequest", output = "http://team.chapterOne/Teams/getTeamResponse")
    public Team getTeam(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<chapterOne.team.client.Team>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTeams", targetNamespace = "http://team.chapterOne/", className = "chapterOne.team.client.GetTeams")
    @ResponseWrapper(localName = "getTeamsResponse", targetNamespace = "http://team.chapterOne/", className = "chapterOne.team.client.GetTeamsResponse")
    @Action(input = "http://team.chapterOne/Teams/getTeamsRequest", output = "http://team.chapterOne/Teams/getTeamsResponse")
    public List<Team> getTeams();

}