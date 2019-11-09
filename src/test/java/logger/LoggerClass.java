package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class LoggerClass {
	public Logger logger = Logger.getLogger(this.getClass().getName());
			
	public LoggerClass(){
		PropertyConfigurator.configure("log4j.properties");
	}
}
