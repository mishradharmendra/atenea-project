<?xml version='1.0' encoding='UTF-8' ?>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:rich="http://richfaces.org/rich"
	  xmlns:richfaces="http://richfaces.ajax4jsf.org/rich"      
	  xmlns:a4j="http://richfaces.org/a4j">
<body>
	<ui:composition template="../template.xhtml">
		<ui:define name="encabezado">
			<table width="940">
				<tr><h:inputTextarea></h:inputTextarea>
					<td height="20" valign="middle" bgcolor="#0093DD" class="PrimerNivel" align="right">
					<table border="0" align="right" cellpadding="0" cellspacing="0" class="PrimerNivel">
						<tr><rich:message for="tdcNidtipodoc" />
							<td width="10">&nbsp;</td>
							<td><h:outputLink value="" rendered="true">
								<img src="../web/imagenes/home.png" alt="Salir" title="Salir" width="16" height="16" border="0" />
							</h:outputLink></td>
							<td width="5"></td>
							<td><h:outputLink value="../web/faces/home.jsf" styleClass="PrimerNivel">Inicio</h:outputLink></td>
							<td width="10"></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td height="80" bgcolor="#000000">
						<script type="text/javascript">
							AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','900','height','80','hspace','0','vspace','0','src','${pageContext.request.contextPath}/web/swf/menuNuevo','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','${pageContext.request.contextPath}/web/swf/menuNuevo' ); //end AC code
	              		</script>
						<noscript>
							<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="900" height="80" hspace="0" vspace="0">
							<param name="movie" value="${pageContext.request.contextPath}/web/swf/menuNuevo.swf" />
							<param name="quality" value="high" />
							<embed src="${pageContext.request.contextPath}/web/swf/menuNuevo.swf" width="900" height="80" hspace="0" vspace="0" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash"></embed> 
							</object>
						</noscript>
					</td>
				</tr>
			</table>		
		</ui:define>
	</ui:composition>
</body>
</html>