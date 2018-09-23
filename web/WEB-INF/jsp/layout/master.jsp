
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.manpower.vo.PageObject"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Man Power</title>
        <%
            String respage = null;
            PageObject pageobj = null;

        %>
        <script src="js/jquery.min.js"></script>
        <style>
            body{
                background-color: #666666;
                border: 0px;
                text-align:justify;
                font-family:"Times New Roman", Times, serif;
                font-size:12px;
                text-decoration:none;
                margin: 0px;
                vertical-align:top;
            }
            .name{
                color:#C9EDF1;
                font-weight:bold;
                font-size:24px;
                font-style:italic;
                padding:10px;
                border:#FFFFFF 1px solid;
                margin-left:10px;
            }
            .nav-menu ul li{
                list-style: none;
                float:left;

                border:#CCCCCC 0px solid;
                margin-left:5px;
                border-bottom:0px;
            }
            .nav-menu ul li a{
                text-decoration:none;
                color:65C971;
                text-transform:uppercase;
                font-size:14px;
                padding : 3px 20px 3px 20px;
                background-color:#CCCCCC;
            }
            .nav-menu ul li a:hover{
                background-color:#65C971;
                color:#FFFFFF;
            }
            .nav-footer ul li{
                list-style:none;
                padding-left:20px;
                line-height:20px;
            }
            .nav-footer ul li a{
                text-decoration:none;
                color:#0033CC;
                font-size:12px;
            }
            .nav-footer ul li a:hover{
                color:#990000;
            }
            .lock{
                height:12px;
                width:12px;
                border:0px;
                margin-left:3px;
            }
            .button-nav {
                margin-right:20px;
            }
            .button-nav ul li{
                list-style:none;
                float:right;
                margin-left:5px;
            }
            .button-nav ul li a{
                text-decoration:none;
                color:#FFFFFF;
                font-size:13px;
                background-color:#CC6666;
                padding:5px 20px 5px 20px;
                border:#FFFFFF 1px solid;
            }
            .button-nav ul li a:hover{
                background-color:#00CCFF;
                color:#FFFFFF;
            }
        </style>
    </head>
    <%        try {
            pageobj = (PageObject) request.getAttribute("pageobj");
            respage = pageobj.getPage();
    %>
    <body>
        <table align="center" width="1004px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
            <tr><td>
                    <jsp:include page="header.jsp"/>
                    <jsp:include page="menu.jsp"/>
                    <jsp:include page="<%=respage%>"/>
                    <jsp:include page="footer.jsp"/>
                </td></tr>
        </table>
    </body>
    <%} catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    %>
</html>
