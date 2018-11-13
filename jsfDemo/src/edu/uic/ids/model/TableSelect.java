package edu.uic.ids.model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
@ManagedBean(name="tableSelect")
@SessionScoped
public class TableSelect {
	
	Statement stmt;
	ResultSet rs;
//	ArrayList TableList = new ArrayList();
	private List<String> TableList=new ArrayList();
	private List<String> colnames=new ArrayList();
	String selectTable;
	public String[] selectedcol;
//	String[] colnames;
	private List<Double> colval=new ArrayList();
	
	
	

	public List<String> init() throws SQLException
	{
		if(TableList.isEmpty()) {
		String status;
		 DatabaseMetaData md = Connect.con.getMetaData();
		 rs = md.getTables("world", null, null, new String[] {"TABLE"});
		 while (rs.next()) 
		 {
		 TableList.add(rs.getString("TABLE_NAME")); 
			
		 }
		}
		
		return TableList;

	}
	
	public void valueChanged(ValueChangeEvent e) throws SQLException {
		stmt = Connect.con.createStatement();
		colnames.clear();
		if(e.getNewValue()!= null)
		{
		 selectTable = e.getNewValue().toString();
		 rs = stmt.executeQuery("SELECT * FROM "+selectTable);
		 ResultSetMetaData rsmd = rs.getMetaData();		 
		 int i = rsmd.getColumnCount();
		 
		 	while(i!=0)
		 	{			 
			 colnames.add(rsmd.getColumnName(i));
			 i--;
		 	}
		}
		
//		selectTable = e.getNewValue().toString();
	}
	
	public void colvalues() throws SQLException
	{
//		
//		int i =colnames.size();
//		while(i!=0)
//		{
//			
//			 try {
//				rs = stmt.executeQuery("SELECT"+colnames.get(i)+"FROM"+selectTable);
//				while(rs.next())
//				colval.add(rs.get);
//			 	} 
//			 catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			 						}
//			 i--;
//		}
		int i =colnames.size();
		while(i!=0)
	{
	rs = stmt.executeQuery("SELECT"+colnames.get(i)+"FROM"+selectTable);
	while (rs.next()) {
	
	      Double value = rs.getDouble(colnames.get(1));	      
	      colval.add(value);
	    }
	i--;
	}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getSelectTable() {
		return selectTable;
	}

	public void setSelectTable(String selectTable) {
		this.selectTable = selectTable;
	}

	public List<String> getColnames() {
		return colnames;
	}

	public void setColnames(List<String> colnames) {
		this.colnames = colnames;
	}

	public List<String> getTableList() {
		return TableList;
	}

	public String[] getSelectedcol() {
		return selectedcol;
	}

	public void setSelectedcol(String[] selectedcol) {
		this.selectedcol = selectedcol;
	}

	public void setTableList(List<String> tableList) {
		TableList = tableList;
	}

	

}
