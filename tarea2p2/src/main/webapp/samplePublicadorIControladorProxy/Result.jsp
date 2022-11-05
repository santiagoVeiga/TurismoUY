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
</TABLE>
<%
}
break;
case 49:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull49mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull49mtemp == null){
%>
<%=dataCGNull49mtemp %>
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
if(dataCGNull49mtemp != null){
java.util.Calendar typefecha52 = dataCGNull49mtemp.getFecha();
        java.text.DateFormat dateFormatfecha52 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha52 = typefecha52.getTime();
        String tempResultfecha52 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha52.format(datefecha52));
        %>
        <%= tempResultfecha52 %>
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
if(dataCGNull49mtemp != null){
servidor.DataSalida tebece0=dataCGNull49mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora56 = tebece0.getHora();
        java.text.DateFormat dateFormathora56 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora56 = typehora56.getTime();
        String tempResulthora56 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora56.format(datehora56));
        %>
        <%= tempResulthora56 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
servidor.DataSalida tebece0=dataCGNull49mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha58 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha58 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha58 = typefecha58.getTime();
        String tempResultfecha58 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha58.format(datefecha58));
        %>
        <%= tempResultfecha58 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
servidor.DataSalida tebece0=dataCGNull49mtemp.getSalida();
if(tebece0 != null){
%>
<%=tebece0.getCant()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
servidor.DataSalida tebece0=dataCGNull49mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta62 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta62 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta62 = typefechaAlta62.getTime();
        String tempResultfechaAlta62 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta62.format(datefechaAlta62));
        %>
        <%= tempResultfechaAlta62 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
servidor.DataSalida tebece0=dataCGNull49mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar64 = tebece0.getLugar();
        String tempResultlugar64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar64));
        %>
        <%= tempResultlugar64 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
servidor.DataSalida tebece0=dataCGNull49mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre66 = tebece0.getNombre();
        String tempResultnombre66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre66));
        %>
        <%= tempResultnombre66 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">porPaquete:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
%>
<%=dataCGNull49mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
%>
<%=dataCGNull49mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull49mtemp != null){
%>
<%=dataCGNull49mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 74:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull74mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull74mtemp == null){
%>
<%=dataCPNull74mtemp %>
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
if(dataCPNull74mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct77 = dataCPNull74mtemp.getRestAct();
        String temprestAct77 = null;
        if(typerestAct77 != null){
        java.util.List listrestAct77= java.util.Arrays.asList(typerestAct77);
        temprestAct77 = listrestAct77.toString();
        }
        %>
        <%=temprestAct77%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
java.util.Calendar typefecha79 = dataCPNull74mtemp.getFecha();
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
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
%>
<%=dataCPNull74mtemp.getCantidad()
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
if(dataCPNull74mtemp != null){
servidor.DataPaquete tebece0=dataCPNull74mtemp.getPaq();
if(tebece0 != null){
%>
<%=tebece0.getDescuento()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
servidor.DataPaquete tebece0=dataCPNull74mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion87 = tebece0.getDescripcion();
        String tempResultdescripcion87 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion87));
        %>
        <%= tempResultdescripcion87 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
servidor.DataPaquete tebece0=dataCPNull74mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta89 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta89 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta89 = typefechaAlta89.getTime();
        String tempResultfechaAlta89 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta89.format(datefechaAlta89));
        %>
        <%= tempResultfechaAlta89 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
servidor.DataPaquete tebece0=dataCPNull74mtemp.getPaq();
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
if(dataCPNull74mtemp != null){
servidor.DataPaquete tebece0=dataCPNull74mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre93 = tebece0.getNombre();
        String tempResultnombre93 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre93));
        %>
        <%= tempResultnombre93 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
java.util.Calendar typevencimiento95 = dataCPNull74mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento95 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento95 = typevencimiento95.getTime();
        String tempResultvencimiento95 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento95.format(datevencimiento95));
        %>
        <%= tempResultvencimiento95 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull74mtemp != null){
%>
<%=dataCPNull74mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 99:
        gotMethod = true;
        servidor.EstadoAct estadoActNull99mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull99mtemp == null){
%>
<%=estadoActNull99mtemp %>
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
case 104:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg0107");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg1109");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        String arg2_3id=  request.getParameter("arg2111");
            java.lang.String arg2_3idTemp = null;
        if(!arg2_3id.equals("")){
         arg2_3idTemp  = arg2_3id;
        }
        String arg3_4id=  request.getParameter("arg3113");
            java.lang.String arg3_4idTemp = null;
        if(!arg3_4id.equals("")){
         arg3_4idTemp  = arg3_4id;
        }
        String arg4_5id=  request.getParameter("arg4115");
            java.util.Calendar arg4_5idTemp = null;
        if(!arg4_5id.equals("")){
        java.text.DateFormat dateFormatarg4115 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4115  = dateFormatarg4115.parse(arg4_5id);
         arg4_5idTemp = new java.util.GregorianCalendar();
        arg4_5idTemp.setTime(dateTemparg4115);
        }
        String arg5_6id=  request.getParameter("arg5117");
            java.lang.String arg5_6idTemp = null;
        if(!arg5_6id.equals("")){
         arg5_6idTemp  = arg5_6id;
        }
        String arg6_7id=  request.getParameter("arg6119");
            java.lang.String arg6_7idTemp = null;
        if(!arg6_7id.equals("")){
         arg6_7idTemp  = arg6_7id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTuristaPass(arg0_1idTemp,arg1_2idTemp,arg2_3idTemp,arg3_4idTemp,arg4_5idTemp,arg5_6idTemp,arg6_7idTemp);
break;
case 121:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0124");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        String arg1_9id=  request.getParameter("arg1126");
            java.lang.String arg1_9idTemp = null;
        if(!arg1_9id.equals("")){
         arg1_9idTemp  = arg1_9id;
        }
        String arg2_10id=  request.getParameter("arg2128");
            java.lang.String arg2_10idTemp = null;
        if(!arg2_10id.equals("")){
         arg2_10idTemp  = arg2_10id;
        }
        String arg3_11id=  request.getParameter("arg3130");
            java.lang.String arg3_11idTemp = null;
        if(!arg3_11id.equals("")){
         arg3_11idTemp  = arg3_11id;
        }
        String arg4_12id=  request.getParameter("arg4132");
            java.util.Calendar arg4_12idTemp = null;
        if(!arg4_12id.equals("")){
        java.text.DateFormat dateFormatarg4132 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4132  = dateFormatarg4132.parse(arg4_12id);
         arg4_12idTemp = new java.util.GregorianCalendar();
        arg4_12idTemp.setTime(dateTemparg4132);
        }
        String arg5_13id=  request.getParameter("arg5134");
            java.lang.String arg5_13idTemp = null;
        if(!arg5_13id.equals("")){
         arg5_13idTemp  = arg5_13id;
        }
        String arg6_14id=  request.getParameter("arg6136");
            java.lang.String arg6_14idTemp = null;
        if(!arg6_14id.equals("")){
         arg6_14idTemp  = arg6_14id;
        }
        String arg7_15id=  request.getParameter("arg7138");
        boolean arg7_15idTemp  = Boolean.valueOf(arg7_15id).booleanValue();
        String arg8_16id=  request.getParameter("arg8140");
            java.lang.String arg8_16idTemp = null;
        if(!arg8_16id.equals("")){
         arg8_16idTemp  = arg8_16id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedorPass(arg0_8idTemp,arg1_9idTemp,arg2_10idTemp,arg3_11idTemp,arg4_12idTemp,arg5_13idTemp,arg6_14idTemp,arg7_15idTemp,arg8_16idTemp);
break;
case 142:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg0157");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        servidor.DataUsuario verInfoUsuario142mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_17idTemp);
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
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario142mtemp != null){
java.lang.String typeapellido155 = verInfoUsuario142mtemp.getApellido();
        String tempResultapellido155 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido155));
        %>
        <%= tempResultapellido155 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 159:
        gotMethod = true;
        servidor.DataColeccionObject getUsuariosComp159mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp159mtemp == null){
%>
<%=getUsuariosComp159mtemp %>
<%
}else{
        if(getUsuariosComp159mtemp!= null){
        String tempreturnp160 = getUsuariosComp159mtemp.toString();
        %>
        <%=tempreturnp160%>
        <%
        }}
break;
case 162:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg0177");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        servidor.DataUsuario ingresarDatos162mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_18idTemp);
if(ingresarDatos162mtemp == null){
%>
<%=ingresarDatos162mtemp %>
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
if(ingresarDatos162mtemp != null){
java.util.Calendar typenacimiento165 = ingresarDatos162mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento165 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento165 = typenacimiento165.getTime();
        String tempResultnacimiento165 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento165.format(datenacimiento165));
        %>
        <%= tempResultnacimiento165 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos162mtemp != null){
java.lang.String typenick167 = ingresarDatos162mtemp.getNick();
        String tempResultnick167 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick167));
        %>
        <%= tempResultnick167 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos162mtemp != null){
java.lang.String typemail169 = ingresarDatos162mtemp.getMail();
        String tempResultmail169 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail169));
        %>
        <%= tempResultmail169 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos162mtemp != null){
java.lang.String typepassword171 = ingresarDatos162mtemp.getPassword();
        String tempResultpassword171 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword171));
        %>
        <%= tempResultpassword171 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos162mtemp != null){
java.lang.String typenombre173 = ingresarDatos162mtemp.getNombre();
        String tempResultnombre173 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre173));
        %>
        <%= tempResultnombre173 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos162mtemp != null){
java.lang.String typeapellido175 = ingresarDatos162mtemp.getApellido();
        String tempResultapellido175 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido175));
        %>
        <%= tempResultapellido175 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 179:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0182");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        servidor.DataColeccionObject obtenerActividadCategoria179mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_19idTemp);
if(obtenerActividadCategoria179mtemp == null){
%>
<%=obtenerActividadCategoria179mtemp %>
<%
}else{
        if(obtenerActividadCategoria179mtemp!= null){
        String tempreturnp180 = obtenerActividadCategoria179mtemp.toString();
        %>
        <%=tempreturnp180%>
        <%
        }}
break;
case 184:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0199");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick184mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_20idTemp);
if(obtenerDataUsuarioNick184mtemp == null){
%>
<%=obtenerDataUsuarioNick184mtemp %>
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
if(obtenerDataUsuarioNick184mtemp != null){
java.util.Calendar typenacimiento187 = obtenerDataUsuarioNick184mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento187 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento187 = typenacimiento187.getTime();
        String tempResultnacimiento187 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento187.format(datenacimiento187));
        %>
        <%= tempResultnacimiento187 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick184mtemp != null){
java.lang.String typenick189 = obtenerDataUsuarioNick184mtemp.getNick();
        String tempResultnick189 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick189));
        %>
        <%= tempResultnick189 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick184mtemp != null){
java.lang.String typemail191 = obtenerDataUsuarioNick184mtemp.getMail();
        String tempResultmail191 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail191));
        %>
        <%= tempResultmail191 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick184mtemp != null){
java.lang.String typepassword193 = obtenerDataUsuarioNick184mtemp.getPassword();
        String tempResultpassword193 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword193));
        %>
        <%= tempResultpassword193 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick184mtemp != null){
java.lang.String typenombre195 = obtenerDataUsuarioNick184mtemp.getNombre();
        String tempResultnombre195 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre195));
        %>
        <%= tempResultnombre195 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick184mtemp != null){
java.lang.String typeapellido197 = obtenerDataUsuarioNick184mtemp.getApellido();
        String tempResultapellido197 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido197));
        %>
        <%= tempResultapellido197 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 201:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0216");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail201mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_21idTemp);
if(obtenerDataUsuarioMail201mtemp == null){
%>
<%=obtenerDataUsuarioMail201mtemp %>
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
if(obtenerDataUsuarioMail201mtemp != null){
java.util.Calendar typenacimiento204 = obtenerDataUsuarioMail201mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento204 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento204 = typenacimiento204.getTime();
        String tempResultnacimiento204 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento204.format(datenacimiento204));
        %>
        <%= tempResultnacimiento204 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail201mtemp != null){
java.lang.String typenick206 = obtenerDataUsuarioMail201mtemp.getNick();
        String tempResultnick206 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick206));
        %>
        <%= tempResultnick206 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail201mtemp != null){
java.lang.String typemail208 = obtenerDataUsuarioMail201mtemp.getMail();
        String tempResultmail208 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail208));
        %>
        <%= tempResultmail208 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail201mtemp != null){
java.lang.String typepassword210 = obtenerDataUsuarioMail201mtemp.getPassword();
        String tempResultpassword210 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword210));
        %>
        <%= tempResultpassword210 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail201mtemp != null){
java.lang.String typenombre212 = obtenerDataUsuarioMail201mtemp.getNombre();
        String tempResultnombre212 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre212));
        %>
        <%= tempResultnombre212 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail201mtemp != null){
java.lang.String typeapellido214 = obtenerDataUsuarioMail201mtemp.getApellido();
        String tempResultapellido214 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido214));
        %>
        <%= tempResultapellido214 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 218:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0235");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        servidor.DataActividad obtenerDataActividad218mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_22idTemp);
if(obtenerDataActividad218mtemp == null){
%>
<%=obtenerDataActividad218mtemp %>
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
if(obtenerDataActividad218mtemp != null){
java.util.Calendar typefechaAlta221 = obtenerDataActividad218mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta221 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta221 = typefechaAlta221.getTime();
        String tempResultfechaAlta221 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta221.format(datefechaAlta221));
        %>
        <%= tempResultfechaAlta221 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad218mtemp != null){
java.lang.String typedepartamento223 = obtenerDataActividad218mtemp.getDepartamento();
        String tempResultdepartamento223 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento223));
        %>
        <%= tempResultdepartamento223 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad218mtemp != null){
%>
<%=obtenerDataActividad218mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad218mtemp != null){
java.lang.String typedescripcion227 = obtenerDataActividad218mtemp.getDescripcion();
        String tempResultdescripcion227 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion227));
        %>
        <%= tempResultdescripcion227 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad218mtemp != null){
java.lang.String typeciudad229 = obtenerDataActividad218mtemp.getCiudad();
        String tempResultciudad229 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad229));
        %>
        <%= tempResultciudad229 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad218mtemp != null){
%>
<%=obtenerDataActividad218mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad218mtemp != null){
java.lang.String typenombre233 = obtenerDataActividad218mtemp.getNombre();
        String tempResultnombre233 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre233));
        %>
        <%= tempResultnombre233 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 237:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0252");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        servidor.DataSalida obtenerDataSalida237mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_23idTemp);
if(obtenerDataSalida237mtemp == null){
%>
<%=obtenerDataSalida237mtemp %>
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
if(obtenerDataSalida237mtemp != null){
java.util.Calendar typehora240 = obtenerDataSalida237mtemp.getHora();
        java.text.DateFormat dateFormathora240 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora240 = typehora240.getTime();
        String tempResulthora240 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora240.format(datehora240));
        %>
        <%= tempResulthora240 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida237mtemp != null){
java.util.Calendar typefecha242 = obtenerDataSalida237mtemp.getFecha();
        java.text.DateFormat dateFormatfecha242 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha242 = typefecha242.getTime();
        String tempResultfecha242 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha242.format(datefecha242));
        %>
        <%= tempResultfecha242 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida237mtemp != null){
%>
<%=obtenerDataSalida237mtemp.getCant()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataSalida237mtemp != null){
java.util.Calendar typefechaAlta246 = obtenerDataSalida237mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta246 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta246 = typefechaAlta246.getTime();
        String tempResultfechaAlta246 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta246.format(datefechaAlta246));
        %>
        <%= tempResultfechaAlta246 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida237mtemp != null){
java.lang.String typelugar248 = obtenerDataSalida237mtemp.getLugar();
        String tempResultlugar248 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar248));
        %>
        <%= tempResultlugar248 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida237mtemp != null){
java.lang.String typenombre250 = obtenerDataSalida237mtemp.getNombre();
        String tempResultnombre250 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre250));
        %>
        <%= tempResultnombre250 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 254:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0257");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1259");
            java.util.Calendar arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
        java.text.DateFormat dateFormatarg1259 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1259  = dateFormatarg1259.parse(arg1_25id);
         arg1_25idTemp = new java.util.GregorianCalendar();
        arg1_25idTemp.setTime(dateTemparg1259);
        }
        String arg2_26id=  request.getParameter("arg2261");
        int arg2_26idTemp  = Integer.parseInt(arg2_26id);
        String arg3_27id=  request.getParameter("arg3263");
            java.lang.String arg3_27idTemp = null;
        if(!arg3_27id.equals("")){
         arg3_27idTemp  = arg3_27id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_24idTemp,arg1_25idTemp,arg2_26idTemp,arg3_27idTemp);
break;
case 265:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0268");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        String arg1_29id=  request.getParameter("arg1270");
            java.lang.String arg1_29idTemp = null;
        if(!arg1_29id.equals("")){
         arg1_29idTemp  = arg1_29id;
        }
        String arg2_30id=  request.getParameter("arg2272");
        int arg2_30idTemp  = Integer.parseInt(arg2_30id);
        String arg3_31id=  request.getParameter("arg3274");
            java.util.Calendar arg3_31idTemp = null;
        if(!arg3_31id.equals("")){
        java.text.DateFormat dateFormatarg3274 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3274  = dateFormatarg3274.parse(arg3_31id);
         arg3_31idTemp = new java.util.GregorianCalendar();
        arg3_31idTemp.setTime(dateTemparg3274);
        }
        String arg4_32id=  request.getParameter("arg4276");
            java.lang.String arg4_32idTemp = null;
        if(!arg4_32id.equals("")){
         arg4_32idTemp  = arg4_32id;
        }
        String arg5_33id=  request.getParameter("arg5278");
            java.lang.String arg5_33idTemp = null;
        if(!arg5_33id.equals("")){
         arg5_33idTemp  = arg5_33id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_28idTemp,arg1_29idTemp,arg2_30idTemp,arg3_31idTemp,arg4_32idTemp,arg5_33idTemp);
break;
case 280:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0283");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        servidor.DataColeccionObject obtenerPaquetesComprados280mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_34idTemp);
if(obtenerPaquetesComprados280mtemp == null){
%>
<%=obtenerPaquetesComprados280mtemp %>
<%
}else{
        if(obtenerPaquetesComprados280mtemp!= null){
        String tempreturnp281 = obtenerPaquetesComprados280mtemp.toString();
        %>
        <%=tempreturnp281%>
        <%
        }}
break;
case 285:
        gotMethod = true;
        String arg0_35id=  request.getParameter("arg0288");
            java.lang.String arg0_35idTemp = null;
        if(!arg0_35id.equals("")){
         arg0_35idTemp  = arg0_35id;
        }
        java.lang.String obtenerNomActPorSalida285mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_35idTemp);
if(obtenerNomActPorSalida285mtemp == null){
%>
<%=obtenerNomActPorSalida285mtemp %>
<%
}else{
        String tempResultreturnp286 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida285mtemp));
        %>
        <%= tempResultreturnp286 %>
        <%
}
break;
case 290:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0293");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        servidor.DataColeccionObject selecDepartamento290mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_36idTemp);
if(selecDepartamento290mtemp == null){
%>
<%=selecDepartamento290mtemp %>
<%
}else{
        if(selecDepartamento290mtemp!= null){
        String tempreturnp291 = selecDepartamento290mtemp.toString();
        %>
        <%=tempreturnp291%>
        <%
        }}
break;
case 295:
        gotMethod = true;
        String arg0_37id=  request.getParameter("arg0298");
            java.lang.String arg0_37idTemp = null;
        if(!arg0_37id.equals("")){
         arg0_37idTemp  = arg0_37id;
        }
        servidor.DataColeccionObject salidas295mtemp = samplePublicadorIControladorProxyid.salidas(arg0_37idTemp);
if(salidas295mtemp == null){
%>
<%=salidas295mtemp %>
<%
}else{
        if(salidas295mtemp!= null){
        String tempreturnp296 = salidas295mtemp.toString();
        %>
        <%=tempreturnp296%>
        <%
        }}
break;
case 300:
        gotMethod = true;
        String arg0_38id=  request.getParameter("arg0303");
            java.lang.String arg0_38idTemp = null;
        if(!arg0_38id.equals("")){
         arg0_38idTemp  = arg0_38id;
        }
        String arg1_39id=  request.getParameter("arg1305");
            java.lang.String arg1_39idTemp = null;
        if(!arg1_39id.equals("")){
         arg1_39idTemp  = arg1_39id;
        }
        String arg2_40id=  request.getParameter("arg2307");
        int arg2_40idTemp  = Integer.parseInt(arg2_40id);
        String arg3_41id=  request.getParameter("arg3309");
            java.util.Calendar arg3_41idTemp = null;
        if(!arg3_41id.equals("")){
        java.text.DateFormat dateFormatarg3309 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3309  = dateFormatarg3309.parse(arg3_41id);
         arg3_41idTemp = new java.util.GregorianCalendar();
        arg3_41idTemp.setTime(dateTemparg3309);
        }
        String arg4_42id=  request.getParameter("arg4311");
            java.lang.String arg4_42idTemp = null;
        if(!arg4_42id.equals("")){
         arg4_42idTemp  = arg4_42id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_38idTemp,arg1_39idTemp,arg2_40idTemp,arg3_41idTemp,arg4_42idTemp);
break;
case 313:
        gotMethod = true;
        servidor.DataColeccionObject listarUsuarios313mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios313mtemp == null){
%>
<%=listarUsuarios313mtemp %>
<%
}else{
        if(listarUsuarios313mtemp!= null){
        String tempreturnp314 = listarUsuarios313mtemp.toString();
        %>
        <%=tempreturnp314%>
        <%
        }}
break;
case 316:
        gotMethod = true;
        String arg0_43id=  request.getParameter("arg0319");
            java.lang.String arg0_43idTemp = null;
        if(!arg0_43id.equals("")){
         arg0_43idTemp  = arg0_43id;
        }
        String arg1_44id=  request.getParameter("arg1321");
            java.lang.String arg1_44idTemp = null;
        if(!arg1_44id.equals("")){
         arg1_44idTemp  = arg1_44id;
        }
        String arg2_45id=  request.getParameter("arg2323");
            java.lang.String arg2_45idTemp = null;
        if(!arg2_45id.equals("")){
         arg2_45idTemp  = arg2_45id;
        }
        String arg3_46id=  request.getParameter("arg3325");
        int arg3_46idTemp  = Integer.parseInt(arg3_46id);
        String arg4_47id=  request.getParameter("arg4327");
        int arg4_47idTemp  = Integer.parseInt(arg4_47id);
        String arg5_48id=  request.getParameter("arg5329");
            java.lang.String arg5_48idTemp = null;
        if(!arg5_48id.equals("")){
         arg5_48idTemp  = arg5_48id;
        }
        String arg6_49id=  request.getParameter("arg6331");
            java.util.Calendar arg6_49idTemp = null;
        if(!arg6_49id.equals("")){
        java.text.DateFormat dateFormatarg6331 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6331  = dateFormatarg6331.parse(arg6_49id);
         arg6_49idTemp = new java.util.GregorianCalendar();
        arg6_49idTemp.setTime(dateTemparg6331);
        }
        String arg7_50id=  request.getParameter("arg7333");
            java.lang.String arg7_50idTemp = null;
        if(!arg7_50id.equals("")){
         arg7_50idTemp  = arg7_50id;
        }
        %>
        <jsp:useBean id="servidor1DataColeccionObject_51id" scope="session" class="servidor.DataColeccionObject" />
        <%
        samplePublicadorIControladorProxyid.registrarActividad(arg0_43idTemp,arg1_44idTemp,arg2_45idTemp,arg3_46idTemp,arg4_47idTemp,arg5_48idTemp,arg6_49idTemp,arg7_50idTemp,servidor1DataColeccionObject_51id);
break;
case 337:
        gotMethod = true;
        servidor.DataColeccionObject getUsuarios337mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios337mtemp == null){
%>
<%=getUsuarios337mtemp %>
<%
}else{
        if(getUsuarios337mtemp!= null){
        String tempreturnp338 = getUsuarios337mtemp.toString();
        %>
        <%=tempreturnp338%>
        <%
        }}
break;
case 340:
        gotMethod = true;
        servidor.DataColeccionObject obtenerNombreCategorias340mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias340mtemp == null){
%>
<%=obtenerNombreCategorias340mtemp %>
<%
}else{
        if(obtenerNombreCategorias340mtemp!= null){
        String tempreturnp341 = obtenerNombreCategorias340mtemp.toString();
        %>
        <%=tempreturnp341%>
        <%
        }}
break;
case 343:
        gotMethod = true;
        String arg0_52id=  request.getParameter("arg0346");
            java.lang.String arg0_52idTemp = null;
        if(!arg0_52id.equals("")){
         arg0_52idTemp  = arg0_52id;
        }
        String arg1_53id=  request.getParameter("arg1348");
            java.lang.String arg1_53idTemp = null;
        if(!arg1_53id.equals("")){
         arg1_53idTemp  = arg1_53id;
        }
        String arg2_54id=  request.getParameter("arg2350");
            java.util.Calendar arg2_54idTemp = null;
        if(!arg2_54id.equals("")){
        java.text.DateFormat dateFormatarg2350 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2350  = dateFormatarg2350.parse(arg2_54id);
         arg2_54idTemp = new java.util.GregorianCalendar();
        arg2_54idTemp.setTime(dateTemparg2350);
        }
        String arg3_55id=  request.getParameter("arg3352");
            java.util.Calendar arg3_55idTemp = null;
        if(!arg3_55id.equals("")){
        java.text.DateFormat dateFormatarg3352 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3352  = dateFormatarg3352.parse(arg3_55id);
         arg3_55idTemp = new java.util.GregorianCalendar();
        arg3_55idTemp.setTime(dateTemparg3352);
        }
        String arg4_56id=  request.getParameter("arg4354");
            java.lang.String arg4_56idTemp = null;
        if(!arg4_56id.equals("")){
         arg4_56idTemp  = arg4_56id;
        }
        String arg5_57id=  request.getParameter("arg5356");
        int arg5_57idTemp  = Integer.parseInt(arg5_57id);
        String arg6_58id=  request.getParameter("arg6358");
            java.util.Calendar arg6_58idTemp = null;
        if(!arg6_58id.equals("")){
        java.text.DateFormat dateFormatarg6358 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6358  = dateFormatarg6358.parse(arg6_58id);
         arg6_58idTemp = new java.util.GregorianCalendar();
        arg6_58idTemp.setTime(dateTemparg6358);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_52idTemp,arg1_53idTemp,arg2_54idTemp,arg3_55idTemp,arg4_56idTemp,arg5_57idTemp,arg6_58idTemp);
break;
case 360:
        gotMethod = true;
        String arg0_59id=  request.getParameter("arg0363");
            java.lang.String arg0_59idTemp = null;
        if(!arg0_59id.equals("")){
         arg0_59idTemp  = arg0_59id;
        }
        String arg1_60id=  request.getParameter("arg1365");
            java.lang.String arg1_60idTemp = null;
        if(!arg1_60id.equals("")){
         arg1_60idTemp  = arg1_60id;
        }
        String arg2_61id=  request.getParameter("arg2367");
            java.lang.String arg2_61idTemp = null;
        if(!arg2_61id.equals("")){
         arg2_61idTemp  = arg2_61id;
        }
        String arg3_62id=  request.getParameter("arg3369");
            java.lang.String arg3_62idTemp = null;
        if(!arg3_62id.equals("")){
         arg3_62idTemp  = arg3_62id;
        }
        String arg4_63id=  request.getParameter("arg4371");
            java.util.Calendar arg4_63idTemp = null;
        if(!arg4_63id.equals("")){
        java.text.DateFormat dateFormatarg4371 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4371  = dateFormatarg4371.parse(arg4_63id);
         arg4_63idTemp = new java.util.GregorianCalendar();
        arg4_63idTemp.setTime(dateTemparg4371);
        }
        String arg5_64id=  request.getParameter("arg5373");
            java.lang.String arg5_64idTemp = null;
        if(!arg5_64id.equals("")){
         arg5_64idTemp  = arg5_64id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_59idTemp,arg1_60idTemp,arg2_61idTemp,arg3_62idTemp,arg4_63idTemp,arg5_64idTemp);
break;
case 375:
        gotMethod = true;
        String arg0_65id=  request.getParameter("arg0378");
            java.lang.String arg0_65idTemp = null;
        if(!arg0_65id.equals("")){
         arg0_65idTemp  = arg0_65id;
        }
        String arg1_66id=  request.getParameter("arg1380");
            java.lang.String arg1_66idTemp = null;
        if(!arg1_66id.equals("")){
         arg1_66idTemp  = arg1_66id;
        }
        String arg2_67id=  request.getParameter("arg2382");
            java.lang.String arg2_67idTemp = null;
        if(!arg2_67id.equals("")){
         arg2_67idTemp  = arg2_67id;
        }
        String arg3_68id=  request.getParameter("arg3384");
            java.lang.String arg3_68idTemp = null;
        if(!arg3_68id.equals("")){
         arg3_68idTemp  = arg3_68id;
        }
        String arg4_69id=  request.getParameter("arg4386");
            java.util.Calendar arg4_69idTemp = null;
        if(!arg4_69id.equals("")){
        java.text.DateFormat dateFormatarg4386 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4386  = dateFormatarg4386.parse(arg4_69id);
         arg4_69idTemp = new java.util.GregorianCalendar();
        arg4_69idTemp.setTime(dateTemparg4386);
        }
        String arg5_70id=  request.getParameter("arg5388");
            java.lang.String arg5_70idTemp = null;
        if(!arg5_70id.equals("")){
         arg5_70idTemp  = arg5_70id;
        }
        String arg6_71id=  request.getParameter("arg6390");
            java.lang.String arg6_71idTemp = null;
        if(!arg6_71id.equals("")){
         arg6_71idTemp  = arg6_71id;
        }
        String arg7_72id=  request.getParameter("arg7392");
        boolean arg7_72idTemp  = Boolean.valueOf(arg7_72id).booleanValue();
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_65idTemp,arg1_66idTemp,arg2_67idTemp,arg3_68idTemp,arg4_69idTemp,arg5_70idTemp,arg6_71idTemp,arg7_72idTemp);
break;
case 394:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetes394mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes394mtemp == null){
%>
<%=listarPaquetes394mtemp %>
<%
}else{
        if(listarPaquetes394mtemp!= null){
        String tempreturnp395 = listarPaquetes394mtemp.toString();
        %>
        <%=tempreturnp395%>
        <%
        }}
break;
case 397:
        gotMethod = true;
        String arg0_73id=  request.getParameter("arg0410");
            java.lang.String arg0_73idTemp = null;
        if(!arg0_73id.equals("")){
         arg0_73idTemp  = arg0_73id;
        }
        servidor.DataPaquete obtenerDataPaquete397mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_73idTemp);
if(obtenerDataPaquete397mtemp == null){
%>
<%=obtenerDataPaquete397mtemp %>
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
if(obtenerDataPaquete397mtemp != null){
%>
<%=obtenerDataPaquete397mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete397mtemp != null){
java.lang.String typedescripcion402 = obtenerDataPaquete397mtemp.getDescripcion();
        String tempResultdescripcion402 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion402));
        %>
        <%= tempResultdescripcion402 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete397mtemp != null){
java.util.Calendar typefechaAlta404 = obtenerDataPaquete397mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta404 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta404 = typefechaAlta404.getTime();
        String tempResultfechaAlta404 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta404.format(datefechaAlta404));
        %>
        <%= tempResultfechaAlta404 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete397mtemp != null){
%>
<%=obtenerDataPaquete397mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete397mtemp != null){
java.lang.String typenombre408 = obtenerDataPaquete397mtemp.getNombre();
        String tempResultnombre408 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre408));
        %>
        <%= tempResultnombre408 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 412:
        gotMethod = true;
        String arg0_74id=  request.getParameter("arg0415");
            java.lang.String arg0_74idTemp = null;
        if(!arg0_74id.equals("")){
         arg0_74idTemp  = arg0_74id;
        }
        String arg1_75id=  request.getParameter("arg1417");
            java.lang.String arg1_75idTemp = null;
        if(!arg1_75id.equals("")){
         arg1_75idTemp  = arg1_75id;
        }
        String arg2_76id=  request.getParameter("arg2419");
            java.lang.String arg2_76idTemp = null;
        if(!arg2_76id.equals("")){
         arg2_76idTemp  = arg2_76id;
        }
        String arg3_77id=  request.getParameter("arg3421");
            java.lang.String arg3_77idTemp = null;
        if(!arg3_77id.equals("")){
         arg3_77idTemp  = arg3_77id;
        }
        String arg4_78id=  request.getParameter("arg4423");
            java.util.Calendar arg4_78idTemp = null;
        if(!arg4_78id.equals("")){
        java.text.DateFormat dateFormatarg4423 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4423  = dateFormatarg4423.parse(arg4_78id);
         arg4_78idTemp = new java.util.GregorianCalendar();
        arg4_78idTemp.setTime(dateTemparg4423);
        }
        String arg5_79id=  request.getParameter("arg5425");
            java.lang.String arg5_79idTemp = null;
        if(!arg5_79id.equals("")){
         arg5_79idTemp  = arg5_79id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_74idTemp,arg1_75idTemp,arg2_76idTemp,arg3_77idTemp,arg4_78idTemp,arg5_79idTemp);
break;
case 427:
        gotMethod = true;
        String arg0_80id=  request.getParameter("arg0430");
            java.lang.String arg0_80idTemp = null;
        if(!arg0_80id.equals("")){
         arg0_80idTemp  = arg0_80id;
        }
        String arg1_81id=  request.getParameter("arg1432");
            java.lang.String arg1_81idTemp = null;
        if(!arg1_81id.equals("")){
         arg1_81idTemp  = arg1_81id;
        }
        String arg2_82id=  request.getParameter("arg2434");
            java.lang.String arg2_82idTemp = null;
        if(!arg2_82id.equals("")){
         arg2_82idTemp  = arg2_82id;
        }
        String arg3_83id=  request.getParameter("arg3436");
            java.lang.String arg3_83idTemp = null;
        if(!arg3_83id.equals("")){
         arg3_83idTemp  = arg3_83id;
        }
        String arg4_84id=  request.getParameter("arg4438");
            java.util.Calendar arg4_84idTemp = null;
        if(!arg4_84id.equals("")){
        java.text.DateFormat dateFormatarg4438 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4438  = dateFormatarg4438.parse(arg4_84id);
         arg4_84idTemp = new java.util.GregorianCalendar();
        arg4_84idTemp.setTime(dateTemparg4438);
        }
        String arg5_85id=  request.getParameter("arg5440");
            java.lang.String arg5_85idTemp = null;
        if(!arg5_85id.equals("")){
         arg5_85idTemp  = arg5_85id;
        }
        String arg6_86id=  request.getParameter("arg6442");
            java.lang.String arg6_86idTemp = null;
        if(!arg6_86id.equals("")){
         arg6_86idTemp  = arg6_86id;
        }
        String arg7_87id=  request.getParameter("arg7444");
        boolean arg7_87idTemp  = Boolean.valueOf(arg7_87id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_80idTemp,arg1_81idTemp,arg2_82idTemp,arg3_83idTemp,arg4_84idTemp,arg5_85idTemp,arg6_86idTemp,arg7_87idTemp);
break;
case 446:
        gotMethod = true;
        servidor.DataColeccionObject listarActividadesAgregadas446mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas446mtemp == null){
%>
<%=listarActividadesAgregadas446mtemp %>
<%
}else{
        if(listarActividadesAgregadas446mtemp!= null){
        String tempreturnp447 = listarActividadesAgregadas446mtemp.toString();
        %>
        <%=tempreturnp447%>
        <%
        }}
break;
case 449:
        gotMethod = true;
        String arg0_88id=  request.getParameter("arg0452");
            java.lang.String arg0_88idTemp = null;
        if(!arg0_88id.equals("")){
         arg0_88idTemp  = arg0_88id;
        }
        String arg1_89id=  request.getParameter("arg1454");
            java.lang.String arg1_89idTemp = null;
        if(!arg1_89id.equals("")){
         arg1_89idTemp  = arg1_89id;
        }
        servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete449mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_88idTemp,arg1_89idTemp);
if(actividadesPorDepartamentoNoEnPaquete449mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete449mtemp %>
<%
}else{
        if(actividadesPorDepartamentoNoEnPaquete449mtemp!= null){
        String tempreturnp450 = actividadesPorDepartamentoNoEnPaquete449mtemp.toString();
        %>
        <%=tempreturnp450%>
        <%
        }}
break;
case 456:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetesNoComprados456mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados456mtemp == null){
%>
<%=listarPaquetesNoComprados456mtemp %>
<%
}else{
        if(listarPaquetesNoComprados456mtemp!= null){
        String tempreturnp457 = listarPaquetesNoComprados456mtemp.toString();
        %>
        <%=tempreturnp457%>
        <%
        }}
break;
case 459:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 462:
        gotMethod = true;
        servidor.DataColeccionObject obtenerDataDepartamentos462mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos462mtemp == null){
%>
<%=obtenerDataDepartamentos462mtemp %>
<%
}else{
        if(obtenerDataDepartamentos462mtemp!= null){
        String tempreturnp463 = obtenerDataDepartamentos462mtemp.toString();
        %>
        <%=tempreturnp463%>
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