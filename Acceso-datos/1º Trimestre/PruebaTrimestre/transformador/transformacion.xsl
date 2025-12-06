<?xml version="1.0" encoding="utf-8" ?>
<stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
               <title>Lista de productos</title>
            </head>
            <body>
                <h1>Listado de productos</h1>
                <ul>
                    <xsl:for-each select="productos/producto">
                        <li>
                            <xsl:value-of select="id"/>
                            <xsl:value-of select="nombre"/>
                            <xsl:value-of select="precio"/>
                            <xsl:value-of select="categoria"/>
                        </li>

                    </xsl:for-each>
                </ul>
            </body>
        </html>

    </xsl:template>

</stylesheet>