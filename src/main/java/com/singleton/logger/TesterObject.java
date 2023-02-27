package com.singleton.logger;


public class TesterObject {
	
	private String Name;
	private TestLogger logger = TestLogger.getInstance();
	
	
	public TesterObject() {}
	
	public void setName(String name) throws Exception {
		this.Name=name;
	    logger.debugLogger("Hash from:"+this.getClass().getSimpleName()+":"+logger.hashCode());
		logger.debugClassLogger(this.getClass().getSimpleName(), (new Object() {}.getClass().getEnclosingMethod().getName()),Name);
	}
	
}
