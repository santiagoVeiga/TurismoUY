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
        servidor.DataColeccionObject getUsuariosComp134mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp134mtemp == null){
%>
<%=getUsuariosComp134mtemp %>
<%
}else{
        if(getUsuariosComp134mtemp!= null){
        String tempreturnp135 = getUsuariosComp134mtemp.toString();
        %>
        <%=tempreturnp135%>
        <%
        }}
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
        servidor.DataColeccionObject obtenerActividadCategoria156mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_4idTemp);
if(obtenerActividadCategoria156mtemp == null){
%>
<%=obtenerActividadCategoria156mtemp %>
<%
}else{
        if(obtenerActividadCategoria156mtemp!= null){
        String tempreturnp157 = obtenerActividadCategoria156mtemp.toString();
        %>
        <%=tempreturnp157%>
        <%
        }}
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
        servidor.DataColeccionObject obtenerPaquetesComprados265mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_19idTemp);
if(obtenerPaquetesComprados265mtemp == null){
%>
<%=obtenerPaquetesComprados265mtemp %>
<%
}else{
        if(obtenerPaquetesComprados265mtemp!= null){
        String tempreturnp266 = obtenerPaquetesComprados265mtemp.toString();
        %>
        <%=tempreturnp266%>
        <%
        }}
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
        servidor.DataColeccionObject selecDepartamento275mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_21idTemp);
if(selecDepartamento275mtemp == null){
%>
<%=selecDepartamento275mtemp %>
<%
}else{
        if(selecDepartamento275mtemp!= null){
        String tempreturnp276 = selecDepartamento275mtemp.toString();
        %>
        <%=tempreturnp276%>
        <%
        }}
break;
case 280:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0283");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        servidor.DataColeccionObject salidas280mtemp = samplePublicadorIControladorProxyid.salidas(arg0_22idTemp);
if(salidas280mtemp == null){
%>
<%=salidas280mtemp %>
<%
}else{
        if(salidas280mtemp!= null){
        String tempreturnp281 = salidas280mtemp.toString();
        %>
        <%=tempreturnp281%>
        <%
        }}
break;
case 285:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0288");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg1290");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        String arg2_25id=  request.getParameter("arg2292");
        int arg2_25idTemp  = Integer.parseInt(arg2_25id);
        String arg3_26id=  request.getParameter("arg3294");
            java.util.Calendar arg3_26idTemp = null;
        if(!arg3_26id.equals("")){
        java.text.DateFormat dateFormatarg3294 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3294  = dateFormatarg3294.parse(arg3_26id);
         arg3_26idTemp = new java.util.GregorianCalendar();
        arg3_26idTemp.setTime(dateTemparg3294);
        }
        String arg4_27id=  request.getParameter("arg4296");
            java.lang.String arg4_27idTemp = null;
        if(!arg4_27id.equals("")){
         arg4_27idTemp  = arg4_27id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_23idTemp,arg1_24idTemp,arg2_25idTemp,arg3_26idTemp,arg4_27idTemp);
break;
case 298:
        gotMethod = true;
        servidor.DataColeccionObject listarUsuarios298mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios298mtemp == null){
%>
<%=listarUsuarios298mtemp %>
<%
}else{
        if(listarUsuarios298mtemp!= null){
        String tempreturnp299 = listarUsuarios298mtemp.toString();
        %>
        <%=tempreturnp299%>
        <%
        }}
break;
case 301:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0304");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        String arg1_29id=  request.getParameter("arg1306");
            java.lang.String arg1_29idTemp = null;
        if(!arg1_29id.equals("")){
         arg1_29idTemp  = arg1_29id;
        }
        String arg2_30id=  request.getParameter("arg2308");
            java.lang.String arg2_30idTemp = null;
        if(!arg2_30id.equals("")){
         arg2_30idTemp  = arg2_30id;
        }
        String arg3_31id=  request.getParameter("arg3310");
        int arg3_31idTemp  = Integer.parseInt(arg3_31id);
        String arg4_32id=  request.getParameter("arg4312");
        int arg4_32idTemp  = Integer.parseInt(arg4_32id);
        String arg5_33id=  request.getParameter("arg5314");
            java.lang.String arg5_33idTemp = null;
        if(!arg5_33id.equals("")){
         arg5_33idTemp  = arg5_33id;
        }
        String arg6_34id=  request.getParameter("arg6316");
            java.util.Calendar arg6_34idTemp = null;
        if(!arg6_34id.equals("")){
        java.text.DateFormat dateFormatarg6316 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6316  = dateFormatarg6316.parse(arg6_34id);
         arg6_34idTemp = new java.util.GregorianCalendar();
        arg6_34idTemp.setTime(dateTemparg6316);
        }
        String arg7_35id=  request.getParameter("arg7318");
            java.lang.String arg7_35idTemp = null;
        if(!arg7_35id.equals("")){
         arg7_35idTemp  = arg7_35id;
        }
        %>
        <jsp:useBean id="servidor1DataColeccionObject_36id" scope="session" class="servidor.DataColeccionObject" />
        <%
        samplePublicadorIControladorProxyid.registrarActividad(arg0_28idTemp,arg1_29idTemp,arg2_30idTemp,arg3_31idTemp,arg4_32idTemp,arg5_33idTemp,arg6_34idTemp,arg7_35idTemp,servidor1DataColeccionObject_36id);
break;
case 322:
        gotMethod = true;
        servidor.DataColeccionObject getUsuarios322mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios322mtemp == null){
%>
<%=getUsuarios322mtemp %>
<%
}else{
        if(getUsuarios322mtemp!= null){
        String tempreturnp323 = getUsuarios322mtemp.toString();
        %>
        <%=tempreturnp323%>
        <%
        }}
break;
case 325:
        gotMethod = true;
        servidor.DataColeccionObject obtenerNombreCategorias325mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias325mtemp == null){
%>
<%=obtenerNombreCategorias325mtemp %>
<%
}else{
        if(obtenerNombreCategorias325mtemp!= null){
        String tempreturnp326 = obtenerNombreCategorias325mtemp.toString();
        %>
        <%=tempreturnp326%>
        <%
        }}
break;
case 328:
        gotMethod = true;
        String arg0_37id=  request.getParameter("arg0331");
            java.lang.String arg0_37idTemp = null;
        if(!arg0_37id.equals("")){
         arg0_37idTemp  = arg0_37id;
        }
        String arg1_38id=  request.getParameter("arg1333");
            java.lang.String arg1_38idTemp = null;
        if(!arg1_38id.equals("")){
         arg1_38idTemp  = arg1_38id;
        }
        String arg2_39id=  request.getParameter("arg2335");
            java.util.Calendar arg2_39idTemp = null;
        if(!arg2_39id.equals("")){
        java.text.DateFormat dateFormatarg2335 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2335  = dateFormatarg2335.parse(arg2_39id);
         arg2_39idTemp = new java.util.GregorianCalendar();
        arg2_39idTemp.setTime(dateTemparg2335);
        }
        String arg3_40id=  request.getParameter("arg3337");
            java.util.Calendar arg3_40idTemp = null;
        if(!arg3_40id.equals("")){
        java.text.DateFormat dateFormatarg3337 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3337  = dateFormatarg3337.parse(arg3_40id);
         arg3_40idTemp = new java.util.GregorianCalendar();
        arg3_40idTemp.setTime(dateTemparg3337);
        }
        String arg4_41id=  request.getParameter("arg4339");
            java.lang.String arg4_41idTemp = null;
        if(!arg4_41id.equals("")){
         arg4_41idTemp  = arg4_41id;
        }
        String arg5_42id=  request.getParameter("arg5341");
        int arg5_42idTemp  = Integer.parseInt(arg5_42id);
        String arg6_43id=  request.getParameter("arg6343");
            java.util.Calendar arg6_43idTemp = null;
        if(!arg6_43id.equals("")){
        java.text.DateFormat dateFormatarg6343 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6343  = dateFormatarg6343.parse(arg6_43id);
         arg6_43idTemp = new java.util.GregorianCalendar();
        arg6_43idTemp.setTime(dateTemparg6343);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_37idTemp,arg1_38idTemp,arg2_39idTemp,arg3_40idTemp,arg4_41idTemp,arg5_42idTemp,arg6_43idTemp);
break;
case 345:
        gotMethod = true;
        String arg0_44id=  request.getParameter("arg0348");
            java.lang.String arg0_44idTemp = null;
        if(!arg0_44id.equals("")){
         arg0_44idTemp  = arg0_44id;
        }
        String arg1_45id=  request.getParameter("arg1350");
            java.lang.String arg1_45idTemp = null;
        if(!arg1_45id.equals("")){
         arg1_45idTemp  = arg1_45id;
        }
        String arg2_46id=  request.getParameter("arg2352");
            java.lang.String arg2_46idTemp = null;
        if(!arg2_46id.equals("")){
         arg2_46idTemp  = arg2_46id;
        }
        String arg3_47id=  request.getParameter("arg3354");
            java.lang.String arg3_47idTemp = null;
        if(!arg3_47id.equals("")){
         arg3_47idTemp  = arg3_47id;
        }
        String arg4_48id=  request.getParameter("arg4356");
            java.util.Calendar arg4_48idTemp = null;
        if(!arg4_48id.equals("")){
        java.text.DateFormat dateFormatarg4356 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4356  = dateFormatarg4356.parse(arg4_48id);
         arg4_48idTemp = new java.util.GregorianCalendar();
        arg4_48idTemp.setTime(dateTemparg4356);
        }
        String arg5_49id=  request.getParameter("arg5358");
            java.lang.String arg5_49idTemp = null;
        if(!arg5_49id.equals("")){
         arg5_49idTemp  = arg5_49id;
        }
        String arg6_50id=  request.getParameter("arg6360");
            java.lang.String arg6_50idTemp = null;
        if(!arg6_50id.equals("")){
         arg6_50idTemp  = arg6_50id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_44idTemp,arg1_45idTemp,arg2_46idTemp,arg3_47idTemp,arg4_48idTemp,arg5_49idTemp,arg6_50idTemp);
break;
case 362:
        gotMethod = true;
        String arg0_51id=  request.getParameter("arg0365");
            java.lang.String arg0_51idTemp = null;
        if(!arg0_51id.equals("")){
         arg0_51idTemp  = arg0_51id;
        }
        String arg1_52id=  request.getParameter("arg1367");
            java.lang.String arg1_52idTemp = null;
        if(!arg1_52id.equals("")){
         arg1_52idTemp  = arg1_52id;
        }
        String arg2_53id=  request.getParameter("arg2369");
            java.lang.String arg2_53idTemp = null;
        if(!arg2_53id.equals("")){
         arg2_53idTemp  = arg2_53id;
        }
        String arg3_54id=  request.getParameter("arg3371");
            java.lang.String arg3_54idTemp = null;
        if(!arg3_54id.equals("")){
         arg3_54idTemp  = arg3_54id;
        }
        String arg4_55id=  request.getParameter("arg4373");
            java.util.Calendar arg4_55idTemp = null;
        if(!arg4_55id.equals("")){
        java.text.DateFormat dateFormatarg4373 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4373  = dateFormatarg4373.parse(arg4_55id);
         arg4_55idTemp = new java.util.GregorianCalendar();
        arg4_55idTemp.setTime(dateTemparg4373);
        }
        String arg5_56id=  request.getParameter("arg5375");
            java.lang.String arg5_56idTemp = null;
        if(!arg5_56id.equals("")){
         arg5_56idTemp  = arg5_56id;
        }
        String arg6_57id=  request.getParameter("arg6377");
            java.lang.String arg6_57idTemp = null;
        if(!arg6_57id.equals("")){
         arg6_57idTemp  = arg6_57id;
        }
        String arg7_58id=  request.getParameter("arg7379");
        boolean arg7_58idTemp  = Boolean.valueOf(arg7_58id).booleanValue();
        String arg8_59id=  request.getParameter("arg8381");
            java.lang.String arg8_59idTemp = null;
        if(!arg8_59id.equals("")){
         arg8_59idTemp  = arg8_59id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_51idTemp,arg1_52idTemp,arg2_53idTemp,arg3_54idTemp,arg4_55idTemp,arg5_56idTemp,arg6_57idTemp,arg7_58idTemp,arg8_59idTemp);
break;
case 383:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetes383mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes383mtemp == null){
%>
<%=listarPaquetes383mtemp %>
<%
}else{
        if(listarPaquetes383mtemp!= null){
        String tempreturnp384 = listarPaquetes383mtemp.toString();
        %>
        <%=tempreturnp384%>
        <%
        }}
break;
case 386:
        gotMethod = true;
        String arg0_60id=  request.getParameter("arg0401");
            java.lang.String arg0_60idTemp = null;
        if(!arg0_60id.equals("")){
         arg0_60idTemp  = arg0_60id;
        }
        servidor.DataPaquete obtenerDataPaquete386mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_60idTemp);
if(obtenerDataPaquete386mtemp == null){
%>
<%=obtenerDataPaquete386mtemp %>
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
if(obtenerDataPaquete386mtemp != null){
%>
<%=obtenerDataPaquete386mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete386mtemp != null){
java.util.Calendar typefechaAlta391 = obtenerDataPaquete386mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta391 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta391 = typefechaAlta391.getTime();
        String tempResultfechaAlta391 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta391.format(datefechaAlta391));
        %>
        <%= tempResultfechaAlta391 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete386mtemp != null){
java.lang.String typedescripcion393 = obtenerDataPaquete386mtemp.getDescripcion();
        String tempResultdescripcion393 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion393));
        %>
        <%= tempResultdescripcion393 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete386mtemp != null){
%>
<%=obtenerDataPaquete386mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete386mtemp != null){
java.lang.String typenombre397 = obtenerDataPaquete386mtemp.getNombre();
        String tempResultnombre397 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre397));
        %>
        <%= tempResultnombre397 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete386mtemp != null){
java.lang.String typeimagen399 = obtenerDataPaquete386mtemp.getImagen();
        String tempResultimagen399 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen399));
        %>
        <%= tempResultimagen399 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 403:
        gotMethod = true;
        String arg0_61id=  request.getParameter("arg0406");
            java.lang.String arg0_61idTemp = null;
        if(!arg0_61id.equals("")){
         arg0_61idTemp  = arg0_61id;
        }
        String arg1_62id=  request.getParameter("arg1408");
            java.lang.String arg1_62idTemp = null;
        if(!arg1_62id.equals("")){
         arg1_62idTemp  = arg1_62id;
        }
        String arg2_63id=  request.getParameter("arg2410");
            java.lang.String arg2_63idTemp = null;
        if(!arg2_63id.equals("")){
         arg2_63idTemp  = arg2_63id;
        }
        String arg3_64id=  request.getParameter("arg3412");
            java.lang.String arg3_64idTemp = null;
        if(!arg3_64id.equals("")){
         arg3_64idTemp  = arg3_64id;
        }
        String arg4_65id=  request.getParameter("arg4414");
            java.util.Calendar arg4_65idTemp = null;
        if(!arg4_65id.equals("")){
        java.text.DateFormat dateFormatarg4414 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4414  = dateFormatarg4414.parse(arg4_65id);
         arg4_65idTemp = new java.util.GregorianCalendar();
        arg4_65idTemp.setTime(dateTemparg4414);
        }
        String arg5_66id=  request.getParameter("arg5416");
            java.lang.String arg5_66idTemp = null;
        if(!arg5_66id.equals("")){
         arg5_66idTemp  = arg5_66id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_61idTemp,arg1_62idTemp,arg2_63idTemp,arg3_64idTemp,arg4_65idTemp,arg5_66idTemp);
break;
case 418:
        gotMethod = true;
        String arg0_67id=  request.getParameter("arg0421");
            java.lang.String arg0_67idTemp = null;
        if(!arg0_67id.equals("")){
         arg0_67idTemp  = arg0_67id;
        }
        String arg1_68id=  request.getParameter("arg1423");
            java.lang.String arg1_68idTemp = null;
        if(!arg1_68id.equals("")){
         arg1_68idTemp  = arg1_68id;
        }
        String arg2_69id=  request.getParameter("arg2425");
            java.lang.String arg2_69idTemp = null;
        if(!arg2_69id.equals("")){
         arg2_69idTemp  = arg2_69id;
        }
        String arg3_70id=  request.getParameter("arg3427");
            java.lang.String arg3_70idTemp = null;
        if(!arg3_70id.equals("")){
         arg3_70idTemp  = arg3_70id;
        }
        String arg4_71id=  request.getParameter("arg4429");
            java.util.Calendar arg4_71idTemp = null;
        if(!arg4_71id.equals("")){
        java.text.DateFormat dateFormatarg4429 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4429  = dateFormatarg4429.parse(arg4_71id);
         arg4_71idTemp = new java.util.GregorianCalendar();
        arg4_71idTemp.setTime(dateTemparg4429);
        }
        String arg5_72id=  request.getParameter("arg5431");
            java.lang.String arg5_72idTemp = null;
        if(!arg5_72id.equals("")){
         arg5_72idTemp  = arg5_72id;
        }
        String arg6_73id=  request.getParameter("arg6433");
            java.lang.String arg6_73idTemp = null;
        if(!arg6_73id.equals("")){
         arg6_73idTemp  = arg6_73id;
        }
        String arg7_74id=  request.getParameter("arg7435");
        boolean arg7_74idTemp  = Boolean.valueOf(arg7_74id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_67idTemp,arg1_68idTemp,arg2_69idTemp,arg3_70idTemp,arg4_71idTemp,arg5_72idTemp,arg6_73idTemp,arg7_74idTemp);
break;
case 437:
        gotMethod = true;
        servidor.DataColeccionObject listarActividadesAgregadas437mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas437mtemp == null){
%>
<%=listarActividadesAgregadas437mtemp %>
<%
}else{
        if(listarActividadesAgregadas437mtemp!= null){
        String tempreturnp438 = listarActividadesAgregadas437mtemp.toString();
        %>
        <%=tempreturnp438%>
        <%
        }}
break;
case 440:
        gotMethod = true;
        String arg0_75id=  request.getParameter("arg0443");
            java.lang.String arg0_75idTemp = null;
        if(!arg0_75id.equals("")){
         arg0_75idTemp  = arg0_75id;
        }
        String arg1_76id=  request.getParameter("arg1445");
            java.lang.String arg1_76idTemp = null;
        if(!arg1_76id.equals("")){
         arg1_76idTemp  = arg1_76id;
        }
        servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete440mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_75idTemp,arg1_76idTemp);
if(actividadesPorDepartamentoNoEnPaquete440mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete440mtemp %>
<%
}else{
        if(actividadesPorDepartamentoNoEnPaquete440mtemp!= null){
        String tempreturnp441 = actividadesPorDepartamentoNoEnPaquete440mtemp.toString();
        %>
        <%=tempreturnp441%>
        <%
        }}
break;
case 447:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetesNoComprados447mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados447mtemp == null){
%>
<%=listarPaquetesNoComprados447mtemp %>
<%
}else{
        if(listarPaquetesNoComprados447mtemp!= null){
        String tempreturnp448 = listarPaquetesNoComprados447mtemp.toString();
        %>
        <%=tempreturnp448%>
        <%
        }}
break;
case 450:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 453:
        gotMethod = true;
        servidor.DataColeccionObject obtenerDataDepartamentos453mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos453mtemp == null){
%>
<%=obtenerDataDepartamentos453mtemp %>
<%
}else{
        if(obtenerDataDepartamentos453mtemp!= null){
        String tempreturnp454 = obtenerDataDepartamentos453mtemp.toString();
        %>
        <%=tempreturnp454%>
        <%
        }}
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