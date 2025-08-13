package com.xtg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.xtg.manager.EntryManagerImpl;
import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;

@Repository
public class EntryDaoImpl implements EntryDao {
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	EntryManagerImpl b= new EntryManagerImpl();
	
	 public Map<String,Object> callEntryPrc(EntryFormModel entry){
			try{
				Map<String, Object> entryInParamMapping = new HashMap<String, Object>();
				entryInParamMapping.put("PIV_ASSET_TYPE", entry.getAssettype());
			    entryInParamMapping.put("PIV_MAKE_AND_MODEL", entry.getMakeandmodel());
				entryInParamMapping.put("PIV_PROCESSOR_DETAILS", entry.getProcessordetails());
				entryInParamMapping.put("PIV_MEMORY_DETAILS", entry.getMemorydetails());
				entryInParamMapping.put("PIV_OPERATING_SYSTEM", entry.getOperatingsystem());
				entryInParamMapping.put("PIV_SERIALNO", entry.getSerialno());
				entryInParamMapping.put("PIV_INVOICENO", entry.getInvoiceno());
				entryInParamMapping.put("PIV_INVOICE_DATE", entry.getInvoicedate());
				entryInParamMapping.put("PIV_HARDWARE_ASSET_ID", entry.getHardwareassetid());
				entryInParamMapping.put("PIV_CURRENT_STATUS", entry.getCurrentstatus());
				entryInParamMapping.put("PIV_ASSIGNED_TO", entry.getAssignedto());
				entryInParamMapping.put("PIV_ASSET_LOC", entry.getAssetloc());
				/*if(entry.getSpareassetid()!=null && entry.getSpareassetid()!=""){
					entryInParamMapping.put("PIV_SPARE_ASSET_ID", entry.getSpareassetid());
				}else{
					entryInParamMapping.put("PIV_SPARE_ASSET_ID", 0);
				}*/
				entryInParamMapping.put("PIV_SPARE_ASSET_ID", entry.getSpareassetid());
				entryInParamMapping.put("PIV_DEPARTMENT", entry.getDepartment());
				entryInParamMapping.put("PIV_REMARKS", entry.getRemarks());
				SimpleJdbcCall entryJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("XT_ENTRY_FORM_PRC");
				
				SqlParameterSource inParameterSource = new MapSqlParameterSource().addValues(entryInParamMapping);

				return entryJdbcCall.execute(inParameterSource);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	 }
	 public List<SearchFormModel> callSearchPrc(Map<String, Object> inputSearchResults){
		 
		 Connection connection =null;
		 Statement statement =null;
		 ResultSet resultSet=null;
		List<SearchFormModel> listResults = null;
		listResults =new LinkedList<SearchFormModel>();
		 
		 try {

			 
			 StringBuilder searchresultsQuery = null;
			 searchresultsQuery = new StringBuilder();
			 
			 String searchQuery=null;
			 
			 
			 
			 
			 if( inputSearchResults.get("PIV_ASSET_TYPE")!=null && ""!=inputSearchResults.get("PIV_ASSET_TYPE")){
				 
				 searchresultsQuery.append(" AND ASSET_TYPE = "+"\'"+inputSearchResults.get("PIV_ASSET_TYPE")+"\'");
				 
			 }
			 if(inputSearchResults.get("PIV_MEMORY_DETAILS")!=null && ""!=inputSearchResults.get("PIV_MEMORY_DETAILS")){
				 
				 searchresultsQuery.append(" AND MEMORY_DETAILS = "+"\'"+inputSearchResults.get("PIV_MEMORY_DETAILS")+"\'");
			 }	
			 
			 if( inputSearchResults.get("PIV_OPERATING_SYSTEM")!=null && ""!=inputSearchResults.get("PIV_OPERATING_SYSTEM")){
				 
				 searchresultsQuery.append(" AND OPERATING_SYSTEM = "+"\'"+inputSearchResults.get("PIV_OPERATING_SYSTEM")+"\'");
			 }	
			 
			 if( inputSearchResults.get("PIV_SERIAL_NO")!=null && ""!=inputSearchResults.get("PIV_SERIAL_NO")){
				 
				 searchresultsQuery.append(" AND  SERIALNO = "+"\'"+inputSearchResults.get("PIV_SERIAL_NO")+"\'");
			 }	
			 
			 if(inputSearchResults.get("PIV_HARDWARE_ASSET_ID")!=null && ""!=inputSearchResults.get("PIV_HARDWARE_ASSET_ID")){
				 
				 searchresultsQuery.append(" AND  HARDWARE_ASSET_ID = "+"\'"+inputSearchResults.get("PIV_HARDWARE_ASSET_ID")+"\'");
			 }	
			 
			 if( inputSearchResults.get("PIV_CURRENT_STATUS")!=null && ""!=inputSearchResults.get("PIV_CURRENT_STATUS")){
				 
				 searchresultsQuery.append(" AND  CURRENT_STATUS = "+"\'"+inputSearchResults.get("PIV_CURRENT_STATUS")+"\'");
			 }	
			 if( inputSearchResults.get("PIV_ASSIGNED_TO")!=null && ""!=inputSearchResults.get("PIV_ASSIGNED_TO")){
				 
				 searchresultsQuery.append(" AND  ASSIGNED_TO = "+"\'"+inputSearchResults.get("PIV_ASSIGNED_TO")+"\'");
			 }	
			 if( inputSearchResults.get("PIV_ASSET_LOCATION")!=null && ""!=inputSearchResults.get("PIV_ASSET_LOCATION")){
				 
				 searchresultsQuery.append(" AND  ASSET_LOC = "+"\'"+inputSearchResults.get("PIV_ASSET_LOCATION")+"\'");
			 }
			 if( inputSearchResults.get("PIV_SPARE_ASSET_ID")!=null && ""!=inputSearchResults.get("PIV_SPARE_ASSET_ID")){
				 
				 searchresultsQuery.append(" AND  SPARE_ASSET_ID = "+"\'"+inputSearchResults.get("PIV_SPARE_ASSET_ID")+"\'");
			 }
			 
			 if(searchresultsQuery!=null){
                 
	                 
	                 searchQuery= "select * from ENTRY_TYPE where "+searchresultsQuery.substring(searchresultsQuery.indexOf("AND")+3, searchresultsQuery.length());
	             }
			 System.out.println("searchQuery  "+searchQuery);
			 
			 if(datasource!=null){
				  connection = datasource.getConnection();
				  statement = connection.createStatement();
				  resultSet = statement.executeQuery(searchQuery);
			 }
			 
			 listResults = new LinkedList<SearchFormModel>();
			 
			 while ( resultSet.next() ) {
				 
				     SearchFormModel  searchModel = new SearchFormModel();
				     if(resultSet.getString("ASSET_TYPE")!=null){
				    	 
				    	 searchModel.setAssettype(resultSet.getString("ASSET_TYPE"));
				     }
				     if(resultSet.getString("MEMORY_DETAILS")!=null){
				    	 
				    	 searchModel.setMemorydetails(resultSet.getString("MEMORY_DETAILS"));
				     }
				     if(resultSet.getString("OPERATING_SYSTEM")!=null){
				    	 
				    	 searchModel.setOperatingsystem(resultSet.getString("OPERATING_SYSTEM"));
				     }
				     if(resultSet.getString("SERIALNO")!=null){
				    	 
				    	 searchModel.setSerialno(resultSet.getString("SERIALNO"));
				     }
				     if(resultSet.getString("HARDWARE_ASSET_ID")!=null){
				    	 
				    	 searchModel.setHardwareassetid(resultSet.getString("HARDWARE_ASSET_ID"));
				     }
				     if(resultSet.getString("CURRENT_STATUS")!=null){
				    	 
				    	 searchModel.setCurrentstatus(resultSet.getString("CURRENT_STATUS"));
				     }
				     if(resultSet.getString("ASSIGNED_TO")!=null){
				    	 
				    	 searchModel.setAssignedto(resultSet.getString("ASSIGNED_TO"));
				     }
				     if(resultSet.getString("ASSET_LOC")!=null){
				    	 
				    	 searchModel.setAssetloc(resultSet.getString("ASSET_LOC"));
				     }
				     if(resultSet.getString("SPARE_ASSET_ID")!=null){
				    	 
				    	 searchModel.setSpareassetid(resultSet.getString("SPARE_ASSET_ID"));
				     }
				     
				     
				     
				      listResults.add(searchModel);
	             
	            }
/*
	           SimpleJdbcCall searchJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("XTG_SEARCH_INFO_PKG")
	                    .withProcedureName("XT_SEARCH_RESULT_PRC");



	           SqlParameterSource inParameterSource = new MapSqlParameterSource().addValues(inputss);



	           return searchJdbcCall.execute(inParameterSource);*/
	        } catch (Exception e) {
	        	if(connection!=null){
					try {
						connection.close();
					} catch (SQLException e1) {
						
					}       
				}
	        	}finally{
	        		
					if(connection!=null){
						try {
							connection.close();
						} catch (SQLException e) {
							
						}       
					}
					
	        	}
		 return listResults;
	   
	    }
	 
	 }


