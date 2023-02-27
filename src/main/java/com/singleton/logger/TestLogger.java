package com.singleton.logger;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;


public class TestLogger implements Serializable{

	private static final long serialVersionUID = 8265054014958152152L;
	private File logFile;
	
	
	/**
	 *Private constructor to restrict instantiation of the 
	 *TestLogger class from other classes 
	 */
	private TestLogger() {}
	
	/**
	 * Private static helper method to instantiate TestLogger 
	 *
	 */
	private static class TestLoggerHelper{
		private static final TestLogger loggerInstance = new TestLogger();
	}
	
	/**
	 * 
	 * @return an Instance of TestLogger from the helper method, This is our
	 * global access point for the other classes to get the instance of our singleton
	 * class TestLogger
	 */
	public static TestLogger getInstance() {
		return TestLoggerHelper.loggerInstance;
	}
	
	/**
	 * debugLogger Operation will create or append to the logfile
	 * Utilizing a Writer method
	 * @param String to log
	 * @throws Exception 
	 */
	public void debugLogger(String itemToLog) throws Exception {
		try {
			logFile= new File("log.txt");
			if(logFile.createNewFile()) {
				System.out.println("Creating log file");
				Writer(logFile,itemToLog);
			}else {
				System.out.println("Writing to log...");
				Writer(logFile,itemToLog);
			}
		}catch (Exception ex) {
			Writer(logFile,ex);
		}
	}
	/**
	 * 
	 * @param className Used for simple className
	 * @param method that is used during log
	 * @param itemToLog string item to be logged
	 * @throws Exception
	 */
	public void debugClassLogger(String className,String method,String itemToLog) throws Exception {
		try {
			logFile= new File("log.txt");
			if(logFile.createNewFile()) {
				System.out.println("Creating log file");
				Writer(logFile,className,method,itemToLog);
			}else {
				System.out.println("Writing to log...");
				Writer(logFile,className,method,itemToLog);
			}
		}catch (Exception ex) {
			Writer(logFile,ex);
		}
	}
	/**
	 * Writer will write to a file along with string to be logged. See other implementations below
	 * @param file to be logged to
	 * @param logged string that will be logged
	 * @throws IOException
	 */
	public void Writer(File file,String logged) throws Exception {
		FileWriter fileLogger= new FileWriter(file,true);
		fileLogger.write(LocalDateTime.now()+":"+logged+"\n");
		fileLogger.close();
	}
	/**
	 * 
	 * @param file to be written to
	 * @param classname simple class name
	 * @param method is the method being used during logging -> pass with out creating a variable -> (new Object() {}.getClass().getEnclosingMethod().getName())
	 * @param logged String to log
	 * @throws Exception
	 */
	public void Writer(File file,String classname,String method,String logged) throws Exception {
		FileWriter fileLogger= new FileWriter(file,true);
		fileLogger.write(LocalDateTime.now()+":"+classname+":"+method+":--"+logged+"\n");
		fileLogger.close();
	}
	
	/**
	 * 
	 * @param file to be written to
	 * @param logged String to log
	 * @throws Exception
	 */
	public void Writer(File file,Exception logged) throws Exception {
		FileWriter fileLogger= new FileWriter(file,true);
		fileLogger.write(LocalDateTime.now()+":"+logged+"\n");
		fileLogger.close();
	}
}

