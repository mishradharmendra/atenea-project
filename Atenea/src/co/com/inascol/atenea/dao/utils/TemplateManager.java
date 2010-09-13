package co.com.inascol.atenea.dao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TemplateManager {

	private static TemplateManager templateManager;	
	private Properties propertiesFile;
	private final String fieldUsername = "Username";
	private final String fieldPassword = "Password";
	private final String fieldURL = "Url";
	private final String fieldDriver = "Driver";
	private final String Database_PropertiesFile = "DatabaseAtenea.properties";
	
	public TemplateManager() {}
	
	public static TemplateManager getInstance(){		
		if(templateManager == null){
			templateManager = new TemplateManager();
		}
		return templateManager;
	}
	
	public JdbcTemplate getJDBCTemplate(){
		return new JdbcTemplate(getDataSource());
	}
	
	public DriverManagerDataSource getDataSource(){				
		try {
			propertiesFile = new Properties();
			FileInputStream archivo = new FileInputStream(new File(Database_PropertiesFile));
			propertiesFile.load(archivo);
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(propertiesFile.getProperty(fieldDriver));
			dataSource.setUsername(propertiesFile.getProperty(fieldUsername));
			dataSource.setPassword(propertiesFile.getProperty(fieldPassword));
			dataSource.setUrl(propertiesFile.getProperty(fieldURL));
			return dataSource;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}