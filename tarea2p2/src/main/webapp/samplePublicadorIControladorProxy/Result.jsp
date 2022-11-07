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
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typenombre47 = dataActividadNull32mtemp.getNombre();
        String tempResultnombre47 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre47));
        %>
        <%= tempResultnombre47 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataActividadNull32mtemp != null){
java.lang.String typeimagen49 = dataActividadNull32mtemp.getImagen();
        String tempResultimagen49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen49));
        %>
        <%= tempResultimagen49 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 51:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull51mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull51mtemp == null){
%>
<%=dataCGNull51mtemp %>
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
if(dataCGNull51mtemp != null){
java.util.Calendar typefecha54 = dataCGNull51mtemp.getFecha();
        java.text.DateFormat dateFormatfecha54 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha54 = typefecha54.getTime();
        String tempResultfecha54 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha54.format(datefecha54));
        %>
        <%= tempResultfecha54 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">salida:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora58 = tebece0.getHora();
        java.text.DateFormat dateFormathora58 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora58 = typehora58.getTime();
        String tempResulthora58 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora58.format(datehora58));
        %>
        <%= tempResulthora58 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha60 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha60 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha60 = typefecha60.getTime();
        String tempResultfecha60 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha60.format(datefecha60));
        %>
        <%= tempResultfecha60 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
if(tebece0 != null){
%>
<%=tebece0.getCant()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
if(tebece0 != null){
java.lang.String typeimagen64 = tebece0.getImagen();
        String tempResultimagen64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen64));
        %>
        <%= tempResultimagen64 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta66 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta66 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta66 = typefechaAlta66.getTime();
        String tempResultfechaAlta66 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta66.format(datefechaAlta66));
        %>
        <%= tempResultfechaAlta66 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
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
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
servidor.DataSalida tebece0=dataCGNull51mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre70 = tebece0.getNombre();
        String tempResultnombre70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre70));
        %>
        <%= tempResultnombre70 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">porPaquete:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
%>
<%=dataCGNull51mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
%>
<%=dataCGNull51mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull51mtemp != null){
%>
<%=dataCGNull51mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 78:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull78mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull78mtemp == null){
%>
<%=dataCPNull78mtemp %>
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
if(dataCPNull78mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct81 = dataCPNull78mtemp.getRestAct();
        String temprestAct81 = null;
        if(typerestAct81 != null){
        java.util.List listrestAct81= java.util.Arrays.asList(typerestAct81);
        temprestAct81 = listrestAct81.toString();
        }
        %>
        <%=temprestAct81%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
java.util.Calendar typefecha83 = dataCPNull78mtemp.getFecha();
        java.text.DateFormat dateFormatfecha83 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha83 = typefecha83.getTime();
        String tempResultfecha83 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha83.format(datefecha83));
        %>
        <%= tempResultfecha83 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
%>
<%=dataCPNull78mtemp.getCantidad()
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
if(dataCPNull78mtemp != null){
servidor.DataPaquete tebece0=dataCPNull78mtemp.getPaq();
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
if(dataCPNull78mtemp != null){
servidor.DataPaquete tebece0=dataCPNull78mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta91 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta91 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta91 = typefechaAlta91.getTime();
        String tempResultfechaAlta91 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta91.format(datefechaAlta91));
        %>
        <%= tempResultfechaAlta91 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
servidor.DataPaquete tebece0=dataCPNull78mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion93 = tebece0.getDescripcion();
        String tempResultdescripcion93 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion93));
        %>
        <%= tempResultdescripcion93 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
servidor.DataPaquete tebece0=dataCPNull78mtemp.getPaq();
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
if(dataCPNull78mtemp != null){
servidor.DataPaquete tebece0=dataCPNull78mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre97 = tebece0.getNombre();
        String tempResultnombre97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre97));
        %>
        <%= tempResultnombre97 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
servidor.DataPaquete tebece0=dataCPNull78mtemp.getPaq();
if(tebece0 != null){
java.lang.String typeimagen99 = tebece0.getImagen();
        String tempResultimagen99 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen99));
        %>
        <%= tempResultimagen99 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
java.util.Calendar typevencimiento101 = dataCPNull78mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento101 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento101 = typevencimiento101.getTime();
        String tempResultvencimiento101 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento101.format(datevencimiento101));
        %>
        <%= tempResultvencimiento101 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull78mtemp != null){
%>
<%=dataCPNull78mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 105:
        gotMethod = true;
        servidor.EstadoAct estadoActNull105mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull105mtemp == null){
%>
<%=estadoActNull105mtemp %>
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
case 110:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg0127");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        servidor.DataUsuario verInfoUsuario110mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_1idTemp);
if(verInfoUsuario110mtemp == null){
%>
<%=verInfoUsuario110mtemp %>
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
if(verInfoUsuario110mtemp != null){
java.util.Calendar typenacimiento113 = verInfoUsuario110mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento113 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento113 = typenacimiento113.getTime();
        String tempResultnacimiento113 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento113.format(datenacimiento113));
        %>
        <%= tempResultnacimiento113 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario110mtemp != null){
java.lang.String typenick115 = verInfoUsuario110mtemp.getNick();
        String tempResultnick115 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick115));
        %>
        <%= tempResultnick115 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario110mtemp != null){
java.lang.String typemail117 = verInfoUsuario110mtemp.getMail();
        String tempResultmail117 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail117));
        %>
        <%= tempResultmail117 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario110mtemp != null){
java.lang.String typepassword119 = verInfoUsuario110mtemp.getPassword();
        String tempResultpassword119 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword119));
        %>
        <%= tempResultpassword119 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario110mtemp != null){
java.lang.String typenombre121 = verInfoUsuario110mtemp.getNombre();
        String tempResultnombre121 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre121));
        %>
        <%= tempResultnombre121 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(verInfoUsuario110mtemp != null){
java.lang.String typeimagen123 = verInfoUsuario110mtemp.getImagen();
        String tempResultimagen123 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen123));
        %>
        <%= tempResultimagen123 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario110mtemp != null){
java.lang.String typeapellido125 = verInfoUsuario110mtemp.getApellido();
        String tempResultapellido125 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido125));
        %>
        <%= tempResultapellido125 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 129:
        gotMethod = true;
        java.lang.Object[] getUsuariosComp129mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp129mtemp == null){
%>
<%=getUsuariosComp129mtemp %>
<%
}else{
        String tempreturnp130 = null;
        if(getUsuariosComp129mtemp != null){
        java.util.List listreturnp130= java.util.Arrays.asList(getUsuariosComp129mtemp);
        tempreturnp130 = listreturnp130.toString();
        }
        %>
        <%=tempreturnp130%>
        <%
}
break;
case 132:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg0149");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        servidor.DataUsuario ingresarDatos132mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_2idTemp);
if(ingresarDatos132mtemp == null){
%>
<%=ingresarDatos132mtemp %>
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
if(ingresarDatos132mtemp != null){
java.util.Calendar typenacimiento135 = ingresarDatos132mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento135 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento135 = typenacimiento135.getTime();
        String tempResultnacimiento135 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento135.format(datenacimiento135));
        %>
        <%= tempResultnacimiento135 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos132mtemp != null){
java.lang.String typenick137 = ingresarDatos132mtemp.getNick();
        String tempResultnick137 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick137));
        %>
        <%= tempResultnick137 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos132mtemp != null){
java.lang.String typemail139 = ingresarDatos132mtemp.getMail();
        String tempResultmail139 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail139));
        %>
        <%= tempResultmail139 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos132mtemp != null){
java.lang.String typepassword141 = ingresarDatos132mtemp.getPassword();
        String tempResultpassword141 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword141));
        %>
        <%= tempResultpassword141 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos132mtemp != null){
java.lang.String typenombre143 = ingresarDatos132mtemp.getNombre();
        String tempResultnombre143 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre143));
        %>
        <%= tempResultnombre143 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(ingresarDatos132mtemp != null){
java.lang.String typeimagen145 = ingresarDatos132mtemp.getImagen();
        String tempResultimagen145 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen145));
        %>
        <%= tempResultimagen145 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos132mtemp != null){
java.lang.String typeapellido147 = ingresarDatos132mtemp.getApellido();
        String tempResultapellido147 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido147));
        %>
        <%= tempResultapellido147 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 151:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg0154");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        java.lang.Object[] obtenerActividadCategoria151mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_3idTemp);
if(obtenerActividadCategoria151mtemp == null){
%>
<%=obtenerActividadCategoria151mtemp %>
<%
}else{
        String tempreturnp152 = null;
        if(obtenerActividadCategoria151mtemp != null){
        java.util.List listreturnp152= java.util.Arrays.asList(obtenerActividadCategoria151mtemp);
        tempreturnp152 = listreturnp152.toString();
        }
        %>
        <%=tempreturnp152%>
        <%
}
break;
case 156:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0173");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick156mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_4idTemp);
if(obtenerDataUsuarioNick156mtemp == null){
%>
<%=obtenerDataUsuarioNick156mtemp %>
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
if(obtenerDataUsuarioNick156mtemp != null){
java.util.Calendar typenacimiento159 = obtenerDataUsuarioNick156mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento159 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento159 = typenacimiento159.getTime();
        String tempResultnacimiento159 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento159.format(datenacimiento159));
        %>
        <%= tempResultnacimiento159 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick156mtemp != null){
java.lang.String typenick161 = obtenerDataUsuarioNick156mtemp.getNick();
        String tempResultnick161 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick161));
        %>
        <%= tempResultnick161 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick156mtemp != null){
java.lang.String typemail163 = obtenerDataUsuarioNick156mtemp.getMail();
        String tempResultmail163 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail163));
        %>
        <%= tempResultmail163 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick156mtemp != null){
java.lang.String typepassword165 = obtenerDataUsuarioNick156mtemp.getPassword();
        String tempResultpassword165 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword165));
        %>
        <%= tempResultpassword165 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick156mtemp != null){
java.lang.String typenombre167 = obtenerDataUsuarioNick156mtemp.getNombre();
        String tempResultnombre167 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre167));
        %>
        <%= tempResultnombre167 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioNick156mtemp != null){
java.lang.String typeimagen169 = obtenerDataUsuarioNick156mtemp.getImagen();
        String tempResultimagen169 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen169));
        %>
        <%= tempResultimagen169 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick156mtemp != null){
java.lang.String typeapellido171 = obtenerDataUsuarioNick156mtemp.getApellido();
        String tempResultapellido171 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido171));
        %>
        <%= tempResultapellido171 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 175:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg0192");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail175mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_5idTemp);
if(obtenerDataUsuarioMail175mtemp == null){
%>
<%=obtenerDataUsuarioMail175mtemp %>
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
if(obtenerDataUsuarioMail175mtemp != null){
java.util.Calendar typenacimiento178 = obtenerDataUsuarioMail175mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento178 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento178 = typenacimiento178.getTime();
        String tempResultnacimiento178 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento178.format(datenacimiento178));
        %>
        <%= tempResultnacimiento178 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail175mtemp != null){
java.lang.String typenick180 = obtenerDataUsuarioMail175mtemp.getNick();
        String tempResultnick180 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick180));
        %>
        <%= tempResultnick180 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail175mtemp != null){
java.lang.String typemail182 = obtenerDataUsuarioMail175mtemp.getMail();
        String tempResultmail182 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail182));
        %>
        <%= tempResultmail182 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail175mtemp != null){
java.lang.String typepassword184 = obtenerDataUsuarioMail175mtemp.getPassword();
        String tempResultpassword184 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword184));
        %>
        <%= tempResultpassword184 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail175mtemp != null){
java.lang.String typenombre186 = obtenerDataUsuarioMail175mtemp.getNombre();
        String tempResultnombre186 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre186));
        %>
        <%= tempResultnombre186 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioMail175mtemp != null){
java.lang.String typeimagen188 = obtenerDataUsuarioMail175mtemp.getImagen();
        String tempResultimagen188 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen188));
        %>
        <%= tempResultimagen188 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail175mtemp != null){
java.lang.String typeapellido190 = obtenerDataUsuarioMail175mtemp.getApellido();
        String tempResultapellido190 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido190));
        %>
        <%= tempResultapellido190 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 194:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0213");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        servidor.DataActividad obtenerDataActividad194mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_6idTemp);
if(obtenerDataActividad194mtemp == null){
%>
<%=obtenerDataActividad194mtemp %>
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
if(obtenerDataActividad194mtemp != null){
java.util.Calendar typefechaAlta197 = obtenerDataActividad194mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta197 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta197 = typefechaAlta197.getTime();
        String tempResultfechaAlta197 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta197.format(datefechaAlta197));
        %>
        <%= tempResultfechaAlta197 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
java.lang.String typedepartamento199 = obtenerDataActividad194mtemp.getDepartamento();
        String tempResultdepartamento199 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento199));
        %>
        <%= tempResultdepartamento199 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
%>
<%=obtenerDataActividad194mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
java.lang.String typedescripcion203 = obtenerDataActividad194mtemp.getDescripcion();
        String tempResultdescripcion203 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion203));
        %>
        <%= tempResultdescripcion203 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
java.lang.String typeciudad205 = obtenerDataActividad194mtemp.getCiudad();
        String tempResultciudad205 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad205));
        %>
        <%= tempResultciudad205 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
%>
<%=obtenerDataActividad194mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
java.lang.String typenombre209 = obtenerDataActividad194mtemp.getNombre();
        String tempResultnombre209 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre209));
        %>
        <%= tempResultnombre209 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataActividad194mtemp != null){
java.lang.String typeimagen211 = obtenerDataActividad194mtemp.getImagen();
        String tempResultimagen211 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen211));
        %>
        <%= tempResultimagen211 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 215:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0232");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        servidor.DataSalida obtenerDataSalida215mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_7idTemp);
if(obtenerDataSalida215mtemp == null){
%>
<%=obtenerDataSalida215mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
java.util.Calendar typehora218 = obtenerDataSalida215mtemp.getHora();
        java.text.DateFormat dateFormathora218 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora218 = typehora218.getTime();
        String tempResulthora218 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora218.format(datehora218));
        %>
        <%= tempResulthora218 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
java.util.Calendar typefecha220 = obtenerDataSalida215mtemp.getFecha();
        java.text.DateFormat dateFormatfecha220 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha220 = typefecha220.getTime();
        String tempResultfecha220 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha220.format(datefecha220));
        %>
        <%= tempResultfecha220 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
%>
<%=obtenerDataSalida215mtemp.getCant()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
java.lang.String typeimagen224 = obtenerDataSalida215mtemp.getImagen();
        String tempResultimagen224 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen224));
        %>
        <%= tempResultimagen224 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
java.util.Calendar typefechaAlta226 = obtenerDataSalida215mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta226 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta226 = typefechaAlta226.getTime();
        String tempResultfechaAlta226 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta226.format(datefechaAlta226));
        %>
        <%= tempResultfechaAlta226 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
java.lang.String typelugar228 = obtenerDataSalida215mtemp.getLugar();
        String tempResultlugar228 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar228));
        %>
        <%= tempResultlugar228 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida215mtemp != null){
java.lang.String typenombre230 = obtenerDataSalida215mtemp.getNombre();
        String tempResultnombre230 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre230));
        %>
        <%= tempResultnombre230 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 234:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0237");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        String arg1_9id=  request.getParameter("arg1239");
            java.util.Calendar arg1_9idTemp = null;
        if(!arg1_9id.equals("")){
        java.text.DateFormat dateFormatarg1239 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1239  = dateFormatarg1239.parse(arg1_9id);
         arg1_9idTemp = new java.util.GregorianCalendar();
        arg1_9idTemp.setTime(dateTemparg1239);
        }
        String arg2_10id=  request.getParameter("arg2241");
        int arg2_10idTemp  = Integer.parseInt(arg2_10id);
        String arg3_11id=  request.getParameter("arg3243");
            java.lang.String arg3_11idTemp = null;
        if(!arg3_11id.equals("")){
         arg3_11idTemp  = arg3_11id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_8idTemp,arg1_9idTemp,arg2_10idTemp,arg3_11idTemp);
break;
case 245:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg0248");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg1250");
            java.lang.String arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
         arg1_13idTemp  = arg1_13id;
        }
        String arg2_14id=  request.getParameter("arg2252");
        int arg2_14idTemp  = Integer.parseInt(arg2_14id);
        String arg3_15id=  request.getParameter("arg3254");
            java.util.Calendar arg3_15idTemp = null;
        if(!arg3_15id.equals("")){
        java.text.DateFormat dateFormatarg3254 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3254  = dateFormatarg3254.parse(arg3_15id);
         arg3_15idTemp = new java.util.GregorianCalendar();
        arg3_15idTemp.setTime(dateTemparg3254);
        }
        String arg4_16id=  request.getParameter("arg4256");
            java.lang.String arg4_16idTemp = null;
        if(!arg4_16id.equals("")){
         arg4_16idTemp  = arg4_16id;
        }
        String arg5_17id=  request.getParameter("arg5258");
            java.lang.String arg5_17idTemp = null;
        if(!arg5_17id.equals("")){
         arg5_17idTemp  = arg5_17id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_12idTemp,arg1_13idTemp,arg2_14idTemp,arg3_15idTemp,arg4_16idTemp,arg5_17idTemp);
break;
case 260:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg0263");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        java.lang.Object[] obtenerPaquetesComprados260mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_18idTemp);
if(obtenerPaquetesComprados260mtemp == null){
%>
<%=obtenerPaquetesComprados260mtemp %>
<%
}else{
        String tempreturnp261 = null;
        if(obtenerPaquetesComprados260mtemp != null){
        java.util.List listreturnp261= java.util.Arrays.asList(obtenerPaquetesComprados260mtemp);
        tempreturnp261 = listreturnp261.toString();
        }
        %>
        <%=tempreturnp261%>
        <%
}
break;
case 265:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0268");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        java.lang.String obtenerNomActPorSalida265mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_19idTemp);
if(obtenerNomActPorSalida265mtemp == null){
%>
<%=obtenerNomActPorSalida265mtemp %>
<%
}else{
        String tempResultreturnp266 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida265mtemp));
        %>
        <%= tempResultreturnp266 %>
        <%
}
break;
case 270:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0273");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        String arg1_21id=  request.getParameter("arg1275");
            java.lang.String arg1_21idTemp = null;
        if(!arg1_21id.equals("")){
         arg1_21idTemp  = arg1_21id;
        }
        String arg2_22id=  request.getParameter("arg2277");
        boolean arg2_22idTemp  = Boolean.valueOf(arg2_22id).booleanValue();
        samplePublicadorIControladorProxyid.seguirDejarDeSeguirUsuario(arg0_20idTemp,arg1_21idTemp,arg2_22idTemp);
break;
case 279:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0282");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg1284");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        String arg2_25id=  request.getParameter("arg2286");
        boolean arg2_25idTemp  = Boolean.valueOf(arg2_25id).booleanValue();
        samplePublicadorIControladorProxyid.agregarQuitarActividadFavorita(arg0_23idTemp,arg1_24idTemp,arg2_25idTemp);
break;
case 288:
        gotMethod = true;
        String arg0_26id=  request.getParameter("arg0291");
            java.lang.String arg0_26idTemp = null;
        if(!arg0_26id.equals("")){
         arg0_26idTemp  = arg0_26id;
        }
        samplePublicadorIControladorProxyid.finalizarActividad(arg0_26idTemp);
break;
case 293:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0296");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        java.lang.Object[] selecDepartamento293mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_27idTemp);
if(selecDepartamento293mtemp == null){
%>
<%=selecDepartamento293mtemp %>
<%
}else{
        String tempreturnp294 = null;
        if(selecDepartamento293mtemp != null){
        java.util.List listreturnp294= java.util.Arrays.asList(selecDepartamento293mtemp);
        tempreturnp294 = listreturnp294.toString();
        }
        %>
        <%=tempreturnp294%>
        <%
}
break;
case 298:
        gotMethod = true;
        java.lang.Object[] listarUsuarios298mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios298mtemp == null){
%>
<%=listarUsuarios298mtemp %>
<%
}else{
        String tempreturnp299 = null;
        if(listarUsuarios298mtemp != null){
        java.util.List listreturnp299= java.util.Arrays.asList(listarUsuarios298mtemp);
        tempreturnp299 = listreturnp299.toString();
        }
        %>
        <%=tempreturnp299%>
        <%
}
break;
case 301:
        gotMethod = true;
        java.lang.Object[] listarActividadesAgregadas301mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas301mtemp == null){
%>
<%=listarActividadesAgregadas301mtemp %>
<%
}else{
        String tempreturnp302 = null;
        if(listarActividadesAgregadas301mtemp != null){
        java.util.List listreturnp302= java.util.Arrays.asList(listarActividadesAgregadas301mtemp);
        tempreturnp302 = listreturnp302.toString();
        }
        %>
        <%=tempreturnp302%>
        <%
}
break;
case 304:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 307:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0310");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        String arg1_29id=  request.getParameter("arg1312");
            java.lang.String arg1_29idTemp = null;
        if(!arg1_29id.equals("")){
         arg1_29idTemp  = arg1_29id;
        }
        String arg2_30id=  request.getParameter("arg2314");
            java.lang.String arg2_30idTemp = null;
        if(!arg2_30id.equals("")){
         arg2_30idTemp  = arg2_30id;
        }
        String arg3_31id=  request.getParameter("arg3316");
            java.lang.String arg3_31idTemp = null;
        if(!arg3_31id.equals("")){
         arg3_31idTemp  = arg3_31id;
        }
        String arg4_32id=  request.getParameter("arg4318");
            java.util.Calendar arg4_32idTemp = null;
        if(!arg4_32id.equals("")){
        java.text.DateFormat dateFormatarg4318 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4318  = dateFormatarg4318.parse(arg4_32id);
         arg4_32idTemp = new java.util.GregorianCalendar();
        arg4_32idTemp.setTime(dateTemparg4318);
        }
        String arg5_33id=  request.getParameter("arg5320");
            java.lang.String arg5_33idTemp = null;
        if(!arg5_33id.equals("")){
         arg5_33idTemp  = arg5_33id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_28idTemp,arg1_29idTemp,arg2_30idTemp,arg3_31idTemp,arg4_32idTemp,arg5_33idTemp);
break;
case 322:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0325");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        String arg1_35id=  request.getParameter("arg1327");
            java.lang.String arg1_35idTemp = null;
        if(!arg1_35id.equals("")){
         arg1_35idTemp  = arg1_35id;
        }
        String arg2_36id=  request.getParameter("arg2329");
            java.lang.String arg2_36idTemp = null;
        if(!arg2_36id.equals("")){
         arg2_36idTemp  = arg2_36id;
        }
        String arg3_37id=  request.getParameter("arg3331");
            java.lang.String arg3_37idTemp = null;
        if(!arg3_37id.equals("")){
         arg3_37idTemp  = arg3_37id;
        }
        String arg4_38id=  request.getParameter("arg4333");
            java.util.Calendar arg4_38idTemp = null;
        if(!arg4_38id.equals("")){
        java.text.DateFormat dateFormatarg4333 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4333  = dateFormatarg4333.parse(arg4_38id);
         arg4_38idTemp = new java.util.GregorianCalendar();
        arg4_38idTemp.setTime(dateTemparg4333);
        }
        String arg5_39id=  request.getParameter("arg5335");
            java.lang.String arg5_39idTemp = null;
        if(!arg5_39id.equals("")){
         arg5_39idTemp  = arg5_39id;
        }
        String arg6_40id=  request.getParameter("arg6337");
            java.lang.String arg6_40idTemp = null;
        if(!arg6_40id.equals("")){
         arg6_40idTemp  = arg6_40id;
        }
        String arg7_41id=  request.getParameter("arg7339");
        boolean arg7_41idTemp  = Boolean.valueOf(arg7_41id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_34idTemp,arg1_35idTemp,arg2_36idTemp,arg3_37idTemp,arg4_38idTemp,arg5_39idTemp,arg6_40idTemp,arg7_41idTemp);
break;
case 341:
        gotMethod = true;
        java.lang.Object[] obtenerDataDepartamentos341mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos341mtemp == null){
%>
<%=obtenerDataDepartamentos341mtemp %>
<%
}else{
        String tempreturnp342 = null;
        if(obtenerDataDepartamentos341mtemp != null){
        java.util.List listreturnp342= java.util.Arrays.asList(obtenerDataDepartamentos341mtemp);
        tempreturnp342 = listreturnp342.toString();
        }
        %>
        <%=tempreturnp342%>
        <%
}
break;
case 344:
        gotMethod = true;
        String arg0_42id=  request.getParameter("arg0347");
            java.lang.String arg0_42idTemp = null;
        if(!arg0_42id.equals("")){
         arg0_42idTemp  = arg0_42id;
        }
        java.lang.Object[] salidas344mtemp = samplePublicadorIControladorProxyid.salidas(arg0_42idTemp);
if(salidas344mtemp == null){
%>
<%=salidas344mtemp %>
<%
}else{
        String tempreturnp345 = null;
        if(salidas344mtemp != null){
        java.util.List listreturnp345= java.util.Arrays.asList(salidas344mtemp);
        tempreturnp345 = listreturnp345.toString();
        }
        %>
        <%=tempreturnp345%>
        <%
}
break;
case 349:
        gotMethod = true;
        String arg0_43id=  request.getParameter("arg0352");
            java.lang.String arg0_43idTemp = null;
        if(!arg0_43id.equals("")){
         arg0_43idTemp  = arg0_43id;
        }
        String arg1_44id=  request.getParameter("arg1354");
            java.lang.String arg1_44idTemp = null;
        if(!arg1_44id.equals("")){
         arg1_44idTemp  = arg1_44id;
        }
        String arg2_45id=  request.getParameter("arg2356");
        int arg2_45idTemp  = Integer.parseInt(arg2_45id);
        String arg3_46id=  request.getParameter("arg3358");
            java.util.Calendar arg3_46idTemp = null;
        if(!arg3_46id.equals("")){
        java.text.DateFormat dateFormatarg3358 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3358  = dateFormatarg3358.parse(arg3_46id);
         arg3_46idTemp = new java.util.GregorianCalendar();
        arg3_46idTemp.setTime(dateTemparg3358);
        }
        String arg4_47id=  request.getParameter("arg4360");
            java.lang.String arg4_47idTemp = null;
        if(!arg4_47id.equals("")){
         arg4_47idTemp  = arg4_47id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_43idTemp,arg1_44idTemp,arg2_45idTemp,arg3_46idTemp,arg4_47idTemp);
break;
case 362:
        gotMethod = true;
        java.lang.Object[] getUsuarios362mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios362mtemp == null){
%>
<%=getUsuarios362mtemp %>
<%
}else{
        String tempreturnp363 = null;
        if(getUsuarios362mtemp != null){
        java.util.List listreturnp363= java.util.Arrays.asList(getUsuarios362mtemp);
        tempreturnp363 = listreturnp363.toString();
        }
        %>
        <%=tempreturnp363%>
        <%
}
break;
case 365:
        gotMethod = true;
        java.lang.Object[] obtenerNombreCategorias365mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias365mtemp == null){
%>
<%=obtenerNombreCategorias365mtemp %>
<%
}else{
        String tempreturnp366 = null;
        if(obtenerNombreCategorias365mtemp != null){
        java.util.List listreturnp366= java.util.Arrays.asList(obtenerNombreCategorias365mtemp);
        tempreturnp366 = listreturnp366.toString();
        }
        %>
        <%=tempreturnp366%>
        <%
}
break;
case 368:
        gotMethod = true;
        String arg0_48id=  request.getParameter("arg0371");
            java.lang.String arg0_48idTemp = null;
        if(!arg0_48id.equals("")){
         arg0_48idTemp  = arg0_48id;
        }
        String arg1_49id=  request.getParameter("arg1373");
            java.lang.String arg1_49idTemp = null;
        if(!arg1_49id.equals("")){
         arg1_49idTemp  = arg1_49id;
        }
        String arg2_50id=  request.getParameter("arg2375");
            java.lang.String arg2_50idTemp = null;
        if(!arg2_50id.equals("")){
         arg2_50idTemp  = arg2_50id;
        }
        String arg3_51id=  request.getParameter("arg3377");
            java.lang.String arg3_51idTemp = null;
        if(!arg3_51id.equals("")){
         arg3_51idTemp  = arg3_51id;
        }
        String arg4_52id=  request.getParameter("arg4379");
            java.util.Calendar arg4_52idTemp = null;
        if(!arg4_52id.equals("")){
        java.text.DateFormat dateFormatarg4379 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4379  = dateFormatarg4379.parse(arg4_52id);
         arg4_52idTemp = new java.util.GregorianCalendar();
        arg4_52idTemp.setTime(dateTemparg4379);
        }
        String arg5_53id=  request.getParameter("arg5381");
            java.lang.String arg5_53idTemp = null;
        if(!arg5_53id.equals("")){
         arg5_53idTemp  = arg5_53id;
        }
        String arg6_54id=  request.getParameter("arg6383");
            java.lang.String arg6_54idTemp = null;
        if(!arg6_54id.equals("")){
         arg6_54idTemp  = arg6_54id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_48idTemp,arg1_49idTemp,arg2_50idTemp,arg3_51idTemp,arg4_52idTemp,arg5_53idTemp,arg6_54idTemp);
break;
case 385:
        gotMethod = true;
        String arg0_55id=  request.getParameter("arg0388");
            java.lang.String arg0_55idTemp = null;
        if(!arg0_55id.equals("")){
         arg0_55idTemp  = arg0_55id;
        }
        String arg1_56id=  request.getParameter("arg1390");
            java.lang.String arg1_56idTemp = null;
        if(!arg1_56id.equals("")){
         arg1_56idTemp  = arg1_56id;
        }
        String arg2_57id=  request.getParameter("arg2392");
            java.lang.String arg2_57idTemp = null;
        if(!arg2_57id.equals("")){
         arg2_57idTemp  = arg2_57id;
        }
        String arg3_58id=  request.getParameter("arg3394");
            java.lang.String arg3_58idTemp = null;
        if(!arg3_58id.equals("")){
         arg3_58idTemp  = arg3_58id;
        }
        String arg4_59id=  request.getParameter("arg4396");
            java.util.Calendar arg4_59idTemp = null;
        if(!arg4_59id.equals("")){
        java.text.DateFormat dateFormatarg4396 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4396  = dateFormatarg4396.parse(arg4_59id);
         arg4_59idTemp = new java.util.GregorianCalendar();
        arg4_59idTemp.setTime(dateTemparg4396);
        }
        String arg5_60id=  request.getParameter("arg5398");
            java.lang.String arg5_60idTemp = null;
        if(!arg5_60id.equals("")){
         arg5_60idTemp  = arg5_60id;
        }
        String arg6_61id=  request.getParameter("arg6400");
            java.lang.String arg6_61idTemp = null;
        if(!arg6_61id.equals("")){
         arg6_61idTemp  = arg6_61id;
        }
        String arg7_62id=  request.getParameter("arg7402");
        boolean arg7_62idTemp  = Boolean.valueOf(arg7_62id).booleanValue();
        String arg8_63id=  request.getParameter("arg8404");
            java.lang.String arg8_63idTemp = null;
        if(!arg8_63id.equals("")){
         arg8_63idTemp  = arg8_63id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_55idTemp,arg1_56idTemp,arg2_57idTemp,arg3_58idTemp,arg4_59idTemp,arg5_60idTemp,arg6_61idTemp,arg7_62idTemp,arg8_63idTemp);
break;
case 406:
        gotMethod = true;
        String arg0_64id=  request.getParameter("arg0409");
            java.lang.String arg0_64idTemp = null;
        if(!arg0_64id.equals("")){
         arg0_64idTemp  = arg0_64id;
        }
        String arg1_65id=  request.getParameter("arg1411");
            java.lang.String arg1_65idTemp = null;
        if(!arg1_65id.equals("")){
         arg1_65idTemp  = arg1_65id;
        }
        String arg2_66id=  request.getParameter("arg2413");
            java.util.Calendar arg2_66idTemp = null;
        if(!arg2_66id.equals("")){
        java.text.DateFormat dateFormatarg2413 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2413  = dateFormatarg2413.parse(arg2_66id);
         arg2_66idTemp = new java.util.GregorianCalendar();
        arg2_66idTemp.setTime(dateTemparg2413);
        }
        String arg3_67id=  request.getParameter("arg3415");
            java.util.Calendar arg3_67idTemp = null;
        if(!arg3_67id.equals("")){
        java.text.DateFormat dateFormatarg3415 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3415  = dateFormatarg3415.parse(arg3_67id);
         arg3_67idTemp = new java.util.GregorianCalendar();
        arg3_67idTemp.setTime(dateTemparg3415);
        }
        String arg4_68id=  request.getParameter("arg4417");
            java.lang.String arg4_68idTemp = null;
        if(!arg4_68id.equals("")){
         arg4_68idTemp  = arg4_68id;
        }
        String arg5_69id=  request.getParameter("arg5419");
        int arg5_69idTemp  = Integer.parseInt(arg5_69id);
        String arg6_70id=  request.getParameter("arg6421");
            java.util.Calendar arg6_70idTemp = null;
        if(!arg6_70id.equals("")){
        java.text.DateFormat dateFormatarg6421 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6421  = dateFormatarg6421.parse(arg6_70id);
         arg6_70idTemp = new java.util.GregorianCalendar();
        arg6_70idTemp.setTime(dateTemparg6421);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_64idTemp,arg1_65idTemp,arg2_66idTemp,arg3_67idTemp,arg4_68idTemp,arg5_69idTemp,arg6_70idTemp);
break;
case 423:
        gotMethod = true;
        java.lang.Object[] listarPaquetes423mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes423mtemp == null){
%>
<%=listarPaquetes423mtemp %>
<%
}else{
        String tempreturnp424 = null;
        if(listarPaquetes423mtemp != null){
        java.util.List listreturnp424= java.util.Arrays.asList(listarPaquetes423mtemp);
        tempreturnp424 = listreturnp424.toString();
        }
        %>
        <%=tempreturnp424%>
        <%
}
break;
case 426:
        gotMethod = true;
        String arg0_71id=  request.getParameter("arg0441");
            java.lang.String arg0_71idTemp = null;
        if(!arg0_71id.equals("")){
         arg0_71idTemp  = arg0_71id;
        }
        servidor.DataPaquete obtenerDataPaquete426mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_71idTemp);
if(obtenerDataPaquete426mtemp == null){
%>
<%=obtenerDataPaquete426mtemp %>
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
if(obtenerDataPaquete426mtemp != null){
%>
<%=obtenerDataPaquete426mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete426mtemp != null){
java.util.Calendar typefechaAlta431 = obtenerDataPaquete426mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta431 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta431 = typefechaAlta431.getTime();
        String tempResultfechaAlta431 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta431.format(datefechaAlta431));
        %>
        <%= tempResultfechaAlta431 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete426mtemp != null){
java.lang.String typedescripcion433 = obtenerDataPaquete426mtemp.getDescripcion();
        String tempResultdescripcion433 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion433));
        %>
        <%= tempResultdescripcion433 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete426mtemp != null){
%>
<%=obtenerDataPaquete426mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete426mtemp != null){
java.lang.String typenombre437 = obtenerDataPaquete426mtemp.getNombre();
        String tempResultnombre437 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre437));
        %>
        <%= tempResultnombre437 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete426mtemp != null){
java.lang.String typeimagen439 = obtenerDataPaquete426mtemp.getImagen();
        String tempResultimagen439 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen439));
        %>
        <%= tempResultimagen439 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 443:
        gotMethod = true;
        String arg0_72id=  request.getParameter("arg0446");
            java.lang.String arg0_72idTemp = null;
        if(!arg0_72id.equals("")){
         arg0_72idTemp  = arg0_72id;
        }
        String arg1_73id=  request.getParameter("arg1448");
            java.lang.String arg1_73idTemp = null;
        if(!arg1_73id.equals("")){
         arg1_73idTemp  = arg1_73id;
        }
        java.lang.Object[] actividadesPorDepartamentoNoEnPaquete443mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_72idTemp,arg1_73idTemp);
if(actividadesPorDepartamentoNoEnPaquete443mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete443mtemp %>
<%
}else{
        String tempreturnp444 = null;
        if(actividadesPorDepartamentoNoEnPaquete443mtemp != null){
        java.util.List listreturnp444= java.util.Arrays.asList(actividadesPorDepartamentoNoEnPaquete443mtemp);
        tempreturnp444 = listreturnp444.toString();
        }
        %>
        <%=tempreturnp444%>
        <%
}
break;
case 450:
        gotMethod = true;
        java.lang.Object[] listarPaquetesNoComprados450mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados450mtemp == null){
%>
<%=listarPaquetesNoComprados450mtemp %>
<%
}else{
        String tempreturnp451 = null;
        if(listarPaquetesNoComprados450mtemp != null){
        java.util.List listreturnp451= java.util.Arrays.asList(listarPaquetesNoComprados450mtemp);
        tempreturnp451 = listreturnp451.toString();
        }
        %>
        <%=tempreturnp451%>
        <%
}
break;
case 453:
        gotMethod = true;
        String fileName_74id=  request.getParameter("fileName456");
            java.lang.String fileName_74idTemp = null;
        if(!fileName_74id.equals("")){
         fileName_74idTemp  = fileName_74id;
        }
        byte[] getFile453mtemp = samplePublicadorIControladorProxyid.getFile(fileName_74idTemp);
if(getFile453mtemp == null){
%>
<%=getFile453mtemp %>
<%
}else{
        String tempreturnp454 = "[";        for(int ireturnp454=0;ireturnp454< getFile453mtemp.length;ireturnp454++){
            tempreturnp454 = tempreturnp454 + getFile453mtemp[ireturnp454] + ",";
        }
        int lengthreturnp454 = tempreturnp454.length();
        tempreturnp454 = tempreturnp454.substring(0,(lengthreturnp454 - 1)) + "]";
        %>
        <%=tempreturnp454%>
        <%
}
break;
case 458:
        gotMethod = true;
        String arg0_75id=  request.getParameter("arg0461");
            java.lang.String arg0_75idTemp = null;
        if(!arg0_75id.equals("")){
         arg0_75idTemp  = arg0_75id;
        }
        samplePublicadorIControladorProxyid.sumarVistaAAct(arg0_75idTemp);
break;
case 463:
        gotMethod = true;
        String arg0_76id=  request.getParameter("arg0466");
            java.lang.String arg0_76idTemp = null;
        if(!arg0_76id.equals("")){
         arg0_76idTemp  = arg0_76id;
        }
        samplePublicadorIControladorProxyid.sumarVistaASal(arg0_76idTemp);
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