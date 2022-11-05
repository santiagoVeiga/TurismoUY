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
        if(dataTuristaNull31mtemp!= null){
        String tempreturnp32 = dataTuristaNull31mtemp.toString();
        %>
        <%=tempreturnp32%>
        <%
        }}
break;
case 34:
        gotMethod = true;
        servidor.DataProveedor dataProveedorNull34mtemp = samplePublicadorIControladorProxyid.dataProveedorNull();
if(dataProveedorNull34mtemp == null){
%>
<%=dataProveedorNull34mtemp %>
<%
}else{
        if(dataProveedorNull34mtemp!= null){
        String tempreturnp35 = dataProveedorNull34mtemp.toString();
        %>
        <%=tempreturnp35%>
        <%
        }}
break;
case 37:
        gotMethod = true;
        servidor.DataActividad dataActividadNull37mtemp = samplePublicadorIControladorProxyid.dataActividadNull();
if(dataActividadNull37mtemp == null){
%>
<%=dataActividadNull37mtemp %>
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
if(dataActividadNull37mtemp != null){
java.util.Calendar typefechaAlta40 = dataActividadNull37mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta40 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta40 = typefechaAlta40.getTime();
        String tempResultfechaAlta40 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta40.format(datefechaAlta40));
        %>
        <%= tempResultfechaAlta40 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
java.lang.String typedepartamento42 = dataActividadNull37mtemp.getDepartamento();
        String tempResultdepartamento42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento42));
        %>
        <%= tempResultdepartamento42 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
%>
<%=dataActividadNull37mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
java.lang.String typedescripcion46 = dataActividadNull37mtemp.getDescripcion();
        String tempResultdescripcion46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion46));
        %>
        <%= tempResultdescripcion46 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
java.lang.String typeciudad48 = dataActividadNull37mtemp.getCiudad();
        String tempResultciudad48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad48));
        %>
        <%= tempResultciudad48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
%>
<%=dataActividadNull37mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
java.lang.String typenombre52 = dataActividadNull37mtemp.getNombre();
        String tempResultnombre52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre52));
        %>
        <%= tempResultnombre52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataActividadNull37mtemp != null){
java.lang.String typeimagen54 = dataActividadNull37mtemp.getImagen();
        String tempResultimagen54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen54));
        %>
        <%= tempResultimagen54 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 56:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull56mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull56mtemp == null){
%>
<%=dataCGNull56mtemp %>
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
if(dataCGNull56mtemp != null){
java.util.Calendar typefecha59 = dataCGNull56mtemp.getFecha();
        java.text.DateFormat dateFormatfecha59 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha59 = typefecha59.getTime();
        String tempResultfecha59 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha59.format(datefecha59));
        %>
        <%= tempResultfecha59 %>
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
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora63 = tebece0.getHora();
        java.text.DateFormat dateFormathora63 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora63 = typehora63.getTime();
        String tempResulthora63 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora63.format(datehora63));
        %>
        <%= tempResulthora63 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha65 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha65 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha65 = typefecha65.getTime();
        String tempResultfecha65 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha65.format(datefecha65));
        %>
        <%= tempResultfecha65 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
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
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
if(tebece0 != null){
java.lang.String typeimagen69 = tebece0.getImagen();
        String tempResultimagen69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen69));
        %>
        <%= tempResultimagen69 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta71 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta71 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta71 = typefechaAlta71.getTime();
        String tempResultfechaAlta71 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta71.format(datefechaAlta71));
        %>
        <%= tempResultfechaAlta71 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar73 = tebece0.getLugar();
        String tempResultlugar73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar73));
        %>
        <%= tempResultlugar73 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
servidor.DataSalida tebece0=dataCGNull56mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre75 = tebece0.getNombre();
        String tempResultnombre75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre75));
        %>
        <%= tempResultnombre75 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">porPaquete:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
%>
<%=dataCGNull56mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
%>
<%=dataCGNull56mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull56mtemp != null){
%>
<%=dataCGNull56mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 83:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull83mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull83mtemp == null){
%>
<%=dataCPNull83mtemp %>
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
if(dataCPNull83mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct86 = dataCPNull83mtemp.getRestAct();
        String temprestAct86 = null;
        if(typerestAct86 != null){
        java.util.List listrestAct86= java.util.Arrays.asList(typerestAct86);
        temprestAct86 = listrestAct86.toString();
        }
        %>
        <%=temprestAct86%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
java.util.Calendar typefecha88 = dataCPNull83mtemp.getFecha();
        java.text.DateFormat dateFormatfecha88 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha88 = typefecha88.getTime();
        String tempResultfecha88 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha88.format(datefecha88));
        %>
        <%= tempResultfecha88 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
%>
<%=dataCPNull83mtemp.getCantidad()
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
if(dataCPNull83mtemp != null){
servidor.DataPaquete tebece0=dataCPNull83mtemp.getPaq();
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
if(dataCPNull83mtemp != null){
servidor.DataPaquete tebece0=dataCPNull83mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta96 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta96 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta96 = typefechaAlta96.getTime();
        String tempResultfechaAlta96 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta96.format(datefechaAlta96));
        %>
        <%= tempResultfechaAlta96 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
servidor.DataPaquete tebece0=dataCPNull83mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion98 = tebece0.getDescripcion();
        String tempResultdescripcion98 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion98));
        %>
        <%= tempResultdescripcion98 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
servidor.DataPaquete tebece0=dataCPNull83mtemp.getPaq();
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
if(dataCPNull83mtemp != null){
servidor.DataPaquete tebece0=dataCPNull83mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre102 = tebece0.getNombre();
        String tempResultnombre102 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre102));
        %>
        <%= tempResultnombre102 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
servidor.DataPaquete tebece0=dataCPNull83mtemp.getPaq();
if(tebece0 != null){
java.lang.String typeimagen104 = tebece0.getImagen();
        String tempResultimagen104 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen104));
        %>
        <%= tempResultimagen104 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
java.util.Calendar typevencimiento106 = dataCPNull83mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento106 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento106 = typevencimiento106.getTime();
        String tempResultvencimiento106 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento106.format(datevencimiento106));
        %>
        <%= tempResultvencimiento106 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull83mtemp != null){
%>
<%=dataCPNull83mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 110:
        gotMethod = true;
        servidor.EstadoAct estadoActNull110mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull110mtemp == null){
%>
<%=estadoActNull110mtemp %>
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
case 115:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg0132");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        servidor.DataUsuario verInfoUsuario115mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_2idTemp);
if(verInfoUsuario115mtemp == null){
%>
<%=verInfoUsuario115mtemp %>
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
if(verInfoUsuario115mtemp != null){
java.util.Calendar typenacimiento118 = verInfoUsuario115mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento118 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento118 = typenacimiento118.getTime();
        String tempResultnacimiento118 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento118.format(datenacimiento118));
        %>
        <%= tempResultnacimiento118 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario115mtemp != null){
java.lang.String typenick120 = verInfoUsuario115mtemp.getNick();
        String tempResultnick120 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick120));
        %>
        <%= tempResultnick120 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario115mtemp != null){
java.lang.String typemail122 = verInfoUsuario115mtemp.getMail();
        String tempResultmail122 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail122));
        %>
        <%= tempResultmail122 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario115mtemp != null){
java.lang.String typepassword124 = verInfoUsuario115mtemp.getPassword();
        String tempResultpassword124 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword124));
        %>
        <%= tempResultpassword124 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario115mtemp != null){
java.lang.String typenombre126 = verInfoUsuario115mtemp.getNombre();
        String tempResultnombre126 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre126));
        %>
        <%= tempResultnombre126 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(verInfoUsuario115mtemp != null){
java.lang.String typeimagen128 = verInfoUsuario115mtemp.getImagen();
        String tempResultimagen128 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen128));
        %>
        <%= tempResultimagen128 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario115mtemp != null){
java.lang.String typeapellido130 = verInfoUsuario115mtemp.getApellido();
        String tempResultapellido130 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido130));
        %>
        <%= tempResultapellido130 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 134:
        gotMethod = true;
        java.lang.Object[] getUsuariosComp134mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp134mtemp == null){
%>
<%=getUsuariosComp134mtemp %>
<%
}else{
        String tempreturnp135 = null;
        if(getUsuariosComp134mtemp != null){
        java.util.List listreturnp135= java.util.Arrays.asList(getUsuariosComp134mtemp);
        tempreturnp135 = listreturnp135.toString();
        }
        %>
        <%=tempreturnp135%>
        <%
}
break;
case 137:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg0154");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        servidor.DataUsuario ingresarDatos137mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_3idTemp);
if(ingresarDatos137mtemp == null){
%>
<%=ingresarDatos137mtemp %>
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
if(ingresarDatos137mtemp != null){
java.util.Calendar typenacimiento140 = ingresarDatos137mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento140 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento140 = typenacimiento140.getTime();
        String tempResultnacimiento140 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento140.format(datenacimiento140));
        %>
        <%= tempResultnacimiento140 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos137mtemp != null){
java.lang.String typenick142 = ingresarDatos137mtemp.getNick();
        String tempResultnick142 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick142));
        %>
        <%= tempResultnick142 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos137mtemp != null){
java.lang.String typemail144 = ingresarDatos137mtemp.getMail();
        String tempResultmail144 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail144));
        %>
        <%= tempResultmail144 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos137mtemp != null){
java.lang.String typepassword146 = ingresarDatos137mtemp.getPassword();
        String tempResultpassword146 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword146));
        %>
        <%= tempResultpassword146 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos137mtemp != null){
java.lang.String typenombre148 = ingresarDatos137mtemp.getNombre();
        String tempResultnombre148 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre148));
        %>
        <%= tempResultnombre148 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(ingresarDatos137mtemp != null){
java.lang.String typeimagen150 = ingresarDatos137mtemp.getImagen();
        String tempResultimagen150 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen150));
        %>
        <%= tempResultimagen150 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos137mtemp != null){
java.lang.String typeapellido152 = ingresarDatos137mtemp.getApellido();
        String tempResultapellido152 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido152));
        %>
        <%= tempResultapellido152 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 156:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0159");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        java.lang.Object[] obtenerActividadCategoria156mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_4idTemp);
if(obtenerActividadCategoria156mtemp == null){
%>
<%=obtenerActividadCategoria156mtemp %>
<%
}else{
        String tempreturnp157 = null;
        if(obtenerActividadCategoria156mtemp != null){
        java.util.List listreturnp157= java.util.Arrays.asList(obtenerActividadCategoria156mtemp);
        tempreturnp157 = listreturnp157.toString();
        }
        %>
        <%=tempreturnp157%>
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
        servidor.DataUsuario obtenerDataUsuarioNick161mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_5idTemp);
if(obtenerDataUsuarioNick161mtemp == null){
%>
<%=obtenerDataUsuarioNick161mtemp %>
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
if(obtenerDataUsuarioNick161mtemp != null){
java.util.Calendar typenacimiento164 = obtenerDataUsuarioNick161mtemp.getNacimiento();
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
if(obtenerDataUsuarioNick161mtemp != null){
java.lang.String typenick166 = obtenerDataUsuarioNick161mtemp.getNick();
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
if(obtenerDataUsuarioNick161mtemp != null){
java.lang.String typemail168 = obtenerDataUsuarioNick161mtemp.getMail();
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
if(obtenerDataUsuarioNick161mtemp != null){
java.lang.String typepassword170 = obtenerDataUsuarioNick161mtemp.getPassword();
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
if(obtenerDataUsuarioNick161mtemp != null){
java.lang.String typenombre172 = obtenerDataUsuarioNick161mtemp.getNombre();
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
if(obtenerDataUsuarioNick161mtemp != null){
java.lang.String typeimagen174 = obtenerDataUsuarioNick161mtemp.getImagen();
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
if(obtenerDataUsuarioNick161mtemp != null){
java.lang.String typeapellido176 = obtenerDataUsuarioNick161mtemp.getApellido();
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
        String arg0_6id=  request.getParameter("arg0197");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail180mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_6idTemp);
if(obtenerDataUsuarioMail180mtemp == null){
%>
<%=obtenerDataUsuarioMail180mtemp %>
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
if(obtenerDataUsuarioMail180mtemp != null){
java.util.Calendar typenacimiento183 = obtenerDataUsuarioMail180mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento183 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento183 = typenacimiento183.getTime();
        String tempResultnacimiento183 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento183.format(datenacimiento183));
        %>
        <%= tempResultnacimiento183 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail180mtemp != null){
java.lang.String typenick185 = obtenerDataUsuarioMail180mtemp.getNick();
        String tempResultnick185 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick185));
        %>
        <%= tempResultnick185 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail180mtemp != null){
java.lang.String typemail187 = obtenerDataUsuarioMail180mtemp.getMail();
        String tempResultmail187 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail187));
        %>
        <%= tempResultmail187 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail180mtemp != null){
java.lang.String typepassword189 = obtenerDataUsuarioMail180mtemp.getPassword();
        String tempResultpassword189 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword189));
        %>
        <%= tempResultpassword189 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail180mtemp != null){
java.lang.String typenombre191 = obtenerDataUsuarioMail180mtemp.getNombre();
        String tempResultnombre191 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre191));
        %>
        <%= tempResultnombre191 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioMail180mtemp != null){
java.lang.String typeimagen193 = obtenerDataUsuarioMail180mtemp.getImagen();
        String tempResultimagen193 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen193));
        %>
        <%= tempResultimagen193 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail180mtemp != null){
java.lang.String typeapellido195 = obtenerDataUsuarioMail180mtemp.getApellido();
        String tempResultapellido195 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido195));
        %>
        <%= tempResultapellido195 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 199:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0218");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        servidor.DataActividad obtenerDataActividad199mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_7idTemp);
if(obtenerDataActividad199mtemp == null){
%>
<%=obtenerDataActividad199mtemp %>
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
if(obtenerDataActividad199mtemp != null){
java.util.Calendar typefechaAlta202 = obtenerDataActividad199mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta202 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta202 = typefechaAlta202.getTime();
        String tempResultfechaAlta202 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta202.format(datefechaAlta202));
        %>
        <%= tempResultfechaAlta202 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
java.lang.String typedepartamento204 = obtenerDataActividad199mtemp.getDepartamento();
        String tempResultdepartamento204 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento204));
        %>
        <%= tempResultdepartamento204 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
%>
<%=obtenerDataActividad199mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
java.lang.String typedescripcion208 = obtenerDataActividad199mtemp.getDescripcion();
        String tempResultdescripcion208 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion208));
        %>
        <%= tempResultdescripcion208 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
java.lang.String typeciudad210 = obtenerDataActividad199mtemp.getCiudad();
        String tempResultciudad210 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad210));
        %>
        <%= tempResultciudad210 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
%>
<%=obtenerDataActividad199mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
java.lang.String typenombre214 = obtenerDataActividad199mtemp.getNombre();
        String tempResultnombre214 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre214));
        %>
        <%= tempResultnombre214 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataActividad199mtemp != null){
java.lang.String typeimagen216 = obtenerDataActividad199mtemp.getImagen();
        String tempResultimagen216 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen216));
        %>
        <%= tempResultimagen216 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 220:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0237");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        servidor.DataSalida obtenerDataSalida220mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_8idTemp);
if(obtenerDataSalida220mtemp == null){
%>
<%=obtenerDataSalida220mtemp %>
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
if(obtenerDataSalida220mtemp != null){
java.util.Calendar typehora223 = obtenerDataSalida220mtemp.getHora();
        java.text.DateFormat dateFormathora223 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora223 = typehora223.getTime();
        String tempResulthora223 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora223.format(datehora223));
        %>
        <%= tempResulthora223 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida220mtemp != null){
java.util.Calendar typefecha225 = obtenerDataSalida220mtemp.getFecha();
        java.text.DateFormat dateFormatfecha225 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha225 = typefecha225.getTime();
        String tempResultfecha225 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha225.format(datefecha225));
        %>
        <%= tempResultfecha225 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida220mtemp != null){
%>
<%=obtenerDataSalida220mtemp.getCant()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataSalida220mtemp != null){
java.lang.String typeimagen229 = obtenerDataSalida220mtemp.getImagen();
        String tempResultimagen229 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen229));
        %>
        <%= tempResultimagen229 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataSalida220mtemp != null){
java.util.Calendar typefechaAlta231 = obtenerDataSalida220mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta231 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta231 = typefechaAlta231.getTime();
        String tempResultfechaAlta231 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta231.format(datefechaAlta231));
        %>
        <%= tempResultfechaAlta231 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida220mtemp != null){
java.lang.String typelugar233 = obtenerDataSalida220mtemp.getLugar();
        String tempResultlugar233 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar233));
        %>
        <%= tempResultlugar233 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida220mtemp != null){
java.lang.String typenombre235 = obtenerDataSalida220mtemp.getNombre();
        String tempResultnombre235 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre235));
        %>
        <%= tempResultnombre235 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 239:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0242");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        String arg1_10id=  request.getParameter("arg1244");
            java.util.Calendar arg1_10idTemp = null;
        if(!arg1_10id.equals("")){
        java.text.DateFormat dateFormatarg1244 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1244  = dateFormatarg1244.parse(arg1_10id);
         arg1_10idTemp = new java.util.GregorianCalendar();
        arg1_10idTemp.setTime(dateTemparg1244);
        }
        String arg2_11id=  request.getParameter("arg2246");
        int arg2_11idTemp  = Integer.parseInt(arg2_11id);
        String arg3_12id=  request.getParameter("arg3248");
            java.lang.String arg3_12idTemp = null;
        if(!arg3_12id.equals("")){
         arg3_12idTemp  = arg3_12id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_9idTemp,arg1_10idTemp,arg2_11idTemp,arg3_12idTemp);
break;
case 250:
        gotMethod = true;
        String arg0_13id=  request.getParameter("arg0253");
            java.lang.String arg0_13idTemp = null;
        if(!arg0_13id.equals("")){
         arg0_13idTemp  = arg0_13id;
        }
        String arg1_14id=  request.getParameter("arg1255");
            java.lang.String arg1_14idTemp = null;
        if(!arg1_14id.equals("")){
         arg1_14idTemp  = arg1_14id;
        }
        String arg2_15id=  request.getParameter("arg2257");
        int arg2_15idTemp  = Integer.parseInt(arg2_15id);
        String arg3_16id=  request.getParameter("arg3259");
            java.util.Calendar arg3_16idTemp = null;
        if(!arg3_16id.equals("")){
        java.text.DateFormat dateFormatarg3259 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3259  = dateFormatarg3259.parse(arg3_16id);
         arg3_16idTemp = new java.util.GregorianCalendar();
        arg3_16idTemp.setTime(dateTemparg3259);
        }
        String arg4_17id=  request.getParameter("arg4261");
            java.lang.String arg4_17idTemp = null;
        if(!arg4_17id.equals("")){
         arg4_17idTemp  = arg4_17id;
        }
        String arg5_18id=  request.getParameter("arg5263");
            java.lang.String arg5_18idTemp = null;
        if(!arg5_18id.equals("")){
         arg5_18idTemp  = arg5_18id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_13idTemp,arg1_14idTemp,arg2_15idTemp,arg3_16idTemp,arg4_17idTemp,arg5_18idTemp);
break;
case 265:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0268");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        java.lang.Object[] obtenerPaquetesComprados265mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_19idTemp);
if(obtenerPaquetesComprados265mtemp == null){
%>
<%=obtenerPaquetesComprados265mtemp %>
<%
}else{
        String tempreturnp266 = null;
        if(obtenerPaquetesComprados265mtemp != null){
        java.util.List listreturnp266= java.util.Arrays.asList(obtenerPaquetesComprados265mtemp);
        tempreturnp266 = listreturnp266.toString();
        }
        %>
        <%=tempreturnp266%>
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
        java.lang.String obtenerNomActPorSalida270mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_20idTemp);
if(obtenerNomActPorSalida270mtemp == null){
%>
<%=obtenerNomActPorSalida270mtemp %>
<%
}else{
        String tempResultreturnp271 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida270mtemp));
        %>
        <%= tempResultreturnp271 %>
        <%
}
break;
case 275:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0278");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        String arg1_22id=  request.getParameter("arg1280");
            java.lang.String arg1_22idTemp = null;
        if(!arg1_22id.equals("")){
         arg1_22idTemp  = arg1_22id;
        }
        String arg2_23id=  request.getParameter("arg2282");
        boolean arg2_23idTemp  = Boolean.valueOf(arg2_23id).booleanValue();
        samplePublicadorIControladorProxyid.seguirDejarDeSeguirUsuario(arg0_21idTemp,arg1_22idTemp,arg2_23idTemp);
break;
case 284:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0287");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1289");
            java.lang.String arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
         arg1_25idTemp  = arg1_25id;
        }
        String arg2_26id=  request.getParameter("arg2291");
        boolean arg2_26idTemp  = Boolean.valueOf(arg2_26id).booleanValue();
        samplePublicadorIControladorProxyid.agregarQuitarActividadFavorita(arg0_24idTemp,arg1_25idTemp,arg2_26idTemp);
break;
case 293:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0296");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        samplePublicadorIControladorProxyid.finalizarActividad(arg0_27idTemp);
break;
case 298:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0301");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        java.lang.Object[] selecDepartamento298mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_28idTemp);
if(selecDepartamento298mtemp == null){
%>
<%=selecDepartamento298mtemp %>
<%
}else{
        String tempreturnp299 = null;
        if(selecDepartamento298mtemp != null){
        java.util.List listreturnp299= java.util.Arrays.asList(selecDepartamento298mtemp);
        tempreturnp299 = listreturnp299.toString();
        }
        %>
        <%=tempreturnp299%>
        <%
}
break;
case 303:
        gotMethod = true;
        String arg0_29id=  request.getParameter("arg0306");
            java.lang.String arg0_29idTemp = null;
        if(!arg0_29id.equals("")){
         arg0_29idTemp  = arg0_29id;
        }
        java.lang.Object[] salidas303mtemp = samplePublicadorIControladorProxyid.salidas(arg0_29idTemp);
if(salidas303mtemp == null){
%>
<%=salidas303mtemp %>
<%
}else{
        String tempreturnp304 = null;
        if(salidas303mtemp != null){
        java.util.List listreturnp304= java.util.Arrays.asList(salidas303mtemp);
        tempreturnp304 = listreturnp304.toString();
        }
        %>
        <%=tempreturnp304%>
        <%
}
break;
case 308:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0311");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        String arg1_31id=  request.getParameter("arg1313");
            java.lang.String arg1_31idTemp = null;
        if(!arg1_31id.equals("")){
         arg1_31idTemp  = arg1_31id;
        }
        String arg2_32id=  request.getParameter("arg2315");
        int arg2_32idTemp  = Integer.parseInt(arg2_32id);
        String arg3_33id=  request.getParameter("arg3317");
            java.util.Calendar arg3_33idTemp = null;
        if(!arg3_33id.equals("")){
        java.text.DateFormat dateFormatarg3317 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3317  = dateFormatarg3317.parse(arg3_33id);
         arg3_33idTemp = new java.util.GregorianCalendar();
        arg3_33idTemp.setTime(dateTemparg3317);
        }
        String arg4_34id=  request.getParameter("arg4319");
            java.lang.String arg4_34idTemp = null;
        if(!arg4_34id.equals("")){
         arg4_34idTemp  = arg4_34id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_30idTemp,arg1_31idTemp,arg2_32idTemp,arg3_33idTemp,arg4_34idTemp);
break;
case 321:
        gotMethod = true;
        java.lang.Object[] listarUsuarios321mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios321mtemp == null){
%>
<%=listarUsuarios321mtemp %>
<%
}else{
        String tempreturnp322 = null;
        if(listarUsuarios321mtemp != null){
        java.util.List listreturnp322= java.util.Arrays.asList(listarUsuarios321mtemp);
        tempreturnp322 = listreturnp322.toString();
        }
        %>
        <%=tempreturnp322%>
        <%
}
break;
case 324:
        gotMethod = true;
        java.lang.Object[] getUsuarios324mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios324mtemp == null){
%>
<%=getUsuarios324mtemp %>
<%
}else{
        String tempreturnp325 = null;
        if(getUsuarios324mtemp != null){
        java.util.List listreturnp325= java.util.Arrays.asList(getUsuarios324mtemp);
        tempreturnp325 = listreturnp325.toString();
        }
        %>
        <%=tempreturnp325%>
        <%
}
break;
case 327:
        gotMethod = true;
        java.lang.Object[] obtenerNombreCategorias327mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias327mtemp == null){
%>
<%=obtenerNombreCategorias327mtemp %>
<%
}else{
        String tempreturnp328 = null;
        if(obtenerNombreCategorias327mtemp != null){
        java.util.List listreturnp328= java.util.Arrays.asList(obtenerNombreCategorias327mtemp);
        tempreturnp328 = listreturnp328.toString();
        }
        %>
        <%=tempreturnp328%>
        <%
}
break;
case 330:
        gotMethod = true;
        String arg0_35id=  request.getParameter("arg0333");
            java.lang.String arg0_35idTemp = null;
        if(!arg0_35id.equals("")){
         arg0_35idTemp  = arg0_35id;
        }
        String arg1_36id=  request.getParameter("arg1335");
            java.lang.String arg1_36idTemp = null;
        if(!arg1_36id.equals("")){
         arg1_36idTemp  = arg1_36id;
        }
        String arg2_37id=  request.getParameter("arg2337");
            java.util.Calendar arg2_37idTemp = null;
        if(!arg2_37id.equals("")){
        java.text.DateFormat dateFormatarg2337 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2337  = dateFormatarg2337.parse(arg2_37id);
         arg2_37idTemp = new java.util.GregorianCalendar();
        arg2_37idTemp.setTime(dateTemparg2337);
        }
        String arg3_38id=  request.getParameter("arg3339");
            java.util.Calendar arg3_38idTemp = null;
        if(!arg3_38id.equals("")){
        java.text.DateFormat dateFormatarg3339 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3339  = dateFormatarg3339.parse(arg3_38id);
         arg3_38idTemp = new java.util.GregorianCalendar();
        arg3_38idTemp.setTime(dateTemparg3339);
        }
        String arg4_39id=  request.getParameter("arg4341");
            java.lang.String arg4_39idTemp = null;
        if(!arg4_39id.equals("")){
         arg4_39idTemp  = arg4_39id;
        }
        String arg5_40id=  request.getParameter("arg5343");
        int arg5_40idTemp  = Integer.parseInt(arg5_40id);
        String arg6_41id=  request.getParameter("arg6345");
            java.util.Calendar arg6_41idTemp = null;
        if(!arg6_41id.equals("")){
        java.text.DateFormat dateFormatarg6345 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6345  = dateFormatarg6345.parse(arg6_41id);
         arg6_41idTemp = new java.util.GregorianCalendar();
        arg6_41idTemp.setTime(dateTemparg6345);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_35idTemp,arg1_36idTemp,arg2_37idTemp,arg3_38idTemp,arg4_39idTemp,arg5_40idTemp,arg6_41idTemp);
break;
case 347:
        gotMethod = true;
        String arg0_42id=  request.getParameter("arg0350");
            java.lang.String arg0_42idTemp = null;
        if(!arg0_42id.equals("")){
         arg0_42idTemp  = arg0_42id;
        }
        String arg1_43id=  request.getParameter("arg1352");
            java.lang.String arg1_43idTemp = null;
        if(!arg1_43id.equals("")){
         arg1_43idTemp  = arg1_43id;
        }
        String arg2_44id=  request.getParameter("arg2354");
            java.lang.String arg2_44idTemp = null;
        if(!arg2_44id.equals("")){
         arg2_44idTemp  = arg2_44id;
        }
        String arg3_45id=  request.getParameter("arg3356");
            java.lang.String arg3_45idTemp = null;
        if(!arg3_45id.equals("")){
         arg3_45idTemp  = arg3_45id;
        }
        String arg4_46id=  request.getParameter("arg4358");
            java.util.Calendar arg4_46idTemp = null;
        if(!arg4_46id.equals("")){
        java.text.DateFormat dateFormatarg4358 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4358  = dateFormatarg4358.parse(arg4_46id);
         arg4_46idTemp = new java.util.GregorianCalendar();
        arg4_46idTemp.setTime(dateTemparg4358);
        }
        String arg5_47id=  request.getParameter("arg5360");
            java.lang.String arg5_47idTemp = null;
        if(!arg5_47id.equals("")){
         arg5_47idTemp  = arg5_47id;
        }
        String arg6_48id=  request.getParameter("arg6362");
            java.lang.String arg6_48idTemp = null;
        if(!arg6_48id.equals("")){
         arg6_48idTemp  = arg6_48id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_42idTemp,arg1_43idTemp,arg2_44idTemp,arg3_45idTemp,arg4_46idTemp,arg5_47idTemp,arg6_48idTemp);
break;
case 364:
        gotMethod = true;
        String arg0_49id=  request.getParameter("arg0367");
            java.lang.String arg0_49idTemp = null;
        if(!arg0_49id.equals("")){
         arg0_49idTemp  = arg0_49id;
        }
        String arg1_50id=  request.getParameter("arg1369");
            java.lang.String arg1_50idTemp = null;
        if(!arg1_50id.equals("")){
         arg1_50idTemp  = arg1_50id;
        }
        String arg2_51id=  request.getParameter("arg2371");
            java.lang.String arg2_51idTemp = null;
        if(!arg2_51id.equals("")){
         arg2_51idTemp  = arg2_51id;
        }
        String arg3_52id=  request.getParameter("arg3373");
            java.lang.String arg3_52idTemp = null;
        if(!arg3_52id.equals("")){
         arg3_52idTemp  = arg3_52id;
        }
        String arg4_53id=  request.getParameter("arg4375");
            java.util.Calendar arg4_53idTemp = null;
        if(!arg4_53id.equals("")){
        java.text.DateFormat dateFormatarg4375 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4375  = dateFormatarg4375.parse(arg4_53id);
         arg4_53idTemp = new java.util.GregorianCalendar();
        arg4_53idTemp.setTime(dateTemparg4375);
        }
        String arg5_54id=  request.getParameter("arg5377");
            java.lang.String arg5_54idTemp = null;
        if(!arg5_54id.equals("")){
         arg5_54idTemp  = arg5_54id;
        }
        String arg6_55id=  request.getParameter("arg6379");
            java.lang.String arg6_55idTemp = null;
        if(!arg6_55id.equals("")){
         arg6_55idTemp  = arg6_55id;
        }
        String arg7_56id=  request.getParameter("arg7381");
        boolean arg7_56idTemp  = Boolean.valueOf(arg7_56id).booleanValue();
        String arg8_57id=  request.getParameter("arg8383");
            java.lang.String arg8_57idTemp = null;
        if(!arg8_57id.equals("")){
         arg8_57idTemp  = arg8_57id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_49idTemp,arg1_50idTemp,arg2_51idTemp,arg3_52idTemp,arg4_53idTemp,arg5_54idTemp,arg6_55idTemp,arg7_56idTemp,arg8_57idTemp);
break;
case 385:
        gotMethod = true;
        java.lang.Object[] listarPaquetes385mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes385mtemp == null){
%>
<%=listarPaquetes385mtemp %>
<%
}else{
        String tempreturnp386 = null;
        if(listarPaquetes385mtemp != null){
        java.util.List listreturnp386= java.util.Arrays.asList(listarPaquetes385mtemp);
        tempreturnp386 = listreturnp386.toString();
        }
        %>
        <%=tempreturnp386%>
        <%
}
break;
case 388:
        gotMethod = true;
        String arg0_58id=  request.getParameter("arg0403");
            java.lang.String arg0_58idTemp = null;
        if(!arg0_58id.equals("")){
         arg0_58idTemp  = arg0_58id;
        }
        servidor.DataPaquete obtenerDataPaquete388mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_58idTemp);
if(obtenerDataPaquete388mtemp == null){
%>
<%=obtenerDataPaquete388mtemp %>
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
if(obtenerDataPaquete388mtemp != null){
%>
<%=obtenerDataPaquete388mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete388mtemp != null){
java.util.Calendar typefechaAlta393 = obtenerDataPaquete388mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta393 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta393 = typefechaAlta393.getTime();
        String tempResultfechaAlta393 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta393.format(datefechaAlta393));
        %>
        <%= tempResultfechaAlta393 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete388mtemp != null){
java.lang.String typedescripcion395 = obtenerDataPaquete388mtemp.getDescripcion();
        String tempResultdescripcion395 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion395));
        %>
        <%= tempResultdescripcion395 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete388mtemp != null){
%>
<%=obtenerDataPaquete388mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete388mtemp != null){
java.lang.String typenombre399 = obtenerDataPaquete388mtemp.getNombre();
        String tempResultnombre399 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre399));
        %>
        <%= tempResultnombre399 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete388mtemp != null){
java.lang.String typeimagen401 = obtenerDataPaquete388mtemp.getImagen();
        String tempResultimagen401 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen401));
        %>
        <%= tempResultimagen401 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 405:
        gotMethod = true;
        String arg0_59id=  request.getParameter("arg0408");
            java.lang.String arg0_59idTemp = null;
        if(!arg0_59id.equals("")){
         arg0_59idTemp  = arg0_59id;
        }
        String arg1_60id=  request.getParameter("arg1410");
            java.lang.String arg1_60idTemp = null;
        if(!arg1_60id.equals("")){
         arg1_60idTemp  = arg1_60id;
        }
        String arg2_61id=  request.getParameter("arg2412");
            java.lang.String arg2_61idTemp = null;
        if(!arg2_61id.equals("")){
         arg2_61idTemp  = arg2_61id;
        }
        String arg3_62id=  request.getParameter("arg3414");
            java.lang.String arg3_62idTemp = null;
        if(!arg3_62id.equals("")){
         arg3_62idTemp  = arg3_62id;
        }
        String arg4_63id=  request.getParameter("arg4416");
            java.util.Calendar arg4_63idTemp = null;
        if(!arg4_63id.equals("")){
        java.text.DateFormat dateFormatarg4416 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4416  = dateFormatarg4416.parse(arg4_63id);
         arg4_63idTemp = new java.util.GregorianCalendar();
        arg4_63idTemp.setTime(dateTemparg4416);
        }
        String arg5_64id=  request.getParameter("arg5418");
            java.lang.String arg5_64idTemp = null;
        if(!arg5_64id.equals("")){
         arg5_64idTemp  = arg5_64id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_59idTemp,arg1_60idTemp,arg2_61idTemp,arg3_62idTemp,arg4_63idTemp,arg5_64idTemp);
break;
case 420:
        gotMethod = true;
        String arg0_65id=  request.getParameter("arg0423");
            java.lang.String arg0_65idTemp = null;
        if(!arg0_65id.equals("")){
         arg0_65idTemp  = arg0_65id;
        }
        String arg1_66id=  request.getParameter("arg1425");
            java.lang.String arg1_66idTemp = null;
        if(!arg1_66id.equals("")){
         arg1_66idTemp  = arg1_66id;
        }
        String arg2_67id=  request.getParameter("arg2427");
            java.lang.String arg2_67idTemp = null;
        if(!arg2_67id.equals("")){
         arg2_67idTemp  = arg2_67id;
        }
        String arg3_68id=  request.getParameter("arg3429");
            java.lang.String arg3_68idTemp = null;
        if(!arg3_68id.equals("")){
         arg3_68idTemp  = arg3_68id;
        }
        String arg4_69id=  request.getParameter("arg4431");
            java.util.Calendar arg4_69idTemp = null;
        if(!arg4_69id.equals("")){
        java.text.DateFormat dateFormatarg4431 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4431  = dateFormatarg4431.parse(arg4_69id);
         arg4_69idTemp = new java.util.GregorianCalendar();
        arg4_69idTemp.setTime(dateTemparg4431);
        }
        String arg5_70id=  request.getParameter("arg5433");
            java.lang.String arg5_70idTemp = null;
        if(!arg5_70id.equals("")){
         arg5_70idTemp  = arg5_70id;
        }
        String arg6_71id=  request.getParameter("arg6435");
            java.lang.String arg6_71idTemp = null;
        if(!arg6_71id.equals("")){
         arg6_71idTemp  = arg6_71id;
        }
        String arg7_72id=  request.getParameter("arg7437");
        boolean arg7_72idTemp  = Boolean.valueOf(arg7_72id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_65idTemp,arg1_66idTemp,arg2_67idTemp,arg3_68idTemp,arg4_69idTemp,arg5_70idTemp,arg6_71idTemp,arg7_72idTemp);
break;
case 439:
        gotMethod = true;
        java.lang.Object[] listarActividadesAgregadas439mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas439mtemp == null){
%>
<%=listarActividadesAgregadas439mtemp %>
<%
}else{
        String tempreturnp440 = null;
        if(listarActividadesAgregadas439mtemp != null){
        java.util.List listreturnp440= java.util.Arrays.asList(listarActividadesAgregadas439mtemp);
        tempreturnp440 = listreturnp440.toString();
        }
        %>
        <%=tempreturnp440%>
        <%
}
break;
case 442:
        gotMethod = true;
        String arg0_73id=  request.getParameter("arg0445");
            java.lang.String arg0_73idTemp = null;
        if(!arg0_73id.equals("")){
         arg0_73idTemp  = arg0_73id;
        }
        String arg1_74id=  request.getParameter("arg1447");
            java.lang.String arg1_74idTemp = null;
        if(!arg1_74id.equals("")){
         arg1_74idTemp  = arg1_74id;
        }
        java.lang.Object[] actividadesPorDepartamentoNoEnPaquete442mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_73idTemp,arg1_74idTemp);
if(actividadesPorDepartamentoNoEnPaquete442mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete442mtemp %>
<%
}else{
        String tempreturnp443 = null;
        if(actividadesPorDepartamentoNoEnPaquete442mtemp != null){
        java.util.List listreturnp443= java.util.Arrays.asList(actividadesPorDepartamentoNoEnPaquete442mtemp);
        tempreturnp443 = listreturnp443.toString();
        }
        %>
        <%=tempreturnp443%>
        <%
}
break;
case 449:
        gotMethod = true;
        java.lang.Object[] listarPaquetesNoComprados449mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados449mtemp == null){
%>
<%=listarPaquetesNoComprados449mtemp %>
<%
}else{
        String tempreturnp450 = null;
        if(listarPaquetesNoComprados449mtemp != null){
        java.util.List listreturnp450= java.util.Arrays.asList(listarPaquetesNoComprados449mtemp);
        tempreturnp450 = listreturnp450.toString();
        }
        %>
        <%=tempreturnp450%>
        <%
}
break;
case 452:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 455:
        gotMethod = true;
        java.lang.Object[] obtenerDataDepartamentos455mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos455mtemp == null){
%>
<%=obtenerDataDepartamentos455mtemp %>
<%
}else{
        String tempreturnp456 = null;
        if(obtenerDataDepartamentos455mtemp != null){
        java.util.List listreturnp456= java.util.Arrays.asList(obtenerDataDepartamentos455mtemp);
        tempreturnp456 = listreturnp456.toString();
        }
        %>
        <%=tempreturnp456%>
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