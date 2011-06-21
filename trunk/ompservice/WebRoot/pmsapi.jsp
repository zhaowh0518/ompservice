<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="sun.misc.BASE64Encoder"%>
<%@ page language="java" import="java.security.MessageDigest"%>
<%
/*pms api should get parameters from client and call */
//user id,unique,assign by server
String userid = request.getHeader("userid");
//client action
String action = request.getHeader("action");
//data used by action
String data = request.getHeader("data");
//client hash generate rule: clienthash=Base64(MD5(userid@omp))
String clienthash = request.getHeader("clienthash");

String key = request.getParameter("key");
MessageDigest md5 = MessageDigest.getInstance("MD5");
md5.update(key.getBytes("utf-8"));
BASE64Encoder base64en = new BASE64Encoder();
// ¼ÓÃÜºóµÄ×Ö·û´®
String pubKey = base64en.encode(md5.digest());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>pms api</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="pms api">
	<meta http-equiv="description" content="this is pms api of omp servie">
	
  </head>
  
  <body>
   <%=pubKey %> 
  </body>
</html>
