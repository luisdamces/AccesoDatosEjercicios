<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

<html> 

<body>
  <h2>Lista de canciones</h2>
  
  <table style="border:2px solid black">
    <tr>
      <th style="text-align:left">ID</th>
      <th style="text-align:left">Año</th>
    </tr>
    <xsl:for-each select="canciones/cancion">
    <tr>
      <td><xsl:value-of select="id"/></td>
      <td><xsl:value-of select="año"/></td>
    </tr>
    </xsl:for-each>
  </table>
  
</body>

</html>

</xsl:template>
</xsl:stylesheet>