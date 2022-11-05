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
        String arg0_1id=  request.getParameter("arg029");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg131");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        String arg2_3id=  request.getParameter("arg233");
            java.lang.String arg2_3idTemp = null;
        if(!arg2_3id.equals("")){
         arg2_3idTemp  = arg2_3id;
        }
        String arg3_4id=  request.getParameter("arg335");
            java.lang.String arg3_4idTemp = null;
        if(!arg3_4id.equals("")){
         arg3_4idTemp  = arg3_4id;
        }
        String arg4_5id=  request.getParameter("arg437");
            java.util.Calendar arg4_5idTemp = null;
        if(!arg4_5id.equals("")){
        java.text.DateFormat dateFormatarg437 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg437  = dateFormatarg437.parse(arg4_5id);
         arg4_5idTemp = new java.util.GregorianCalendar();
        arg4_5idTemp.setTime(dateTemparg437);
        }
        String arg5_6id=  request.getParameter("arg539");
            java.lang.String arg5_6idTemp = null;
        if(!arg5_6id.equals("")){
         arg5_6idTemp  = arg5_6id;
        }
        String arg6_7id=  request.getParameter("arg641");
            java.lang.String arg6_7idTemp = null;
        if(!arg6_7id.equals("")){
         arg6_7idTemp  = arg6_7id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTuristaPass(arg0_1idTemp,arg1_2idTemp,arg2_3idTemp,arg3_4idTemp,arg4_5idTemp,arg5_6idTemp,arg6_7idTemp);
break;
case 43:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg046");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        String arg1_9id=  request.getParameter("arg148");
            java.lang.String arg1_9idTemp = null;
        if(!arg1_9id.equals("")){
         arg1_9idTemp  = arg1_9id;
        }
        String arg2_10id=  request.getParameter("arg250");
            java.lang.String arg2_10idTemp = null;
        if(!arg2_10id.equals("")){
         arg2_10idTemp  = arg2_10id;
        }
        String arg3_11id=  request.getParameter("arg352");
            java.lang.String arg3_11idTemp = null;
        if(!arg3_11id.equals("")){
         arg3_11idTemp  = arg3_11id;
        }
        String arg4_12id=  request.getParameter("arg454");
            java.util.Calendar arg4_12idTemp = null;
        if(!arg4_12id.equals("")){
        java.text.DateFormat dateFormatarg454 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg454  = dateFormatarg454.parse(arg4_12id);
         arg4_12idTemp = new java.util.GregorianCalendar();
        arg4_12idTemp.setTime(dateTemparg454);
        }
        String arg5_13id=  request.getParameter("arg556");
            java.lang.String arg5_13idTemp = null;
        if(!arg5_13id.equals("")){
         arg5_13idTemp  = arg5_13id;
        }
        String arg6_14id=  request.getParameter("arg658");
            java.lang.String arg6_14idTemp = null;
        if(!arg6_14id.equals("")){
         arg6_14idTemp  = arg6_14id;
        }
        String arg7_15id=  request.getParameter("arg760");
        boolean arg7_15idTemp  = Boolean.valueOf(arg7_15id).booleanValue();
        String arg8_16id=  request.getParameter("arg862");
            java.lang.String arg8_16idTemp = null;
        if(!arg8_16id.equals("")){
         arg8_16idTemp  = arg8_16id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaProveedorPass(arg0_8idTemp,arg1_9idTemp,arg2_10idTemp,arg3_11idTemp,arg4_12idTemp,arg5_13idTemp,arg6_14idTemp,arg7_15idTemp,arg8_16idTemp);
break;
case 64:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg079");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        servidor.DataUsuario verInfoUsuario64mtemp = samplePublicadorIControladorProxyid.verInfoUsuario(arg0_17idTemp);
if(verInfoUsuario64mtemp == null){
%>
<%=verInfoUsuario64mtemp %>
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
if(verInfoUsuario64mtemp != null){
java.util.Calendar typenacimiento67 = verInfoUsuario64mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento67 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento67 = typenacimiento67.getTime();
        String tempResultnacimiento67 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento67.format(datenacimiento67));
        %>
        <%= tempResultnacimiento67 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario64mtemp != null){
java.lang.String typenick69 = verInfoUsuario64mtemp.getNick();
        String tempResultnick69 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick69));
        %>
        <%= tempResultnick69 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(verInfoUsuario64mtemp != null){
java.lang.String typemail71 = verInfoUsuario64mtemp.getMail();
        String tempResultmail71 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail71));
        %>
        <%= tempResultmail71 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario64mtemp != null){
java.lang.String typepassword73 = verInfoUsuario64mtemp.getPassword();
        String tempResultpassword73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword73));
        %>
        <%= tempResultpassword73 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario64mtemp != null){
java.lang.String typenombre75 = verInfoUsuario64mtemp.getNombre();
        String tempResultnombre75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre75));
        %>
        <%= tempResultnombre75 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario64mtemp != null){
java.lang.String typeapellido77 = verInfoUsuario64mtemp.getApellido();
        String tempResultapellido77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido77));
        %>
        <%= tempResultapellido77 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 81:
        gotMethod = true;
        servidor.DataColeccionObject getUsuariosComp81mtemp = samplePublicadorIControladorProxyid.getUsuariosComp();
if(getUsuariosComp81mtemp == null){
%>
<%=getUsuariosComp81mtemp %>
<%
}else{
        if(getUsuariosComp81mtemp!= null){
        String tempreturnp82 = getUsuariosComp81mtemp.toString();
        %>
        <%=tempreturnp82%>
        <%
        }}
break;
case 84:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg099");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        servidor.DataUsuario ingresarDatos84mtemp = samplePublicadorIControladorProxyid.ingresarDatos(arg0_18idTemp);
if(ingresarDatos84mtemp == null){
%>
<%=ingresarDatos84mtemp %>
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
if(ingresarDatos84mtemp != null){
java.util.Calendar typenacimiento87 = ingresarDatos84mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento87 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento87 = typenacimiento87.getTime();
        String tempResultnacimiento87 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento87.format(datenacimiento87));
        %>
        <%= tempResultnacimiento87 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(ingresarDatos84mtemp != null){
java.lang.String typenick89 = ingresarDatos84mtemp.getNick();
        String tempResultnick89 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick89));
        %>
        <%= tempResultnick89 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(ingresarDatos84mtemp != null){
java.lang.String typemail91 = ingresarDatos84mtemp.getMail();
        String tempResultmail91 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail91));
        %>
        <%= tempResultmail91 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(ingresarDatos84mtemp != null){
java.lang.String typepassword93 = ingresarDatos84mtemp.getPassword();
        String tempResultpassword93 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword93));
        %>
        <%= tempResultpassword93 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(ingresarDatos84mtemp != null){
java.lang.String typenombre95 = ingresarDatos84mtemp.getNombre();
        String tempResultnombre95 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre95));
        %>
        <%= tempResultnombre95 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(ingresarDatos84mtemp != null){
java.lang.String typeapellido97 = ingresarDatos84mtemp.getApellido();
        String tempResultapellido97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido97));
        %>
        <%= tempResultapellido97 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 101:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0104");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        servidor.DataColeccionObject obtenerActividadCategoria101mtemp = samplePublicadorIControladorProxyid.obtenerActividadCategoria(arg0_19idTemp);
if(obtenerActividadCategoria101mtemp == null){
%>
<%=obtenerActividadCategoria101mtemp %>
<%
}else{
        if(obtenerActividadCategoria101mtemp!= null){
        String tempreturnp102 = obtenerActividadCategoria101mtemp.toString();
        %>
        <%=tempreturnp102%>
        <%
        }}
break;
case 106:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0121");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        servidor.DataUsuario obtenerDataUsuarioNick106mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioNick(arg0_20idTemp);
if(obtenerDataUsuarioNick106mtemp == null){
%>
<%=obtenerDataUsuarioNick106mtemp %>
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
if(obtenerDataUsuarioNick106mtemp != null){
java.util.Calendar typenacimiento109 = obtenerDataUsuarioNick106mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento109 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento109 = typenacimiento109.getTime();
        String tempResultnacimiento109 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento109.format(datenacimiento109));
        %>
        <%= tempResultnacimiento109 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioNick106mtemp != null){
java.lang.String typenick111 = obtenerDataUsuarioNick106mtemp.getNick();
        String tempResultnick111 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick111));
        %>
        <%= tempResultnick111 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioNick106mtemp != null){
java.lang.String typemail113 = obtenerDataUsuarioNick106mtemp.getMail();
        String tempResultmail113 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail113));
        %>
        <%= tempResultmail113 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioNick106mtemp != null){
java.lang.String typepassword115 = obtenerDataUsuarioNick106mtemp.getPassword();
        String tempResultpassword115 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword115));
        %>
        <%= tempResultpassword115 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioNick106mtemp != null){
java.lang.String typenombre117 = obtenerDataUsuarioNick106mtemp.getNombre();
        String tempResultnombre117 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre117));
        %>
        <%= tempResultnombre117 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioNick106mtemp != null){
java.lang.String typeapellido119 = obtenerDataUsuarioNick106mtemp.getApellido();
        String tempResultapellido119 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido119));
        %>
        <%= tempResultapellido119 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 123:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0138");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        servidor.DataUsuario obtenerDataUsuarioMail123mtemp = samplePublicadorIControladorProxyid.obtenerDataUsuarioMail(arg0_21idTemp);
if(obtenerDataUsuarioMail123mtemp == null){
%>
<%=obtenerDataUsuarioMail123mtemp %>
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
if(obtenerDataUsuarioMail123mtemp != null){
java.util.Calendar typenacimiento126 = obtenerDataUsuarioMail123mtemp.getNacimiento();
        java.text.DateFormat dateFormatnacimiento126 = java.text.DateFormat.getDateInstance();
        java.util.Date datenacimiento126 = typenacimiento126.getTime();
        String tempResultnacimiento126 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatnacimiento126.format(datenacimiento126));
        %>
        <%= tempResultnacimiento126 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(obtenerDataUsuarioMail123mtemp != null){
java.lang.String typenick128 = obtenerDataUsuarioMail123mtemp.getNick();
        String tempResultnick128 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick128));
        %>
        <%= tempResultnick128 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mail:</TD>
<TD>
<%
if(obtenerDataUsuarioMail123mtemp != null){
java.lang.String typemail130 = obtenerDataUsuarioMail123mtemp.getMail();
        String tempResultmail130 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemail130));
        %>
        <%= tempResultmail130 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(obtenerDataUsuarioMail123mtemp != null){
java.lang.String typepassword132 = obtenerDataUsuarioMail123mtemp.getPassword();
        String tempResultpassword132 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword132));
        %>
        <%= tempResultpassword132 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataUsuarioMail123mtemp != null){
java.lang.String typenombre134 = obtenerDataUsuarioMail123mtemp.getNombre();
        String tempResultnombre134 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre134));
        %>
        <%= tempResultnombre134 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerDataUsuarioMail123mtemp != null){
java.lang.String typeapellido136 = obtenerDataUsuarioMail123mtemp.getApellido();
        String tempResultapellido136 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido136));
        %>
        <%= tempResultapellido136 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 140:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0157");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        servidor.DataActividad obtenerDataActividad140mtemp = samplePublicadorIControladorProxyid.obtenerDataActividad(arg0_22idTemp);
if(obtenerDataActividad140mtemp == null){
%>
<%=obtenerDataActividad140mtemp %>
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
if(obtenerDataActividad140mtemp != null){
java.util.Calendar typefechaAlta143 = obtenerDataActividad140mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta143 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta143 = typefechaAlta143.getTime();
        String tempResultfechaAlta143 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta143.format(datefechaAlta143));
        %>
        <%= tempResultfechaAlta143 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">departamento:</TD>
<TD>
<%
if(obtenerDataActividad140mtemp != null){
java.lang.String typedepartamento145 = obtenerDataActividad140mtemp.getDepartamento();
        String tempResultdepartamento145 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedepartamento145));
        %>
        <%= tempResultdepartamento145 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(obtenerDataActividad140mtemp != null){
%>
<%=obtenerDataActividad140mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataActividad140mtemp != null){
java.lang.String typedescripcion149 = obtenerDataActividad140mtemp.getDescripcion();
        String tempResultdescripcion149 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion149));
        %>
        <%= tempResultdescripcion149 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">ciudad:</TD>
<TD>
<%
if(obtenerDataActividad140mtemp != null){
java.lang.String typeciudad151 = obtenerDataActividad140mtemp.getCiudad();
        String tempResultciudad151 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeciudad151));
        %>
        <%= tempResultciudad151 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(obtenerDataActividad140mtemp != null){
%>
<%=obtenerDataActividad140mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataActividad140mtemp != null){
java.lang.String typenombre155 = obtenerDataActividad140mtemp.getNombre();
        String tempResultnombre155 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre155));
        %>
        <%= tempResultnombre155 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 159:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0174");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        servidor.DataSalida obtenerDataSalida159mtemp = samplePublicadorIControladorProxyid.obtenerDataSalida(arg0_23idTemp);
if(obtenerDataSalida159mtemp == null){
%>
<%=obtenerDataSalida159mtemp %>
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
if(obtenerDataSalida159mtemp != null){
java.util.Calendar typehora162 = obtenerDataSalida159mtemp.getHora();
        java.text.DateFormat dateFormathora162 = java.text.DateFormat.getDateInstance();
        java.util.Date datehora162 = typehora162.getTime();
        String tempResulthora162 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathora162.format(datehora162));
        %>
        <%= tempResulthora162 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(obtenerDataSalida159mtemp != null){
java.util.Calendar typefecha164 = obtenerDataSalida159mtemp.getFecha();
        java.text.DateFormat dateFormatfecha164 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha164 = typefecha164.getTime();
        String tempResultfecha164 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha164.format(datefecha164));
        %>
        <%= tempResultfecha164 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cant:</TD>
<TD>
<%
if(obtenerDataSalida159mtemp != null){
%>
<%=obtenerDataSalida159mtemp.getCant()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataSalida159mtemp != null){
java.util.Calendar typefechaAlta168 = obtenerDataSalida159mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta168 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta168 = typefechaAlta168.getTime();
        String tempResultfechaAlta168 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta168.format(datefechaAlta168));
        %>
        <%= tempResultfechaAlta168 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lugar:</TD>
<TD>
<%
if(obtenerDataSalida159mtemp != null){
java.lang.String typelugar170 = obtenerDataSalida159mtemp.getLugar();
        String tempResultlugar170 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelugar170));
        %>
        <%= tempResultlugar170 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataSalida159mtemp != null){
java.lang.String typenombre172 = obtenerDataSalida159mtemp.getNombre();
        String tempResultnombre172 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre172));
        %>
        <%= tempResultnombre172 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 176:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0179");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1181");
            java.util.Calendar arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
        java.text.DateFormat dateFormatarg1181 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1181  = dateFormatarg1181.parse(arg1_25id);
         arg1_25idTemp = new java.util.GregorianCalendar();
        arg1_25idTemp.setTime(dateTemparg1181);
        }
        String arg2_26id=  request.getParameter("arg2183");
        int arg2_26idTemp  = Integer.parseInt(arg2_26id);
        String arg3_27id=  request.getParameter("arg3185");
            java.lang.String arg3_27idTemp = null;
        if(!arg3_27id.equals("")){
         arg3_27idTemp  = arg3_27id;
        }
        samplePublicadorIControladorProxyid.comprarPaquete(arg0_24idTemp,arg1_25idTemp,arg2_26idTemp,arg3_27idTemp);
break;
case 187:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0190");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        String arg1_29id=  request.getParameter("arg1192");
            java.lang.String arg1_29idTemp = null;
        if(!arg1_29id.equals("")){
         arg1_29idTemp  = arg1_29id;
        }
        String arg2_30id=  request.getParameter("arg2194");
        int arg2_30idTemp  = Integer.parseInt(arg2_30id);
        String arg3_31id=  request.getParameter("arg3196");
            java.util.Calendar arg3_31idTemp = null;
        if(!arg3_31id.equals("")){
        java.text.DateFormat dateFormatarg3196 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3196  = dateFormatarg3196.parse(arg3_31id);
         arg3_31idTemp = new java.util.GregorianCalendar();
        arg3_31idTemp.setTime(dateTemparg3196);
        }
        String arg4_32id=  request.getParameter("arg4198");
            java.lang.String arg4_32idTemp = null;
        if(!arg4_32id.equals("")){
         arg4_32idTemp  = arg4_32id;
        }
        String arg5_33id=  request.getParameter("arg5200");
            java.lang.String arg5_33idTemp = null;
        if(!arg5_33id.equals("")){
         arg5_33idTemp  = arg5_33id;
        }
        samplePublicadorIControladorProxyid.inscribirPaq(arg0_28idTemp,arg1_29idTemp,arg2_30idTemp,arg3_31idTemp,arg4_32idTemp,arg5_33idTemp);
break;
case 202:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0205");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        servidor.DataColeccionObject obtenerPaquetesComprados202mtemp = samplePublicadorIControladorProxyid.obtenerPaquetesComprados(arg0_34idTemp);
if(obtenerPaquetesComprados202mtemp == null){
%>
<%=obtenerPaquetesComprados202mtemp %>
<%
}else{
        if(obtenerPaquetesComprados202mtemp!= null){
        String tempreturnp203 = obtenerPaquetesComprados202mtemp.toString();
        %>
        <%=tempreturnp203%>
        <%
        }}
break;
case 207:
        gotMethod = true;
        String arg0_35id=  request.getParameter("arg0210");
            java.lang.String arg0_35idTemp = null;
        if(!arg0_35id.equals("")){
         arg0_35idTemp  = arg0_35id;
        }
        java.lang.String obtenerNomActPorSalida207mtemp = samplePublicadorIControladorProxyid.obtenerNomActPorSalida(arg0_35idTemp);
if(obtenerNomActPorSalida207mtemp == null){
%>
<%=obtenerNomActPorSalida207mtemp %>
<%
}else{
        String tempResultreturnp208 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerNomActPorSalida207mtemp));
        %>
        <%= tempResultreturnp208 %>
        <%
}
break;
case 212:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0215");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        servidor.DataColeccionObject selecDepartamento212mtemp = samplePublicadorIControladorProxyid.selecDepartamento(arg0_36idTemp);
if(selecDepartamento212mtemp == null){
%>
<%=selecDepartamento212mtemp %>
<%
}else{
        if(selecDepartamento212mtemp!= null){
        String tempreturnp213 = selecDepartamento212mtemp.toString();
        %>
        <%=tempreturnp213%>
        <%
        }}
break;
case 217:
        gotMethod = true;
        String arg0_37id=  request.getParameter("arg0220");
            java.lang.String arg0_37idTemp = null;
        if(!arg0_37id.equals("")){
         arg0_37idTemp  = arg0_37id;
        }
        servidor.DataColeccionObject salidas217mtemp = samplePublicadorIControladorProxyid.salidas(arg0_37idTemp);
if(salidas217mtemp == null){
%>
<%=salidas217mtemp %>
<%
}else{
        if(salidas217mtemp!= null){
        String tempreturnp218 = salidas217mtemp.toString();
        %>
        <%=tempreturnp218%>
        <%
        }}
break;
case 222:
        gotMethod = true;
        String arg0_38id=  request.getParameter("arg0225");
            java.lang.String arg0_38idTemp = null;
        if(!arg0_38id.equals("")){
         arg0_38idTemp  = arg0_38id;
        }
        String arg1_39id=  request.getParameter("arg1227");
            java.lang.String arg1_39idTemp = null;
        if(!arg1_39id.equals("")){
         arg1_39idTemp  = arg1_39id;
        }
        String arg2_40id=  request.getParameter("arg2229");
        int arg2_40idTemp  = Integer.parseInt(arg2_40id);
        String arg3_41id=  request.getParameter("arg3231");
            java.util.Calendar arg3_41idTemp = null;
        if(!arg3_41id.equals("")){
        java.text.DateFormat dateFormatarg3231 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3231  = dateFormatarg3231.parse(arg3_41id);
         arg3_41idTemp = new java.util.GregorianCalendar();
        arg3_41idTemp.setTime(dateTemparg3231);
        }
        String arg4_42id=  request.getParameter("arg4233");
            java.lang.String arg4_42idTemp = null;
        if(!arg4_42id.equals("")){
         arg4_42idTemp  = arg4_42id;
        }
        samplePublicadorIControladorProxyid.inscribir(arg0_38idTemp,arg1_39idTemp,arg2_40idTemp,arg3_41idTemp,arg4_42idTemp);
break;
case 235:
        gotMethod = true;
        servidor.DataColeccionObject listarUsuarios235mtemp = samplePublicadorIControladorProxyid.listarUsuarios();
if(listarUsuarios235mtemp == null){
%>
<%=listarUsuarios235mtemp %>
<%
}else{
        if(listarUsuarios235mtemp!= null){
        String tempreturnp236 = listarUsuarios235mtemp.toString();
        %>
        <%=tempreturnp236%>
        <%
        }}
break;
case 238:
        gotMethod = true;
        String arg0_43id=  request.getParameter("arg0241");
            java.lang.String arg0_43idTemp = null;
        if(!arg0_43id.equals("")){
         arg0_43idTemp  = arg0_43id;
        }
        String arg1_44id=  request.getParameter("arg1243");
            java.lang.String arg1_44idTemp = null;
        if(!arg1_44id.equals("")){
         arg1_44idTemp  = arg1_44id;
        }
        String arg2_45id=  request.getParameter("arg2245");
            java.lang.String arg2_45idTemp = null;
        if(!arg2_45id.equals("")){
         arg2_45idTemp  = arg2_45id;
        }
        String arg3_46id=  request.getParameter("arg3247");
        int arg3_46idTemp  = Integer.parseInt(arg3_46id);
        String arg4_47id=  request.getParameter("arg4249");
        int arg4_47idTemp  = Integer.parseInt(arg4_47id);
        String arg5_48id=  request.getParameter("arg5251");
            java.lang.String arg5_48idTemp = null;
        if(!arg5_48id.equals("")){
         arg5_48idTemp  = arg5_48id;
        }
        String arg6_49id=  request.getParameter("arg6253");
            java.util.Calendar arg6_49idTemp = null;
        if(!arg6_49id.equals("")){
        java.text.DateFormat dateFormatarg6253 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6253  = dateFormatarg6253.parse(arg6_49id);
         arg6_49idTemp = new java.util.GregorianCalendar();
        arg6_49idTemp.setTime(dateTemparg6253);
        }
        String arg7_50id=  request.getParameter("arg7255");
            java.lang.String arg7_50idTemp = null;
        if(!arg7_50id.equals("")){
         arg7_50idTemp  = arg7_50id;
        }
        %>
        <jsp:useBean id="servidor1DataColeccionObject_51id" scope="session" class="servidor.DataColeccionObject" />
        <%
        samplePublicadorIControladorProxyid.registrarActividad(arg0_43idTemp,arg1_44idTemp,arg2_45idTemp,arg3_46idTemp,arg4_47idTemp,arg5_48idTemp,arg6_49idTemp,arg7_50idTemp,servidor1DataColeccionObject_51id);
break;
case 259:
        gotMethod = true;
        servidor.DataColeccionObject getUsuarios259mtemp = samplePublicadorIControladorProxyid.getUsuarios();
if(getUsuarios259mtemp == null){
%>
<%=getUsuarios259mtemp %>
<%
}else{
        if(getUsuarios259mtemp!= null){
        String tempreturnp260 = getUsuarios259mtemp.toString();
        %>
        <%=tempreturnp260%>
        <%
        }}
break;
case 262:
        gotMethod = true;
        servidor.DataColeccionObject obtenerNombreCategorias262mtemp = samplePublicadorIControladorProxyid.obtenerNombreCategorias();
if(obtenerNombreCategorias262mtemp == null){
%>
<%=obtenerNombreCategorias262mtemp %>
<%
}else{
        if(obtenerNombreCategorias262mtemp!= null){
        String tempreturnp263 = obtenerNombreCategorias262mtemp.toString();
        %>
        <%=tempreturnp263%>
        <%
        }}
break;
case 265:
        gotMethod = true;
        String arg0_52id=  request.getParameter("arg0268");
            java.lang.String arg0_52idTemp = null;
        if(!arg0_52id.equals("")){
         arg0_52idTemp  = arg0_52id;
        }
        String arg1_53id=  request.getParameter("arg1270");
            java.lang.String arg1_53idTemp = null;
        if(!arg1_53id.equals("")){
         arg1_53idTemp  = arg1_53id;
        }
        String arg2_54id=  request.getParameter("arg2272");
            java.util.Calendar arg2_54idTemp = null;
        if(!arg2_54id.equals("")){
        java.text.DateFormat dateFormatarg2272 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2272  = dateFormatarg2272.parse(arg2_54id);
         arg2_54idTemp = new java.util.GregorianCalendar();
        arg2_54idTemp.setTime(dateTemparg2272);
        }
        String arg3_55id=  request.getParameter("arg3274");
            java.util.Calendar arg3_55idTemp = null;
        if(!arg3_55id.equals("")){
        java.text.DateFormat dateFormatarg3274 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3274  = dateFormatarg3274.parse(arg3_55id);
         arg3_55idTemp = new java.util.GregorianCalendar();
        arg3_55idTemp.setTime(dateTemparg3274);
        }
        String arg4_56id=  request.getParameter("arg4276");
            java.lang.String arg4_56idTemp = null;
        if(!arg4_56id.equals("")){
         arg4_56idTemp  = arg4_56id;
        }
        String arg5_57id=  request.getParameter("arg5278");
        int arg5_57idTemp  = Integer.parseInt(arg5_57id);
        String arg6_58id=  request.getParameter("arg6280");
            java.util.Calendar arg6_58idTemp = null;
        if(!arg6_58id.equals("")){
        java.text.DateFormat dateFormatarg6280 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg6280  = dateFormatarg6280.parse(arg6_58id);
         arg6_58idTemp = new java.util.GregorianCalendar();
        arg6_58idTemp.setTime(dateTemparg6280);
        }
        samplePublicadorIControladorProxyid.confirmarAltaSalida(arg0_52idTemp,arg1_53idTemp,arg2_54idTemp,arg3_55idTemp,arg4_56idTemp,arg5_57idTemp,arg6_58idTemp);
break;
case 282:
        gotMethod = true;
        String arg0_59id=  request.getParameter("arg0285");
            java.lang.String arg0_59idTemp = null;
        if(!arg0_59id.equals("")){
         arg0_59idTemp  = arg0_59id;
        }
        samplePublicadorIControladorProxyid.registrarCategoria(arg0_59idTemp);
break;
case 287:
        gotMethod = true;
        String arg0_60id=  request.getParameter("arg0290");
            java.lang.String arg0_60idTemp = null;
        if(!arg0_60id.equals("")){
         arg0_60idTemp  = arg0_60id;
        }
        String arg1_61id=  request.getParameter("arg1292");
            java.lang.String arg1_61idTemp = null;
        if(!arg1_61id.equals("")){
         arg1_61idTemp  = arg1_61id;
        }
        String arg2_62id=  request.getParameter("arg2294");
            java.lang.String arg2_62idTemp = null;
        if(!arg2_62id.equals("")){
         arg2_62idTemp  = arg2_62id;
        }
        String arg3_63id=  request.getParameter("arg3296");
            java.lang.String arg3_63idTemp = null;
        if(!arg3_63id.equals("")){
         arg3_63idTemp  = arg3_63id;
        }
        String arg4_64id=  request.getParameter("arg4298");
            java.util.Calendar arg4_64idTemp = null;
        if(!arg4_64id.equals("")){
        java.text.DateFormat dateFormatarg4298 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4298  = dateFormatarg4298.parse(arg4_64id);
         arg4_64idTemp = new java.util.GregorianCalendar();
        arg4_64idTemp.setTime(dateTemparg4298);
        }
        String arg5_65id=  request.getParameter("arg5300");
            java.lang.String arg5_65idTemp = null;
        if(!arg5_65id.equals("")){
         arg5_65idTemp  = arg5_65id;
        }
        samplePublicadorIControladorProxyid.confirmarAltaTurista(arg0_60idTemp,arg1_61idTemp,arg2_62idTemp,arg3_63idTemp,arg4_64idTemp,arg5_65idTemp);
break;
case 302:
        gotMethod = true;
        String arg0_66id=  request.getParameter("arg0305");
            java.lang.String arg0_66idTemp = null;
        if(!arg0_66id.equals("")){
         arg0_66idTemp  = arg0_66id;
        }
        String arg1_67id=  request.getParameter("arg1307");
            java.lang.String arg1_67idTemp = null;
        if(!arg1_67id.equals("")){
         arg1_67idTemp  = arg1_67id;
        }
        String arg2_68id=  request.getParameter("arg2309");
            java.lang.String arg2_68idTemp = null;
        if(!arg2_68id.equals("")){
         arg2_68idTemp  = arg2_68id;
        }
        String arg3_69id=  request.getParameter("arg3311");
            java.lang.String arg3_69idTemp = null;
        if(!arg3_69id.equals("")){
         arg3_69idTemp  = arg3_69id;
        }
        String arg4_70id=  request.getParameter("arg4313");
            java.util.Calendar arg4_70idTemp = null;
        if(!arg4_70id.equals("")){
        java.text.DateFormat dateFormatarg4313 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4313  = dateFormatarg4313.parse(arg4_70id);
         arg4_70idTemp = new java.util.GregorianCalendar();
        arg4_70idTemp.setTime(dateTemparg4313);
        }
        String arg5_71id=  request.getParameter("arg5315");
            java.lang.String arg5_71idTemp = null;
        if(!arg5_71id.equals("")){
         arg5_71idTemp  = arg5_71id;
        }
        String arg6_72id=  request.getParameter("arg6317");
            java.lang.String arg6_72idTemp = null;
        if(!arg6_72id.equals("")){
         arg6_72idTemp  = arg6_72id;
        }
        String arg7_73id=  request.getParameter("arg7319");
        boolean arg7_73idTemp  = Boolean.valueOf(arg7_73id).booleanValue();
        samplePublicadorIControladorProxyid.confirmarAltaProveedor(arg0_66idTemp,arg1_67idTemp,arg2_68idTemp,arg3_69idTemp,arg4_70idTemp,arg5_71idTemp,arg6_72idTemp,arg7_73idTemp);
break;
case 321:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetes321mtemp = samplePublicadorIControladorProxyid.listarPaquetes();
if(listarPaquetes321mtemp == null){
%>
<%=listarPaquetes321mtemp %>
<%
}else{
        if(listarPaquetes321mtemp!= null){
        String tempreturnp322 = listarPaquetes321mtemp.toString();
        %>
        <%=tempreturnp322%>
        <%
        }}
break;
case 324:
        gotMethod = true;
        String arg0_74id=  request.getParameter("arg0337");
            java.lang.String arg0_74idTemp = null;
        if(!arg0_74id.equals("")){
         arg0_74idTemp  = arg0_74id;
        }
        servidor.DataPaquete obtenerDataPaquete324mtemp = samplePublicadorIControladorProxyid.obtenerDataPaquete(arg0_74idTemp);
if(obtenerDataPaquete324mtemp == null){
%>
<%=obtenerDataPaquete324mtemp %>
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
if(obtenerDataPaquete324mtemp != null){
%>
<%=obtenerDataPaquete324mtemp.getDescuento()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerDataPaquete324mtemp != null){
java.lang.String typedescripcion329 = obtenerDataPaquete324mtemp.getDescripcion();
        String tempResultdescripcion329 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion329));
        %>
        <%= tempResultdescripcion329 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaAlta:</TD>
<TD>
<%
if(obtenerDataPaquete324mtemp != null){
java.util.Calendar typefechaAlta331 = obtenerDataPaquete324mtemp.getFechaAlta();
        java.text.DateFormat dateFormatfechaAlta331 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaAlta331 = typefechaAlta331.getTime();
        String tempResultfechaAlta331 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaAlta331.format(datefechaAlta331));
        %>
        <%= tempResultfechaAlta331 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">validez:</TD>
<TD>
<%
if(obtenerDataPaquete324mtemp != null){
%>
<%=obtenerDataPaquete324mtemp.getValidez()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerDataPaquete324mtemp != null){
java.lang.String typenombre335 = obtenerDataPaquete324mtemp.getNombre();
        String tempResultnombre335 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre335));
        %>
        <%= tempResultnombre335 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 339:
        gotMethod = true;
        String arg0_75id=  request.getParameter("arg0342");
            java.lang.String arg0_75idTemp = null;
        if(!arg0_75id.equals("")){
         arg0_75idTemp  = arg0_75id;
        }
        String arg1_76id=  request.getParameter("arg1344");
            java.lang.String arg1_76idTemp = null;
        if(!arg1_76id.equals("")){
         arg1_76idTemp  = arg1_76id;
        }
        String arg2_77id=  request.getParameter("arg2346");
            java.lang.String arg2_77idTemp = null;
        if(!arg2_77id.equals("")){
         arg2_77idTemp  = arg2_77id;
        }
        String arg3_78id=  request.getParameter("arg3348");
            java.lang.String arg3_78idTemp = null;
        if(!arg3_78id.equals("")){
         arg3_78idTemp  = arg3_78id;
        }
        String arg4_79id=  request.getParameter("arg4350");
            java.util.Calendar arg4_79idTemp = null;
        if(!arg4_79id.equals("")){
        java.text.DateFormat dateFormatarg4350 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4350  = dateFormatarg4350.parse(arg4_79id);
         arg4_79idTemp = new java.util.GregorianCalendar();
        arg4_79idTemp.setTime(dateTemparg4350);
        }
        String arg5_80id=  request.getParameter("arg5352");
            java.lang.String arg5_80idTemp = null;
        if(!arg5_80id.equals("")){
         arg5_80idTemp  = arg5_80id;
        }
        samplePublicadorIControladorProxyid.actualizarDatosTurista(arg0_75idTemp,arg1_76idTemp,arg2_77idTemp,arg3_78idTemp,arg4_79idTemp,arg5_80idTemp);
break;
case 354:
        gotMethod = true;
        String arg0_81id=  request.getParameter("arg0357");
            java.lang.String arg0_81idTemp = null;
        if(!arg0_81id.equals("")){
         arg0_81idTemp  = arg0_81id;
        }
        String arg1_82id=  request.getParameter("arg1359");
            java.lang.String arg1_82idTemp = null;
        if(!arg1_82id.equals("")){
         arg1_82idTemp  = arg1_82id;
        }
        String arg2_83id=  request.getParameter("arg2361");
            java.lang.String arg2_83idTemp = null;
        if(!arg2_83id.equals("")){
         arg2_83idTemp  = arg2_83id;
        }
        String arg3_84id=  request.getParameter("arg3363");
            java.lang.String arg3_84idTemp = null;
        if(!arg3_84id.equals("")){
         arg3_84idTemp  = arg3_84id;
        }
        String arg4_85id=  request.getParameter("arg4365");
            java.util.Calendar arg4_85idTemp = null;
        if(!arg4_85id.equals("")){
        java.text.DateFormat dateFormatarg4365 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4365  = dateFormatarg4365.parse(arg4_85id);
         arg4_85idTemp = new java.util.GregorianCalendar();
        arg4_85idTemp.setTime(dateTemparg4365);
        }
        String arg5_86id=  request.getParameter("arg5367");
            java.lang.String arg5_86idTemp = null;
        if(!arg5_86id.equals("")){
         arg5_86idTemp  = arg5_86id;
        }
        String arg6_87id=  request.getParameter("arg6369");
            java.lang.String arg6_87idTemp = null;
        if(!arg6_87id.equals("")){
         arg6_87idTemp  = arg6_87id;
        }
        String arg7_88id=  request.getParameter("arg7371");
        boolean arg7_88idTemp  = Boolean.valueOf(arg7_88id).booleanValue();
        samplePublicadorIControladorProxyid.actualizarDatosProveedor(arg0_81idTemp,arg1_82idTemp,arg2_83idTemp,arg3_84idTemp,arg4_85idTemp,arg5_86idTemp,arg6_87idTemp,arg7_88idTemp);
break;
case 373:
        gotMethod = true;
        String arg0_89id=  request.getParameter("arg0376");
            java.lang.String arg0_89idTemp = null;
        if(!arg0_89id.equals("")){
         arg0_89idTemp  = arg0_89id;
        }
        servidor.EstadoAct servidor1EstadoAct_90id = null;
        samplePublicadorIControladorProxyid.aceptarRechazarAct(arg0_89idTemp,servidor1EstadoAct_90id);
break;
case 380:
        gotMethod = true;
        servidor.DataColeccionObject listarActividadesAgregadas380mtemp = samplePublicadorIControladorProxyid.listarActividadesAgregadas();
if(listarActividadesAgregadas380mtemp == null){
%>
<%=listarActividadesAgregadas380mtemp %>
<%
}else{
        if(listarActividadesAgregadas380mtemp!= null){
        String tempreturnp381 = listarActividadesAgregadas380mtemp.toString();
        %>
        <%=tempreturnp381%>
        <%
        }}
break;
case 383:
        gotMethod = true;
        String arg0_91id=  request.getParameter("arg0386");
            java.lang.String arg0_91idTemp = null;
        if(!arg0_91id.equals("")){
         arg0_91idTemp  = arg0_91id;
        }
        String arg1_92id=  request.getParameter("arg1388");
            java.lang.String arg1_92idTemp = null;
        if(!arg1_92id.equals("")){
         arg1_92idTemp  = arg1_92id;
        }
        servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete383mtemp = samplePublicadorIControladorProxyid.actividadesPorDepartamentoNoEnPaquete(arg0_91idTemp,arg1_92idTemp);
if(actividadesPorDepartamentoNoEnPaquete383mtemp == null){
%>
<%=actividadesPorDepartamentoNoEnPaquete383mtemp %>
<%
}else{
        if(actividadesPorDepartamentoNoEnPaquete383mtemp!= null){
        String tempreturnp384 = actividadesPorDepartamentoNoEnPaquete383mtemp.toString();
        %>
        <%=tempreturnp384%>
        <%
        }}
break;
case 390:
        gotMethod = true;
        servidor.DataColeccionObject listarPaquetesNoComprados390mtemp = samplePublicadorIControladorProxyid.listarPaquetesNoComprados();
if(listarPaquetesNoComprados390mtemp == null){
%>
<%=listarPaquetesNoComprados390mtemp %>
<%
}else{
        if(listarPaquetesNoComprados390mtemp!= null){
        String tempreturnp391 = listarPaquetesNoComprados390mtemp.toString();
        %>
        <%=tempreturnp391%>
        <%
        }}
break;
case 393:
        gotMethod = true;
        String arg0_93id=  request.getParameter("arg0396");
            java.lang.String arg0_93idTemp = null;
        if(!arg0_93id.equals("")){
         arg0_93idTemp  = arg0_93id;
        }
        String arg1_94id=  request.getParameter("arg1398");
            java.lang.String arg1_94idTemp = null;
        if(!arg1_94id.equals("")){
         arg1_94idTemp  = arg1_94id;
        }
        samplePublicadorIControladorProxyid.confirmar(arg0_93idTemp,arg1_94idTemp);
break;
case 400:
        gotMethod = true;
        servidor.DataColeccionObject obtenerDataDepartamentos400mtemp = samplePublicadorIControladorProxyid.obtenerDataDepartamentos();
if(obtenerDataDepartamentos400mtemp == null){
%>
<%=obtenerDataDepartamentos400mtemp %>
<%
}else{
        if(obtenerDataDepartamentos400mtemp!= null){
        String tempreturnp401 = obtenerDataDepartamentos400mtemp.toString();
        %>
        <%=tempreturnp401%>
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