<%@ page language="java" import="java.io.PrintWriter"
	pageEncoding="utf-8"%>
<%@ page import="com.mysql.jdbc.Driver"%>

<%@ page import="java.sql.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String DRIVER_NAME = "com.mysql.jdbc.Driver";

	Class.forName(DRIVER_NAME).newInstance();

	Connection connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/art", "root", "123");

	Statement statement = connection.createStatement();

	String name = request.getParameter("name");//getuser
	String sql = "SELECT COUNT(*) FROM tbUser WHERE userName='" + name
			+ "'";
	ResultSet rs = statement.executeQuery(sql);
	int count = 1;
	while (rs.next()) {
		count = rs.getInt(1);
	}
	connection.close();
	request.setCharacterEncoding("UTF-8");
	//设置输出信息的格式及字符集
	response.setContentType("text/xml;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	//创建输出流对象
	PrintWriter outer = response.getWriter();

	//依据结果输出不同的数据信息
	outer.println("<response>");
	if (count == 0) {//将获取的值与数据库中的值相对比
		outer.println("<res>" + "ok" + "</res>");
	} else {
		outer.println("<res>" + "no" + "</res>");
	}
	outer.println("</response>");
	outer.close();
%>

