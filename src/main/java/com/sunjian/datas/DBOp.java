package com.sunjian.datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用sqlite数据库存储测试数据
 * 
 * @author sunjian
 *
 */
public class DBOp {
	
	private Statement stat = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
    
	//连接数据库
	public void conn(String db){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+db);
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库中的xpath
	public String  getXpath(String elementName){
		String xpath = null;
		try {
			rsq =stat.executeQuery("select Xpath from "+tablename+" where ElementName = '"+elementName+"';");
			while (rsq.next()) { 
				xpath = rsq.getString("Xpath");
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xpath;
	}
	
	//获取数据库中的css
	public String getCss(String elementName){
		String css = null;
		try {
			rsq =stat.executeQuery("select Css from "+tablename+" where ElementName = '"+elementName+"';");
			while (rsq.next()) { 
				css=rsq.getString("Css");
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return css;
	}
	
	//获取数据库中的values
	public String getValues(String elementName){
		String values = null;
		try {
			rsq =stat.executeQuery("select Value from "+tablename+" where ElementName = '"+elementName+"';");
			while (rsq.next()) { 
				values=rsq.getString("Value");
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return values;
	}
	
	//获取数据库中的comments
	public String getComments(String elementName){
		String comments = null;
		try {
			rsq =stat.executeQuery("select Comment from "+tablename+" where ElementName = '"+elementName+"';");
			while (rsq.next()) { 
				comments=rsq.getString("Comment");
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}
	
	/***************************************************************/
	
	
	//获取数据库中的元素名
	public String getElementName(String elementName){
		String name = null;
		try {
			rsq =stat.executeQuery("select ElementName from "+tablename+";");
			while (rsq.next()) { 
				name=rsq.getString(elementName);
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	//获取数据库中存储的指定的元素的指定内容
	public String getContents(String elementName,String columName){
		String contents = null;
		try {
			rsq =stat.executeQuery("select "+columName+" from "+tablename+" where ElementName = '"+elementName+"';");
			while (rsq.next()) { 
				contents=rsq.getString(columName);
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contents;
	}
	
	public static void main(String[] args) {
		DBOp test = new DBOp("LoginPage");
		test.conn(System.getProperty("user.dir")+"/src/test/tools/sd.sqlite");
		System.out.println(test.getXpath( "targetElements"));
		System.out.println(test.getCss(""));
		System.out.println(test.getValues(""));
		System.out.println(test.getContents("url", "Value"));
	}
}
