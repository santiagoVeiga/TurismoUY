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
case 21:
        gotMethod = true;
        String fileName_1id=  request.getParameter("fileName24");
            java.lang.String fileName_1idTemp = null;
        if(!fileName_1id.equals("")){
         fileName_1idTemp  = fileName_1id;
        }
        byte[] getFile21mtemp = samplePublicadorIControladorProxyid.getFile(fileName_1idTemp);
if(getFile21mtemp == null){
%>
<%=getFile21mtemp %>
<%
}else{
        String tempreturnp22 = "[";        for(int ireturnp22=0;ireturnp22< getFile21mtemp.length;ireturnp22++){
            tempreturnp22 = tempreturnp22 + getFile21mtemp[ireturnp22] + ",";
        }
        int lengthreturnp22 = tempreturnp22.length();
        tempreturnp22 = tempreturnp22.substring(0,(lengthreturnp22 - 1)) + "]";
        %>
        <%=tempreturnp22%>
        <%
}
break;
case 26:
        gotMethod = true;
        servidor.DataDepartamento dataDepartamentoNull26mtemp = samplePublicadorIControladorProxyid.dataDepartamentoNull();
if(dataDepartamentoNull26mtemp == null){
%>
<%=dataDepartamentoNull26mtemp %>
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
if(dataDepartamentoNull26mtemp != null){
java.lang.String typedescripcion29 = dataDepartamentoNull26mtemp.getDescripcion();
        String tempResultdescripcion29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion29));
        %>
        <%= tempResultdescripcion29 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(dataDepartamentoNull26mtemp != null){
java.lang.String typeurl31 = dataDepartamentoNull26mtemp.getUrl();
        String tempResulturl31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl31));
        %>
        <%= tempResulturl31 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataDepartamentoNull26mtemp != null){
java.lang.String typenombre33 = dataDepartamentoNull26mtemp.getNombre();
        String tempResultnombre33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre33));
        %>
        <%= tempResultnombre33 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 35:
        gotMethod = true;
        servidor.DataTurista dataTuristaNull35mtemp = samplePublicadorIControladorProxyid.dataTuristaNull();
if(dataTuristaNull35mtemp == null){
%>
<%=dataTuristaNull35mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nacionalidad:</TD>
<TD>
<%
if(dataTuristaNull35mtemp != null){
java.lang.String typenacionalidad38 = dataTuristaNull35mtemp.getNacionalidad();
        String tempResultnacionalidad38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenacionalidad38));
        %>
        <%= tempResultnacionalidad38 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 40:
        gotMethod = true;
        servidor.DataProveedor dataProveedorNull40mtemp = samplePublicadorIControladorProxyid.dataProveedorNull();
if(dataProveedorNull40mtemp == null){
%>
<%=dataProveedorNull40mtemp %>
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
if(dataProveedorNull40mtemp != null){
java.lang.String typedescripcion43 = dataProveedorNull40mtemp.getDescripcion();
        String tempResultdescripcion43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion43));
        %>
        <%= tempResultdescripcion43 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(dataProveedorNull40mtemp != null){
java.lang.String typelink45 = dataProveedorNull40mtemp.getLink();
        String tempResultlink45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink45));
        %>
        <%= tempResultlink45 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 47:
        gotMethod = true;
        servidor.DataActividad dataActividadNull47mtemp = samplePublicadorIControladorProxyid.dataActividadNull();
if(dataActividadNull47mtemp == null){
%>
<%=dataActividadNull47mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typenombre50 = dataActividadNull47mtemp.getNombre();
        String tempResultnombre50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre50));
        %>
        <%= tempResultnombre50 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaBaja:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.util.Calendar typefechaBaja52 = dataActividadNull47mtemp.getFechaBaja();
        java.text.DateFormat dateFormatfechaBaja52 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaBaja52 = typefechaBaja52.getTime();
        String tempResultfechaBaja52 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaBaja52.format(datefechaBaja52));
        %>
        <%= tempResultfechaBaja52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typedepartamento54 = dataActividadNull47mtemp.getDepartamento();
        String tempResultdepartamento54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento54));
        %>
        <%= tempResultdepartamento54 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typedescripcion56 = dataActividadNull47mtemp.getDescripcion();
        String tempResultdescripcion56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion56));
        %>
        <%= tempResultdescripcion56 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typelink58 = dataActividadNull47mtemp.getLink();
        String tempResultlink58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink58));
        %>
        <%= tempResultlink58 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
%>
<%=dataActividadNull47mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
%>
<%=dataActividadNull47mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typeciudad64 = dataActividadNull47mtemp.getCiudad();
        String tempResultciudad64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad64));
        %>
        <%= tempResultciudad64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.util.Calendar typefechaAlta66 = dataActividadNull47mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta66 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta66 = typefechaAlta66.getTime();
        String tempResultfechaAlta66 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta66.format(datefechaAlta66));
        %>
        <%= tempResultfechaAlta66 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typeimagen68 = dataActividadNull47mtemp.getImagen();
        String tempResultimagen68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen68));
        %>
        <%= tempResultimagen68 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantFavs:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
%>
<%=dataActividadNull47mtemp.getCantFavs()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
%>
<%=dataActividadNull47mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
%>
<%=dataActividadNull47mtemp.getCantVis()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 76:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull76mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull76mtemp == null){
%>
<%=dataCGNull76mtemp %>
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
if(dataCGNull76mtemp != null){
java.util.Calendar typefecha79 = dataCGNull76mtemp.getFecha();
        java.text.DateFormat dateFormatfecha79 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha79 = typefecha79.getTime();
        String tempResultfecha79 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha79.format(datefecha79));
        %>
        <%= tempResultfecha79 %>
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
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta83 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta83 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta83 = typefechaAlta83.getTime();
        String tempResultfechaAlta83 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta83.format(datefechaAlta83));
        %>
        <%= tempResultfechaAlta83 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora85 = tebece0.getHora();
        java.text.DateFormat dateFormathora85 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora85 = typehora85.getTime();
        String tempResulthora85 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora85.format(datehora85));
        %>
        <%= tempResulthora85 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar87 = tebece0.getLugar();
        String tempResultlugar87 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar87));
        %>
        <%= tempResultlugar87 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
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
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre91 = tebece0.getNombre();
        String tempResultnombre91 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre91));
        %>
        <%= tempResultnombre91 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
if(tebece0 != null){
java.lang.String typeimagen93 = tebece0.getImagen();
        String tempResultimagen93 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen93));
        %>
        <%= tempResultimagen93 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha95 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha95 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha95 = typefecha95.getTime();
        String tempResultfecha95 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha95.format(datefecha95));
        %>
        <%= tempResultfecha95 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
servidor.DataSalida tebece0=dataCGNull76mtemp.getSalida();
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
if(dataCGNull76mtemp != null){
%>
<%=dataCGNull76mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
%>
<%=dataCGNull76mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull76mtemp != null){
%>
<%=dataCGNull76mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 105:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull105mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull105mtemp == null){
%>
<%=dataCPNull105mtemp %>
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
if(dataCPNull105mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct108 = dataCPNull105mtemp.getRestAct();
        String temprestAct108 = null;
        if(typerestAct108 != null){
        java.util.List listrestAct108= java.util.Arrays.asList(typerestAct108);
        temprestAct108 = listrestAct108.toString();
        }
        %>
        <%=temprestAct108%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
java.util.Calendar typefecha110 = dataCPNull105mtemp.getFecha();
        java.text.DateFormat dateFormatfecha110 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha110 = typefecha110.getTime();
        String tempResultfecha110 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha110.format(datefecha110));
        %>
        <%= tempResultfecha110 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
%>
<%=dataCPNull105mtemp.getCantidad()
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
if(dataCPNull105mtemp != null){
servidor.DataPaquete tebece0=dataCPNull105mtemp.getPaq();
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
if(dataCPNull105mtemp != null){
servidor.DataPaquete tebece0=dataCPNull105mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta118 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta118 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta118 = typefechaAlta118.getTime();
        String tempResultfechaAlta118 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta118.format(datefechaAlta118));
        %>
        <%= tempResultfechaAlta118 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
servidor.DataPaquete tebece0=dataCPNull105mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion120 = tebece0.getDescripcion();
        String tempResultdescripcion120 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion120));
        %>
        <%= tempResultdescripcion120 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
servidor.DataPaquete tebece0=dataCPNull105mtemp.getPaq();
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
if(dataCPNull105mtemp != null){
servidor.DataPaquete tebece0=dataCPNull105mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre124 = tebece0.getNombre();
        String tempResultnombre124 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre124));
        %>
        <%= tempResultnombre124 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
servidor.DataPaquete tebece0=dataCPNull105mtemp.getPaq();
if(tebece0 != null){
java.lang.String typeimagen126 = tebece0.getImagen();
        String tempResultimagen126 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen126));
        %>
        <%= tempResultimagen126 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
java.util.Calendar typevencimiento128 = dataCPNull105mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento128 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento128 = typevencimiento128.getTime();
        String tempResultvencimiento128 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento128.format(datevencimiento128));
        %>
        <%= tempResultvencimiento128 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull105mtemp != null){
%>
<%=dataCPNull105mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 132:
        gotMethod = true;
        servidor.EstadoAct estadoActNull132mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull132mtemp == null){
%>
<%=estadoActNull132mtemp %>
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
case 137:
        gotMethod = true;
        %>
        <jsp:useBean id="servidor1DataColeccionObject_2id" scope="session" class="servidor.DataColeccionObject" />
        <%
        samplePublicadorIControladorProxyid.prueba(servidor1DataColeccionObject_2id);
break;
case 142:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg0159");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        servidor.DataUsuario verInfoUsuario142mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_3idTemp);
if(verInfoUsuario142mtemp == null){
%>
<%=verInfoUsuario142mtemp %>
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
if(verInfoUsuario142mtemp != null){
java.util.Calendar typenacimiento145 = verInfoUsuario142mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento145 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento145 = typenacimiento145.getTime();
        String tempResultnacimiento145 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento145.format(datenacimiento145));
        %>
        <%= tempResultnacimiento145 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typenick147 = verInfoUsuario142mtemp.getNick();
        String tempResultnick147 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick147));
        %>
        <%= tempResultnick147 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typemail149 = verInfoUsuario142mtemp.getMail();
        String tempResultmail149 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail149));
        %>
        <%= tempResultmail149 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typepassword151 = verInfoUsuario142mtemp.getPassword();
        String tempResultpassword151 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword151));
        %>
        <%= tempResultpassword151 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typenombre153 = verInfoUsuario142mtemp.getNombre();
        String tempResultnombre153 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre153));
        %>
        <%= tempResultnombre153 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typeimagen155 = verInfoUsuario142mtemp.getImagen();
        String tempResultimagen155 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen155));
        %>
        <%= tempResultimagen155 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typeapellido157 = verInfoUsuario142mtemp.getApellido();
        String tempResultapellido157 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido157));
        %>
        <%= tempResultapellido157 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 161:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0164");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        samplePublicadorIControladorProxyid.sumarVistaAAct(arg0_4idTemp);
break;
case 166:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg0169");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        samplePublicadorIControladorProxyid.sumarVistaASal(arg0_5idTemp);
break;
case 171:
        gotMethod = true;
        servidor.DataColeccionObject getUsuariosComp171mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp171mtemp == null){
%>
<%=getUsuariosComp171mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(getUsuariosComp171mtemp != null){
java.lang.Object typeobj174 = getUsuariosComp171mtemp.getObj();
        String tempResultobj174 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj174.toString());
        %>
        <%= tempResultobj174 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 176:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0193");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        servidor.DataUsuario ingresarDatos176mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_6idTemp);
if(ingresarDatos176mtemp == null){
%>
<%=ingresarDatos176mtemp %>
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
if(ingresarDatos176mtemp != null){
java.util.Calendar typenacimiento179 = ingresarDatos176mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento179 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento179 = typenacimiento179.getTime();
        String tempResultnacimiento179 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento179.format(datenacimiento179));
        %>
        <%= tempResultnacimiento179 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos176mtemp != null){
java.lang.String typenick181 = ingresarDatos176mtemp.getNick();
        String tempResultnick181 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick181));
        %>
        <%= tempResultnick181 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos176mtemp != null){
java.lang.String typemail183 = ingresarDatos176mtemp.getMail();
        String tempResultmail183 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail183));
        %>
        <%= tempResultmail183 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos176mtemp != null){
java.lang.String typepassword185 = ingresarDatos176mtemp.getPassword();
        String tempResultpassword185 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword185));
        %>
        <%= tempResultpassword185 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos176mtemp != null){
java.lang.String typenombre187 = ingresarDatos176mtemp.getNombre();
        String tempResultnombre187 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre187));
        %>
        <%= tempResultnombre187 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(ingresarDatos176mtemp != null){
java.lang.String typeimagen189 = ingresarDatos176mtemp.getImagen();
        String tempResultimagen189 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen189));
        %>
        <%= tempResultimagen189 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos176mtemp != null){
java.lang.String typeapellido191 = ingresarDatos176mtemp.getApellido();
        String tempResultapellido191 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido191));
        %>
        <%= tempResultapellido191 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 195:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0200");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        servidor.DataColeccionObject obtenerActividadCategoria195mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_7idTemp);
if(obtenerActividadCategoria195mtemp == null){
%>
<%=obtenerActividadCategoria195mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(obtenerActividadCategoria195mtemp != null){
java.lang.Object typeobj198 = obtenerActividadCategoria195mtemp.getObj();
        String tempResultobj198 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj198.toString());
        %>
        <%= tempResultobj198 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 202:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0219");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick202mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_8idTemp);
if(obtenerDataUsuarioNick202mtemp == null){
%>
<%=obtenerDataUsuarioNick202mtemp %>
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
if(obtenerDataUsuarioNick202mtemp != null){
java.util.Calendar typenacimiento205 = obtenerDataUsuarioNick202mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento205 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento205 = typenacimiento205.getTime();
        String tempResultnacimiento205 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento205.format(datenacimiento205));
        %>
        <%= tempResultnacimiento205 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick202mtemp != null){
java.lang.String typenick207 = obtenerDataUsuarioNick202mtemp.getNick();
        String tempResultnick207 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick207));
        %>
        <%= tempResultnick207 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick202mtemp != null){
java.lang.String typemail209 = obtenerDataUsuarioNick202mtemp.getMail();
        String tempResultmail209 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail209));
        %>
        <%= tempResultmail209 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick202mtemp != null){
java.lang.String typepassword211 = obtenerDataUsuarioNick202mtemp.getPassword();
        String tempResultpassword211 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword211));
        %>
        <%= tempResultpassword211 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick202mtemp != null){
java.lang.String typenombre213 = obtenerDataUsuarioNick202mtemp.getNombre();
        String tempResultnombre213 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre213));
        %>
        <%= tempResultnombre213 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioNick202mtemp != null){
java.lang.String typeimagen215 = obtenerDataUsuarioNick202mtemp.getImagen();
        String tempResultimagen215 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen215));
        %>
        <%= tempResultimagen215 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick202mtemp != null){
java.lang.String typeapellido217 = obtenerDataUsuarioNick202mtemp.getApellido();
        String tempResultapellido217 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido217));
        %>
        <%= tempResultapellido217 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 221:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0238");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail221mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_9idTemp);
if(obtenerDataUsuarioMail221mtemp == null){
%>
<%=obtenerDataUsuarioMail221mtemp %>
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
if(obtenerDataUsuarioMail221mtemp != null){
java.util.Calendar typenacimiento224 = obtenerDataUsuarioMail221mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento224 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento224 = typenacimiento224.getTime();
        String tempResultnacimiento224 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento224.format(datenacimiento224));
        %>
        <%= tempResultnacimiento224 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail221mtemp != null){
java.lang.String typenick226 = obtenerDataUsuarioMail221mtemp.getNick();
        String tempResultnick226 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick226));
        %>
        <%= tempResultnick226 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail221mtemp != null){
java.lang.String typemail228 = obtenerDataUsuarioMail221mtemp.getMail();
        String tempResultmail228 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail228));
        %>
        <%= tempResultmail228 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail221mtemp != null){
java.lang.String typepassword230 = obtenerDataUsuarioMail221mtemp.getPassword();
        String tempResultpassword230 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword230));
        %>
        <%= tempResultpassword230 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail221mtemp != null){
java.lang.String typenombre232 = obtenerDataUsuarioMail221mtemp.getNombre();
        String tempResultnombre232 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre232));
        %>
        <%= tempResultnombre232 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioMail221mtemp != null){
java.lang.String typeimagen234 = obtenerDataUsuarioMail221mtemp.getImagen();
        String tempResultimagen234 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen234));
        %>
        <%= tempResultimagen234 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail221mtemp != null){
java.lang.String typeapellido236 = obtenerDataUsuarioMail221mtemp.getApellido();
        String tempResultapellido236 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido236));
        %>
        <%= tempResultapellido236 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 240:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0269");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        servidor.DataActividad obtenerDataActividad240mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_10idTemp);
if(obtenerDataActividad240mtemp == null){
%>
<%=obtenerDataActividad240mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.lang.String typenombre243 = obtenerDataActividad240mtemp.getNombre();
        String tempResultnombre243 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre243));
        %>
        <%= tempResultnombre243 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaBaja:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.util.Calendar typefechaBaja245 = obtenerDataActividad240mtemp.getFechaBaja();
        java.text.DateFormat dateFormatfechaBaja245 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaBaja245 = typefechaBaja245.getTime();
        String tempResultfechaBaja245 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaBaja245.format(datefechaBaja245));
        %>
        <%= tempResultfechaBaja245 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.lang.String typedepartamento247 = obtenerDataActividad240mtemp.getDepartamento();
        String tempResultdepartamento247 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento247));
        %>
        <%= tempResultdepartamento247 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.lang.String typedescripcion249 = obtenerDataActividad240mtemp.getDescripcion();
        String tempResultdescripcion249 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion249));
        %>
        <%= tempResultdescripcion249 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.lang.String typelink251 = obtenerDataActividad240mtemp.getLink();
        String tempResultlink251 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink251));
        %>
        <%= tempResultlink251 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
%>
<%=obtenerDataActividad240mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
%>
<%=obtenerDataActividad240mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.lang.String typeciudad257 = obtenerDataActividad240mtemp.getCiudad();
        String tempResultciudad257 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad257));
        %>
        <%= tempResultciudad257 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.util.Calendar typefechaAlta259 = obtenerDataActividad240mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta259 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta259 = typefechaAlta259.getTime();
        String tempResultfechaAlta259 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta259.format(datefechaAlta259));
        %>
        <%= tempResultfechaAlta259 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
java.lang.String typeimagen261 = obtenerDataActividad240mtemp.getImagen();
        String tempResultimagen261 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen261));
        %>
        <%= tempResultimagen261 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantFavs:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
%>
<%=obtenerDataActividad240mtemp.getCantFavs()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
%>
<%=obtenerDataActividad240mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataActividad240mtemp != null){
%>
<%=obtenerDataActividad240mtemp.getCantVis()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 271:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg0290");
            java.lang.String arg0_11idTemp = null;
        if(!arg0_11id.equals("")){
         arg0_11idTemp  = arg0_11id;
        }
        servidor.DataSalida obtenerDataSalida271mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_11idTemp);
if(obtenerDataSalida271mtemp == null){
%>
<%=obtenerDataSalida271mtemp %>
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
if(obtenerDataSalida271mtemp != null){
java.util.Calendar typefechaAlta274 = obtenerDataSalida271mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta274 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta274 = typefechaAlta274.getTime();
        String tempResultfechaAlta274 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta274.format(datefechaAlta274));
        %>
        <%= tempResultfechaAlta274 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
java.util.Calendar typehora276 = obtenerDataSalida271mtemp.getHora();
        java.text.DateFormat dateFormathora276 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora276 = typehora276.getTime();
        String tempResulthora276 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora276.format(datehora276));
        %>
        <%= tempResulthora276 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
java.lang.String typelugar278 = obtenerDataSalida271mtemp.getLugar();
        String tempResultlugar278 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar278));
        %>
        <%= tempResultlugar278 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
%>
<%=obtenerDataSalida271mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
java.lang.String typenombre282 = obtenerDataSalida271mtemp.getNombre();
        String tempResultnombre282 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre282));
        %>
        <%= tempResultnombre282 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
java.lang.String typeimagen284 = obtenerDataSalida271mtemp.getImagen();
        String tempResultimagen284 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen284));
        %>
        <%= tempResultimagen284 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
java.util.Calendar typefecha286 = obtenerDataSalida271mtemp.getFecha();
        java.text.DateFormat dateFormatfecha286 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha286 = typefecha286.getTime();
        String tempResultfecha286 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha286.format(datefecha286));
        %>
        <%= tempResultfecha286 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida271mtemp != null){
%>
<%=obtenerDataSalida271mtemp.getCant()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 292:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg0295");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg1297");
            java.util.Calendar arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
        java.text.DateFormat dateFormatarg1297 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1297  = dateFormatarg1297.parse(arg1_13id);
         arg1_13idTemp = new java.util.GregorianCalendar();
        arg1_13idTemp.setTime(dateTemparg1297);
        }
        String arg2_14id=  request.getParameter("arg2299");
        int arg2_14idTemp  = Integer.parseInt(arg2_14id);
        String arg3_15id=  request.getParameter("arg3301");
            java.lang.String arg3_15idTemp = null;
        if(!arg3_15id.equals("")){
         arg3_15idTemp  = arg3_15id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_12idTemp,arg1_13idTemp,arg2_14idTemp,arg3_15idTemp);
break;
case 303:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg0306");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        String arg1_17id=  request.getParameter("arg1308");
            java.lang.String arg1_17idTemp = null;
        if(!arg1_17id.equals("")){
         arg1_17idTemp  = arg1_17id;
        }
        String arg2_18id=  request.getParameter("arg2310");
        int arg2_18idTemp  = Integer.parseInt(arg2_18id);
        String arg3_19id=  request.getParameter("arg3312");
            java.util.Calendar arg3_19idTemp = null;
        if(!arg3_19id.equals("")){
        java.text.DateFormat dateFormatarg3312 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3312  = dateFormatarg3312.parse(arg3_19id);
         arg3_19idTemp = new java.util.GregorianCalendar();
        arg3_19idTemp.setTime(dateTemparg3312);
        }
        String arg4_20id=  request.getParameter("arg4314");
            java.lang.String arg4_20idTemp = null;
        if(!arg4_20id.equals("")){
         arg4_20idTemp  = arg4_20id;
        }
        String arg5_21id=  request.getParameter("arg5316");
            java.lang.String arg5_21idTemp = null;
        if(!arg5_21id.equals("")){
         arg5_21idTemp  = arg5_21id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_16idTemp,arg1_17idTemp,arg2_18idTemp,arg3_19idTemp,arg4_20idTemp,arg5_21idTemp);
break;
case 318:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0323");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        servidor.DataColeccionObject obtenerPaquetesComprados318mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_22idTemp);
if(obtenerPaquetesComprados318mtemp == null){
%>
<%=obtenerPaquetesComprados318mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(obtenerPaquetesComprados318mtemp != null){
java.lang.Object typeobj321 = obtenerPaquetesComprados318mtemp.getObj();
        String tempResultobj321 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj321.toString());
        %>
        <%= tempResultobj321 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 325:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0328");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        java.lang.String obtenerNomActPorSalida325mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_23idTemp);
if(obtenerNomActPorSalida325mtemp == null){
%>
<%=obtenerNomActPorSalida325mtemp %>
<%
}else{
        String tempResultreturnp326 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida325mtemp));
        %>
        <%= tempResultreturnp326 %>
        <%
}
break;
case 330:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0333");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1335");
            java.lang.String arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
         arg1_25idTemp  = arg1_25id;
        }
        String arg2_26id=  request.getParameter("arg2337");
        boolean arg2_26idTemp  = Boolean.valueOf(arg2_26id).booleanValue();
        samplePublicadorIControladorProxyid.seguirDejarDeSeguirUsuario(arg0_24idTemp,arg1_25idTemp,arg2_26idTemp);
break;
case 339:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0342");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        String arg1_28id=  request.getParameter("arg1344");
            java.lang.String arg1_28idTemp = null;
        if(!arg1_28id.equals("")){
         arg1_28idTemp  = arg1_28id;
        }
        String arg2_29id=  request.getParameter("arg2346");
        boolean arg2_29idTemp  = Boolean.valueOf(arg2_29id).booleanValue();
        samplePublicadorIControladorProxyid.agregarQuitarActividadFavorita(arg0_27idTemp,arg1_28idTemp,arg2_29idTemp);
break;
case 348:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0351");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        String arg1_31id=  request.getParameter("arg1353");
            java.lang.String arg1_31idTemp = null;
        if(!arg1_31id.equals("")){
         arg1_31idTemp  = arg1_31id;
        }
        samplePublicadorIControladorProxyid.finalizarActividad(arg0_30idTemp,arg1_31idTemp);
break;
case 355:
        gotMethod = true;
        servidor.DataColeccionObject listarUsuarios355mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios355mtemp == null){
%>
<%=listarUsuarios355mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(listarUsuarios355mtemp != null){
java.lang.Object typeobj358 = listarUsuarios355mtemp.getObj();
        String tempResultobj358 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj358.toString());
        %>
        <%= tempResultobj358 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 360:
        gotMethod = true;
        servidor.DataColeccionObject obtenerDataDepartamentos360mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos360mtemp == null){
%>
<%=obtenerDataDepartamentos360mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(obtenerDataDepartamentos360mtemp != null){
java.lang.Object typeobj363 = obtenerDataDepartamentos360mtemp.getObj();
        String tempResultobj363 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj363.toString());
        %>
        <%= tempResultobj363 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 365:
        gotMethod = true;
        String arg0_32id=  request.getParameter("arg0368");
            java.lang.String arg0_32idTemp = null;
        if(!arg0_32id.equals("")){
         arg0_32idTemp  = arg0_32id;
        }
        String arg1_33id=  request.getParameter("arg1370");
            java.lang.String arg1_33idTemp = null;
        if(!arg1_33id.equals("")){
         arg1_33idTemp  = arg1_33id;
        }
        String arg2_34id=  request.getParameter("arg2372");
            java.util.Calendar arg2_34idTemp = null;
        if(!arg2_34id.equals("")){
        java.text.DateFormat dateFormatarg2372 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2372  = dateFormatarg2372.parse(arg2_34id);
         arg2_34idTemp = new java.util.GregorianCalendar();
        arg2_34idTemp.setTime(dateTemparg2372);
        }
        String arg3_35id=  request.getParameter("arg3374");
            java.util.Calendar arg3_35idTemp = null;
        if(!arg3_35id.equals("")){
        java.text.DateFormat dateFormatarg3374 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3374  = dateFormatarg3374.parse(arg3_35id);
         arg3_35idTemp = new java.util.GregorianCalendar();
        arg3_35idTemp.setTime(dateTemparg3374);
        }
        String arg4_36id=  request.getParameter("arg4376");
            java.lang.String arg4_36idTemp = null;
        if(!arg4_36id.equals("")){
         arg4_36idTemp  = arg4_36id;
        }
        String arg5_37id=  request.getParameter("arg5378");
        int arg5_37idTemp  = Integer.parseInt(arg5_37id);
        String arg6_38id=  request.getParameter("arg6380");
            java.util.Calendar arg6_38idTemp = null;
        if(!arg6_38id.equals("")){
        java.text.DateFormat dateFormatarg6380 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6380  = dateFormatarg6380.parse(arg6_38id);
         arg6_38idTemp = new java.util.GregorianCalendar();
        arg6_38idTemp.setTime(dateTemparg6380);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_32idTemp,arg1_33idTemp,arg2_34idTemp,arg3_35idTemp,arg4_36idTemp,arg5_37idTemp,arg6_38idTemp);
break;
case 382:
        gotMethod = true;
        String arg0_39id=  request.getParameter("arg0385");
            java.lang.String arg0_39idTemp = null;
        if(!arg0_39id.equals("")){
         arg0_39idTemp  = arg0_39id;
        }
        String arg1_40id=  request.getParameter("arg1387");
            java.lang.String arg1_40idTemp = null;
        if(!arg1_40id.equals("")){
         arg1_40idTemp  = arg1_40id;
        }
        String arg2_41id=  request.getParameter("arg2389");
            java.lang.String arg2_41idTemp = null;
        if(!arg2_41id.equals("")){
         arg2_41idTemp  = arg2_41id;
        }
        String arg3_42id=  request.getParameter("arg3391");
        int arg3_42idTemp  = Integer.parseInt(arg3_42id);
        String arg4_43id=  request.getParameter("arg4393");
        int arg4_43idTemp  = Integer.parseInt(arg4_43id);
        String arg5_44id=  request.getParameter("arg5395");
            java.lang.String arg5_44idTemp = null;
        if(!arg5_44id.equals("")){
         arg5_44idTemp  = arg5_44id;
        }
        String arg6_45id=  request.getParameter("arg6397");
            java.util.Calendar arg6_45idTemp = null;
        if(!arg6_45id.equals("")){
        java.text.DateFormat dateFormatarg6397 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6397  = dateFormatarg6397.parse(arg6_45id);
         arg6_45idTemp = new java.util.GregorianCalendar();
        arg6_45idTemp.setTime(dateTemparg6397);
        }
        String arg7_46id=  request.getParameter("arg7399");
            java.lang.String arg7_46idTemp = null;
        if(!arg7_46id.equals("")){
         arg7_46idTemp  = arg7_46id;
        }
        %>
        <jsp:useBean id="servidor1DataColeccionObject_47id" scope="session" class="servidor.DataColeccionObject" />
        <%
        String arg9_48id=  request.getParameter("arg9403");
            java.lang.String arg9_48idTemp = null;
        if(!arg9_48id.equals("")){
         arg9_48idTemp  = arg9_48id;
        }
        String arg10_49id=  request.getParameter("arg10405");
        boolean arg10_49idTemp  = Boolean.valueOf(arg10_49id).booleanValue();
        samplePublicadorIControladorProxyid.registrarActividad(arg0_39idTemp,arg1_40idTemp,arg2_41idTemp,arg3_42idTemp,arg4_43idTemp,arg5_44idTemp,arg6_45idTemp,arg7_46idTemp,servidor1DataColeccionObject_47id,arg9_48idTemp,arg10_49idTemp);
break;
case 407:
        gotMethod = true;
        servidor.DataColeccionObject getUsuarios407mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios407mtemp == null){
%>
<%=getUsuarios407mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(getUsuarios407mtemp != null){
java.lang.Object typeobj410 = getUsuarios407mtemp.getObj();
        String tempResultobj410 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj410.toString());
        %>
        <%= tempResultobj410 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 412:
        gotMethod = true;
        servidor.DataColeccionObject obtenerNombreCategorias412mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias412mtemp == null){
%>
<%=obtenerNombreCategorias412mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(obtenerNombreCategorias412mtemp != null){
java.lang.Object typeobj415 = obtenerNombreCategorias412mtemp.getObj();
        String tempResultobj415 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj415.toString());
        %>
        <%= tempResultobj415 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 417:
        gotMethod = true;
        String arg0_50id=  request.getParameter("arg0422");
            java.lang.String arg0_50idTemp = null;
        if(!arg0_50id.equals("")){
         arg0_50idTemp  = arg0_50id;
        }
        servidor.DataColeccionObject selecDepartamento417mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_50idTemp);
if(selecDepartamento417mtemp == null){
%>
<%=selecDepartamento417mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(selecDepartamento417mtemp != null){
java.lang.Object typeobj420 = selecDepartamento417mtemp.getObj();
        String tempResultobj420 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj420.toString());
        %>
        <%= tempResultobj420 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 424:
        gotMethod = true;
        String arg0_51id=  request.getParameter("arg0429");
            java.lang.String arg0_51idTemp = null;
        if(!arg0_51id.equals("")){
         arg0_51idTemp  = arg0_51id;
        }
        servidor.DataColeccionObject salidas424mtemp = samplePublicadorIControladorProxyid.salidas(arg0_51idTemp);
if(salidas424mtemp == null){
%>
<%=salidas424mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(salidas424mtemp != null){
java.lang.Object typeobj427 = salidas424mtemp.getObj();
        String tempResultobj427 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj427.toString());
        %>
        <%= tempResultobj427 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 431:
        gotMethod = true;
        String arg0_52id=  request.getParameter("arg0434");
            java.lang.String arg0_52idTemp = null;
        if(!arg0_52id.equals("")){
         arg0_52idTemp  = arg0_52id;
        }
        String arg1_53id=  request.getParameter("arg1436");
            java.lang.String arg1_53idTemp = null;
        if(!arg1_53id.equals("")){
         arg1_53idTemp  = arg1_53id;
        }
        String arg2_54id=  request.getParameter("arg2438");
        int arg2_54idTemp  = Integer.parseInt(arg2_54id);
        String arg3_55id=  request.getParameter("arg3440");
            java.util.Calendar arg3_55idTemp = null;
        if(!arg3_55id.equals("")){
        java.text.DateFormat dateFormatarg3440 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3440  = dateFormatarg3440.parse(arg3_55id);
         arg3_55idTemp = new java.util.GregorianCalendar();
        arg3_55idTemp.setTime(dateTemparg3440);
        }
        String arg4_56id=  request.getParameter("arg4442");
            java.lang.String arg4_56idTemp = null;
        if(!arg4_56id.equals("")){
         arg4_56idTemp  = arg4_56id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_52idTemp,arg1_53idTemp,arg2_54idTemp,arg3_55idTemp,arg4_56idTemp);
break;
case 444:
        gotMethod = true;
        servidor.DataColeccionObject listarActividadesAgregadas444mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas444mtemp == null){
%>
<%=listarActividadesAgregadas444mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(listarActividadesAgregadas444mtemp != null){
java.lang.Object typeobj447 = listarActividadesAgregadas444mtemp.getObj();
        String tempResultobj447 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj447.toString());
        %>
        <%= tempResultobj447 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 449:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetes449mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes449mtemp == null){
%>
<%=listarPaquetes449mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(listarPaquetes449mtemp != null){
java.lang.Object typeobj452 = listarPaquetes449mtemp.getObj();
        String tempResultobj452 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj452.toString());
        %>
        <%= tempResultobj452 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 454:
        gotMethod = true;
        String arg0_57id=  request.getParameter("arg0469");
            java.lang.String arg0_57idTemp = null;
        if(!arg0_57id.equals("")){
         arg0_57idTemp  = arg0_57id;
        }
        servidor.DataPaquete obtenerDataPaquete454mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_57idTemp);
if(obtenerDataPaquete454mtemp == null){
%>
<%=obtenerDataPaquete454mtemp %>
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
if(obtenerDataPaquete454mtemp != null){
%>
<%=obtenerDataPaquete454mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete454mtemp != null){
java.util.Calendar typefechaAlta459 = obtenerDataPaquete454mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta459 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta459 = typefechaAlta459.getTime();
        String tempResultfechaAlta459 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta459.format(datefechaAlta459));
        %>
        <%= tempResultfechaAlta459 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete454mtemp != null){
java.lang.String typedescripcion461 = obtenerDataPaquete454mtemp.getDescripcion();
        String tempResultdescripcion461 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion461));
        %>
        <%= tempResultdescripcion461 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete454mtemp != null){
%>
<%=obtenerDataPaquete454mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete454mtemp != null){
java.lang.String typenombre465 = obtenerDataPaquete454mtemp.getNombre();
        String tempResultnombre465 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre465));
        %>
        <%= tempResultnombre465 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete454mtemp != null){
java.lang.String typeimagen467 = obtenerDataPaquete454mtemp.getImagen();
        String tempResultimagen467 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen467));
        %>
        <%= tempResultimagen467 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 471:
        gotMethod = true;
        String arg0_58id=  request.getParameter("arg0474");
            java.lang.String arg0_58idTemp = null;
        if(!arg0_58id.equals("")){
         arg0_58idTemp  = arg0_58id;
        }
        String arg1_59id=  request.getParameter("arg1476");
            java.lang.String arg1_59idTemp = null;
        if(!arg1_59id.equals("")){
         arg1_59idTemp  = arg1_59id;
        }
        String arg2_60id=  request.getParameter("arg2478");
            java.lang.String arg2_60idTemp = null;
        if(!arg2_60id.equals("")){
         arg2_60idTemp  = arg2_60id;
        }
        String arg3_61id=  request.getParameter("arg3480");
            java.lang.String arg3_61idTemp = null;
        if(!arg3_61id.equals("")){
         arg3_61idTemp  = arg3_61id;
        }
        String arg4_62id=  request.getParameter("arg4482");
            java.util.Calendar arg4_62idTemp = null;
        if(!arg4_62id.equals("")){
        java.text.DateFormat dateFormatarg4482 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4482  = dateFormatarg4482.parse(arg4_62id);
         arg4_62idTemp = new java.util.GregorianCalendar();
        arg4_62idTemp.setTime(dateTemparg4482);
        }
        String arg5_63id=  request.getParameter("arg5484");
            java.lang.String arg5_63idTemp = null;
        if(!arg5_63id.equals("")){
         arg5_63idTemp  = arg5_63id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_58idTemp,arg1_59idTemp,arg2_60idTemp,arg3_61idTemp,arg4_62idTemp,arg5_63idTemp);
break;
case 486:
        gotMethod = true;
        String arg0_64id=  request.getParameter("arg0489");
            java.lang.String arg0_64idTemp = null;
        if(!arg0_64id.equals("")){
         arg0_64idTemp  = arg0_64id;
        }
        String arg1_65id=  request.getParameter("arg1491");
            java.lang.String arg1_65idTemp = null;
        if(!arg1_65id.equals("")){
         arg1_65idTemp  = arg1_65id;
        }
        String arg2_66id=  request.getParameter("arg2493");
            java.lang.String arg2_66idTemp = null;
        if(!arg2_66id.equals("")){
         arg2_66idTemp  = arg2_66id;
        }
        String arg3_67id=  request.getParameter("arg3495");
            java.lang.String arg3_67idTemp = null;
        if(!arg3_67id.equals("")){
         arg3_67idTemp  = arg3_67id;
        }
        String arg4_68id=  request.getParameter("arg4497");
            java.util.Calendar arg4_68idTemp = null;
        if(!arg4_68id.equals("")){
        java.text.DateFormat dateFormatarg4497 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4497  = dateFormatarg4497.parse(arg4_68id);
         arg4_68idTemp = new java.util.GregorianCalendar();
        arg4_68idTemp.setTime(dateTemparg4497);
        }
        String arg5_69id=  request.getParameter("arg5499");
            java.lang.String arg5_69idTemp = null;
        if(!arg5_69id.equals("")){
         arg5_69idTemp  = arg5_69id;
        }
        String arg6_70id=  request.getParameter("arg6501");
            java.lang.String arg6_70idTemp = null;
        if(!arg6_70id.equals("")){
         arg6_70idTemp  = arg6_70id;
        }
        String arg7_71id=  request.getParameter("arg7503");
        boolean arg7_71idTemp  = Boolean.valueOf(arg7_71id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_64idTemp,arg1_65idTemp,arg2_66idTemp,arg3_67idTemp,arg4_68idTemp,arg5_69idTemp,arg6_70idTemp,arg7_71idTemp);
break;
case 505:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 508:
        gotMethod = true;
        String arg0_72id=  request.getParameter("arg0511");
            java.lang.String arg0_72idTemp = null;
        if(!arg0_72id.equals("")){
         arg0_72idTemp  = arg0_72id;
        }
        String arg1_73id=  request.getParameter("arg1513");
            java.lang.String arg1_73idTemp = null;
        if(!arg1_73id.equals("")){
         arg1_73idTemp  = arg1_73id;
        }
        String arg2_74id=  request.getParameter("arg2515");
            java.lang.String arg2_74idTemp = null;
        if(!arg2_74id.equals("")){
         arg2_74idTemp  = arg2_74id;
        }
        String arg3_75id=  request.getParameter("arg3517");
            java.lang.String arg3_75idTemp = null;
        if(!arg3_75id.equals("")){
         arg3_75idTemp  = arg3_75id;
        }
        String arg4_76id=  request.getParameter("arg4519");
            java.util.Calendar arg4_76idTemp = null;
        if(!arg4_76id.equals("")){
        java.text.DateFormat dateFormatarg4519 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4519  = dateFormatarg4519.parse(arg4_76id);
         arg4_76idTemp = new java.util.GregorianCalendar();
        arg4_76idTemp.setTime(dateTemparg4519);
        }
        String arg5_77id=  request.getParameter("arg5521");
            java.lang.String arg5_77idTemp = null;
        if(!arg5_77id.equals("")){
         arg5_77idTemp  = arg5_77id;
        }
        String arg6_78id=  request.getParameter("arg6523");
            java.lang.String arg6_78idTemp = null;
        if(!arg6_78id.equals("")){
         arg6_78idTemp  = arg6_78id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_72idTemp,arg1_73idTemp,arg2_74idTemp,arg3_75idTemp,arg4_76idTemp,arg5_77idTemp,arg6_78idTemp);
break;
case 525:
        gotMethod = true;
        String arg0_79id=  request.getParameter("arg0528");
            java.lang.String arg0_79idTemp = null;
        if(!arg0_79id.equals("")){
         arg0_79idTemp  = arg0_79id;
        }
        String arg1_80id=  request.getParameter("arg1530");
            java.lang.String arg1_80idTemp = null;
        if(!arg1_80id.equals("")){
         arg1_80idTemp  = arg1_80id;
        }
        String arg2_81id=  request.getParameter("arg2532");
            java.lang.String arg2_81idTemp = null;
        if(!arg2_81id.equals("")){
         arg2_81idTemp  = arg2_81id;
        }
        String arg3_82id=  request.getParameter("arg3534");
            java.lang.String arg3_82idTemp = null;
        if(!arg3_82id.equals("")){
         arg3_82idTemp  = arg3_82id;
        }
        String arg4_83id=  request.getParameter("arg4536");
            java.util.Calendar arg4_83idTemp = null;
        if(!arg4_83id.equals("")){
        java.text.DateFormat dateFormatarg4536 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4536  = dateFormatarg4536.parse(arg4_83id);
         arg4_83idTemp = new java.util.GregorianCalendar();
        arg4_83idTemp.setTime(dateTemparg4536);
        }
        String arg5_84id=  request.getParameter("arg5538");
            java.lang.String arg5_84idTemp = null;
        if(!arg5_84id.equals("")){
         arg5_84idTemp  = arg5_84id;
        }
        String arg6_85id=  request.getParameter("arg6540");
            java.lang.String arg6_85idTemp = null;
        if(!arg6_85id.equals("")){
         arg6_85idTemp  = arg6_85id;
        }
        String arg7_86id=  request.getParameter("arg7542");
        boolean arg7_86idTemp  = Boolean.valueOf(arg7_86id).booleanValue();
        String arg8_87id=  request.getParameter("arg8544");
            java.lang.String arg8_87idTemp = null;
        if(!arg8_87id.equals("")){
         arg8_87idTemp  = arg8_87id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_79idTemp,arg1_80idTemp,arg2_81idTemp,arg3_82idTemp,arg4_83idTemp,arg5_84idTemp,arg6_85idTemp,arg7_86idTemp,arg8_87idTemp);
break;
case 546:
        gotMethod = true;
        String arg0_88id=  request.getParameter("arg0551");
            java.lang.String arg0_88idTemp = null;
        if(!arg0_88id.equals("")){
         arg0_88idTemp  = arg0_88id;
        }
        String arg1_89id=  request.getParameter("arg1553");
            java.lang.String arg1_89idTemp = null;
        if(!arg1_89id.equals("")){
         arg1_89idTemp  = arg1_89id;
        }
        servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete546mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_88idTemp,arg1_89idTemp);
if(actividadesPorDepartamentoNoEnPaquete546mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete546mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(actividadesPorDepartamentoNoEnPaquete546mtemp != null){
java.lang.Object typeobj549 = actividadesPorDepartamentoNoEnPaquete546mtemp.getObj();
        String tempResultobj549 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj549.toString());
        %>
        <%= tempResultobj549 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 555:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetesNoComprados555mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados555mtemp == null){
%>
<%=listarPaquetesNoComprados555mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">obj:</TD>
<TD>
<%
if(listarPaquetesNoComprados555mtemp != null){
java.lang.Object typeobj558 = listarPaquetesNoComprados555mtemp.getObj();
        String tempResultobj558 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj558.toString());
        %>
        <%= tempResultobj558 %>
        <%
}%>
</TD>
</TABLE>
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