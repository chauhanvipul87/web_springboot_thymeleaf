package com.iana.repository;

import java.util.Map;

public interface GreetingDAO {

	String getConnectedDatabaseProductName() throws Exception;

	Map<String, Object> getUserDetailsFromUIIA() throws Exception;

	Map<String, Object> getUserDetailsFromEquipReturn() throws Exception;

	Map<String, Object> getUserDetailsFromGIER() throws Exception;

}
