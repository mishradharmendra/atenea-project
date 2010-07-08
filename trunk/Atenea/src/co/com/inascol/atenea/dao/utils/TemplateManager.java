package co.com.inascol.atenea.dao.utils;

import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TemplateManager {

	private static TemplateManager templateManager;	
	private Properties propertiesFile;
	private final String fieldUsername = "Username";
	private final String fieldPassword = "Password";
	private final String fieldURL = "Url";
	private final String fieldDriver = "Driver";
	private final String Database_PropertiesFile = "/co/com/inascol/atenea/dao/utils/Database.properties";
	
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
			propertiesFile.load(TemplateManager.class.getResourceAsStream(Database_PropertiesFile));
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