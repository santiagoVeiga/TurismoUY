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
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.util.Calendar typefechaAlta50 = dataActividadNull47mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta50 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta50 = typefechaAlta50.getTime();
        String tempResultfechaAlta50 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta50.format(datefechaAlta50));
        %>
        <%= tempResultfechaAlta50 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typedepartamento52 = dataActividadNull47mtemp.getDepartamento();
        String tempResultdepartamento52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento52));
        %>
        <%= tempResultdepartamento52 %>
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
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typeciudad58 = dataActividadNull47mtemp.getCiudad();
        String tempResultciudad58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad58));
        %>
        <%= tempResultciudad58 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typelink60 = dataActividadNull47mtemp.getLink();
        String tempResultlink60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink60));
        %>
        <%= tempResultlink60 %>
        <%
}%>
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
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
%>
<%=dataActividadNull47mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typenombre68 = dataActividadNull47mtemp.getNombre();
        String tempResultnombre68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre68));
        %>
        <%= tempResultnombre68 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataActividadNull47mtemp != null){
java.lang.String typeimagen70 = dataActividadNull47mtemp.getImagen();
        String tempResultimagen70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen70));
        %>
        <%= tempResultimagen70 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 72:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull72mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull72mtemp == null){
%>
<%=dataCGNull72mtemp %>
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
if(dataCGNull72mtemp != null){
java.util.Calendar typefecha75 = dataCGNull72mtemp.getFecha();
        java.text.DateFormat dateFormatfecha75 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha75 = typefecha75.getTime();
        String tempResultfecha75 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha75.format(datefecha75));
        %>
        <%= tempResultfecha75 %>
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
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta79 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta79 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta79 = typefechaAlta79.getTime();
        String tempResultfechaAlta79 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta79.format(datefechaAlta79));
        %>
        <%= tempResultfechaAlta79 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora81 = tebece0.getHora();
        java.text.DateFormat dateFormathora81 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora81 = typehora81.getTime();
        String tempResulthora81 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora81.format(datehora81));
        %>
        <%= tempResulthora81 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar83 = tebece0.getLugar();
        String tempResultlugar83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar83));
        %>
        <%= tempResultlugar83 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
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
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre87 = tebece0.getNombre();
        String tempResultnombre87 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre87));
        %>
        <%= tempResultnombre87 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
if(tebece0 != null){
java.lang.String typeimagen89 = tebece0.getImagen();
        String tempResultimagen89 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen89));
        %>
        <%= tempResultimagen89 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha91 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha91 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha91 = typefecha91.getTime();
        String tempResultfecha91 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha91.format(datefecha91));
        %>
        <%= tempResultfecha91 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
servidor.DataSalida tebece0=dataCGNull72mtemp.getSalida();
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
if(dataCGNull72mtemp != null){
%>
<%=dataCGNull72mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
%>
<%=dataCGNull72mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull72mtemp != null){
%>
<%=dataCGNull72mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 101:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull101mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull101mtemp == null){
%>
<%=dataCPNull101mtemp %>
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
if(dataCPNull101mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct104 = dataCPNull101mtemp.getRestAct();
        String temprestAct104 = null;
        if(typerestAct104 != null){
        java.util.List listrestAct104= java.util.Arrays.asList(typerestAct104);
        temprestAct104 = listrestAct104.toString();
        }
        %>
        <%=temprestAct104%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
java.util.Calendar typefecha106 = dataCPNull101mtemp.getFecha();
        java.text.DateFormat dateFormatfecha106 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha106 = typefecha106.getTime();
        String tempResultfecha106 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha106.format(datefecha106));
        %>
        <%= tempResultfecha106 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
%>
<%=dataCPNull101mtemp.getCantidad()
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
if(dataCPNull101mtemp != null){
servidor.DataPaquete tebece0=dataCPNull101mtemp.getPaq();
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
if(dataCPNull101mtemp != null){
servidor.DataPaquete tebece0=dataCPNull101mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta114 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta114 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta114 = typefechaAlta114.getTime();
        String tempResultfechaAlta114 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta114.format(datefechaAlta114));
        %>
        <%= tempResultfechaAlta114 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
servidor.DataPaquete tebece0=dataCPNull101mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion116 = tebece0.getDescripcion();
        String tempResultdescripcion116 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion116));
        %>
        <%= tempResultdescripcion116 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
servidor.DataPaquete tebece0=dataCPNull101mtemp.getPaq();
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
if(dataCPNull101mtemp != null){
servidor.DataPaquete tebece0=dataCPNull101mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre120 = tebece0.getNombre();
        String tempResultnombre120 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre120));
        %>
        <%= tempResultnombre120 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
servidor.DataPaquete tebece0=dataCPNull101mtemp.getPaq();
if(tebece0 != null){
java.lang.String typeimagen122 = tebece0.getImagen();
        String tempResultimagen122 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen122));
        %>
        <%= tempResultimagen122 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
java.util.Calendar typevencimiento124 = dataCPNull101mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento124 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento124 = typevencimiento124.getTime();
        String tempResultvencimiento124 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento124.format(datevencimiento124));
        %>
        <%= tempResultvencimiento124 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull101mtemp != null){
%>
<%=dataCPNull101mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 128:
        gotMethod = true;
        servidor.EstadoAct estadoActNull128mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull128mtemp == null){
%>
<%=estadoActNull128mtemp %>
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
case 133:
        gotMethod = true;
        %>
        <jsp:useBean id="servidor1DataColeccionObject_2id" scope="session" class="servidor.DataColeccionObject" />
        <%
        samplePublicadorIControladorProxyid.prueba(servidor1DataColeccionObject_2id);
break;
case 138:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg0155");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        servidor.DataUsuario verInfoUsuario138mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_3idTemp);
if(verInfoUsuario138mtemp == null){
%>
<%=verInfoUsuario138mtemp %>
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
if(verInfoUsuario138mtemp != null){
java.util.Calendar typenacimiento141 = verInfoUsuario138mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento141 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento141 = typenacimiento141.getTime();
        String tempResultnacimiento141 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento141.format(datenacimiento141));
        %>
        <%= tempResultnacimiento141 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario138mtemp != null){
java.lang.String typenick143 = verInfoUsuario138mtemp.getNick();
        String tempResultnick143 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick143));
        %>
        <%= tempResultnick143 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario138mtemp != null){
java.lang.String typemail145 = verInfoUsuario138mtemp.getMail();
        String tempResultmail145 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail145));
        %>
        <%= tempResultmail145 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario138mtemp != null){
java.lang.String typepassword147 = verInfoUsuario138mtemp.getPassword();
        String tempResultpassword147 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword147));
        %>
        <%= tempResultpassword147 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario138mtemp != null){
java.lang.String typenombre149 = verInfoUsuario138mtemp.getNombre();
        String tempResultnombre149 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre149));
        %>
        <%= tempResultnombre149 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(verInfoUsuario138mtemp != null){
java.lang.String typeimagen151 = verInfoUsuario138mtemp.getImagen();
        String tempResultimagen151 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen151));
        %>
        <%= tempResultimagen151 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario138mtemp != null){
java.lang.String typeapellido153 = verInfoUsuario138mtemp.getApellido();
        String tempResultapellido153 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido153));
        %>
        <%= tempResultapellido153 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 157:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0160");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        samplePublicadorIControladorProxyid.sumarVistaAAct(arg0_4idTemp);
break;
case 162:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg0165");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        samplePublicadorIControladorProxyid.sumarVistaASal(arg0_5idTemp);
break;
case 167:
        gotMethod = true;
        servidor.DataColeccionObject getUsuariosComp167mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp167mtemp == null){
%>
<%=getUsuariosComp167mtemp %>
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
if(getUsuariosComp167mtemp != null){
java.lang.Object typeobj170 = getUsuariosComp167mtemp.getObj();
        String tempResultobj170 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj170.toString());
        %>
        <%= tempResultobj170 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 172:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0189");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        servidor.DataUsuario ingresarDatos172mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_6idTemp);
if(ingresarDatos172mtemp == null){
%>
<%=ingresarDatos172mtemp %>
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
if(ingresarDatos172mtemp != null){
java.util.Calendar typenacimiento175 = ingresarDatos172mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento175 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento175 = typenacimiento175.getTime();
        String tempResultnacimiento175 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento175.format(datenacimiento175));
        %>
        <%= tempResultnacimiento175 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos172mtemp != null){
java.lang.String typenick177 = ingresarDatos172mtemp.getNick();
        String tempResultnick177 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick177));
        %>
        <%= tempResultnick177 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos172mtemp != null){
java.lang.String typemail179 = ingresarDatos172mtemp.getMail();
        String tempResultmail179 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail179));
        %>
        <%= tempResultmail179 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos172mtemp != null){
java.lang.String typepassword181 = ingresarDatos172mtemp.getPassword();
        String tempResultpassword181 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword181));
        %>
        <%= tempResultpassword181 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos172mtemp != null){
java.lang.String typenombre183 = ingresarDatos172mtemp.getNombre();
        String tempResultnombre183 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre183));
        %>
        <%= tempResultnombre183 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(ingresarDatos172mtemp != null){
java.lang.String typeimagen185 = ingresarDatos172mtemp.getImagen();
        String tempResultimagen185 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen185));
        %>
        <%= tempResultimagen185 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos172mtemp != null){
java.lang.String typeapellido187 = ingresarDatos172mtemp.getApellido();
        String tempResultapellido187 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido187));
        %>
        <%= tempResultapellido187 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 191:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0196");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        servidor.DataColeccionObject obtenerActividadCategoria191mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_7idTemp);
if(obtenerActividadCategoria191mtemp == null){
%>
<%=obtenerActividadCategoria191mtemp %>
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
if(obtenerActividadCategoria191mtemp != null){
java.lang.Object typeobj194 = obtenerActividadCategoria191mtemp.getObj();
        String tempResultobj194 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj194.toString());
        %>
        <%= tempResultobj194 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 198:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0215");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick198mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_8idTemp);
if(obtenerDataUsuarioNick198mtemp == null){
%>
<%=obtenerDataUsuarioNick198mtemp %>
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
if(obtenerDataUsuarioNick198mtemp != null){
java.util.Calendar typenacimiento201 = obtenerDataUsuarioNick198mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento201 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento201 = typenacimiento201.getTime();
        String tempResultnacimiento201 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento201.format(datenacimiento201));
        %>
        <%= tempResultnacimiento201 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick198mtemp != null){
java.lang.String typenick203 = obtenerDataUsuarioNick198mtemp.getNick();
        String tempResultnick203 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick203));
        %>
        <%= tempResultnick203 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick198mtemp != null){
java.lang.String typemail205 = obtenerDataUsuarioNick198mtemp.getMail();
        String tempResultmail205 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail205));
        %>
        <%= tempResultmail205 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick198mtemp != null){
java.lang.String typepassword207 = obtenerDataUsuarioNick198mtemp.getPassword();
        String tempResultpassword207 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword207));
        %>
        <%= tempResultpassword207 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick198mtemp != null){
java.lang.String typenombre209 = obtenerDataUsuarioNick198mtemp.getNombre();
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
if(obtenerDataUsuarioNick198mtemp != null){
java.lang.String typeimagen211 = obtenerDataUsuarioNick198mtemp.getImagen();
        String tempResultimagen211 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen211));
        %>
        <%= tempResultimagen211 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick198mtemp != null){
java.lang.String typeapellido213 = obtenerDataUsuarioNick198mtemp.getApellido();
        String tempResultapellido213 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido213));
        %>
        <%= tempResultapellido213 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 217:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0234");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail217mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_9idTemp);
if(obtenerDataUsuarioMail217mtemp == null){
%>
<%=obtenerDataUsuarioMail217mtemp %>
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
if(obtenerDataUsuarioMail217mtemp != null){
java.util.Calendar typenacimiento220 = obtenerDataUsuarioMail217mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento220 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento220 = typenacimiento220.getTime();
        String tempResultnacimiento220 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento220.format(datenacimiento220));
        %>
        <%= tempResultnacimiento220 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail217mtemp != null){
java.lang.String typenick222 = obtenerDataUsuarioMail217mtemp.getNick();
        String tempResultnick222 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick222));
        %>
        <%= tempResultnick222 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail217mtemp != null){
java.lang.String typemail224 = obtenerDataUsuarioMail217mtemp.getMail();
        String tempResultmail224 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail224));
        %>
        <%= tempResultmail224 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail217mtemp != null){
java.lang.String typepassword226 = obtenerDataUsuarioMail217mtemp.getPassword();
        String tempResultpassword226 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword226));
        %>
        <%= tempResultpassword226 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail217mtemp != null){
java.lang.String typenombre228 = obtenerDataUsuarioMail217mtemp.getNombre();
        String tempResultnombre228 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre228));
        %>
        <%= tempResultnombre228 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataUsuarioMail217mtemp != null){
java.lang.String typeimagen230 = obtenerDataUsuarioMail217mtemp.getImagen();
        String tempResultimagen230 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen230));
        %>
        <%= tempResultimagen230 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail217mtemp != null){
java.lang.String typeapellido232 = obtenerDataUsuarioMail217mtemp.getApellido();
        String tempResultapellido232 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido232));
        %>
        <%= tempResultapellido232 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 236:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0261");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        servidor.DataActividad obtenerDataActividad236mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_10idTemp);
if(obtenerDataActividad236mtemp == null){
%>
<%=obtenerDataActividad236mtemp %>
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
if(obtenerDataActividad236mtemp != null){
java.util.Calendar typefechaAlta239 = obtenerDataActividad236mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta239 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta239 = typefechaAlta239.getTime();
        String tempResultfechaAlta239 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta239.format(datefechaAlta239));
        %>
        <%= tempResultfechaAlta239 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
java.lang.String typedepartamento241 = obtenerDataActividad236mtemp.getDepartamento();
        String tempResultdepartamento241 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento241));
        %>
        <%= tempResultdepartamento241 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
%>
<%=obtenerDataActividad236mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
java.lang.String typedescripcion245 = obtenerDataActividad236mtemp.getDescripcion();
        String tempResultdescripcion245 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion245));
        %>
        <%= tempResultdescripcion245 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
java.lang.String typeciudad247 = obtenerDataActividad236mtemp.getCiudad();
        String tempResultciudad247 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad247));
        %>
        <%= tempResultciudad247 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">link:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
java.lang.String typelink249 = obtenerDataActividad236mtemp.getLink();
        String tempResultlink249 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelink249));
        %>
        <%= tempResultlink249 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hayLink:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
%>
<%=obtenerDataActividad236mtemp.isHayLink()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
%>
<%=obtenerDataActividad236mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
%>
<%=obtenerDataActividad236mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
java.lang.String typenombre257 = obtenerDataActividad236mtemp.getNombre();
        String tempResultnombre257 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre257));
        %>
        <%= tempResultnombre257 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataActividad236mtemp != null){
java.lang.String typeimagen259 = obtenerDataActividad236mtemp.getImagen();
        String tempResultimagen259 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen259));
        %>
        <%= tempResultimagen259 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 263:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg0282");
            java.lang.String arg0_11idTemp = null;
        if(!arg0_11id.equals("")){
         arg0_11idTemp  = arg0_11id;
        }
        servidor.DataSalida obtenerDataSalida263mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_11idTemp);
if(obtenerDataSalida263mtemp == null){
%>
<%=obtenerDataSalida263mtemp %>
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
if(obtenerDataSalida263mtemp != null){
java.util.Calendar typefechaAlta266 = obtenerDataSalida263mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta266 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta266 = typefechaAlta266.getTime();
        String tempResultfechaAlta266 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta266.format(datefechaAlta266));
        %>
        <%= tempResultfechaAlta266 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
java.util.Calendar typehora268 = obtenerDataSalida263mtemp.getHora();
        java.text.DateFormat dateFormathora268 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora268 = typehora268.getTime();
        String tempResulthora268 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora268.format(datehora268));
        %>
        <%= tempResulthora268 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
java.lang.String typelugar270 = obtenerDataSalida263mtemp.getLugar();
        String tempResultlugar270 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar270));
        %>
        <%= tempResultlugar270 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantVis:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
%>
<%=obtenerDataSalida263mtemp.getCantVis()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
java.lang.String typenombre274 = obtenerDataSalida263mtemp.getNombre();
        String tempResultnombre274 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre274));
        %>
        <%= tempResultnombre274 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
java.lang.String typeimagen276 = obtenerDataSalida263mtemp.getImagen();
        String tempResultimagen276 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen276));
        %>
        <%= tempResultimagen276 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
java.util.Calendar typefecha278 = obtenerDataSalida263mtemp.getFecha();
        java.text.DateFormat dateFormatfecha278 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha278 = typefecha278.getTime();
        String tempResultfecha278 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha278.format(datefecha278));
        %>
        <%= tempResultfecha278 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida263mtemp != null){
%>
<%=obtenerDataSalida263mtemp.getCant()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 284:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg0287");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg1289");
            java.util.Calendar arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
        java.text.DateFormat dateFormatarg1289 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1289  = dateFormatarg1289.parse(arg1_13id);
         arg1_13idTemp = new java.util.GregorianCalendar();
        arg1_13idTemp.setTime(dateTemparg1289);
        }
        String arg2_14id=  request.getParameter("arg2291");
        int arg2_14idTemp  = Integer.parseInt(arg2_14id);
        String arg3_15id=  request.getParameter("arg3293");
            java.lang.String arg3_15idTemp = null;
        if(!arg3_15id.equals("")){
         arg3_15idTemp  = arg3_15id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_12idTemp,arg1_13idTemp,arg2_14idTemp,arg3_15idTemp);
break;
case 295:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg0298");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        String arg1_17id=  request.getParameter("arg1300");
            java.lang.String arg1_17idTemp = null;
        if(!arg1_17id.equals("")){
         arg1_17idTemp  = arg1_17id;
        }
        String arg2_18id=  request.getParameter("arg2302");
        int arg2_18idTemp  = Integer.parseInt(arg2_18id);
        String arg3_19id=  request.getParameter("arg3304");
            java.util.Calendar arg3_19idTemp = null;
        if(!arg3_19id.equals("")){
        java.text.DateFormat dateFormatarg3304 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3304  = dateFormatarg3304.parse(arg3_19id);
         arg3_19idTemp = new java.util.GregorianCalendar();
        arg3_19idTemp.setTime(dateTemparg3304);
        }
        String arg4_20id=  request.getParameter("arg4306");
            java.lang.String arg4_20idTemp = null;
        if(!arg4_20id.equals("")){
         arg4_20idTemp  = arg4_20id;
        }
        String arg5_21id=  request.getParameter("arg5308");
            java.lang.String arg5_21idTemp = null;
        if(!arg5_21id.equals("")){
         arg5_21idTemp  = arg5_21id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_16idTemp,arg1_17idTemp,arg2_18idTemp,arg3_19idTemp,arg4_20idTemp,arg5_21idTemp);
break;
case 310:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0315");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        servidor.DataColeccionObject obtenerPaquetesComprados310mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_22idTemp);
if(obtenerPaquetesComprados310mtemp == null){
%>
<%=obtenerPaquetesComprados310mtemp %>
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
if(obtenerPaquetesComprados310mtemp != null){
java.lang.Object typeobj313 = obtenerPaquetesComprados310mtemp.getObj();
        String tempResultobj313 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj313.toString());
        %>
        <%= tempResultobj313 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 317:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0320");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        java.lang.String obtenerNomActPorSalida317mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_23idTemp);
if(obtenerNomActPorSalida317mtemp == null){
%>
<%=obtenerNomActPorSalida317mtemp %>
<%
}else{
        String tempResultreturnp318 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida317mtemp));
        %>
        <%= tempResultreturnp318 %>
        <%
}
break;
case 322:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0325");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1327");
            java.lang.String arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
         arg1_25idTemp  = arg1_25id;
        }
        String arg2_26id=  request.getParameter("arg2329");
        boolean arg2_26idTemp  = Boolean.valueOf(arg2_26id).booleanValue();
        samplePublicadorIControladorProxyid.seguirDejarDeSeguirUsuario(arg0_24idTemp,arg1_25idTemp,arg2_26idTemp);
break;
case 331:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0334");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        String arg1_28id=  request.getParameter("arg1336");
            java.lang.String arg1_28idTemp = null;
        if(!arg1_28id.equals("")){
         arg1_28idTemp  = arg1_28id;
        }
        String arg2_29id=  request.getParameter("arg2338");
        boolean arg2_29idTemp  = Boolean.valueOf(arg2_29id).booleanValue();
        samplePublicadorIControladorProxyid.agregarQuitarActividadFavorita(arg0_27idTemp,arg1_28idTemp,arg2_29idTemp);
break;
case 340:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0343");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        String arg1_31id=  request.getParameter("arg1345");
            java.lang.String arg1_31idTemp = null;
        if(!arg1_31id.equals("")){
         arg1_31idTemp  = arg1_31id;
        }
        samplePublicadorIControladorProxyid.finalizarActividad(arg0_30idTemp,arg1_31idTemp);
break;
case 347:
        gotMethod = true;
        servidor.DataColeccionObject listarUsuarios347mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios347mtemp == null){
%>
<%=listarUsuarios347mtemp %>
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
if(listarUsuarios347mtemp != null){
java.lang.Object typeobj350 = listarUsuarios347mtemp.getObj();
        String tempResultobj350 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj350.toString());
        %>
        <%= tempResultobj350 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 352:
        gotMethod = true;
        servidor.DataColeccionObject obtenerDataDepartamentos352mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos352mtemp == null){
%>
<%=obtenerDataDepartamentos352mtemp %>
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
if(obtenerDataDepartamentos352mtemp != null){
java.lang.Object typeobj355 = obtenerDataDepartamentos352mtemp.getObj();
        String tempResultobj355 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj355.toString());
        %>
        <%= tempResultobj355 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 357:
        gotMethod = true;
        String arg0_32id=  request.getParameter("arg0360");
            java.lang.String arg0_32idTemp = null;
        if(!arg0_32id.equals("")){
         arg0_32idTemp  = arg0_32id;
        }
        String arg1_33id=  request.getParameter("arg1362");
            java.lang.String arg1_33idTemp = null;
        if(!arg1_33id.equals("")){
         arg1_33idTemp  = arg1_33id;
        }
        String arg2_34id=  request.getParameter("arg2364");
            java.util.Calendar arg2_34idTemp = null;
        if(!arg2_34id.equals("")){
        java.text.DateFormat dateFormatarg2364 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2364  = dateFormatarg2364.parse(arg2_34id);
         arg2_34idTemp = new java.util.GregorianCalendar();
        arg2_34idTemp.setTime(dateTemparg2364);
        }
        String arg3_35id=  request.getParameter("arg3366");
            java.util.Calendar arg3_35idTemp = null;
        if(!arg3_35id.equals("")){
        java.text.DateFormat dateFormatarg3366 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3366  = dateFormatarg3366.parse(arg3_35id);
         arg3_35idTemp = new java.util.GregorianCalendar();
        arg3_35idTemp.setTime(dateTemparg3366);
        }
        String arg4_36id=  request.getParameter("arg4368");
            java.lang.String arg4_36idTemp = null;
        if(!arg4_36id.equals("")){
         arg4_36idTemp  = arg4_36id;
        }
        String arg5_37id=  request.getParameter("arg5370");
        int arg5_37idTemp  = Integer.parseInt(arg5_37id);
        String arg6_38id=  request.getParameter("arg6372");
            java.util.Calendar arg6_38idTemp = null;
        if(!arg6_38id.equals("")){
        java.text.DateFormat dateFormatarg6372 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6372  = dateFormatarg6372.parse(arg6_38id);
         arg6_38idTemp = new java.util.GregorianCalendar();
        arg6_38idTemp.setTime(dateTemparg6372);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_32idTemp,arg1_33idTemp,arg2_34idTemp,arg3_35idTemp,arg4_36idTemp,arg5_37idTemp,arg6_38idTemp);
break;
case 374:
        gotMethod = true;
        String arg0_39id=  request.getParameter("arg0377");
            java.lang.String arg0_39idTemp = null;
        if(!arg0_39id.equals("")){
         arg0_39idTemp  = arg0_39id;
        }
        String arg1_40id=  request.getParameter("arg1379");
            java.lang.String arg1_40idTemp = null;
        if(!arg1_40id.equals("")){
         arg1_40idTemp  = arg1_40id;
        }
        String arg2_41id=  request.getParameter("arg2381");
            java.lang.String arg2_41idTemp = null;
        if(!arg2_41id.equals("")){
         arg2_41idTemp  = arg2_41id;
        }
        String arg3_42id=  request.getParameter("arg3383");
        int arg3_42idTemp  = Integer.parseInt(arg3_42id);
        String arg4_43id=  request.getParameter("arg4385");
        int arg4_43idTemp  = Integer.parseInt(arg4_43id);
        String arg5_44id=  request.getParameter("arg5387");
            java.lang.String arg5_44idTemp = null;
        if(!arg5_44id.equals("")){
         arg5_44idTemp  = arg5_44id;
        }
        String arg6_45id=  request.getParameter("arg6389");
            java.util.Calendar arg6_45idTemp = null;
        if(!arg6_45id.equals("")){
        java.text.DateFormat dateFormatarg6389 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6389  = dateFormatarg6389.parse(arg6_45id);
         arg6_45idTemp = new java.util.GregorianCalendar();
        arg6_45idTemp.setTime(dateTemparg6389);
        }
        String arg7_46id=  request.getParameter("arg7391");
            java.lang.String arg7_46idTemp = null;
        if(!arg7_46id.equals("")){
         arg7_46idTemp  = arg7_46id;
        }
        %>
        <jsp:useBean id="servidor1DataColeccionObject_47id" scope="session" class="servidor.DataColeccionObject" />
        <%
        String arg9_48id=  request.getParameter("arg9395");
            java.lang.String arg9_48idTemp = null;
        if(!arg9_48id.equals("")){
         arg9_48idTemp  = arg9_48id;
        }
        String arg10_49id=  request.getParameter("arg10397");
        boolean arg10_49idTemp  = Boolean.valueOf(arg10_49id).booleanValue();
        samplePublicadorIControladorProxyid.registrarActividad(arg0_39idTemp,arg1_40idTemp,arg2_41idTemp,arg3_42idTemp,arg4_43idTemp,arg5_44idTemp,arg6_45idTemp,arg7_46idTemp,servidor1DataColeccionObject_47id,arg9_48idTemp,arg10_49idTemp);
break;
case 399:
        gotMethod = true;
        servidor.DataColeccionObject getUsuarios399mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios399mtemp == null){
%>
<%=getUsuarios399mtemp %>
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
if(getUsuarios399mtemp != null){
java.lang.Object typeobj402 = getUsuarios399mtemp.getObj();
        String tempResultobj402 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj402.toString());
        %>
        <%= tempResultobj402 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 404:
        gotMethod = true;
        servidor.DataColeccionObject obtenerNombreCategorias404mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias404mtemp == null){
%>
<%=obtenerNombreCategorias404mtemp %>
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
if(obtenerNombreCategorias404mtemp != null){
java.lang.Object typeobj407 = obtenerNombreCategorias404mtemp.getObj();
        String tempResultobj407 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj407.toString());
        %>
        <%= tempResultobj407 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 409:
        gotMethod = true;
        String arg0_50id=  request.getParameter("arg0414");
            java.lang.String arg0_50idTemp = null;
        if(!arg0_50id.equals("")){
         arg0_50idTemp  = arg0_50id;
        }
        servidor.DataColeccionObject selecDepartamento409mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_50idTemp);
if(selecDepartamento409mtemp == null){
%>
<%=selecDepartamento409mtemp %>
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
if(selecDepartamento409mtemp != null){
java.lang.Object typeobj412 = selecDepartamento409mtemp.getObj();
        String tempResultobj412 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj412.toString());
        %>
        <%= tempResultobj412 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 416:
        gotMethod = true;
        String arg0_51id=  request.getParameter("arg0421");
            java.lang.String arg0_51idTemp = null;
        if(!arg0_51id.equals("")){
         arg0_51idTemp  = arg0_51id;
        }
        servidor.DataColeccionObject salidas416mtemp = samplePublicadorIControladorProxyid.salidas(arg0_51idTemp);
if(salidas416mtemp == null){
%>
<%=salidas416mtemp %>
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
if(salidas416mtemp != null){
java.lang.Object typeobj419 = salidas416mtemp.getObj();
        String tempResultobj419 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj419.toString());
        %>
        <%= tempResultobj419 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 423:
        gotMethod = true;
        String arg0_52id=  request.getParameter("arg0426");
            java.lang.String arg0_52idTemp = null;
        if(!arg0_52id.equals("")){
         arg0_52idTemp  = arg0_52id;
        }
        String arg1_53id=  request.getParameter("arg1428");
            java.lang.String arg1_53idTemp = null;
        if(!arg1_53id.equals("")){
         arg1_53idTemp  = arg1_53id;
        }
        String arg2_54id=  request.getParameter("arg2430");
        int arg2_54idTemp  = Integer.parseInt(arg2_54id);
        String arg3_55id=  request.getParameter("arg3432");
            java.util.Calendar arg3_55idTemp = null;
        if(!arg3_55id.equals("")){
        java.text.DateFormat dateFormatarg3432 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3432  = dateFormatarg3432.parse(arg3_55id);
         arg3_55idTemp = new java.util.GregorianCalendar();
        arg3_55idTemp.setTime(dateTemparg3432);
        }
        String arg4_56id=  request.getParameter("arg4434");
            java.lang.String arg4_56idTemp = null;
        if(!arg4_56id.equals("")){
         arg4_56idTemp  = arg4_56id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_52idTemp,arg1_53idTemp,arg2_54idTemp,arg3_55idTemp,arg4_56idTemp);
break;
case 436:
        gotMethod = true;
        servidor.DataColeccionObject listarActividadesAgregadas436mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas436mtemp == null){
%>
<%=listarActividadesAgregadas436mtemp %>
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
if(listarActividadesAgregadas436mtemp != null){
java.lang.Object typeobj439 = listarActividadesAgregadas436mtemp.getObj();
        String tempResultobj439 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj439.toString());
        %>
        <%= tempResultobj439 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 441:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetes441mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes441mtemp == null){
%>
<%=listarPaquetes441mtemp %>
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
if(listarPaquetes441mtemp != null){
java.lang.Object typeobj444 = listarPaquetes441mtemp.getObj();
        String tempResultobj444 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj444.toString());
        %>
        <%= tempResultobj444 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 446:
        gotMethod = true;
        String arg0_57id=  request.getParameter("arg0461");
            java.lang.String arg0_57idTemp = null;
        if(!arg0_57id.equals("")){
         arg0_57idTemp  = arg0_57id;
        }
        servidor.DataPaquete obtenerDataPaquete446mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_57idTemp);
if(obtenerDataPaquete446mtemp == null){
%>
<%=obtenerDataPaquete446mtemp %>
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
if(obtenerDataPaquete446mtemp != null){
%>
<%=obtenerDataPaquete446mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete446mtemp != null){
java.util.Calendar typefechaAlta451 = obtenerDataPaquete446mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta451 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta451 = typefechaAlta451.getTime();
        String tempResultfechaAlta451 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta451.format(datefechaAlta451));
        %>
        <%= tempResultfechaAlta451 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete446mtemp != null){
java.lang.String typedescripcion453 = obtenerDataPaquete446mtemp.getDescripcion();
        String tempResultdescripcion453 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion453));
        %>
        <%= tempResultdescripcion453 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete446mtemp != null){
%>
<%=obtenerDataPaquete446mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete446mtemp != null){
java.lang.String typenombre457 = obtenerDataPaquete446mtemp.getNombre();
        String tempResultnombre457 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre457));
        %>
        <%= tempResultnombre457 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagen:</TD>
<TD>
<%
if(obtenerDataPaquete446mtemp != null){
java.lang.String typeimagen459 = obtenerDataPaquete446mtemp.getImagen();
        String tempResultimagen459 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagen459));
        %>
        <%= tempResultimagen459 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 463:
        gotMethod = true;
        String arg0_58id=  request.getParameter("arg0466");
            java.lang.String arg0_58idTemp = null;
        if(!arg0_58id.equals("")){
         arg0_58idTemp  = arg0_58id;
        }
        String arg1_59id=  request.getParameter("arg1468");
            java.lang.String arg1_59idTemp = null;
        if(!arg1_59id.equals("")){
         arg1_59idTemp  = arg1_59id;
        }
        String arg2_60id=  request.getParameter("arg2470");
            java.lang.String arg2_60idTemp = null;
        if(!arg2_60id.equals("")){
         arg2_60idTemp  = arg2_60id;
        }
        String arg3_61id=  request.getParameter("arg3472");
            java.lang.String arg3_61idTemp = null;
        if(!arg3_61id.equals("")){
         arg3_61idTemp  = arg3_61id;
        }
        String arg4_62id=  request.getParameter("arg4474");
            java.util.Calendar arg4_62idTemp = null;
        if(!arg4_62id.equals("")){
        java.text.DateFormat dateFormatarg4474 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4474  = dateFormatarg4474.parse(arg4_62id);
         arg4_62idTemp = new java.util.GregorianCalendar();
        arg4_62idTemp.setTime(dateTemparg4474);
        }
        String arg5_63id=  request.getParameter("arg5476");
            java.lang.String arg5_63idTemp = null;
        if(!arg5_63id.equals("")){
         arg5_63idTemp  = arg5_63id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_58idTemp,arg1_59idTemp,arg2_60idTemp,arg3_61idTemp,arg4_62idTemp,arg5_63idTemp);
break;
case 478:
        gotMethod = true;
        String arg0_64id=  request.getParameter("arg0481");
            java.lang.String arg0_64idTemp = null;
        if(!arg0_64id.equals("")){
         arg0_64idTemp  = arg0_64id;
        }
        String arg1_65id=  request.getParameter("arg1483");
            java.lang.String arg1_65idTemp = null;
        if(!arg1_65id.equals("")){
         arg1_65idTemp  = arg1_65id;
        }
        String arg2_66id=  request.getParameter("arg2485");
            java.lang.String arg2_66idTemp = null;
        if(!arg2_66id.equals("")){
         arg2_66idTemp  = arg2_66id;
        }
        String arg3_67id=  request.getParameter("arg3487");
            java.lang.String arg3_67idTemp = null;
        if(!arg3_67id.equals("")){
         arg3_67idTemp  = arg3_67id;
        }
        String arg4_68id=  request.getParameter("arg4489");
            java.util.Calendar arg4_68idTemp = null;
        if(!arg4_68id.equals("")){
        java.text.DateFormat dateFormatarg4489 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4489  = dateFormatarg4489.parse(arg4_68id);
         arg4_68idTemp = new java.util.GregorianCalendar();
        arg4_68idTemp.setTime(dateTemparg4489);
        }
        String arg5_69id=  request.getParameter("arg5491");
            java.lang.String arg5_69idTemp = null;
        if(!arg5_69id.equals("")){
         arg5_69idTemp  = arg5_69id;
        }
        String arg6_70id=  request.getParameter("arg6493");
            java.lang.String arg6_70idTemp = null;
        if(!arg6_70id.equals("")){
         arg6_70idTemp  = arg6_70id;
        }
        String arg7_71id=  request.getParameter("arg7495");
        boolean arg7_71idTemp  = Boolean.valueOf(arg7_71id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_64idTemp,arg1_65idTemp,arg2_66idTemp,arg3_67idTemp,arg4_68idTemp,arg5_69idTemp,arg6_70idTemp,arg7_71idTemp);
break;
case 497:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 500:
        gotMethod = true;
        String arg0_72id=  request.getParameter("arg0503");
            java.lang.String arg0_72idTemp = null;
        if(!arg0_72id.equals("")){
         arg0_72idTemp  = arg0_72id;
        }
        String arg1_73id=  request.getParameter("arg1505");
            java.lang.String arg1_73idTemp = null;
        if(!arg1_73id.equals("")){
         arg1_73idTemp  = arg1_73id;
        }
        String arg2_74id=  request.getParameter("arg2507");
            java.lang.String arg2_74idTemp = null;
        if(!arg2_74id.equals("")){
         arg2_74idTemp  = arg2_74id;
        }
        String arg3_75id=  request.getParameter("arg3509");
            java.lang.String arg3_75idTemp = null;
        if(!arg3_75id.equals("")){
         arg3_75idTemp  = arg3_75id;
        }
        String arg4_76id=  request.getParameter("arg4511");
            java.util.Calendar arg4_76idTemp = null;
        if(!arg4_76id.equals("")){
        java.text.DateFormat dateFormatarg4511 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4511  = dateFormatarg4511.parse(arg4_76id);
         arg4_76idTemp = new java.util.GregorianCalendar();
        arg4_76idTemp.setTime(dateTemparg4511);
        }
        String arg5_77id=  request.getParameter("arg5513");
            java.lang.String arg5_77idTemp = null;
        if(!arg5_77id.equals("")){
         arg5_77idTemp  = arg5_77id;
        }
        String arg6_78id=  request.getParameter("arg6515");
            java.lang.String arg6_78idTemp = null;
        if(!arg6_78id.equals("")){
         arg6_78idTemp  = arg6_78id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_72idTemp,arg1_73idTemp,arg2_74idTemp,arg3_75idTemp,arg4_76idTemp,arg5_77idTemp,arg6_78idTemp);
break;
case 517:
        gotMethod = true;
        String arg0_79id=  request.getParameter("arg0520");
            java.lang.String arg0_79idTemp = null;
        if(!arg0_79id.equals("")){
         arg0_79idTemp  = arg0_79id;
        }
        String arg1_80id=  request.getParameter("arg1522");
            java.lang.String arg1_80idTemp = null;
        if(!arg1_80id.equals("")){
         arg1_80idTemp  = arg1_80id;
        }
        String arg2_81id=  request.getParameter("arg2524");
            java.lang.String arg2_81idTemp = null;
        if(!arg2_81id.equals("")){
         arg2_81idTemp  = arg2_81id;
        }
        String arg3_82id=  request.getParameter("arg3526");
            java.lang.String arg3_82idTemp = null;
        if(!arg3_82id.equals("")){
         arg3_82idTemp  = arg3_82id;
        }
        String arg4_83id=  request.getParameter("arg4528");
            java.util.Calendar arg4_83idTemp = null;
        if(!arg4_83id.equals("")){
        java.text.DateFormat dateFormatarg4528 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4528  = dateFormatarg4528.parse(arg4_83id);
         arg4_83idTemp = new java.util.GregorianCalendar();
        arg4_83idTemp.setTime(dateTemparg4528);
        }
        String arg5_84id=  request.getParameter("arg5530");
            java.lang.String arg5_84idTemp = null;
        if(!arg5_84id.equals("")){
         arg5_84idTemp  = arg5_84id;
        }
        String arg6_85id=  request.getParameter("arg6532");
            java.lang.String arg6_85idTemp = null;
        if(!arg6_85id.equals("")){
         arg6_85idTemp  = arg6_85id;
        }
        String arg7_86id=  request.getParameter("arg7534");
        boolean arg7_86idTemp  = Boolean.valueOf(arg7_86id).booleanValue();
        String arg8_87id=  request.getParameter("arg8536");
            java.lang.String arg8_87idTemp = null;
        if(!arg8_87id.equals("")){
         arg8_87idTemp  = arg8_87id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_79idTemp,arg1_80idTemp,arg2_81idTemp,arg3_82idTemp,arg4_83idTemp,arg5_84idTemp,arg6_85idTemp,arg7_86idTemp,arg8_87idTemp);
break;
case 538:
        gotMethod = true;
        String arg0_88id=  request.getParameter("arg0543");
            java.lang.String arg0_88idTemp = null;
        if(!arg0_88id.equals("")){
         arg0_88idTemp  = arg0_88id;
        }
        String arg1_89id=  request.getParameter("arg1545");
            java.lang.String arg1_89idTemp = null;
        if(!arg1_89id.equals("")){
         arg1_89idTemp  = arg1_89id;
        }
        servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete538mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_88idTemp,arg1_89idTemp);
if(actividadesPorDepartamentoNoEnPaquete538mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete538mtemp %>
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
if(actividadesPorDepartamentoNoEnPaquete538mtemp != null){
java.lang.Object typeobj541 = actividadesPorDepartamentoNoEnPaquete538mtemp.getObj();
        String tempResultobj541 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj541.toString());
        %>
        <%= tempResultobj541 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 547:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetesNoComprados547mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados547mtemp == null){
%>
<%=listarPaquetesNoComprados547mtemp %>
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
if(listarPaquetesNoComprados547mtemp != null){
java.lang.Object typeobj550 = listarPaquetesNoComprados547mtemp.getObj();
        String tempResultobj550 = org.eclipse.jst.ws.util.JspUtils.markup(typeobj550.toString());
        %>
        <%= tempResultobj550 %>
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