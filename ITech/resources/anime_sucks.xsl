<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:tns="http://www.example.org/WorldartXMLSchema">
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" type="text/css" href="style.css"/>
            </head>
            <body>
                <div class="site">
                    <h1>Worldart</h1>
                    <hr width="650"/>
                    <h2>Sort by anime title</h2>
                    <table border="1">
                        <tr bgcolor="#F0FFF0">
                            <th>ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Year</th>
                            <th>Producer</th>
                            <th>Season</th>
                        </tr>

                        <xsl:for-each select="tns:worldart/tns:animetitle">
                            <xsl:sort select="tns:title"/>
                            <tr>
                                <td>
                                    <xsl:value-of select="@id"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:title"/>
                                </td>
                                <td><xsl:value-of select="tns:originalauthor/tns:firstName"/>&#160;<xsl:value-of
                                        select="tns:originalauthor/tns:lastName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:yearstart"/>
                                </td>

                                <td>
                                    <xsl:value-of select="tns:producer/tns:name"/>
                                </td>

                                <xsl:choose>
                                    <xsl:when test="tns:season='1 season'">
                                        <td bgcolor="#7FFFD4">
                                            <xsl:value-of select="tns:season"/>
                                        </td>
                                    </xsl:when>

                                    <xsl:otherwise>
                                        <td bgcolor="#66CDAA">
                                            <xsl:value-of select="tns:season"/>
                                        </td>
                                    </xsl:otherwise>
                                </xsl:choose>

                                <td>
                                    <xsl:value-of select="tns:originalauthor/tns:country"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>

                    <h2>Anime 2015</h2>
                    <table border="1">
                        <tr bgcolor="#F0FFF0">
                            <th>ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Year</th>
                            <th>Producer</th>
                            <th>Season</th>
                        </tr>

                        <xsl:for-each select="tns:worldart/tns:animetitle[tns:yearstart &gt;= 2015]">
                            <xsl:sort select="tns:originalauthor/tns:firstName"/>

                            <tr>
                                <td>
                                    <xsl:value-of select="@id"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:title"/>
                                </td>
                                <td><xsl:value-of select="tns:originalauthor/tns:firstName"/>&#160;<xsl:value-of
                                        select="tns:originalauthor/tns:lastName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:yearstart"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:producer/tns:name"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:season"/>
                                </td>
                                <td>
                                    <xsl:value-of select="tns:originalauthor/tns:country"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
