<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTimeServerProxyid" scope="session" class="chapterOne.TimeServerProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTimeServerProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTimeServerProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTimeServerProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        chapterOne.TimeServer getTimeServer10mtemp = sampleTimeServerProxyid.getTimeServer();
if(getTimeServer10mtemp == null){
%>
<%=getTimeServer10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 17:
        gotMethod = true;
        java.lang.String getTimeAsString17mtemp = sampleTimeServerProxyid.getTimeAsString();
if(getTimeAsString17mtemp == null){
%>
<%=getTimeAsString17mtemp %>
<%
}else{
        String tempResultreturnp18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getTimeAsString17mtemp));
        %>
        <%= tempResultreturnp18 %>
        <%
}
break;
case 20:
        gotMethod = true;
        long getTimeAsElapsed20mtemp = sampleTimeServerProxyid.getTimeAsElapsed();
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getTimeAsElapsed20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>