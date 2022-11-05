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
</TABLE>
<%
}
break;
case 54:
        gotMethod = true;
        servidor.DataCompraGeneral dataCGNull54mtemp = samplePublicadorIControladorProxyid.dataCGNull();
if(dataCGNull54mtemp == null){
%>
<%=dataCGNull54mtemp %>
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
if(dataCGNull54mtemp != null){
java.util.Calendar typefecha57 = dataCGNull54mtemp.getFecha();
        java.text.DateFormat dateFormatfecha57 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha57 = typefecha57.getTime();
        String tempResultfecha57 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha57.format(datefecha57));
        %>
        <%= tempResultfecha57 %>
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
if(dataCGNull54mtemp != null){
servidor.DataSalida tebece0=dataCGNull54mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typehora61 = tebece0.getHora();
        java.text.DateFormat dateFormathora61 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora61 = typehora61.getTime();
        String tempResulthora61 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora61.format(datehora61));
        %>
        <%= tempResulthora61 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
servidor.DataSalida tebece0=dataCGNull54mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefecha63 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha63 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha63 = typefecha63.getTime();
        String tempResultfecha63 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha63.format(datefecha63));
        %>
        <%= tempResultfecha63 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
servidor.DataSalida tebece0=dataCGNull54mtemp.getSalida();
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
if(dataCGNull54mtemp != null){
servidor.DataSalida tebece0=dataCGNull54mtemp.getSalida();
if(tebece0 != null){
java.util.Calendar typefechaAlta67 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta67 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta67 = typefechaAlta67.getTime();
        String tempResultfechaAlta67 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta67.format(datefechaAlta67));
        %>
        <%= tempResultfechaAlta67 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
servidor.DataSalida tebece0=dataCGNull54mtemp.getSalida();
if(tebece0 != null){
java.lang.String typelugar69 = tebece0.getLugar();
        String tempResultlugar69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar69));
        %>
        <%= tempResultlugar69 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
servidor.DataSalida tebece0=dataCGNull54mtemp.getSalida();
if(tebece0 != null){
java.lang.String typenombre71 = tebece0.getNombre();
        String tempResultnombre71 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre71));
        %>
        <%= tempResultnombre71 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">porPaquete:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
%>
<%=dataCGNull54mtemp.isPorPaquete()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
%>
<%=dataCGNull54mtemp.getCantidad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCGNull54mtemp != null){
%>
<%=dataCGNull54mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 79:
        gotMethod = true;
        servidor.DataCompraPaquete dataCPNull79mtemp = samplePublicadorIControladorProxyid.dataCPNull();
if(dataCPNull79mtemp == null){
%>
<%=dataCPNull79mtemp %>
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
if(dataCPNull79mtemp != null){
servidor.DataCompraPaqueteRestActEntry[] typerestAct82 = dataCPNull79mtemp.getRestAct();
        String temprestAct82 = null;
        if(typerestAct82 != null){
        java.util.List listrestAct82= java.util.Arrays.asList(typerestAct82);
        temprestAct82 = listrestAct82.toString();
        }
        %>
        <%=temprestAct82%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(dataCPNull79mtemp != null){
java.util.Calendar typefecha84 = dataCPNull79mtemp.getFecha();
        java.text.DateFormat dateFormatfecha84 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha84 = typefecha84.getTime();
        String tempResultfecha84 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha84.format(datefecha84));
        %>
        <%= tempResultfecha84 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantidad:</TD>
<TD>
<%
if(dataCPNull79mtemp != null){
%>
<%=dataCPNull79mtemp.getCantidad()
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
if(dataCPNull79mtemp != null){
servidor.DataPaquete tebece0=dataCPNull79mtemp.getPaq();
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
if(dataCPNull79mtemp != null){
servidor.DataPaquete tebece0=dataCPNull79mtemp.getPaq();
if(tebece0 != null){
java.lang.String typedescripcion92 = tebece0.getDescripcion();
        String tempResultdescripcion92 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion92));
        %>
        <%= tempResultdescripcion92 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(dataCPNull79mtemp != null){
servidor.DataPaquete tebece0=dataCPNull79mtemp.getPaq();
if(tebece0 != null){
java.util.Calendar typefechaAlta94 = tebece0.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta94 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta94 = typefechaAlta94.getTime();
        String tempResultfechaAlta94 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta94.format(datefechaAlta94));
        %>
        <%= tempResultfechaAlta94 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(dataCPNull79mtemp != null){
servidor.DataPaquete tebece0=dataCPNull79mtemp.getPaq();
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
if(dataCPNull79mtemp != null){
servidor.DataPaquete tebece0=dataCPNull79mtemp.getPaq();
if(tebece0 != null){
java.lang.String typenombre98 = tebece0.getNombre();
        String tempResultnombre98 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre98));
        %>
        <%= tempResultnombre98 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">vencimiento:</TD>
<TD>
<%
if(dataCPNull79mtemp != null){
java.util.Calendar typevencimiento100 = dataCPNull79mtemp.getVencimiento();
        java.text.DateFormat dateFormatvencimiento100 = java.text.DateFormat.getDateInstance();
        java.util.Date datevencimiento100 = typevencimiento100.getTime();
        String tempResultvencimiento100 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatvencimiento100.format(datevencimiento100));
        %>
        <%= tempResultvencimiento100 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(dataCPNull79mtemp != null){
%>
<%=dataCPNull79mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 104:
        gotMethod = true;
        servidor.EstadoAct estadoActNull104mtemp = samplePublicadorIControladorProxyid.estadoActNull();
if(estadoActNull104mtemp == null){
%>
<%=estadoActNull104mtemp %>
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
case 109:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg0112");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        String arg1_3id=  request.getParameter("arg1114");
            java.lang.String arg1_3idTemp = null;
        if(!arg1_3id.equals("")){
         arg1_3idTemp  = arg1_3id;
        }
        String arg2_4id=  request.getParameter("arg2116");
            java.lang.String arg2_4idTemp = null;
        if(!arg2_4id.equals("")){
         arg2_4idTemp  = arg2_4id;
        }
        String arg3_5id=  request.getParameter("arg3118");
            java.lang.String arg3_5idTemp = null;
        if(!arg3_5id.equals("")){
         arg3_5idTemp  = arg3_5id;
        }
        String arg4_6id=  request.getParameter("arg4120");
            java.util.Calendar arg4_6idTemp = null;
        if(!arg4_6id.equals("")){
        java.text.DateFormat dateFormatarg4120 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4120  = dateFormatarg4120.parse(arg4_6id);
         arg4_6idTemp = new java.util.GregorianCalendar();
        arg4_6idTemp.setTime(dateTemparg4120);
        }
        String arg5_7id=  request.getParameter("arg5122");
            java.lang.String arg5_7idTemp = null;
        if(!arg5_7id.equals("")){
         arg5_7idTemp  = arg5_7id;
        }
        String arg6_8id=  request.getParameter("arg6124");
            java.lang.String arg6_8idTemp = null;
        if(!arg6_8id.equals("")){
         arg6_8idTemp  = arg6_8id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTuristaPass(arg0_2idTemp,arg1_3idTemp,arg2_4idTemp,arg3_5idTemp,arg4_6idTemp,arg5_7idTemp,arg6_8idTemp);
break;
case 126:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0129");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        String arg1_10id=  request.getParameter("arg1131");
            java.lang.String arg1_10idTemp = null;
        if(!arg1_10id.equals("")){
         arg1_10idTemp  = arg1_10id;
        }
        String arg2_11id=  request.getParameter("arg2133");
            java.lang.String arg2_11idTemp = null;
        if(!arg2_11id.equals("")){
         arg2_11idTemp  = arg2_11id;
        }
        String arg3_12id=  request.getParameter("arg3135");
            java.lang.String arg3_12idTemp = null;
        if(!arg3_12id.equals("")){
         arg3_12idTemp  = arg3_12id;
        }
        String arg4_13id=  request.getParameter("arg4137");
            java.util.Calendar arg4_13idTemp = null;
        if(!arg4_13id.equals("")){
        java.text.DateFormat dateFormatarg4137 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4137  = dateFormatarg4137.parse(arg4_13id);
         arg4_13idTemp = new java.util.GregorianCalendar();
        arg4_13idTemp.setTime(dateTemparg4137);
        }
        String arg5_14id=  request.getParameter("arg5139");
            java.lang.String arg5_14idTemp = null;
        if(!arg5_14id.equals("")){
         arg5_14idTemp  = arg5_14id;
        }
        String arg6_15id=  request.getParameter("arg6141");
            java.lang.String arg6_15idTemp = null;
        if(!arg6_15id.equals("")){
         arg6_15idTemp  = arg6_15id;
        }
        String arg7_16id=  request.getParameter("arg7143");
        boolean arg7_16idTemp  = Boolean.valueOf(arg7_16id).booleanValue();
        String arg8_17id=  request.getParameter("arg8145");
            java.lang.String arg8_17idTemp = null;
        if(!arg8_17id.equals("")){
         arg8_17idTemp  = arg8_17id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedorPass(arg0_9idTemp,arg1_10idTemp,arg2_11idTemp,arg3_12idTemp,arg4_13idTemp,arg5_14idTemp,arg6_15idTemp,arg7_16idTemp,arg8_17idTemp);
break;
case 147:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg0162");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        servidor.DataUsuario verInfoUsuario147mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_18idTemp);
if(verInfoUsuario147mtemp == null){
%>
<%=verInfoUsuario147mtemp %>
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
if(verInfoUsuario147mtemp != null){
java.util.Calendar typenacimiento150 = verInfoUsuario147mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento150 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento150 = typenacimiento150.getTime();
        String tempResultnacimiento150 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento150.format(datenacimiento150));
        %>
        <%= tempResultnacimiento150 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario147mtemp != null){
java.lang.String typenick152 = verInfoUsuario147mtemp.getNick();
        String tempResultnick152 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick152));
        %>
        <%= tempResultnick152 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario147mtemp != null){
java.lang.String typemail154 = verInfoUsuario147mtemp.getMail();
        String tempResultmail154 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail154));
        %>
        <%= tempResultmail154 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario147mtemp != null){
java.lang.String typepassword156 = verInfoUsuario147mtemp.getPassword();
        String tempResultpassword156 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword156));
        %>
        <%= tempResultpassword156 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario147mtemp != null){
java.lang.String typenombre158 = verInfoUsuario147mtemp.getNombre();
        String tempResultnombre158 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre158));
        %>
        <%= tempResultnombre158 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario147mtemp != null){
java.lang.String typeapellido160 = verInfoUsuario147mtemp.getApellido();
        String tempResultapellido160 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido160));
        %>
        <%= tempResultapellido160 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 164:
        gotMethod = true;
        servidor.DataColeccionObject getUsuariosComp164mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp164mtemp == null){
%>
<%=getUsuariosComp164mtemp %>
<%
}else{
        if(getUsuariosComp164mtemp!= null){
        String tempreturnp165 = getUsuariosComp164mtemp.toString();
        %>
        <%=tempreturnp165%>
        <%
        }}
break;
case 167:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0182");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        servidor.DataUsuario ingresarDatos167mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_19idTemp);
if(ingresarDatos167mtemp == null){
%>
<%=ingresarDatos167mtemp %>
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
if(ingresarDatos167mtemp != null){
java.util.Calendar typenacimiento170 = ingresarDatos167mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento170 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento170 = typenacimiento170.getTime();
        String tempResultnacimiento170 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento170.format(datenacimiento170));
        %>
        <%= tempResultnacimiento170 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos167mtemp != null){
java.lang.String typenick172 = ingresarDatos167mtemp.getNick();
        String tempResultnick172 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick172));
        %>
        <%= tempResultnick172 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos167mtemp != null){
java.lang.String typemail174 = ingresarDatos167mtemp.getMail();
        String tempResultmail174 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail174));
        %>
        <%= tempResultmail174 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos167mtemp != null){
java.lang.String typepassword176 = ingresarDatos167mtemp.getPassword();
        String tempResultpassword176 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword176));
        %>
        <%= tempResultpassword176 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos167mtemp != null){
java.lang.String typenombre178 = ingresarDatos167mtemp.getNombre();
        String tempResultnombre178 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre178));
        %>
        <%= tempResultnombre178 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos167mtemp != null){
java.lang.String typeapellido180 = ingresarDatos167mtemp.getApellido();
        String tempResultapellido180 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido180));
        %>
        <%= tempResultapellido180 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 184:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0187");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        servidor.DataColeccionObject obtenerActividadCategoria184mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_20idTemp);
if(obtenerActividadCategoria184mtemp == null){
%>
<%=obtenerActividadCategoria184mtemp %>
<%
}else{
        if(obtenerActividadCategoria184mtemp!= null){
        String tempreturnp185 = obtenerActividadCategoria184mtemp.toString();
        %>
        <%=tempreturnp185%>
        <%
        }}
break;
case 189:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0204");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick189mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_21idTemp);
if(obtenerDataUsuarioNick189mtemp == null){
%>
<%=obtenerDataUsuarioNick189mtemp %>
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
if(obtenerDataUsuarioNick189mtemp != null){
java.util.Calendar typenacimiento192 = obtenerDataUsuarioNick189mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento192 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento192 = typenacimiento192.getTime();
        String tempResultnacimiento192 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento192.format(datenacimiento192));
        %>
        <%= tempResultnacimiento192 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick189mtemp != null){
java.lang.String typenick194 = obtenerDataUsuarioNick189mtemp.getNick();
        String tempResultnick194 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick194));
        %>
        <%= tempResultnick194 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick189mtemp != null){
java.lang.String typemail196 = obtenerDataUsuarioNick189mtemp.getMail();
        String tempResultmail196 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail196));
        %>
        <%= tempResultmail196 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick189mtemp != null){
java.lang.String typepassword198 = obtenerDataUsuarioNick189mtemp.getPassword();
        String tempResultpassword198 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword198));
        %>
        <%= tempResultpassword198 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick189mtemp != null){
java.lang.String typenombre200 = obtenerDataUsuarioNick189mtemp.getNombre();
        String tempResultnombre200 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre200));
        %>
        <%= tempResultnombre200 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick189mtemp != null){
java.lang.String typeapellido202 = obtenerDataUsuarioNick189mtemp.getApellido();
        String tempResultapellido202 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido202));
        %>
        <%= tempResultapellido202 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 206:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0221");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail206mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_22idTemp);
if(obtenerDataUsuarioMail206mtemp == null){
%>
<%=obtenerDataUsuarioMail206mtemp %>
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
if(obtenerDataUsuarioMail206mtemp != null){
java.util.Calendar typenacimiento209 = obtenerDataUsuarioMail206mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento209 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento209 = typenacimiento209.getTime();
        String tempResultnacimiento209 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento209.format(datenacimiento209));
        %>
        <%= tempResultnacimiento209 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail206mtemp != null){
java.lang.String typenick211 = obtenerDataUsuarioMail206mtemp.getNick();
        String tempResultnick211 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick211));
        %>
        <%= tempResultnick211 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail206mtemp != null){
java.lang.String typemail213 = obtenerDataUsuarioMail206mtemp.getMail();
        String tempResultmail213 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail213));
        %>
        <%= tempResultmail213 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail206mtemp != null){
java.lang.String typepassword215 = obtenerDataUsuarioMail206mtemp.getPassword();
        String tempResultpassword215 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword215));
        %>
        <%= tempResultpassword215 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail206mtemp != null){
java.lang.String typenombre217 = obtenerDataUsuarioMail206mtemp.getNombre();
        String tempResultnombre217 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre217));
        %>
        <%= tempResultnombre217 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail206mtemp != null){
java.lang.String typeapellido219 = obtenerDataUsuarioMail206mtemp.getApellido();
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
        String arg0_23id=  request.getParameter("arg0240");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        servidor.DataActividad obtenerDataActividad223mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_23idTemp);
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
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad223mtemp != null){
java.lang.String typenombre238 = obtenerDataActividad223mtemp.getNombre();
        String tempResultnombre238 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre238));
        %>
        <%= tempResultnombre238 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 242:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0257");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        servidor.DataSalida obtenerDataSalida242mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_24idTemp);
if(obtenerDataSalida242mtemp == null){
%>
<%=obtenerDataSalida242mtemp %>
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
if(obtenerDataSalida242mtemp != null){
java.util.Calendar typehora245 = obtenerDataSalida242mtemp.getHora();
        java.text.DateFormat dateFormathora245 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora245 = typehora245.getTime();
        String tempResulthora245 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora245.format(datehora245));
        %>
        <%= tempResulthora245 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida242mtemp != null){
java.util.Calendar typefecha247 = obtenerDataSalida242mtemp.getFecha();
        java.text.DateFormat dateFormatfecha247 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha247 = typefecha247.getTime();
        String tempResultfecha247 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha247.format(datefecha247));
        %>
        <%= tempResultfecha247 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida242mtemp != null){
%>
<%=obtenerDataSalida242mtemp.getCant()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataSalida242mtemp != null){
java.util.Calendar typefechaAlta251 = obtenerDataSalida242mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta251 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta251 = typefechaAlta251.getTime();
        String tempResultfechaAlta251 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta251.format(datefechaAlta251));
        %>
        <%= tempResultfechaAlta251 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida242mtemp != null){
java.lang.String typelugar253 = obtenerDataSalida242mtemp.getLugar();
        String tempResultlugar253 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar253));
        %>
        <%= tempResultlugar253 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida242mtemp != null){
java.lang.String typenombre255 = obtenerDataSalida242mtemp.getNombre();
        String tempResultnombre255 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre255));
        %>
        <%= tempResultnombre255 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 259:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0262");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        String arg1_26id=  request.getParameter("arg1264");
            java.util.Calendar arg1_26idTemp = null;
        if(!arg1_26id.equals("")){
        java.text.DateFormat dateFormatarg1264 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1264  = dateFormatarg1264.parse(arg1_26id);
         arg1_26idTemp = new java.util.GregorianCalendar();
        arg1_26idTemp.setTime(dateTemparg1264);
        }
        String arg2_27id=  request.getParameter("arg2266");
        int arg2_27idTemp  = Integer.parseInt(arg2_27id);
        String arg3_28id=  request.getParameter("arg3268");
            java.lang.String arg3_28idTemp = null;
        if(!arg3_28id.equals("")){
         arg3_28idTemp  = arg3_28id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_25idTemp,arg1_26idTemp,arg2_27idTemp,arg3_28idTemp);
break;
case 270:
        gotMethod = true;
        String arg0_29id=  request.getParameter("arg0273");
            java.lang.String arg0_29idTemp = null;
        if(!arg0_29id.equals("")){
         arg0_29idTemp  = arg0_29id;
        }
        String arg1_30id=  request.getParameter("arg1275");
            java.lang.String arg1_30idTemp = null;
        if(!arg1_30id.equals("")){
         arg1_30idTemp  = arg1_30id;
        }
        String arg2_31id=  request.getParameter("arg2277");
        int arg2_31idTemp  = Integer.parseInt(arg2_31id);
        String arg3_32id=  request.getParameter("arg3279");
            java.util.Calendar arg3_32idTemp = null;
        if(!arg3_32id.equals("")){
        java.text.DateFormat dateFormatarg3279 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3279  = dateFormatarg3279.parse(arg3_32id);
         arg3_32idTemp = new java.util.GregorianCalendar();
        arg3_32idTemp.setTime(dateTemparg3279);
        }
        String arg4_33id=  request.getParameter("arg4281");
            java.lang.String arg4_33idTemp = null;
        if(!arg4_33id.equals("")){
         arg4_33idTemp  = arg4_33id;
        }
        String arg5_34id=  request.getParameter("arg5283");
            java.lang.String arg5_34idTemp = null;
        if(!arg5_34id.equals("")){
         arg5_34idTemp  = arg5_34id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_29idTemp,arg1_30idTemp,arg2_31idTemp,arg3_32idTemp,arg4_33idTemp,arg5_34idTemp);
break;
case 285:
        gotMethod = true;
        String arg0_35id=  request.getParameter("arg0288");
            java.lang.String arg0_35idTemp = null;
        if(!arg0_35id.equals("")){
         arg0_35idTemp  = arg0_35id;
        }
        servidor.DataColeccionObject obtenerPaquetesComprados285mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_35idTemp);
if(obtenerPaquetesComprados285mtemp == null){
%>
<%=obtenerPaquetesComprados285mtemp %>
<%
}else{
        if(obtenerPaquetesComprados285mtemp!= null){
        String tempreturnp286 = obtenerPaquetesComprados285mtemp.toString();
        %>
        <%=tempreturnp286%>
        <%
        }}
break;
case 290:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0293");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        java.lang.String obtenerNomActPorSalida290mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_36idTemp);
if(obtenerNomActPorSalida290mtemp == null){
%>
<%=obtenerNomActPorSalida290mtemp %>
<%
}else{
        String tempResultreturnp291 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida290mtemp));
        %>
        <%= tempResultreturnp291 %>
        <%
}
break;
case 295:
        gotMethod = true;
        String arg0_37id=  request.getParameter("arg0298");
            java.lang.String arg0_37idTemp = null;
        if(!arg0_37id.equals("")){
         arg0_37idTemp  = arg0_37id;
        }
        servidor.DataColeccionObject selecDepartamento295mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_37idTemp);
if(selecDepartamento295mtemp == null){
%>
<%=selecDepartamento295mtemp %>
<%
}else{
        if(selecDepartamento295mtemp!= null){
        String tempreturnp296 = selecDepartamento295mtemp.toString();
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
        servidor.DataColeccionObject salidas300mtemp = samplePublicadorIControladorProxyid.salidas(arg0_38idTemp);
if(salidas300mtemp == null){
%>
<%=salidas300mtemp %>
<%
}else{
        if(salidas300mtemp!= null){
        String tempreturnp301 = salidas300mtemp.toString();
        %>
        <%=tempreturnp301%>
        <%
        }}
break;
case 305:
        gotMethod = true;
        String arg0_39id=  request.getParameter("arg0308");
            java.lang.String arg0_39idTemp = null;
        if(!arg0_39id.equals("")){
         arg0_39idTemp  = arg0_39id;
        }
        String arg1_40id=  request.getParameter("arg1310");
            java.lang.String arg1_40idTemp = null;
        if(!arg1_40id.equals("")){
         arg1_40idTemp  = arg1_40id;
        }
        String arg2_41id=  request.getParameter("arg2312");
        int arg2_41idTemp  = Integer.parseInt(arg2_41id);
        String arg3_42id=  request.getParameter("arg3314");
            java.util.Calendar arg3_42idTemp = null;
        if(!arg3_42id.equals("")){
        java.text.DateFormat dateFormatarg3314 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3314  = dateFormatarg3314.parse(arg3_42id);
         arg3_42idTemp = new java.util.GregorianCalendar();
        arg3_42idTemp.setTime(dateTemparg3314);
        }
        String arg4_43id=  request.getParameter("arg4316");
            java.lang.String arg4_43idTemp = null;
        if(!arg4_43id.equals("")){
         arg4_43idTemp  = arg4_43id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_39idTemp,arg1_40idTemp,arg2_41idTemp,arg3_42idTemp,arg4_43idTemp);
break;
case 318:
        gotMethod = true;
        servidor.DataColeccionObject listarUsuarios318mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios318mtemp == null){
%>
<%=listarUsuarios318mtemp %>
<%
}else{
        if(listarUsuarios318mtemp!= null){
        String tempreturnp319 = listarUsuarios318mtemp.toString();
        %>
        <%=tempreturnp319%>
        <%
        }}
break;
case 321:
        gotMethod = true;
        String arg0_44id=  request.getParameter("arg0324");
            java.lang.String arg0_44idTemp = null;
        if(!arg0_44id.equals("")){
         arg0_44idTemp  = arg0_44id;
        }
        String arg1_45id=  request.getParameter("arg1326");
            java.lang.String arg1_45idTemp = null;
        if(!arg1_45id.equals("")){
         arg1_45idTemp  = arg1_45id;
        }
        String arg2_46id=  request.getParameter("arg2328");
            java.lang.String arg2_46idTemp = null;
        if(!arg2_46id.equals("")){
         arg2_46idTemp  = arg2_46id;
        }
        String arg3_47id=  request.getParameter("arg3330");
        int arg3_47idTemp  = Integer.parseInt(arg3_47id);
        String arg4_48id=  request.getParameter("arg4332");
        int arg4_48idTemp  = Integer.parseInt(arg4_48id);
        String arg5_49id=  request.getParameter("arg5334");
            java.lang.String arg5_49idTemp = null;
        if(!arg5_49id.equals("")){
         arg5_49idTemp  = arg5_49id;
        }
        String arg6_50id=  request.getParameter("arg6336");
            java.util.Calendar arg6_50idTemp = null;
        if(!arg6_50id.equals("")){
        java.text.DateFormat dateFormatarg6336 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6336  = dateFormatarg6336.parse(arg6_50id);
         arg6_50idTemp = new java.util.GregorianCalendar();
        arg6_50idTemp.setTime(dateTemparg6336);
        }
        String arg7_51id=  request.getParameter("arg7338");
            java.lang.String arg7_51idTemp = null;
        if(!arg7_51id.equals("")){
         arg7_51idTemp  = arg7_51id;
        }
        %>
        <jsp:useBean id="servidor1DataColeccionObject_52id" scope="session" class="servidor.DataColeccionObject" />
        <%
        samplePublicadorIControladorProxyid.registrarActividad(arg0_44idTemp,arg1_45idTemp,arg2_46idTemp,arg3_47idTemp,arg4_48idTemp,arg5_49idTemp,arg6_50idTemp,arg7_51idTemp,servidor1DataColeccionObject_52id);
break;
case 342:
        gotMethod = true;
        servidor.DataColeccionObject getUsuarios342mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios342mtemp == null){
%>
<%=getUsuarios342mtemp %>
<%
}else{
        if(getUsuarios342mtemp!= null){
        String tempreturnp343 = getUsuarios342mtemp.toString();
        %>
        <%=tempreturnp343%>
        <%
        }}
break;
case 345:
        gotMethod = true;
        servidor.DataColeccionObject obtenerNombreCategorias345mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias345mtemp == null){
%>
<%=obtenerNombreCategorias345mtemp %>
<%
}else{
        if(obtenerNombreCategorias345mtemp!= null){
        String tempreturnp346 = obtenerNombreCategorias345mtemp.toString();
        %>
        <%=tempreturnp346%>
        <%
        }}
break;
case 348:
        gotMethod = true;
        String arg0_53id=  request.getParameter("arg0351");
            java.lang.String arg0_53idTemp = null;
        if(!arg0_53id.equals("")){
         arg0_53idTemp  = arg0_53id;
        }
        String arg1_54id=  request.getParameter("arg1353");
            java.lang.String arg1_54idTemp = null;
        if(!arg1_54id.equals("")){
         arg1_54idTemp  = arg1_54id;
        }
        String arg2_55id=  request.getParameter("arg2355");
            java.util.Calendar arg2_55idTemp = null;
        if(!arg2_55id.equals("")){
        java.text.DateFormat dateFormatarg2355 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2355  = dateFormatarg2355.parse(arg2_55id);
         arg2_55idTemp = new java.util.GregorianCalendar();
        arg2_55idTemp.setTime(dateTemparg2355);
        }
        String arg3_56id=  request.getParameter("arg3357");
            java.util.Calendar arg3_56idTemp = null;
        if(!arg3_56id.equals("")){
        java.text.DateFormat dateFormatarg3357 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3357  = dateFormatarg3357.parse(arg3_56id);
         arg3_56idTemp = new java.util.GregorianCalendar();
        arg3_56idTemp.setTime(dateTemparg3357);
        }
        String arg4_57id=  request.getParameter("arg4359");
            java.lang.String arg4_57idTemp = null;
        if(!arg4_57id.equals("")){
         arg4_57idTemp  = arg4_57id;
        }
        String arg5_58id=  request.getParameter("arg5361");
        int arg5_58idTemp  = Integer.parseInt(arg5_58id);
        String arg6_59id=  request.getParameter("arg6363");
            java.util.Calendar arg6_59idTemp = null;
        if(!arg6_59id.equals("")){
        java.text.DateFormat dateFormatarg6363 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6363  = dateFormatarg6363.parse(arg6_59id);
         arg6_59idTemp = new java.util.GregorianCalendar();
        arg6_59idTemp.setTime(dateTemparg6363);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_53idTemp,arg1_54idTemp,arg2_55idTemp,arg3_56idTemp,arg4_57idTemp,arg5_58idTemp,arg6_59idTemp);
break;
case 365:
        gotMethod = true;
        String arg0_60id=  request.getParameter("arg0368");
            java.lang.String arg0_60idTemp = null;
        if(!arg0_60id.equals("")){
         arg0_60idTemp  = arg0_60id;
        }
        String arg1_61id=  request.getParameter("arg1370");
            java.lang.String arg1_61idTemp = null;
        if(!arg1_61id.equals("")){
         arg1_61idTemp  = arg1_61id;
        }
        String arg2_62id=  request.getParameter("arg2372");
            java.lang.String arg2_62idTemp = null;
        if(!arg2_62id.equals("")){
         arg2_62idTemp  = arg2_62id;
        }
        String arg3_63id=  request.getParameter("arg3374");
            java.lang.String arg3_63idTemp = null;
        if(!arg3_63id.equals("")){
         arg3_63idTemp  = arg3_63id;
        }
        String arg4_64id=  request.getParameter("arg4376");
            java.util.Calendar arg4_64idTemp = null;
        if(!arg4_64id.equals("")){
        java.text.DateFormat dateFormatarg4376 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4376  = dateFormatarg4376.parse(arg4_64id);
         arg4_64idTemp = new java.util.GregorianCalendar();
        arg4_64idTemp.setTime(dateTemparg4376);
        }
        String arg5_65id=  request.getParameter("arg5378");
            java.lang.String arg5_65idTemp = null;
        if(!arg5_65id.equals("")){
         arg5_65idTemp  = arg5_65id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_60idTemp,arg1_61idTemp,arg2_62idTemp,arg3_63idTemp,arg4_64idTemp,arg5_65idTemp);
break;
case 380:
        gotMethod = true;
        String arg0_66id=  request.getParameter("arg0383");
            java.lang.String arg0_66idTemp = null;
        if(!arg0_66id.equals("")){
         arg0_66idTemp  = arg0_66id;
        }
        String arg1_67id=  request.getParameter("arg1385");
            java.lang.String arg1_67idTemp = null;
        if(!arg1_67id.equals("")){
         arg1_67idTemp  = arg1_67id;
        }
        String arg2_68id=  request.getParameter("arg2387");
            java.lang.String arg2_68idTemp = null;
        if(!arg2_68id.equals("")){
         arg2_68idTemp  = arg2_68id;
        }
        String arg3_69id=  request.getParameter("arg3389");
            java.lang.String arg3_69idTemp = null;
        if(!arg3_69id.equals("")){
         arg3_69idTemp  = arg3_69id;
        }
        String arg4_70id=  request.getParameter("arg4391");
            java.util.Calendar arg4_70idTemp = null;
        if(!arg4_70id.equals("")){
        java.text.DateFormat dateFormatarg4391 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4391  = dateFormatarg4391.parse(arg4_70id);
         arg4_70idTemp = new java.util.GregorianCalendar();
        arg4_70idTemp.setTime(dateTemparg4391);
        }
        String arg5_71id=  request.getParameter("arg5393");
            java.lang.String arg5_71idTemp = null;
        if(!arg5_71id.equals("")){
         arg5_71idTemp  = arg5_71id;
        }
        String arg6_72id=  request.getParameter("arg6395");
            java.lang.String arg6_72idTemp = null;
        if(!arg6_72id.equals("")){
         arg6_72idTemp  = arg6_72id;
        }
        String arg7_73id=  request.getParameter("arg7397");
        boolean arg7_73idTemp  = Boolean.valueOf(arg7_73id).booleanValue();
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_66idTemp,arg1_67idTemp,arg2_68idTemp,arg3_69idTemp,arg4_70idTemp,arg5_71idTemp,arg6_72idTemp,arg7_73idTemp);
break;
case 399:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetes399mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes399mtemp == null){
%>
<%=listarPaquetes399mtemp %>
<%
}else{
        if(listarPaquetes399mtemp!= null){
        String tempreturnp400 = listarPaquetes399mtemp.toString();
        %>
        <%=tempreturnp400%>
        <%
        }}
break;
case 402:
        gotMethod = true;
        String arg0_74id=  request.getParameter("arg0415");
            java.lang.String arg0_74idTemp = null;
        if(!arg0_74id.equals("")){
         arg0_74idTemp  = arg0_74id;
        }
        servidor.DataPaquete obtenerDataPaquete402mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_74idTemp);
if(obtenerDataPaquete402mtemp == null){
%>
<%=obtenerDataPaquete402mtemp %>
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
if(obtenerDataPaquete402mtemp != null){
%>
<%=obtenerDataPaquete402mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete402mtemp != null){
java.lang.String typedescripcion407 = obtenerDataPaquete402mtemp.getDescripcion();
        String tempResultdescripcion407 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion407));
        %>
        <%= tempResultdescripcion407 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete402mtemp != null){
java.util.Calendar typefechaAlta409 = obtenerDataPaquete402mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta409 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta409 = typefechaAlta409.getTime();
        String tempResultfechaAlta409 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta409.format(datefechaAlta409));
        %>
        <%= tempResultfechaAlta409 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete402mtemp != null){
%>
<%=obtenerDataPaquete402mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete402mtemp != null){
java.lang.String typenombre413 = obtenerDataPaquete402mtemp.getNombre();
        String tempResultnombre413 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre413));
        %>
        <%= tempResultnombre413 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 417:
        gotMethod = true;
        String arg0_75id=  request.getParameter("arg0420");
            java.lang.String arg0_75idTemp = null;
        if(!arg0_75id.equals("")){
         arg0_75idTemp  = arg0_75id;
        }
        String arg1_76id=  request.getParameter("arg1422");
            java.lang.String arg1_76idTemp = null;
        if(!arg1_76id.equals("")){
         arg1_76idTemp  = arg1_76id;
        }
        String arg2_77id=  request.getParameter("arg2424");
            java.lang.String arg2_77idTemp = null;
        if(!arg2_77id.equals("")){
         arg2_77idTemp  = arg2_77id;
        }
        String arg3_78id=  request.getParameter("arg3426");
            java.lang.String arg3_78idTemp = null;
        if(!arg3_78id.equals("")){
         arg3_78idTemp  = arg3_78id;
        }
        String arg4_79id=  request.getParameter("arg4428");
            java.util.Calendar arg4_79idTemp = null;
        if(!arg4_79id.equals("")){
        java.text.DateFormat dateFormatarg4428 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4428  = dateFormatarg4428.parse(arg4_79id);
         arg4_79idTemp = new java.util.GregorianCalendar();
        arg4_79idTemp.setTime(dateTemparg4428);
        }
        String arg5_80id=  request.getParameter("arg5430");
            java.lang.String arg5_80idTemp = null;
        if(!arg5_80id.equals("")){
         arg5_80idTemp  = arg5_80id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_75idTemp,arg1_76idTemp,arg2_77idTemp,arg3_78idTemp,arg4_79idTemp,arg5_80idTemp);
break;
case 432:
        gotMethod = true;
        String arg0_81id=  request.getParameter("arg0435");
            java.lang.String arg0_81idTemp = null;
        if(!arg0_81id.equals("")){
         arg0_81idTemp  = arg0_81id;
        }
        String arg1_82id=  request.getParameter("arg1437");
            java.lang.String arg1_82idTemp = null;
        if(!arg1_82id.equals("")){
         arg1_82idTemp  = arg1_82id;
        }
        String arg2_83id=  request.getParameter("arg2439");
            java.lang.String arg2_83idTemp = null;
        if(!arg2_83id.equals("")){
         arg2_83idTemp  = arg2_83id;
        }
        String arg3_84id=  request.getParameter("arg3441");
            java.lang.String arg3_84idTemp = null;
        if(!arg3_84id.equals("")){
         arg3_84idTemp  = arg3_84id;
        }
        String arg4_85id=  request.getParameter("arg4443");
            java.util.Calendar arg4_85idTemp = null;
        if(!arg4_85id.equals("")){
        java.text.DateFormat dateFormatarg4443 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4443  = dateFormatarg4443.parse(arg4_85id);
         arg4_85idTemp = new java.util.GregorianCalendar();
        arg4_85idTemp.setTime(dateTemparg4443);
        }
        String arg5_86id=  request.getParameter("arg5445");
            java.lang.String arg5_86idTemp = null;
        if(!arg5_86id.equals("")){
         arg5_86idTemp  = arg5_86id;
        }
        String arg6_87id=  request.getParameter("arg6447");
            java.lang.String arg6_87idTemp = null;
        if(!arg6_87id.equals("")){
         arg6_87idTemp  = arg6_87id;
        }
        String arg7_88id=  request.getParameter("arg7449");
        boolean arg7_88idTemp  = Boolean.valueOf(arg7_88id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_81idTemp,arg1_82idTemp,arg2_83idTemp,arg3_84idTemp,arg4_85idTemp,arg5_86idTemp,arg6_87idTemp,arg7_88idTemp);
break;
case 451:
        gotMethod = true;
        servidor.DataColeccionObject listarActividadesAgregadas451mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas451mtemp == null){
%>
<%=listarActividadesAgregadas451mtemp %>
<%
}else{
        if(listarActividadesAgregadas451mtemp!= null){
        String tempreturnp452 = listarActividadesAgregadas451mtemp.toString();
        %>
        <%=tempreturnp452%>
        <%
        }}
break;
case 454:
        gotMethod = true;
        String arg0_89id=  request.getParameter("arg0457");
            java.lang.String arg0_89idTemp = null;
        if(!arg0_89id.equals("")){
         arg0_89idTemp  = arg0_89id;
        }
        String arg1_90id=  request.getParameter("arg1459");
            java.lang.String arg1_90idTemp = null;
        if(!arg1_90id.equals("")){
         arg1_90idTemp  = arg1_90id;
        }
        servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete454mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_89idTemp,arg1_90idTemp);
if(actividadesPorDepartamentoNoEnPaquete454mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete454mtemp %>
<%
}else{
        if(actividadesPorDepartamentoNoEnPaquete454mtemp!= null){
        String tempreturnp455 = actividadesPorDepartamentoNoEnPaquete454mtemp.toString();
        %>
        <%=tempreturnp455%>
        <%
        }}
break;
case 461:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetesNoComprados461mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados461mtemp == null){
%>
<%=listarPaquetesNoComprados461mtemp %>
<%
}else{
        if(listarPaquetesNoComprados461mtemp!= null){
        String tempreturnp462 = listarPaquetesNoComprados461mtemp.toString();
        %>
        <%=tempreturnp462%>
        <%
        }}
break;
case 464:
        gotMethod = true;
        samplePublicadorIControladorProxyid.excepciones();
break;
case 467:
        gotMethod = true;
        servidor.DataColeccionObject obtenerDataDepartamentos467mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos467mtemp == null){
%>
<%=obtenerDataDepartamentos467mtemp %>
<%
}else{
        if(obtenerDataDepartamentos467mtemp!= null){
        String tempreturnp468 = obtenerDataDepartamentos467mtemp.toString();
        %>
        <%=tempreturnp468%>
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