package com.xtg.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.xtg.model.UserInfo;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * Here in this method we are assigning the values that the user has
	 * provided into parameters that are specified in the XTG_KRISHNA_INFO_PKG
	 * in the database.
	 */
	/*
	 * public Map<String, Object> callRegisterPrc(UserInfo user) { try { Map<String,
	 * String> registerInParamMapping = new HashMap<String, String>();
	 * registerInParamMapping.put("PIV_FULL_NAME", user.getFullname());
	 * registerInParamMapping.put("PIV_USER_NAME", user.getUsername());
	 * registerInParamMapping.put("PIV_EMAIL", user.getEmail());
	 * registerInParamMapping.put("PIV_PASSWORD", user.getPassword());
	 * registerInParamMapping.put("PIV_GENDER", user.getGender()); SimpleJdbcCall
	 * registerJdbcCall = new
	 * SimpleJdbcCall(jdbcTemplate).withProcedureName("XT_INTERN_REGISTER_PRC");
	 * 
	 * SqlParameterSource inParameterSource = new
	 * MapSqlParameterSource().addValues(registerInParamMapping);
	 * 
	 * return registerJdbcCall.execute(inParameterSource); } catch (Exception e) {
	 * e.printStackTrace(); } return null; }
	 */
	
	public Map<String, Object> callRegisterPrc(UserInfo user) {
	    try {
	        // Prepare input parameters
	        Map<String, Object> registerInParamMapping = new HashMap<>();
	        registerInParamMapping.put("PIV_FULL_NAME", user.getFullname());
	        registerInParamMapping.put("PIV_USER_NAME", user.getUsername());
	        registerInParamMapping.put("PIV_EMAIL", user.getEmail());
	        registerInParamMapping.put("PIV_PASSWORD", user.getPassword());
	        registerInParamMapping.put("PIV_GENDER", user.getGender());

	        // Configure SimpleJdbcCall with explicit OUT parameter
	        SimpleJdbcCall registerJdbcCall = new SimpleJdbcCall(jdbcTemplate)
	                .withProcedureName("XT_INTERN_REGISTER_PRC")
	                .declareParameters(
	                        new SqlParameter("PIV_FULL_NAME", Types.VARCHAR),
	                        new SqlParameter("PIV_USER_NAME", Types.VARCHAR),
	                        new SqlParameter("PIV_EMAIL", Types.VARCHAR),
	                        new SqlParameter("PIV_PASSWORD", Types.VARCHAR),
	                        new SqlParameter("PIV_GENDER", Types.VARCHAR),
	                        new SqlOutParameter("POV_RESPONSE", Types.VARCHAR)
	                );

	        SqlParameterSource inParameterSource = new MapSqlParameterSource()
	                .addValues(registerInParamMapping);

	        Map<String, Object> result = registerJdbcCall.execute(inParameterSource);

	        return result;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	/*
	 * Here we are sending the details that the user has provided to the
	 * database for comparing it with the already existing records.The required
	 * operational code is written in XT_KT_LOGIN_PRC
	 */
	public Map<String, Object> callLoginPrc(Map<String, Object> inputs) {
		try {
			SimpleJdbcCall loginJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("XTG_INTERN_LOGIN_PRC");
			SqlParameterSource inParameterSource = new MapSqlParameterSource().addValues(inputs);
			return loginJdbcCall.execute(inParameterSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}