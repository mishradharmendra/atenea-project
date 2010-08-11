package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


public class GppConsultaRapidaRowMapper implements ResultSetExtractor{

	private List<Object> nombreColumnas;
	private ResultSetMetaData resultSetMetaData;
	
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		nombreColumnas = new ArrayList<Object>();
		resultSetMetaData = rs.getMetaData();
		Integer numeroColumnas = resultSetMetaData.getColumnCount();
		String nombreColumna = "";
		for (int i = 1; i <= numeroColumnas; i++) {
			nombreColumna = resultSetMetaData.getColumnName(i);
			nombreColumnas.add(nombreColumna);
		}
		return nombreColumnas;
	}
	
}