<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="samplePublicadorIControladorProxyid" scope="session" class="servidor.PublicadorIControladorProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
samplePublicadorIControladorProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = samplePublicadorIControladorProxyid.getEndpoint();
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
        samplePublicadorIControladorProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        servidor.PublicadorIControlador getPublicadorIControlador10mtemp = samplePublicadorIControladorProxyid.getPublicadorIControlador();
if(getPublicadorIControlador10mtemp == null){
%>
<%=getPublicadorIControlador10mtemp %>
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
        servidor.DataDepartamento dataDepartamentoNull17mtemp = samplePublicadorIControladorProxyid.dataDepartamentoNull();
if(dataDepartamentoNull17mtemp == null){
%>
<%=dataDepartamentoNull17mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataDepartamentoNull17mtemp != null){
java.lang.String typedescripcion20 = dataDepartamentoNull17mtemp.getDescripcion();
        String tempResultdescripcion20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion20));
        %>
        <%= tempResultdescripcion20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(dataDepartamentoNull17mtemp != null){
java.lang.String typeurl22 = dataDepartamentoNull17mtemp.getUrl();
        String tempResulturl22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl22));
        %>
        <%= tempResulturl22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataDepartamentoNull17mtemp != null){
java.lang.String typenombre24 = dataDepartamentoNull17mtemp.getNombre();
        String tempResultnombre24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre24));
        %>
        <%= tempResultnombre24 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 26:
        gotMethod = true;
        servidor.DataTurista dataTuristaNull26mtemp = samplePublicadorIControladorProxyid.dataTuristaNull();
if(dataTuristaNull26mtemp == null){
%>
<%=dataTuristaNull26mtemp %>
<%
}else{
        if(dataTuristaNull26mtemp!= null){
        String tempreturnp27 = dataTuristaNull26mtemp.toString();
        %>
        <%=tempreturnp27%>
        <%
        }}
break;
case 29:
        gotMethod = true;
        servidor.DataProveedor dataProveedorNull29mtemp = samplePublicadorIControladorProxyid.dataProveedorNull();
if(dataProveedorNull29mtemp == null){
%>
<%=dataProveedorNull29mtemp %>
<%
}else{
        if(dataProveedorNull29mtemp!= null){
        String tempreturnp30 = dataProveedorNull29mtemp.toString();
        %>
        <%=tempreturnp30%>
        <%
        }}
break;
case 32:
        gotMethod = true;
        servidor.DataActividad dataActividadNull32mtemp = samplePublicadorIControladorProxyid.dataActividadNull();
if(dataActividadNull32mtemp == null){
%>
<%=dataActividadNull32mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.util.Calendar typefechaAlta35 = dataActividadNull32mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta35 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta35 = typefechaAlta35.getTime();
        String tempResultfechaAlta35 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta35.format(datefechaAlta35));
        %>
        <%= tempResultfechaAlta35 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typedepartamento37 = dataActividadNull32mtemp.getDepartamento();
        String tempResultdepartamento37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento37));
        %>
        <%= tempResultdepartamento37 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
%>
<%=dataActividadNull32mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typedescripcion41 = dataActividadNull32mtemp.getDescripcion();
        String tempResultdescripcion41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion41));
        %>
        <%= tempResultdescripcion41 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typeciudad43 = dataActividadNull32mtemp.getCiudad();
        String tempResultciudad43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad43));
        %>
        <%= tempResultciudad43 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typelink45 = dataActividadNull32mtemp.getLink();
        String tempResultlink45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink45));
        %>
        <%= tempResultlink45 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
%>
<%=dataActividadNull32mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
%>
<%=dataActividadNull32mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
%>
<%=dataActividadNull32mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typenombre53 = dataActividadNull32mtemp.getNombre();
        String tempResultnombre53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre53));
        %>
        <%= tempResultnombre53 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typeimagen55 = dataActividadNull32mtemp.getImagen();
        String tempResultimagen55 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen55));
        %>
        <%= tempResultimagen55 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 57:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull57mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull57mtemp == null){
%>
<%=dataCGNull57mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
java.util.Calendar typefecha60 = dataCGNull57mtemp.getFecha();
        java.text.DateFormat dateFormatfecha60 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha60 = typefecha60.getTime();
        String tempResultfecha60 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha60.format(datefecha60));
        %>
        <%= tempResultfecha60 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">salida:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta64 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta64 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta64 = typefechaAlta64.getTime();
        String tempResultfechaAlta64 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta64.format(datefechaAlta64));
        %>
        <%= tempResultfechaAlta64 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora66 = tebece0.getHora();
        java.text.DateFormat dateFormathora66 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora66 = typehora66.getTime();
        String tempResulthora66 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora66.format(datehora66));
        %>
        <%= tempResulthora66 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar68 = tebece0.getLugar();
        String tempResultlugar68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar68));
        %>
        <%= tempResultlugar68 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
%>
<%=tebece0.getCantVis()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre72 = tebece0.getNombre();
        String tempResultnombre72 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre72));
        %>
        <%= tempResultnombre72 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
java.lang.String typeimagen74 = tebece0.getImagen();
        String tempResultimagen74 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen74));
        %>
        <%= tempResultimagen74 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha76 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha76 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha76 = typefecha76.getTime();
        String tempResultfecha76 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha76.format(datefecha76));
        %>
        <%= tempResultfecha76 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
servidor.DataSalida tebece0=dataCGNull57mtemp.getSalida();
if(tebece0 != null){
%>
<%=tebece0.getCant()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">porPaquete:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
%>
<%=dataCGNull57mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
%>
<%=dataCGNull57mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull57mtemp != null){
%>
<%=dataCGNull57mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 86:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull86mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull86mtemp == null){
%>
<%=dataCPNull86mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">restAct:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct89 = dataCPNull86mtemp.getRestAct();
        String temprestAct89 = null;
        if(typerestAct89 != null){
        java.util.List listrestAct89= java.util.Arrays.asList(typerestAct89);
        temprestAct89 = listrestAct89.toString();
        }
        %>
        <%=temprestAct89%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
java.util.Calendar typefecha91 = dataCPNull86mtemp.getFecha();
        java.text.DateFormat dateFormatfecha91 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha91 = typefecha91.getTime();
        String tempResultfecha91 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha91.format(datefecha91));
        %>
        <%= tempResultfecha91 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
%>
<%=dataCPNull86mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">paq:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descuento:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataPaquete tebece0=dataCPNull86mtemp.getPaq();
if(tebece0 != null){
%>
<%=tebece0.getDescuento()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataPaquete tebece0=dataCPNull86mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta99 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta99 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta99 = typefechaAlta99.getTime();
        String tempResultfechaAlta99 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta99.format(datefechaAlta99));
        %>
        <%= tempResultfechaAlta99 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataPaquete tebece0=dataCPNull86mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion101 = tebece0.getDescripcion();
        String tempResultdescripcion101 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion101));
        %>
        <%= tempResultdescripcion101 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataPaquete tebece0=dataCPNull86mtemp.getPaq();
if(tebece0 != null){
%>
<%=tebece0.getValidez()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataPaquete tebece0=dataCPNull86mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre105 = tebece0.getNombre();
        String tempResultnombre105 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre105));
        %>
        <%= tempResultnombre105 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
servidor.DataPaquete tebece0=dataCPNull86mtemp.getPaq();
if(tebece0 != null){
java.lang.String typeimagen107 = tebece0.getImagen();
        String tempResultimagen107 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen107));
        %>
        <%= tempResultimagen107 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
java.util.Calendar typevencimiento109 = dataCPNull86mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento109 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento109 = typevencimiento109.getTime();
        String tempResultvencimiento109 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento109.format(datevencimiento109));
        %>
        <%= tempResultvencimiento109 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull86mtemp != null){
%>
<%=dataCPNull86mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 113:
        gotMethod = true;
        servidor.EstadoAct estadoActNull113mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull113mtemp == null){
%>
<%=estadoActNull113mtemp %>
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
case 118:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg0135");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        servidor.DataUsuario verInfoUsuario118mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_1idTemp);
if(verInfoUsuario118mtemp == null){
%>
<%=verInfoUsuario118mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nacimiento:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.util.Calendar typenacimiento121 = verInfoUsuario118mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento121 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento121 = typenacimiento121.getTime();
        String tempResultnacimiento121 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento121.format(datenacimiento121));
        %>
        <%= tempResultnacimiento121 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.lang.String typenick123 = verInfoUsuario118mtemp.getNick();
        String tempResultnick123 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick123));
        %>
        <%= tempResultnick123 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.lang.String typemail125 = verInfoUsuario118mtemp.getMail();
        String tempResultmail125 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail125));
        %>
        <%= tempResultmail125 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.lang.String typepassword127 = verInfoUsuario118mtemp.getPassword();
        String tempResultpassword127 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword127));
        %>
        <%= tempResultpassword127 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.lang.String typenombre129 = verInfoUsuario118mtemp.getNombre();
        String tempResultnombre129 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre129));
        %>
        <%= tempResultnombre129 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.lang.String typeimagen131 = verInfoUsuario118mtemp.getImagen();
        String tempResultimagen131 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen131));
        %>
        <%= tempResultimagen131 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario118mtemp != null){
java.lang.String typeapellido133 = verInfoUsuario118mtemp.getApellido();
        String tempResultapellido133 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido133));
        %>
        <%= tempResultapellido133 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 137:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg0140");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        samplePublicadorIControladorProxyid.sumarVistaAAct(arg0_2idTemp);
break;
case 142:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg0145");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        samplePublicadorIControladorProxyid.sumarVistaASal(arg0_3idTemp);
break;
case 147:
        gotMethod = true;
        java.lang.Object[] getUsuariosComp147mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp147mtemp == null){
%>
<%=getUsuariosComp147mtemp %>
<%
}else{
        String tempreturnp148 = null;
        if(getUsuariosComp147mtemp != null){
        java.util.List listreturnp148= java.util.Arrays.asList(getUsuariosComp147mtemp);
        tempreturnp148 = listreturnp148.toString();
        }
        %>
        <%=tempreturnp148%>
        <%
}
break;
case 150:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0167");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        servidor.DataUsuario ingresarDatos150mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_4idTemp);
if(ingresarDatos150mtemp == null){
%>
<%=ingresarDatos150mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nacimiento:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.util.Calendar typenacimiento153 = ingresarDatos150mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento153 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento153 = typenacimiento153.getTime();
        String tempResultnacimiento153 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento153.format(datenacimiento153));
        %>
        <%= tempResultnacimiento153 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.lang.String typenick155 = ingresarDatos150mtemp.getNick();
        String tempResultnick155 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick155));
        %>
        <%= tempResultnick155 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.lang.String typemail157 = ingresarDatos150mtemp.getMail();
        String tempResultmail157 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail157));
        %>
        <%= tempResultmail157 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.lang.String typepassword159 = ingresarDatos150mtemp.getPassword();
        String tempResultpassword159 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword159));
        %>
        <%= tempResultpassword159 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.lang.String typenombre161 = ingresarDatos150mtemp.getNombre();
        String tempResultnombre161 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre161));
        %>
        <%= tempResultnombre161 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.lang.String typeimagen163 = ingresarDatos150mtemp.getImagen();
        String tempResultimagen163 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen163));
        %>
        <%= tempResultimagen163 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos150mtemp != null){
java.lang.String typeapellido165 = ingresarDatos150mtemp.getApellido();
        String tempResultapellido165 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido165));
        %>
        <%= tempResultapellido165 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 169:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg0172");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        java.lang.Object[] obtenerActividadCategoria169mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_5idTemp);
if(obtenerActividadCategoria169mtemp == null){
%>
<%=obtenerActividadCategoria169mtemp %>
<%
}else{
        String tempreturnp170 = null;
        if(obtenerActividadCategoria169mtemp != null){
        java.util.List listreturnp170= java.util.Arrays.asList(obtenerActividadCategoria169mtemp);
        tempreturnp170 = listreturnp170.toString();
        }
        %>
        <%=tempreturnp170%>
        <%
}
break;
case 174:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0191");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick174mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_6idTemp);
if(obtenerDataUsuarioNick174mtemp == null){
%>
<%=obtenerDataUsuarioNick174mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nacimiento:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.util.Calendar typenacimiento177 = obtenerDataUsuarioNick174mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento177 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento177 = typenacimiento177.getTime();
        String tempResultnacimiento177 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento177.format(datenacimiento177));
        %>
        <%= tempResultnacimiento177 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.lang.String typenick179 = obtenerDataUsuarioNick174mtemp.getNick();
        String tempResultnick179 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick179));
        %>
        <%= tempResultnick179 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.lang.String typemail181 = obtenerDataUsuarioNick174mtemp.getMail();
        String tempResultmail181 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail181));
        %>
        <%= tempResultmail181 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.lang.String typepassword183 = obtenerDataUsuarioNick174mtemp.getPassword();
        String tempResultpassword183 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword183));
        %>
        <%= tempResultpassword183 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.lang.String typenombre185 = obtenerDataUsuarioNick174mtemp.getNombre();
        String tempResultnombre185 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre185));
        %>
        <%= tempResultnombre185 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.lang.String typeimagen187 = obtenerDataUsuarioNick174mtemp.getImagen();
        String tempResultimagen187 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen187));
        %>
        <%= tempResultimagen187 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick174mtemp != null){
java.lang.String typeapellido189 = obtenerDataUsuarioNick174mtemp.getApellido();
        String tempResultapellido189 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido189));
        %>
        <%= tempResultapellido189 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 193:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0210");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail193mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_7idTemp);
if(obtenerDataUsuarioMail193mtemp == null){
%>
<%=obtenerDataUsuarioMail193mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nacimiento:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.util.Calendar typenacimiento196 = obtenerDataUsuarioMail193mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento196 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento196 = typenacimiento196.getTime();
        String tempResultnacimiento196 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento196.format(datenacimiento196));
        %>
        <%= tempResultnacimiento196 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.lang.String typenick198 = obtenerDataUsuarioMail193mtemp.getNick();
        String tempResultnick198 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick198));
        %>
        <%= tempResultnick198 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.lang.String typemail200 = obtenerDataUsuarioMail193mtemp.getMail();
        String tempResultmail200 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail200));
        %>
        <%= tempResultmail200 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.lang.String typepassword202 = obtenerDataUsuarioMail193mtemp.getPassword();
        String tempResultpassword202 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword202));
        %>
        <%= tempResultpassword202 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.lang.String typenombre204 = obtenerDataUsuarioMail193mtemp.getNombre();
        String tempResultnombre204 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre204));
        %>
        <%= tempResultnombre204 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.lang.String typeimagen206 = obtenerDataUsuarioMail193mtemp.getImagen();
        String tempResultimagen206 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen206));
        %>
        <%= tempResultimagen206 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail193mtemp != null){
java.lang.String typeapellido208 = obtenerDataUsuarioMail193mtemp.getApellido();
        String tempResultapellido208 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido208));
        %>
        <%= tempResultapellido208 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 212:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0237");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        servidor.DataActividad obtenerDataActividad212mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_8idTemp);
if(obtenerDataActividad212mtemp == null){
%>
<%=obtenerDataActividad212mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.util.Calendar typefechaAlta215 = obtenerDataActividad212mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta215 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta215 = typefechaAlta215.getTime();
        String tempResultfechaAlta215 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta215.format(datefechaAlta215));
        %>
        <%= tempResultfechaAlta215 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.lang.String typedepartamento217 = obtenerDataActividad212mtemp.getDepartamento();
        String tempResultdepartamento217 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento217));
        %>
        <%= tempResultdepartamento217 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
%>
<%=obtenerDataActividad212mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.lang.String typedescripcion221 = obtenerDataActividad212mtemp.getDescripcion();
        String tempResultdescripcion221 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion221));
        %>
        <%= tempResultdescripcion221 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.lang.String typeciudad223 = obtenerDataActividad212mtemp.getCiudad();
        String tempResultciudad223 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad223));
        %>
        <%= tempResultciudad223 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.lang.String typelink225 = obtenerDataActividad212mtemp.getLink();
        String tempResultlink225 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink225));
        %>
        <%= tempResultlink225 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
%>
<%=obtenerDataActividad212mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
%>
<%=obtenerDataActividad212mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
%>
<%=obtenerDataActividad212mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.lang.String typenombre233 = obtenerDataActividad212mtemp.getNombre();
        String tempResultnombre233 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre233));
        %>
        <%= tempResultnombre233 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataActividad212mtemp != null){
java.lang.String typeimagen235 = obtenerDataActividad212mtemp.getImagen();
        String tempResultimagen235 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen235));
        %>
        <%= tempResultimagen235 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 239:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0258");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        servidor.DataSalida obtenerDataSalida239mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_9idTemp);
if(obtenerDataSalida239mtemp == null){
%>
<%=obtenerDataSalida239mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
java.util.Calendar typefechaAlta242 = obtenerDataSalida239mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta242 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta242 = typefechaAlta242.getTime();
        String tempResultfechaAlta242 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta242.format(datefechaAlta242));
        %>
        <%= tempResultfechaAlta242 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
java.util.Calendar typehora244 = obtenerDataSalida239mtemp.getHora();
        java.text.DateFormat dateFormathora244 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora244 = typehora244.getTime();
        String tempResulthora244 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora244.format(datehora244));
        %>
        <%= tempResulthora244 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
java.lang.String typelugar246 = obtenerDataSalida239mtemp.getLugar();
        String tempResultlugar246 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar246));
        %>
        <%= tempResultlugar246 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
%>
<%=obtenerDataSalida239mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
java.lang.String typenombre250 = obtenerDataSalida239mtemp.getNombre();
        String tempResultnombre250 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre250));
        %>
        <%= tempResultnombre250 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
java.lang.String typeimagen252 = obtenerDataSalida239mtemp.getImagen();
        String tempResultimagen252 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen252));
        %>
        <%= tempResultimagen252 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
java.util.Calendar typefecha254 = obtenerDataSalida239mtemp.getFecha();
        java.text.DateFormat dateFormatfecha254 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha254 = typefecha254.getTime();
        String tempResultfecha254 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha254.format(datefecha254));
        %>
        <%= tempResultfecha254 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida239mtemp != null){
%>
<%=obtenerDataSalida239mtemp.getCant()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 260:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0263");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        String arg1_11id=  request.getParameter("arg1265");
            java.util.Calendar arg1_11idTemp = null;
        if(!arg1_11id.equals("")){
        java.text.DateFormat dateFormatarg1265 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1265  = dateFormatarg1265.parse(arg1_11id);
         arg1_11idTemp = new java.util.GregorianCalendar();
        arg1_11idTemp.setTime(dateTemparg1265);
        }
        String arg2_12id=  request.getParameter("arg2267");
        int arg2_12idTemp  = Integer.parseInt(arg2_12id);
        String arg3_13id=  request.getParameter("arg3269");
            java.lang.String arg3_13idTemp = null;
        if(!arg3_13id.equals("")){
         arg3_13idTemp  = arg3_13id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_10idTemp,arg1_11idTemp,arg2_12idTemp,arg3_13idTemp);
break;
case 271:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg0274");
            java.lang.String arg0_14idTemp = null;
        if(!arg0_14id.equals("")){
         arg0_14idTemp  = arg0_14id;
        }
        String arg1_15id=  request.getParameter("arg1276");
            java.lang.String arg1_15idTemp = null;
        if(!arg1_15id.equals("")){
         arg1_15idTemp  = arg1_15id;
        }
        String arg2_16id=  request.getParameter("arg2278");
        int arg2_16idTemp  = Integer.parseInt(arg2_16id);
        String arg3_17id=  request.getParameter("arg3280");
            java.util.Calendar arg3_17idTemp = null;
        if(!arg3_17id.equals("")){
        java.text.DateFormat dateFormatarg3280 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3280  = dateFormatarg3280.parse(arg3_17id);
         arg3_17idTemp = new java.util.GregorianCalendar();
        arg3_17idTemp.setTime(dateTemparg3280);
        }
        String arg4_18id=  request.getParameter("arg4282");
            java.lang.String arg4_18idTemp = null;
        if(!arg4_18id.equals("")){
         arg4_18idTemp  = arg4_18id;
        }
        String arg5_19id=  request.getParameter("arg5284");
            java.lang.String arg5_19idTemp = null;
        if(!arg5_19id.equals("")){
         arg5_19idTemp  = arg5_19id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_14idTemp,arg1_15idTemp,arg2_16idTemp,arg3_17idTemp,arg4_18idTemp,arg5_19idTemp);
break;
case 286:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0289");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        java.lang.Object[] obtenerPaquetesComprados286mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_20idTemp);
if(obtenerPaquetesComprados286mtemp == null){
%>
<%=obtenerPaquetesComprados286mtemp %>
<%
}else{
        String tempreturnp287 = null;
        if(obtenerPaquetesComprados286mtemp != null){
        java.util.List listreturnp287= java.util.Arrays.asList(obtenerPaquetesComprados286mtemp);
        tempreturnp287 = listreturnp287.toString();
        }
        %>
        <%=tempreturnp287%>
        <%
}
break;
case 291:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0294");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        java.lang.String obtenerNomActPorSalida291mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_21idTemp);
if(obtenerNomActPorSalida291mtemp == null){
%>
<%=obtenerNomActPorSalida291mtemp %>
<%
}else{
        String tempResultreturnp292 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida291mtemp));
        %>
        <%= tempResultreturnp292 %>
        <%
}
break;
case 296:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0299");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        String arg1_23id=  request.getParameter("arg1301");
            java.lang.String arg1_23idTemp = null;
        if(!arg1_23id.equals("")){
         arg1_23idTemp  = arg1_23id;
        }
        String arg2_24id=  request.getParameter("arg2303");
        boolean arg2_24idTemp  = Boolean.valueOf(arg2_24id).booleanValue();
        samplePublicadorIControladorProxyid.seguirDejarDeSeguirUsuario(arg0_22idTemp,arg1_23idTemp,arg2_24idTemp);
break;
case 305:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0308");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        String arg1_26id=  request.getParameter("arg1310");
            java.lang.String arg1_26idTemp = null;
        if(!arg1_26id.equals("")){
         arg1_26idTemp  = arg1_26id;
        }
        String arg2_27id=  request.getParameter("arg2312");
        boolean arg2_27idTemp  = Boolean.valueOf(arg2_27id).booleanValue();
        samplePublicadorIControladorProxyid.agregarQuitarActividadFavorita(arg0_25idTemp,arg1_26idTemp,arg2_27idTemp);
break;
case 314:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0317");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        samplePublicadorIControladorProxyid.finalizarActividad(arg0_28idTemp);
break;
case 319:
        gotMethod = true;
        String arg0_29id=  request.getParameter("arg0322");
            java.lang.String arg0_29idTemp = null;
        if(!arg0_29id.equals("")){
         arg0_29idTemp  = arg0_29id;
        }
        java.lang.Object[] selecDepartamento319mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_29idTemp);
if(selecDepartamento319mtemp == null){
%>
<%=selecDepartamento319mtemp %>
<%
}else{
        String tempreturnp320 = null;
        if(selecDepartamento319mtemp != null){
        java.util.List listreturnp320= java.util.Arrays.asList(selecDepartamento319mtemp);
        tempreturnp320 = listreturnp320.toString();
        }
        %>
        <%=tempreturnp320%>
        <%
}
break;
case 324:
        gotMethod = true;
        java.lang.Object[] listarUsuarios324mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios324mtemp == null){
%>
<%=listarUsuarios324mtemp %>
<%
}else{
        String tempreturnp325 = null;
        if(listarUsuarios324mtemp != null){
        java.util.List listreturnp325= java.util.Arrays.asList(listarUsuarios324mtemp);
        tempreturnp325 = listreturnp325.toString();
        }
        %>
        <%=tempreturnp325%>
        <%
}
break;
case 327:
        gotMethod = true;
        java.lang.Object[] listarActividadesAgregadas327mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas327mtemp == null){
%>
<%=listarActividadesAgregadas327mtemp %>
<%
}else{
        String tempreturnp328 = null;
        if(listarActividadesAgregadas327mtemp != null){
        java.util.List listreturnp328= java.util.Arrays.asList(listarActividadesAgregadas327mtemp);
        tempreturnp328 = listreturnp328.toString();
        }
        %>
        <%=tempreturnp328%>
        <%
}
break;
case 330:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 333:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0336");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        String arg1_31id=  request.getParameter("arg1338");
            java.lang.String arg1_31idTemp = null;
        if(!arg1_31id.equals("")){
         arg1_31idTemp  = arg1_31id;
        }
        String arg2_32id=  request.getParameter("arg2340");
            java.lang.String arg2_32idTemp = null;
        if(!arg2_32id.equals("")){
         arg2_32idTemp  = arg2_32id;
        }
        String arg3_33id=  request.getParameter("arg3342");
            java.lang.String arg3_33idTemp = null;
        if(!arg3_33id.equals("")){
         arg3_33idTemp  = arg3_33id;
        }
        String arg4_34id=  request.getParameter("arg4344");
            java.util.Calendar arg4_34idTemp = null;
        if(!arg4_34id.equals("")){
        java.text.DateFormat dateFormatarg4344 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4344  = dateFormatarg4344.parse(arg4_34id);
         arg4_34idTemp = new java.util.GregorianCalendar();
        arg4_34idTemp.setTime(dateTemparg4344);
        }
        String arg5_35id=  request.getParameter("arg5346");
            java.lang.String arg5_35idTemp = null;
        if(!arg5_35id.equals("")){
         arg5_35idTemp  = arg5_35id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_30idTemp,arg1_31idTemp,arg2_32idTemp,arg3_33idTemp,arg4_34idTemp,arg5_35idTemp);
break;
case 348:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0351");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        String arg1_37id=  request.getParameter("arg1353");
            java.lang.String arg1_37idTemp = null;
        if(!arg1_37id.equals("")){
         arg1_37idTemp  = arg1_37id;
        }
        String arg2_38id=  request.getParameter("arg2355");
            java.lang.String arg2_38idTemp = null;
        if(!arg2_38id.equals("")){
         arg2_38idTemp  = arg2_38id;
        }
        String arg3_39id=  request.getParameter("arg3357");
            java.lang.String arg3_39idTemp = null;
        if(!arg3_39id.equals("")){
         arg3_39idTemp  = arg3_39id;
        }
        String arg4_40id=  request.getParameter("arg4359");
            java.util.Calendar arg4_40idTemp = null;
        if(!arg4_40id.equals("")){
        java.text.DateFormat dateFormatarg4359 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4359  = dateFormatarg4359.parse(arg4_40id);
         arg4_40idTemp = new java.util.GregorianCalendar();
        arg4_40idTemp.setTime(dateTemparg4359);
        }
        String arg5_41id=  request.getParameter("arg5361");
            java.lang.String arg5_41idTemp = null;
        if(!arg5_41id.equals("")){
         arg5_41idTemp  = arg5_41id;
        }
        String arg6_42id=  request.getParameter("arg6363");
            java.lang.String arg6_42idTemp = null;
        if(!arg6_42id.equals("")){
         arg6_42idTemp  = arg6_42id;
        }
        String arg7_43id=  request.getParameter("arg7365");
        boolean arg7_43idTemp  = Boolean.valueOf(arg7_43id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_36idTemp,arg1_37idTemp,arg2_38idTemp,arg3_39idTemp,arg4_40idTemp,arg5_41idTemp,arg6_42idTemp,arg7_43idTemp);
break;
case 367:
        gotMethod = true;
        java.lang.Object[] obtenerDataDepartamentos367mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos367mtemp == null){
%>
<%=obtenerDataDepartamentos367mtemp %>
<%
}else{
        String tempreturnp368 = null;
        if(obtenerDataDepartamentos367mtemp != null){
        java.util.List listreturnp368= java.util.Arrays.asList(obtenerDataDepartamentos367mtemp);
        tempreturnp368 = listreturnp368.toString();
        }
        %>
        <%=tempreturnp368%>
        <%
}
break;
case 370:
        gotMethod = true;
        String arg0_44id=  request.getParameter("arg0373");
            java.lang.String arg0_44idTemp = null;
        if(!arg0_44id.equals("")){
         arg0_44idTemp  = arg0_44id;
        }
        java.lang.Object[] salidas370mtemp = samplePublicadorIControladorProxyid.salidas(arg0_44idTemp);
if(salidas370mtemp == null){
%>
<%=salidas370mtemp %>
<%
}else{
        String tempreturnp371 = null;
        if(salidas370mtemp != null){
        java.util.List listreturnp371= java.util.Arrays.asList(salidas370mtemp);
        tempreturnp371 = listreturnp371.toString();
        }
        %>
        <%=tempreturnp371%>
        <%
}
break;
case 375:
        gotMethod = true;
        String arg0_45id=  request.getParameter("arg0378");
            java.lang.String arg0_45idTemp = null;
        if(!arg0_45id.equals("")){
         arg0_45idTemp  = arg0_45id;
        }
        String arg1_46id=  request.getParameter("arg1380");
            java.lang.String arg1_46idTemp = null;
        if(!arg1_46id.equals("")){
         arg1_46idTemp  = arg1_46id;
        }
        String arg2_47id=  request.getParameter("arg2382");
        int arg2_47idTemp  = Integer.parseInt(arg2_47id);
        String arg3_48id=  request.getParameter("arg3384");
            java.util.Calendar arg3_48idTemp = null;
        if(!arg3_48id.equals("")){
        java.text.DateFormat dateFormatarg3384 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3384  = dateFormatarg3384.parse(arg3_48id);
         arg3_48idTemp = new java.util.GregorianCalendar();
        arg3_48idTemp.setTime(dateTemparg3384);
        }
        String arg4_49id=  request.getParameter("arg4386");
            java.lang.String arg4_49idTemp = null;
        if(!arg4_49id.equals("")){
         arg4_49idTemp  = arg4_49id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_45idTemp,arg1_46idTemp,arg2_47idTemp,arg3_48idTemp,arg4_49idTemp);
break;
case 388:
        gotMethod = true;
        java.lang.Object[] getUsuarios388mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios388mtemp == null){
%>
<%=getUsuarios388mtemp %>
<%
}else{
        String tempreturnp389 = null;
        if(getUsuarios388mtemp != null){
        java.util.List listreturnp389= java.util.Arrays.asList(getUsuarios388mtemp);
        tempreturnp389 = listreturnp389.toString();
        }
        %>
        <%=tempreturnp389%>
        <%
}
break;
case 391:
        gotMethod = true;
        java.lang.Object[] obtenerNombreCategorias391mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias391mtemp == null){
%>
<%=obtenerNombreCategorias391mtemp %>
<%
}else{
        String tempreturnp392 = null;
        if(obtenerNombreCategorias391mtemp != null){
        java.util.List listreturnp392= java.util.Arrays.asList(obtenerNombreCategorias391mtemp);
        tempreturnp392 = listreturnp392.toString();
        }
        %>
        <%=tempreturnp392%>
        <%
}
break;
case 394:
        gotMethod = true;
        String arg0_50id=  request.getParameter("arg0397");
            java.lang.String arg0_50idTemp = null;
        if(!arg0_50id.equals("")){
         arg0_50idTemp  = arg0_50id;
        }
        String arg1_51id=  request.getParameter("arg1399");
            java.lang.String arg1_51idTemp = null;
        if(!arg1_51id.equals("")){
         arg1_51idTemp  = arg1_51id;
        }
        String arg2_52id=  request.getParameter("arg2401");
            java.lang.String arg2_52idTemp = null;
        if(!arg2_52id.equals("")){
         arg2_52idTemp  = arg2_52id;
        }
        String arg3_53id=  request.getParameter("arg3403");
            java.lang.String arg3_53idTemp = null;
        if(!arg3_53id.equals("")){
         arg3_53idTemp  = arg3_53id;
        }
        String arg4_54id=  request.getParameter("arg4405");
            java.util.Calendar arg4_54idTemp = null;
        if(!arg4_54id.equals("")){
        java.text.DateFormat dateFormatarg4405 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4405  = dateFormatarg4405.parse(arg4_54id);
         arg4_54idTemp = new java.util.GregorianCalendar();
        arg4_54idTemp.setTime(dateTemparg4405);
        }
        String arg5_55id=  request.getParameter("arg5407");
            java.lang.String arg5_55idTemp = null;
        if(!arg5_55id.equals("")){
         arg5_55idTemp  = arg5_55id;
        }
        String arg6_56id=  request.getParameter("arg6409");
            java.lang.String arg6_56idTemp = null;
        if(!arg6_56id.equals("")){
         arg6_56idTemp  = arg6_56id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_50idTemp,arg1_51idTemp,arg2_52idTemp,arg3_53idTemp,arg4_54idTemp,arg5_55idTemp,arg6_56idTemp);
break;
case 411:
        gotMethod = true;
        String arg0_57id=  request.getParameter("arg0414");
            java.lang.String arg0_57idTemp = null;
        if(!arg0_57id.equals("")){
         arg0_57idTemp  = arg0_57id;
        }
        String arg1_58id=  request.getParameter("arg1416");
            java.lang.String arg1_58idTemp = null;
        if(!arg1_58id.equals("")){
         arg1_58idTemp  = arg1_58id;
        }
        String arg2_59id=  request.getParameter("arg2418");
            java.lang.String arg2_59idTemp = null;
        if(!arg2_59id.equals("")){
         arg2_59idTemp  = arg2_59id;
        }
        String arg3_60id=  request.getParameter("arg3420");
            java.lang.String arg3_60idTemp = null;
        if(!arg3_60id.equals("")){
         arg3_60idTemp  = arg3_60id;
        }
        String arg4_61id=  request.getParameter("arg4422");
            java.util.Calendar arg4_61idTemp = null;
        if(!arg4_61id.equals("")){
        java.text.DateFormat dateFormatarg4422 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4422  = dateFormatarg4422.parse(arg4_61id);
         arg4_61idTemp = new java.util.GregorianCalendar();
        arg4_61idTemp.setTime(dateTemparg4422);
        }
        String arg5_62id=  request.getParameter("arg5424");
            java.lang.String arg5_62idTemp = null;
        if(!arg5_62id.equals("")){
         arg5_62idTemp  = arg5_62id;
        }
        String arg6_63id=  request.getParameter("arg6426");
            java.lang.String arg6_63idTemp = null;
        if(!arg6_63id.equals("")){
         arg6_63idTemp  = arg6_63id;
        }
        String arg7_64id=  request.getParameter("arg7428");
        boolean arg7_64idTemp  = Boolean.valueOf(arg7_64id).booleanValue();
        String arg8_65id=  request.getParameter("arg8430");
            java.lang.String arg8_65idTemp = null;
        if(!arg8_65id.equals("")){
         arg8_65idTemp  = arg8_65id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_57idTemp,arg1_58idTemp,arg2_59idTemp,arg3_60idTemp,arg4_61idTemp,arg5_62idTemp,arg6_63idTemp,arg7_64idTemp,arg8_65idTemp);
break;
case 432:
        gotMethod = true;
        String arg0_66id=  request.getParameter("arg0435");
            java.lang.String arg0_66idTemp = null;
        if(!arg0_66id.equals("")){
         arg0_66idTemp  = arg0_66id;
        }
        String arg1_67id=  request.getParameter("arg1437");
            java.lang.String arg1_67idTemp = null;
        if(!arg1_67id.equals("")){
         arg1_67idTemp  = arg1_67id;
        }
        String arg2_68id=  request.getParameter("arg2439");
            java.util.Calendar arg2_68idTemp = null;
        if(!arg2_68id.equals("")){
        java.text.DateFormat dateFormatarg2439 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2439  = dateFormatarg2439.parse(arg2_68id);
         arg2_68idTemp = new java.util.GregorianCalendar();
        arg2_68idTemp.setTime(dateTemparg2439);
        }
        String arg3_69id=  request.getParameter("arg3441");
            java.util.Calendar arg3_69idTemp = null;
        if(!arg3_69id.equals("")){
        java.text.DateFormat dateFormatarg3441 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3441  = dateFormatarg3441.parse(arg3_69id);
         arg3_69idTemp = new java.util.GregorianCalendar();
        arg3_69idTemp.setTime(dateTemparg3441);
        }
        String arg4_70id=  request.getParameter("arg4443");
            java.lang.String arg4_70idTemp = null;
        if(!arg4_70id.equals("")){
         arg4_70idTemp  = arg4_70id;
        }
        String arg5_71id=  request.getParameter("arg5445");
        int arg5_71idTemp  = Integer.parseInt(arg5_71id);
        String arg6_72id=  request.getParameter("arg6447");
            java.util.Calendar arg6_72idTemp = null;
        if(!arg6_72id.equals("")){
        java.text.DateFormat dateFormatarg6447 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6447  = dateFormatarg6447.parse(arg6_72id);
         arg6_72idTemp = new java.util.GregorianCalendar();
        arg6_72idTemp.setTime(dateTemparg6447);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_66idTemp,arg1_67idTemp,arg2_68idTemp,arg3_69idTemp,arg4_70idTemp,arg5_71idTemp,arg6_72idTemp);
break;
case 449:
        gotMethod = true;
        java.lang.Object[] listarPaquetes449mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes449mtemp == null){
%>
<%=listarPaquetes449mtemp %>
<%
}else{
        String tempreturnp450 = null;
        if(listarPaquetes449mtemp != null){
        java.util.List listreturnp450= java.util.Arrays.asList(listarPaquetes449mtemp);
        tempreturnp450 = listreturnp450.toString();
        }
        %>
        <%=tempreturnp450%>
        <%
}
break;
case 452:
        gotMethod = true;
        String arg0_73id=  request.getParameter("arg0467");
            java.lang.String arg0_73idTemp = null;
        if(!arg0_73id.equals("")){
         arg0_73idTemp  = arg0_73id;
        }
        servidor.DataPaquete obtenerDataPaquete452mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_73idTemp);
if(obtenerDataPaquete452mtemp == null){
%>
<%=obtenerDataPaquete452mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descuento:</TD>
<TD>
<%
if(obtenerDataPaquete452mtemp != null){
%>
<%=obtenerDataPaquete452mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete452mtemp != null){
java.util.Calendar typefechaAlta457 = obtenerDataPaquete452mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta457 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta457 = typefechaAlta457.getTime();
        String tempResultfechaAlta457 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta457.format(datefechaAlta457));
        %>
        <%= tempResultfechaAlta457 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete452mtemp != null){
java.lang.String typedescripcion459 = obtenerDataPaquete452mtemp.getDescripcion();
        String tempResultdescripcion459 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion459));
        %>
        <%= tempResultdescripcion459 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete452mtemp != null){
%>
<%=obtenerDataPaquete452mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete452mtemp != null){
java.lang.String typenombre463 = obtenerDataPaquete452mtemp.getNombre();
        String tempResultnombre463 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre463));
        %>
        <%= tempResultnombre463 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete452mtemp != null){
java.lang.String typeimagen465 = obtenerDataPaquete452mtemp.getImagen();
        String tempResultimagen465 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen465));
        %>
        <%= tempResultimagen465 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 469:
        gotMethod = true;
        java.lang.Object[] listarPaquetesNoComprados469mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados469mtemp == null){
%>
<%=listarPaquetesNoComprados469mtemp %>
<%
}else{
        String tempreturnp470 = null;
        if(listarPaquetesNoComprados469mtemp != null){
        java.util.List listreturnp470= java.util.Arrays.asList(listarPaquetesNoComprados469mtemp);
        tempreturnp470 = listreturnp470.toString();
        }
        %>
        <%=tempreturnp470%>
        <%
}
break;
case 472:
        gotMethod = true;
        String arg0_74id=  request.getParameter("arg0475");
            java.lang.String arg0_74idTemp = null;
        if(!arg0_74id.equals("")){
         arg0_74idTemp  = arg0_74id;
        }
        String arg1_75id=  request.getParameter("arg1477");
            java.lang.String arg1_75idTemp = null;
        if(!arg1_75id.equals("")){
         arg1_75idTemp  = arg1_75id;
        }
        java.lang.Object[] actividadesPorDepartamentoNoEnPaquete472mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_74idTemp,arg1_75idTemp);
if(actividadesPorDepartamentoNoEnPaquete472mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete472mtemp %>
<%
}else{
        String tempreturnp473 = null;
        if(actividadesPorDepartamentoNoEnPaquete472mtemp != null){
        java.util.List listreturnp473= java.util.Arrays.asList(actividadesPorDepartamentoNoEnPaquete472mtemp);
        tempreturnp473 = listreturnp473.toString();
        }
        %>
        <%=tempreturnp473%>
        <%
}
break;
case 479:
        gotMethod = true;
        String fileName_76id=  request.getParameter("fileName482");
            java.lang.String fileName_76idTemp = null;
        if(!fileName_76id.equals("")){
         fileName_76idTemp  = fileName_76id;
        }
        byte[] getFile479mtemp = samplePublicadorIControladorProxyid.getFile(fileName_76idTemp);
if(getFile479mtemp == null){
%>
<%=getFile479mtemp %>
<%
}else{
        String tempreturnp480 = "[";        for(int ireturnp480=0;ireturnp480< getFile479mtemp.length;ireturnp480++){
            tempreturnp480 = tempreturnp480 + getFile479mtemp[ireturnp480] + ",";
        }
        int lengthreturnp480 = tempreturnp480.length();
        tempreturnp480 = tempreturnp480.substring(0,(lengthreturnp480 - 1)) + "]";
        %>
        <%=tempreturnp480%>
        <%
}
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