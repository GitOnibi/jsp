<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*"%>
<%
	Enumeration<String> init = application.getInitParameterNames();

	//기본 파라미터 조회
	while( init.hasMoreElements() ) {
		String str = init.nextElement();
		out.println( str );
		out.println( application.getInitParameter(str) );
	}
	out.println( application.getServerInfo() ); // 서버정보
	
	char[] str		= new char[256];
	int len 		= -1;
	String path		= "./test.txt";
	try {
		InputStreamReader fread = new InputStreamReader(application.getResourceAsStream(path), "UTF-8");
		while( (len = fread.read(str)) != -1 ) {
			out.println( new String(str, 0, len));
		}
	} catch(IOException ioe) {
		ioe.printStackTrace();
	}

	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>