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
        String fileName_1id=  request.getParameter("fileName20");
            java.lang.String fileName_1idTemp = null;
        if(!fileName_1id.equals("")){
         fileName_1idTemp  = fileName_1id;
        }
        byte[] getFile17mtemp = samplePublicadorIControladorProxyid.getFile(fileName_1idTemp);
if(getFile17mtemp == null){
%>
<%=getFile17mtemp %>
<%
}else{
        String tempreturnp18 = "[";        for(int ireturnp18=0;ireturnp18< getFile17mtemp.length;ireturnp18++){
            tempreturnp18 = tempreturnp18 + getFile17mtemp[ireturnp18] + ",";
        }
        int lengthreturnp18 = tempreturnp18.length();
        tempreturnp18 = tempreturnp18.substring(0,(lengthreturnp18 - 1)) + "]";
        %>
        <%=tempreturnp18%>
        <%
}
break;
case 22:
        gotMethod = true;
        servidor.DataDepartamento dataDepartamentoNull22mtemp = samplePublicadorIControladorProxyid.dataDepartamentoNull();
if(dataDepartamentoNull22mtemp == null){
%>
<%=dataDepartamentoNull22mtemp %>
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
if(dataDepartamentoNull22mtemp != null){
java.lang.String typedescripcion25 = dataDepartamentoNull22mtemp.getDescripcion();
        String tempResultdescripcion25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion25));
        %>
        <%= tempResultdescripcion25 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(dataDepartamentoNull22mtemp != null){
java.lang.String typeurl27 = dataDepartamentoNull22mtemp.getUrl();
        String tempResulturl27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl27));
        %>
        <%= tempResulturl27 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataDepartamentoNull22mtemp != null){
java.lang.String typenombre29 = dataDepartamentoNull22mtemp.getNombre();
        String tempResultnombre29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre29));
        %>
        <%= tempResultnombre29 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 31:
        gotMethod = true;
        servidor.DataTurista dataTuristaNull31mtemp = samplePublicadorIControladorProxyid.dataTuristaNull();
if(dataTuristaNull31mtemp == null){
%>
<%=dataTuristaNull31mtemp %>
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
if(dataTuristaNull31mtemp != null){
java.lang.String typenacionalidad34 = dataTuristaNull31mtemp.getNacionalidad();
        String tempResultnacionalidad34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenacionalidad34));
        %>
        <%= tempResultnacionalidad34 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 36:
        gotMethod = true;
        servidor.DataProveedor dataProveedorNull36mtemp = samplePublicadorIControladorProxyid.dataProveedorNull();
if(dataProveedorNull36mtemp == null){
%>
<%=dataProveedorNull36mtemp %>
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
if(dataProveedorNull36mtemp != null){
java.lang.String typedescripcion39 = dataProveedorNull36mtemp.getDescripcion();
        String tempResultdescripcion39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion39));
        %>
        <%= tempResultdescripcion39 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(dataProveedorNull36mtemp != null){
java.lang.String typelink41 = dataProveedorNull36mtemp.getLink();
        String tempResultlink41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink41));
        %>
        <%= tempResultlink41 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 43:
        gotMethod = true;
        servidor.DataActividad dataActividadNull43mtemp = samplePublicadorIControladorProxyid.dataActividadNull();
if(dataActividadNull43mtemp == null){
%>
<%=dataActividadNull43mtemp %>
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
if(dataActividadNull43mtemp != null){
java.util.Calendar typefechaAlta46 = dataActividadNull43mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta46 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta46 = typefechaAlta46.getTime();
        String tempResultfechaAlta46 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta46.format(datefechaAlta46));
        %>
        <%= tempResultfechaAlta46 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
java.lang.String typedepartamento48 = dataActividadNull43mtemp.getDepartamento();
        String tempResultdepartamento48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento48));
        %>
        <%= tempResultdepartamento48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
%>
<%=dataActividadNull43mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
java.lang.String typedescripcion52 = dataActividadNull43mtemp.getDescripcion();
        String tempResultdescripcion52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion52));
        %>
        <%= tempResultdescripcion52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
java.lang.String typeciudad54 = dataActividadNull43mtemp.getCiudad();
        String tempResultciudad54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad54));
        %>
        <%= tempResultciudad54 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
java.lang.String typelink56 = dataActividadNull43mtemp.getLink();
        String tempResultlink56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink56));
        %>
        <%= tempResultlink56 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
%>
<%=dataActividadNull43mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
%>
<%=dataActividadNull43mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
%>
<%=dataActividadNull43mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
java.lang.String typenombre64 = dataActividadNull43mtemp.getNombre();
        String tempResultnombre64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre64));
        %>
        <%= tempResultnombre64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataActividadNull43mtemp != null){
java.lang.String typeimagen66 = dataActividadNull43mtemp.getImagen();
        String tempResultimagen66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen66));
        %>
        <%= tempResultimagen66 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 68:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull68mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull68mtemp == null){
%>
<%=dataCGNull68mtemp %>
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
if(dataCGNull68mtemp != null){
java.util.Calendar typefecha71 = dataCGNull68mtemp.getFecha();
        java.text.DateFormat dateFormatfecha71 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha71 = typefecha71.getTime();
        String tempResultfecha71 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha71.format(datefecha71));
        %>
        <%= tempResultfecha71 %>
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
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta75 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta75 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta75 = typefechaAlta75.getTime();
        String tempResultfechaAlta75 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta75.format(datefechaAlta75));
        %>
        <%= tempResultfechaAlta75 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora77 = tebece0.getHora();
        java.text.DateFormat dateFormathora77 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora77 = typehora77.getTime();
        String tempResulthora77 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora77.format(datehora77));
        %>
        <%= tempResulthora77 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar79 = tebece0.getLugar();
        String tempResultlugar79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar79));
        %>
        <%= tempResultlugar79 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
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
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre83 = tebece0.getNombre();
        String tempResultnombre83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre83));
        %>
        <%= tempResultnombre83 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
if(tebece0 != null){
java.lang.String typeimagen85 = tebece0.getImagen();
        String tempResultimagen85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen85));
        %>
        <%= tempResultimagen85 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha87 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha87 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha87 = typefecha87.getTime();
        String tempResultfecha87 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha87.format(datefecha87));
        %>
        <%= tempResultfecha87 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
servidor.DataSalida tebece0=dataCGNull68mtemp.getSalida();
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
if(dataCGNull68mtemp != null){
%>
<%=dataCGNull68mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
%>
<%=dataCGNull68mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull68mtemp != null){
%>
<%=dataCGNull68mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 97:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull97mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull97mtemp == null){
%>
<%=dataCPNull97mtemp %>
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
if(dataCPNull97mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct100 = dataCPNull97mtemp.getRestAct();
        String temprestAct100 = null;
        if(typerestAct100 != null){
        java.util.List listrestAct100= java.util.Arrays.asList(typerestAct100);
        temprestAct100 = listrestAct100.toString();
        }
        %>
        <%=temprestAct100%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
java.util.Calendar typefecha102 = dataCPNull97mtemp.getFecha();
        java.text.DateFormat dateFormatfecha102 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha102 = typefecha102.getTime();
        String tempResultfecha102 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha102.format(datefecha102));
        %>
        <%= tempResultfecha102 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
%>
<%=dataCPNull97mtemp.getCantidad()
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
if(dataCPNull97mtemp != null){
servidor.DataPaquete tebece0=dataCPNull97mtemp.getPaq();
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
if(dataCPNull97mtemp != null){
servidor.DataPaquete tebece0=dataCPNull97mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta110 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta110 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta110 = typefechaAlta110.getTime();
        String tempResultfechaAlta110 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta110.format(datefechaAlta110));
        %>
        <%= tempResultfechaAlta110 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
servidor.DataPaquete tebece0=dataCPNull97mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion112 = tebece0.getDescripcion();
        String tempResultdescripcion112 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion112));
        %>
        <%= tempResultdescripcion112 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
servidor.DataPaquete tebece0=dataCPNull97mtemp.getPaq();
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
if(dataCPNull97mtemp != null){
servidor.DataPaquete tebece0=dataCPNull97mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre116 = tebece0.getNombre();
        String tempResultnombre116 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre116));
        %>
        <%= tempResultnombre116 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
servidor.DataPaquete tebece0=dataCPNull97mtemp.getPaq();
if(tebece0 != null){
java.lang.String typeimagen118 = tebece0.getImagen();
        String tempResultimagen118 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen118));
        %>
        <%= tempResultimagen118 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
java.util.Calendar typevencimiento120 = dataCPNull97mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento120 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento120 = typevencimiento120.getTime();
        String tempResultvencimiento120 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento120.format(datevencimiento120));
        %>
        <%= tempResultvencimiento120 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull97mtemp != null){
%>
<%=dataCPNull97mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 124:
        gotMethod = true;
        servidor.EstadoAct estadoActNull124mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull124mtemp == null){
%>
<%=estadoActNull124mtemp %>
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
case 129:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg0146");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        servidor.DataUsuario verInfoUsuario129mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_2idTemp);
if(verInfoUsuario129mtemp == null){
%>
<%=verInfoUsuario129mtemp %>
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
if(verInfoUsuario129mtemp != null){
java.util.Calendar typenacimiento132 = verInfoUsuario129mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento132 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento132 = typenacimiento132.getTime();
        String tempResultnacimiento132 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento132.format(datenacimiento132));
        %>
        <%= tempResultnacimiento132 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario129mtemp != null){
java.lang.String typenick134 = verInfoUsuario129mtemp.getNick();
        String tempResultnick134 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick134));
        %>
        <%= tempResultnick134 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario129mtemp != null){
java.lang.String typemail136 = verInfoUsuario129mtemp.getMail();
        String tempResultmail136 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail136));
        %>
        <%= tempResultmail136 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario129mtemp != null){
java.lang.String typepassword138 = verInfoUsuario129mtemp.getPassword();
        String tempResultpassword138 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword138));
        %>
        <%= tempResultpassword138 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario129mtemp != null){
java.lang.String typenombre140 = verInfoUsuario129mtemp.getNombre();
        String tempResultnombre140 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre140));
        %>
        <%= tempResultnombre140 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(verInfoUsuario129mtemp != null){
java.lang.String typeimagen142 = verInfoUsuario129mtemp.getImagen();
        String tempResultimagen142 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen142));
        %>
        <%= tempResultimagen142 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario129mtemp != null){
java.lang.String typeapellido144 = verInfoUsuario129mtemp.getApellido();
        String tempResultapellido144 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido144));
        %>
        <%= tempResultapellido144 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 148:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg0151");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        samplePublicadorIControladorProxyid.sumarVistaAAct(arg0_3idTemp);
break;
case 153:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0156");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        samplePublicadorIControladorProxyid.sumarVistaASal(arg0_4idTemp);
break;
case 158:
        gotMethod = true;
        java.lang.Object[] getUsuariosComp158mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp158mtemp == null){
%>
<%=getUsuariosComp158mtemp %>
<%
}else{
        String tempreturnp159 = null;
        if(getUsuariosComp158mtemp != null){
        java.util.List listreturnp159= java.util.Arrays.asList(getUsuariosComp158mtemp);
        tempreturnp159 = listreturnp159.toString();
        }
        %>
        <%=tempreturnp159%>
        <%
}
break;
case 161:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg0178");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        servidor.DataUsuario ingresarDatos161mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_5idTemp);
if(ingresarDatos161mtemp == null){
%>
<%=ingresarDatos161mtemp %>
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
if(ingresarDatos161mtemp != null){
java.util.Calendar typenacimiento164 = ingresarDatos161mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento164 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento164 = typenacimiento164.getTime();
        String tempResultnacimiento164 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento164.format(datenacimiento164));
        %>
        <%= tempResultnacimiento164 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos161mtemp != null){
java.lang.String typenick166 = ingresarDatos161mtemp.getNick();
        String tempResultnick166 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick166));
        %>
        <%= tempResultnick166 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos161mtemp != null){
java.lang.String typemail168 = ingresarDatos161mtemp.getMail();
        String tempResultmail168 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail168));
        %>
        <%= tempResultmail168 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos161mtemp != null){
java.lang.String typepassword170 = ingresarDatos161mtemp.getPassword();
        String tempResultpassword170 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword170));
        %>
        <%= tempResultpassword170 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos161mtemp != null){
java.lang.String typenombre172 = ingresarDatos161mtemp.getNombre();
        String tempResultnombre172 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre172));
        %>
        <%= tempResultnombre172 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(ingresarDatos161mtemp != null){
java.lang.String typeimagen174 = ingresarDatos161mtemp.getImagen();
        String tempResultimagen174 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen174));
        %>
        <%= tempResultimagen174 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos161mtemp != null){
java.lang.String typeapellido176 = ingresarDatos161mtemp.getApellido();
        String tempResultapellido176 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido176));
        %>
        <%= tempResultapellido176 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 180:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0183");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        java.lang.Object[] obtenerActividadCategoria180mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_6idTemp);
if(obtenerActividadCategoria180mtemp == null){
%>
<%=obtenerActividadCategoria180mtemp %>
<%
}else{
        String tempreturnp181 = null;
        if(obtenerActividadCategoria180mtemp != null){
        java.util.List listreturnp181= java.util.Arrays.asList(obtenerActividadCategoria180mtemp);
        tempreturnp181 = listreturnp181.toString();
        }
        %>
        <%=tempreturnp181%>
        <%
}
break;
case 185:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0202");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick185mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_7idTemp);
if(obtenerDataUsuarioNick185mtemp == null){
%>
<%=obtenerDataUsuarioNick185mtemp %>
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
if(obtenerDataUsuarioNick185mtemp != null){
java.util.Calendar typenacimiento188 = obtenerDataUsuarioNick185mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento188 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento188 = typenacimiento188.getTime();
        String tempResultnacimiento188 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento188.format(datenacimiento188));
        %>
        <%= tempResultnacimiento188 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick185mtemp != null){
java.lang.String typenick190 = obtenerDataUsuarioNick185mtemp.getNick();
        String tempResultnick190 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick190));
        %>
        <%= tempResultnick190 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick185mtemp != null){
java.lang.String typemail192 = obtenerDataUsuarioNick185mtemp.getMail();
        String tempResultmail192 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail192));
        %>
        <%= tempResultmail192 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick185mtemp != null){
java.lang.String typepassword194 = obtenerDataUsuarioNick185mtemp.getPassword();
        String tempResultpassword194 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword194));
        %>
        <%= tempResultpassword194 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick185mtemp != null){
java.lang.String typenombre196 = obtenerDataUsuarioNick185mtemp.getNombre();
        String tempResultnombre196 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre196));
        %>
        <%= tempResultnombre196 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioNick185mtemp != null){
java.lang.String typeimagen198 = obtenerDataUsuarioNick185mtemp.getImagen();
        String tempResultimagen198 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen198));
        %>
        <%= tempResultimagen198 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick185mtemp != null){
java.lang.String typeapellido200 = obtenerDataUsuarioNick185mtemp.getApellido();
        String tempResultapellido200 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido200));
        %>
        <%= tempResultapellido200 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 204:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0221");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail204mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_8idTemp);
if(obtenerDataUsuarioMail204mtemp == null){
%>
<%=obtenerDataUsuarioMail204mtemp %>
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
if(obtenerDataUsuarioMail204mtemp != null){
java.util.Calendar typenacimiento207 = obtenerDataUsuarioMail204mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento207 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento207 = typenacimiento207.getTime();
        String tempResultnacimiento207 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento207.format(datenacimiento207));
        %>
        <%= tempResultnacimiento207 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail204mtemp != null){
java.lang.String typenick209 = obtenerDataUsuarioMail204mtemp.getNick();
        String tempResultnick209 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick209));
        %>
        <%= tempResultnick209 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail204mtemp != null){
java.lang.String typemail211 = obtenerDataUsuarioMail204mtemp.getMail();
        String tempResultmail211 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail211));
        %>
        <%= tempResultmail211 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail204mtemp != null){
java.lang.String typepassword213 = obtenerDataUsuarioMail204mtemp.getPassword();
        String tempResultpassword213 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword213));
        %>
        <%= tempResultpassword213 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail204mtemp != null){
java.lang.String typenombre215 = obtenerDataUsuarioMail204mtemp.getNombre();
        String tempResultnombre215 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre215));
        %>
        <%= tempResultnombre215 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioMail204mtemp != null){
java.lang.String typeimagen217 = obtenerDataUsuarioMail204mtemp.getImagen();
        String tempResultimagen217 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen217));
        %>
        <%= tempResultimagen217 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail204mtemp != null){
java.lang.String typeapellido219 = obtenerDataUsuarioMail204mtemp.getApellido();
        String tempResultapellido219 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido219));
        %>
        <%= tempResultapellido219 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 223:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0248");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        servidor.DataActividad obtenerDataActividad223mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_9idTemp);
if(obtenerDataActividad223mtemp == null){
%>
<%=obtenerDataActividad223mtemp %>
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
if(obtenerDataActividad223mtemp != null){
java.util.Calendar typefechaAlta226 = obtenerDataActividad223mtemp.getFechaAlta();
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
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typedepartamento228 = obtenerDataActividad223mtemp.getDepartamento();
        String tempResultdepartamento228 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento228));
        %>
        <%= tempResultdepartamento228 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
%>
<%=obtenerDataActividad223mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typedescripcion232 = obtenerDataActividad223mtemp.getDescripcion();
        String tempResultdescripcion232 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion232));
        %>
        <%= tempResultdescripcion232 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typeciudad234 = obtenerDataActividad223mtemp.getCiudad();
        String tempResultciudad234 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad234));
        %>
        <%= tempResultciudad234 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typelink236 = obtenerDataActividad223mtemp.getLink();
        String tempResultlink236 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink236));
        %>
        <%= tempResultlink236 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
%>
<%=obtenerDataActividad223mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
%>
<%=obtenerDataActividad223mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
%>
<%=obtenerDataActividad223mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typenombre244 = obtenerDataActividad223mtemp.getNombre();
        String tempResultnombre244 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre244));
        %>
        <%= tempResultnombre244 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typeimagen246 = obtenerDataActividad223mtemp.getImagen();
        String tempResultimagen246 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen246));
        %>
        <%= tempResultimagen246 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 250:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0269");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        servidor.DataSalida obtenerDataSalida250mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_10idTemp);
if(obtenerDataSalida250mtemp == null){
%>
<%=obtenerDataSalida250mtemp %>
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
if(obtenerDataSalida250mtemp != null){
java.util.Calendar typefechaAlta253 = obtenerDataSalida250mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta253 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta253 = typefechaAlta253.getTime();
        String tempResultfechaAlta253 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta253.format(datefechaAlta253));
        %>
        <%= tempResultfechaAlta253 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
java.util.Calendar typehora255 = obtenerDataSalida250mtemp.getHora();
        java.text.DateFormat dateFormathora255 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora255 = typehora255.getTime();
        String tempResulthora255 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora255.format(datehora255));
        %>
        <%= tempResulthora255 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
java.lang.String typelugar257 = obtenerDataSalida250mtemp.getLugar();
        String tempResultlugar257 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar257));
        %>
        <%= tempResultlugar257 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
%>
<%=obtenerDataSalida250mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
java.lang.String typenombre261 = obtenerDataSalida250mtemp.getNombre();
        String tempResultnombre261 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre261));
        %>
        <%= tempResultnombre261 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
java.lang.String typeimagen263 = obtenerDataSalida250mtemp.getImagen();
        String tempResultimagen263 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen263));
        %>
        <%= tempResultimagen263 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
java.util.Calendar typefecha265 = obtenerDataSalida250mtemp.getFecha();
        java.text.DateFormat dateFormatfecha265 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha265 = typefecha265.getTime();
        String tempResultfecha265 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha265.format(datefecha265));
        %>
        <%= tempResultfecha265 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida250mtemp != null){
%>
<%=obtenerDataSalida250mtemp.getCant()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 271:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg0274");
            java.lang.String arg0_11idTemp = null;
        if(!arg0_11id.equals("")){
         arg0_11idTemp  = arg0_11id;
        }
        String arg1_12id=  request.getParameter("arg1276");
            java.util.Calendar arg1_12idTemp = null;
        if(!arg1_12id.equals("")){
        java.text.DateFormat dateFormatarg1276 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1276  = dateFormatarg1276.parse(arg1_12id);
         arg1_12idTemp = new java.util.GregorianCalendar();
        arg1_12idTemp.setTime(dateTemparg1276);
        }
        String arg2_13id=  request.getParameter("arg2278");
        int arg2_13idTemp  = Integer.parseInt(arg2_13id);
        String arg3_14id=  request.getParameter("arg3280");
            java.lang.String arg3_14idTemp = null;
        if(!arg3_14id.equals("")){
         arg3_14idTemp  = arg3_14id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_11idTemp,arg1_12idTemp,arg2_13idTemp,arg3_14idTemp);
break;
case 282:
        gotMethod = true;
        String arg0_15id=  request.getParameter("arg0285");
            java.lang.String arg0_15idTemp = null;
        if(!arg0_15id.equals("")){
         arg0_15idTemp  = arg0_15id;
        }
        String arg1_16id=  request.getParameter("arg1287");
            java.lang.String arg1_16idTemp = null;
        if(!arg1_16id.equals("")){
         arg1_16idTemp  = arg1_16id;
        }
        String arg2_17id=  request.getParameter("arg2289");
        int arg2_17idTemp  = Integer.parseInt(arg2_17id);
        String arg3_18id=  request.getParameter("arg3291");
            java.util.Calendar arg3_18idTemp = null;
        if(!arg3_18id.equals("")){
        java.text.DateFormat dateFormatarg3291 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3291  = dateFormatarg3291.parse(arg3_18id);
         arg3_18idTemp = new java.util.GregorianCalendar();
        arg3_18idTemp.setTime(dateTemparg3291);
        }
        String arg4_19id=  request.getParameter("arg4293");
            java.lang.String arg4_19idTemp = null;
        if(!arg4_19id.equals("")){
         arg4_19idTemp  = arg4_19id;
        }
        String arg5_20id=  request.getParameter("arg5295");
            java.lang.String arg5_20idTemp = null;
        if(!arg5_20id.equals("")){
         arg5_20idTemp  = arg5_20id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_15idTemp,arg1_16idTemp,arg2_17idTemp,arg3_18idTemp,arg4_19idTemp,arg5_20idTemp);
break;
case 297:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0300");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        java.lang.Object[] obtenerPaquetesComprados297mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_21idTemp);
if(obtenerPaquetesComprados297mtemp == null){
%>
<%=obtenerPaquetesComprados297mtemp %>
<%
}else{
        String tempreturnp298 = null;
        if(obtenerPaquetesComprados297mtemp != null){
        java.util.List listreturnp298= java.util.Arrays.asList(obtenerPaquetesComprados297mtemp);
        tempreturnp298 = listreturnp298.toString();
        }
        %>
        <%=tempreturnp298%>
        <%
}
break;
case 302:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0305");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        java.lang.String obtenerNomActPorSalida302mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_22idTemp);
if(obtenerNomActPorSalida302mtemp == null){
%>
<%=obtenerNomActPorSalida302mtemp %>
<%
}else{
        String tempResultreturnp303 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida302mtemp));
        %>
        <%= tempResultreturnp303 %>
        <%
}
break;
case 307:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0310");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg1312");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        String arg2_25id=  request.getParameter("arg2314");
        boolean arg2_25idTemp  = Boolean.valueOf(arg2_25id).booleanValue();
        samplePublicadorIControladorProxyid.seguirDejarDeSeguirUsuario(arg0_23idTemp,arg1_24idTemp,arg2_25idTemp);
break;
case 316:
        gotMethod = true;
        String arg0_26id=  request.getParameter("arg0319");
            java.lang.String arg0_26idTemp = null;
        if(!arg0_26id.equals("")){
         arg0_26idTemp  = arg0_26id;
        }
        String arg1_27id=  request.getParameter("arg1321");
            java.lang.String arg1_27idTemp = null;
        if(!arg1_27id.equals("")){
         arg1_27idTemp  = arg1_27id;
        }
        String arg2_28id=  request.getParameter("arg2323");
        boolean arg2_28idTemp  = Boolean.valueOf(arg2_28id).booleanValue();
        samplePublicadorIControladorProxyid.agregarQuitarActividadFavorita(arg0_26idTemp,arg1_27idTemp,arg2_28idTemp);
break;
case 325:
        gotMethod = true;
        String arg0_29id=  request.getParameter("arg0328");
            java.lang.String arg0_29idTemp = null;
        if(!arg0_29id.equals("")){
         arg0_29idTemp  = arg0_29id;
        }
        String arg1_30id=  request.getParameter("arg1330");
            java.lang.String arg1_30idTemp = null;
        if(!arg1_30id.equals("")){
         arg1_30idTemp  = arg1_30id;
        }
        samplePublicadorIControladorProxyid.finalizarActividad(arg0_29idTemp,arg1_30idTemp);
break;
case 332:
        gotMethod = true;
        java.lang.Object[] listarUsuarios332mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios332mtemp == null){
%>
<%=listarUsuarios332mtemp %>
<%
}else{
        String tempreturnp333 = null;
        if(listarUsuarios332mtemp != null){
        java.util.List listreturnp333= java.util.Arrays.asList(listarUsuarios332mtemp);
        tempreturnp333 = listreturnp333.toString();
        }
        %>
        <%=tempreturnp333%>
        <%
}
break;
case 335:
        gotMethod = true;
        java.lang.Object[] obtenerDataDepartamentos335mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos335mtemp == null){
%>
<%=obtenerDataDepartamentos335mtemp %>
<%
}else{
        String tempreturnp336 = null;
        if(obtenerDataDepartamentos335mtemp != null){
        java.util.List listreturnp336= java.util.Arrays.asList(obtenerDataDepartamentos335mtemp);
        tempreturnp336 = listreturnp336.toString();
        }
        %>
        <%=tempreturnp336%>
        <%
}
break;
case 338:
        gotMethod = true;
        String arg0_31id=  request.getParameter("arg0341");
            java.lang.String arg0_31idTemp = null;
        if(!arg0_31id.equals("")){
         arg0_31idTemp  = arg0_31id;
        }
        String arg1_32id=  request.getParameter("arg1343");
            java.lang.String arg1_32idTemp = null;
        if(!arg1_32id.equals("")){
         arg1_32idTemp  = arg1_32id;
        }
        String arg2_33id=  request.getParameter("arg2345");
            java.util.Calendar arg2_33idTemp = null;
        if(!arg2_33id.equals("")){
        java.text.DateFormat dateFormatarg2345 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2345  = dateFormatarg2345.parse(arg2_33id);
         arg2_33idTemp = new java.util.GregorianCalendar();
        arg2_33idTemp.setTime(dateTemparg2345);
        }
        String arg3_34id=  request.getParameter("arg3347");
            java.util.Calendar arg3_34idTemp = null;
        if(!arg3_34id.equals("")){
        java.text.DateFormat dateFormatarg3347 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3347  = dateFormatarg3347.parse(arg3_34id);
         arg3_34idTemp = new java.util.GregorianCalendar();
        arg3_34idTemp.setTime(dateTemparg3347);
        }
        String arg4_35id=  request.getParameter("arg4349");
            java.lang.String arg4_35idTemp = null;
        if(!arg4_35id.equals("")){
         arg4_35idTemp  = arg4_35id;
        }
        String arg5_36id=  request.getParameter("arg5351");
        int arg5_36idTemp  = Integer.parseInt(arg5_36id);
        String arg6_37id=  request.getParameter("arg6353");
            java.util.Calendar arg6_37idTemp = null;
        if(!arg6_37id.equals("")){
        java.text.DateFormat dateFormatarg6353 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6353  = dateFormatarg6353.parse(arg6_37id);
         arg6_37idTemp = new java.util.GregorianCalendar();
        arg6_37idTemp.setTime(dateTemparg6353);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_31idTemp,arg1_32idTemp,arg2_33idTemp,arg3_34idTemp,arg4_35idTemp,arg5_36idTemp,arg6_37idTemp);
break;
case 355:
        gotMethod = true;
        java.lang.Object[] getUsuarios355mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios355mtemp == null){
%>
<%=getUsuarios355mtemp %>
<%
}else{
        String tempreturnp356 = null;
        if(getUsuarios355mtemp != null){
        java.util.List listreturnp356= java.util.Arrays.asList(getUsuarios355mtemp);
        tempreturnp356 = listreturnp356.toString();
        }
        %>
        <%=tempreturnp356%>
        <%
}
break;
case 358:
        gotMethod = true;
        java.lang.Object[] obtenerNombreCategorias358mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias358mtemp == null){
%>
<%=obtenerNombreCategorias358mtemp %>
<%
}else{
        String tempreturnp359 = null;
        if(obtenerNombreCategorias358mtemp != null){
        java.util.List listreturnp359= java.util.Arrays.asList(obtenerNombreCategorias358mtemp);
        tempreturnp359 = listreturnp359.toString();
        }
        %>
        <%=tempreturnp359%>
        <%
}
break;
case 361:
        gotMethod = true;
        String arg0_38id=  request.getParameter("arg0364");
            java.lang.String arg0_38idTemp = null;
        if(!arg0_38id.equals("")){
         arg0_38idTemp  = arg0_38id;
        }
        java.lang.Object[] selecDepartamento361mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_38idTemp);
if(selecDepartamento361mtemp == null){
%>
<%=selecDepartamento361mtemp %>
<%
}else{
        String tempreturnp362 = null;
        if(selecDepartamento361mtemp != null){
        java.util.List listreturnp362= java.util.Arrays.asList(selecDepartamento361mtemp);
        tempreturnp362 = listreturnp362.toString();
        }
        %>
        <%=tempreturnp362%>
        <%
}
break;
case 366:
        gotMethod = true;
        String arg0_39id=  request.getParameter("arg0369");
            java.lang.String arg0_39idTemp = null;
        if(!arg0_39id.equals("")){
         arg0_39idTemp  = arg0_39id;
        }
        java.lang.Object[] salidas366mtemp = samplePublicadorIControladorProxyid.salidas(arg0_39idTemp);
if(salidas366mtemp == null){
%>
<%=salidas366mtemp %>
<%
}else{
        String tempreturnp367 = null;
        if(salidas366mtemp != null){
        java.util.List listreturnp367= java.util.Arrays.asList(salidas366mtemp);
        tempreturnp367 = listreturnp367.toString();
        }
        %>
        <%=tempreturnp367%>
        <%
}
break;
case 371:
        gotMethod = true;
        String arg0_40id=  request.getParameter("arg0374");
            java.lang.String arg0_40idTemp = null;
        if(!arg0_40id.equals("")){
         arg0_40idTemp  = arg0_40id;
        }
        String arg1_41id=  request.getParameter("arg1376");
            java.lang.String arg1_41idTemp = null;
        if(!arg1_41id.equals("")){
         arg1_41idTemp  = arg1_41id;
        }
        String arg2_42id=  request.getParameter("arg2378");
        int arg2_42idTemp  = Integer.parseInt(arg2_42id);
        String arg3_43id=  request.getParameter("arg3380");
            java.util.Calendar arg3_43idTemp = null;
        if(!arg3_43id.equals("")){
        java.text.DateFormat dateFormatarg3380 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3380  = dateFormatarg3380.parse(arg3_43id);
         arg3_43idTemp = new java.util.GregorianCalendar();
        arg3_43idTemp.setTime(dateTemparg3380);
        }
        String arg4_44id=  request.getParameter("arg4382");
            java.lang.String arg4_44idTemp = null;
        if(!arg4_44id.equals("")){
         arg4_44idTemp  = arg4_44id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_40idTemp,arg1_41idTemp,arg2_42idTemp,arg3_43idTemp,arg4_44idTemp);
break;
case 384:
        gotMethod = true;
        java.lang.Object[] listarActividadesAgregadas384mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas384mtemp == null){
%>
<%=listarActividadesAgregadas384mtemp %>
<%
}else{
        String tempreturnp385 = null;
        if(listarActividadesAgregadas384mtemp != null){
        java.util.List listreturnp385= java.util.Arrays.asList(listarActividadesAgregadas384mtemp);
        tempreturnp385 = listreturnp385.toString();
        }
        %>
        <%=tempreturnp385%>
        <%
}
break;
case 387:
        gotMethod = true;
        java.lang.Object[] listarPaquetes387mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes387mtemp == null){
%>
<%=listarPaquetes387mtemp %>
<%
}else{
        String tempreturnp388 = null;
        if(listarPaquetes387mtemp != null){
        java.util.List listreturnp388= java.util.Arrays.asList(listarPaquetes387mtemp);
        tempreturnp388 = listreturnp388.toString();
        }
        %>
        <%=tempreturnp388%>
        <%
}
break;
case 390:
        gotMethod = true;
        String arg0_45id=  request.getParameter("arg0405");
            java.lang.String arg0_45idTemp = null;
        if(!arg0_45id.equals("")){
         arg0_45idTemp  = arg0_45id;
        }
        servidor.DataPaquete obtenerDataPaquete390mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_45idTemp);
if(obtenerDataPaquete390mtemp == null){
%>
<%=obtenerDataPaquete390mtemp %>
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
if(obtenerDataPaquete390mtemp != null){
%>
<%=obtenerDataPaquete390mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete390mtemp != null){
java.util.Calendar typefechaAlta395 = obtenerDataPaquete390mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta395 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta395 = typefechaAlta395.getTime();
        String tempResultfechaAlta395 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta395.format(datefechaAlta395));
        %>
        <%= tempResultfechaAlta395 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete390mtemp != null){
java.lang.String typedescripcion397 = obtenerDataPaquete390mtemp.getDescripcion();
        String tempResultdescripcion397 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion397));
        %>
        <%= tempResultdescripcion397 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete390mtemp != null){
%>
<%=obtenerDataPaquete390mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete390mtemp != null){
java.lang.String typenombre401 = obtenerDataPaquete390mtemp.getNombre();
        String tempResultnombre401 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre401));
        %>
        <%= tempResultnombre401 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete390mtemp != null){
java.lang.String typeimagen403 = obtenerDataPaquete390mtemp.getImagen();
        String tempResultimagen403 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen403));
        %>
        <%= tempResultimagen403 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 407:
        gotMethod = true;
        String arg0_46id=  request.getParameter("arg0410");
            java.lang.String arg0_46idTemp = null;
        if(!arg0_46id.equals("")){
         arg0_46idTemp  = arg0_46id;
        }
        String arg1_47id=  request.getParameter("arg1412");
            java.lang.String arg1_47idTemp = null;
        if(!arg1_47id.equals("")){
         arg1_47idTemp  = arg1_47id;
        }
        String arg2_48id=  request.getParameter("arg2414");
            java.lang.String arg2_48idTemp = null;
        if(!arg2_48id.equals("")){
         arg2_48idTemp  = arg2_48id;
        }
        String arg3_49id=  request.getParameter("arg3416");
            java.lang.String arg3_49idTemp = null;
        if(!arg3_49id.equals("")){
         arg3_49idTemp  = arg3_49id;
        }
        String arg4_50id=  request.getParameter("arg4418");
            java.util.Calendar arg4_50idTemp = null;
        if(!arg4_50id.equals("")){
        java.text.DateFormat dateFormatarg4418 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4418  = dateFormatarg4418.parse(arg4_50id);
         arg4_50idTemp = new java.util.GregorianCalendar();
        arg4_50idTemp.setTime(dateTemparg4418);
        }
        String arg5_51id=  request.getParameter("arg5420");
            java.lang.String arg5_51idTemp = null;
        if(!arg5_51id.equals("")){
         arg5_51idTemp  = arg5_51id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_46idTemp,arg1_47idTemp,arg2_48idTemp,arg3_49idTemp,arg4_50idTemp,arg5_51idTemp);
break;
case 422:
        gotMethod = true;
        String arg0_52id=  request.getParameter("arg0425");
            java.lang.String arg0_52idTemp = null;
        if(!arg0_52id.equals("")){
         arg0_52idTemp  = arg0_52id;
        }
        String arg1_53id=  request.getParameter("arg1427");
            java.lang.String arg1_53idTemp = null;
        if(!arg1_53id.equals("")){
         arg1_53idTemp  = arg1_53id;
        }
        String arg2_54id=  request.getParameter("arg2429");
            java.lang.String arg2_54idTemp = null;
        if(!arg2_54id.equals("")){
         arg2_54idTemp  = arg2_54id;
        }
        String arg3_55id=  request.getParameter("arg3431");
            java.lang.String arg3_55idTemp = null;
        if(!arg3_55id.equals("")){
         arg3_55idTemp  = arg3_55id;
        }
        String arg4_56id=  request.getParameter("arg4433");
            java.util.Calendar arg4_56idTemp = null;
        if(!arg4_56id.equals("")){
        java.text.DateFormat dateFormatarg4433 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4433  = dateFormatarg4433.parse(arg4_56id);
         arg4_56idTemp = new java.util.GregorianCalendar();
        arg4_56idTemp.setTime(dateTemparg4433);
        }
        String arg5_57id=  request.getParameter("arg5435");
            java.lang.String arg5_57idTemp = null;
        if(!arg5_57id.equals("")){
         arg5_57idTemp  = arg5_57id;
        }
        String arg6_58id=  request.getParameter("arg6437");
            java.lang.String arg6_58idTemp = null;
        if(!arg6_58id.equals("")){
         arg6_58idTemp  = arg6_58id;
        }
        String arg7_59id=  request.getParameter("arg7439");
        boolean arg7_59idTemp  = Boolean.valueOf(arg7_59id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_52idTemp,arg1_53idTemp,arg2_54idTemp,arg3_55idTemp,arg4_56idTemp,arg5_57idTemp,arg6_58idTemp,arg7_59idTemp);
break;
case 441:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 444:
        gotMethod = true;
        String arg0_60id=  request.getParameter("arg0447");
            java.lang.String arg0_60idTemp = null;
        if(!arg0_60id.equals("")){
         arg0_60idTemp  = arg0_60id;
        }
        String arg1_61id=  request.getParameter("arg1449");
            java.lang.String arg1_61idTemp = null;
        if(!arg1_61id.equals("")){
         arg1_61idTemp  = arg1_61id;
        }
        String arg2_62id=  request.getParameter("arg2451");
            java.lang.String arg2_62idTemp = null;
        if(!arg2_62id.equals("")){
         arg2_62idTemp  = arg2_62id;
        }
        String arg3_63id=  request.getParameter("arg3453");
            java.lang.String arg3_63idTemp = null;
        if(!arg3_63id.equals("")){
         arg3_63idTemp  = arg3_63id;
        }
        String arg4_64id=  request.getParameter("arg4455");
            java.util.Calendar arg4_64idTemp = null;
        if(!arg4_64id.equals("")){
        java.text.DateFormat dateFormatarg4455 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4455  = dateFormatarg4455.parse(arg4_64id);
         arg4_64idTemp = new java.util.GregorianCalendar();
        arg4_64idTemp.setTime(dateTemparg4455);
        }
        String arg5_65id=  request.getParameter("arg5457");
            java.lang.String arg5_65idTemp = null;
        if(!arg5_65id.equals("")){
         arg5_65idTemp  = arg5_65id;
        }
        String arg6_66id=  request.getParameter("arg6459");
            java.lang.String arg6_66idTemp = null;
        if(!arg6_66id.equals("")){
         arg6_66idTemp  = arg6_66id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_60idTemp,arg1_61idTemp,arg2_62idTemp,arg3_63idTemp,arg4_64idTemp,arg5_65idTemp,arg6_66idTemp);
break;
case 461:
        gotMethod = true;
        String arg0_67id=  request.getParameter("arg0464");
            java.lang.String arg0_67idTemp = null;
        if(!arg0_67id.equals("")){
         arg0_67idTemp  = arg0_67id;
        }
        String arg1_68id=  request.getParameter("arg1466");
            java.lang.String arg1_68idTemp = null;
        if(!arg1_68id.equals("")){
         arg1_68idTemp  = arg1_68id;
        }
        String arg2_69id=  request.getParameter("arg2468");
            java.lang.String arg2_69idTemp = null;
        if(!arg2_69id.equals("")){
         arg2_69idTemp  = arg2_69id;
        }
        String arg3_70id=  request.getParameter("arg3470");
            java.lang.String arg3_70idTemp = null;
        if(!arg3_70id.equals("")){
         arg3_70idTemp  = arg3_70id;
        }
        String arg4_71id=  request.getParameter("arg4472");
            java.util.Calendar arg4_71idTemp = null;
        if(!arg4_71id.equals("")){
        java.text.DateFormat dateFormatarg4472 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4472  = dateFormatarg4472.parse(arg4_71id);
         arg4_71idTemp = new java.util.GregorianCalendar();
        arg4_71idTemp.setTime(dateTemparg4472);
        }
        String arg5_72id=  request.getParameter("arg5474");
            java.lang.String arg5_72idTemp = null;
        if(!arg5_72id.equals("")){
         arg5_72idTemp  = arg5_72id;
        }
        String arg6_73id=  request.getParameter("arg6476");
            java.lang.String arg6_73idTemp = null;
        if(!arg6_73id.equals("")){
         arg6_73idTemp  = arg6_73id;
        }
        String arg7_74id=  request.getParameter("arg7478");
        boolean arg7_74idTemp  = Boolean.valueOf(arg7_74id).booleanValue();
        String arg8_75id=  request.getParameter("arg8480");
            java.lang.String arg8_75idTemp = null;
        if(!arg8_75id.equals("")){
         arg8_75idTemp  = arg8_75id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_67idTemp,arg1_68idTemp,arg2_69idTemp,arg3_70idTemp,arg4_71idTemp,arg5_72idTemp,arg6_73idTemp,arg7_74idTemp,arg8_75idTemp);
break;
case 482:
        gotMethod = true;
        String arg0_76id=  request.getParameter("arg0485");
            java.lang.String arg0_76idTemp = null;
        if(!arg0_76id.equals("")){
         arg0_76idTemp  = arg0_76id;
        }
        String arg1_77id=  request.getParameter("arg1487");
            java.lang.String arg1_77idTemp = null;
        if(!arg1_77id.equals("")){
         arg1_77idTemp  = arg1_77id;
        }
        java.lang.Object[] actividadesPorDepartamentoNoEnPaquete482mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_76idTemp,arg1_77idTemp);
if(actividadesPorDepartamentoNoEnPaquete482mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete482mtemp %>
<%
}else{
        String tempreturnp483 = null;
        if(actividadesPorDepartamentoNoEnPaquete482mtemp != null){
        java.util.List listreturnp483= java.util.Arrays.asList(actividadesPorDepartamentoNoEnPaquete482mtemp);
        tempreturnp483 = listreturnp483.toString();
        }
        %>
        <%=tempreturnp483%>
        <%
}
break;
case 489:
        gotMethod = true;
        java.lang.Object[] listarPaquetesNoComprados489mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados489mtemp == null){
%>
<%=listarPaquetesNoComprados489mtemp %>
<%
}else{
        String tempreturnp490 = null;
        if(listarPaquetesNoComprados489mtemp != null){
        java.util.List listreturnp490= java.util.Arrays.asList(listarPaquetesNoComprados489mtemp);
        tempreturnp490 = listreturnp490.toString();
        }
        %>
        <%=tempreturnp490%>
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