package genericUtilities;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtils 
{
	
/**
 * This Method Read data from Properties file 
 * @author Nandan V
 * @param key
 * @return
 * @throws Exception
 */
	public String readDataFromPropertyFile(String key) throws Exception 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.propertryFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
