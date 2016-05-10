package com.iana.repository;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingDAOImpl extends GenericDAO implements GreetingDAO{

	 //Single DataSource configuration
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	//Single DataSource configuration
	 @Autowired
	 private DataSource dataSource;
	 
	 
	 @Autowired
	 @Qualifier("uiiaDataSource")
	 private DataSource uiiaDataSource;
	 
	 
	 @Autowired
	 @Qualifier("gierDataSource")
	 private DataSource gierDataSource;
	 
	 @Autowired
	 @Qualifier("equipReturnDataSource")
	 private DataSource equipReturnDataSource;
	 

	@Override
	public String getConnectedDatabaseProductName() throws Exception {
		return dataSource.getConnection().getMetaData().getDatabaseProductName();
	}
	
	
	@Override
	public Map<String, Object> getUserDetailsFromUIIA() throws Exception {
		String query = "SELECT * FROM USER_LOGIN WHERE LOGIN_ID = ? ";
		return findMap(this.uiiaDataSource, query,"1");
	}
	 
	 
	@Override
	public Map<String, Object> getUserDetailsFromEquipReturn() throws Exception {
		String query = "SELECT * FROM equip_providers WHERE EQP_ID = ? ";
		return findMap(this.equipReturnDataSource, query,"1");
	}
	 
	@Override
	public Map<String, Object> getUserDetailsFromGIER() throws Exception {
		String query = "SELECT * FROM Users WHERE UserId = ? ";
		return findMap(this.gierDataSource, query,"1");
	}
	
}
