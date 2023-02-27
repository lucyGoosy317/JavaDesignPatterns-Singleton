package com.singleton.maindriver;


import com.singleton.logger.TestLogger;
import com.singleton.logger.TesterObject;


public class driver{
public static void main(String [] args) throws Exception{
    TestLogger logger=TestLogger.getInstance();
    logger.debugLogger("Testing debugger");
    
    TesterObject test = new TesterObject();
    test.setName("MEOW Cat");
    logger.debugLogger("Hash from driver: "+logger.hashCode());
}
}