package com.util.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtils {

    static String Phrase1;
    static String Phrase2;
    static String Phrase3;
    static String URL;
    static String USER;
    static String PASS;
    static Statement Stmt;
    static ResultSet Res;
    static Connection Conn;

    public static ResultSet getResultSet(String schName, String schPassword, String dbHostName, String dbSid,
	    String dbType, String query) throws Exception {
	if (dbType.equalsIgnoreCase("Oracle")) {
	    try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Phrase1 = "jdbc:oracle:thin:";
		Phrase2 = "@" + dbHostName + ":1521:";
		Phrase3 = dbSid;
		URL = Phrase1 + Phrase2 + Phrase3;
		USER = schName;
		PASS = schPassword;

		Conn = DriverManager.getConnection(URL, USER, PASS);
		Stmt = Conn.createStatement();
		Stmt = Conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		Res = Stmt.executeQuery(query);

	    } catch (Exception e) {
		System.out.println(e);
	    }

	}
	return Res;
    }

    public static ArrayList<String> getData(String schemaName, String schemaPassword, String databaseHost,
	    String dbSID, String databaseType, String databaseQuery, String column_Name) throws Exception {
	ArrayList<String> selectStorelist = new ArrayList<String>();
	ResultSet result = DBUtils.getResultSet(schemaName, schemaPassword, databaseHost, dbSID, databaseType,
		databaseQuery);
	while (result.next()) {
	    String selectStore = result.getString(column_Name);
	    selectStorelist.add(selectStore);
	}

	Stmt.close();
	Res.close();
	Conn.close();
	return selectStorelist;

    }

}
