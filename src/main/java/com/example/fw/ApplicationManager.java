package com.example.fw;

import java.io.IOException;
import java.util.Properties;



public class ApplicationManager {
	
	private static ApplicationManager singleton;

	private Properties props;

	private ContactHelper contactHelper;

	private ProcessHelper processHelper;

	private AutoItHelper autoItHelper;

	public static ApplicationManager getInstance(Properties props) throws IOException {
		if (singleton == null) {
			singleton = new ApplicationManager();
			singleton.setProperties(props);
			singleton.start();
		}
		return singleton;
	}

	public void start() throws IOException {
		getProcessHelper().startApp();
	}
	
	public void stop() {
		getProcessHelper().stopApp();
	}
	
	public void setProperties(Properties props) {
		this.props = props;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this); 
		}
		return processHelper;
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this); 
		}
		return contactHelper;
	}

	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null) {
			autoItHelper = new AutoItHelper(this); 
		}
		return autoItHelper;
	}
	
	
}
