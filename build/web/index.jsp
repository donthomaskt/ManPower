
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.manpower.vo.PageObject"%> 
<!DOCTYPE html>
<script type="text/javascript">
    //window.location.href = "ManPowerControlServelt?iId=100001";
</script>
<%
try{
response.sendRedirect("ManPowerControlServelt?iId=100001");
}catch(Exception e)
{e.printStackTrace();}
finally{
}
%>