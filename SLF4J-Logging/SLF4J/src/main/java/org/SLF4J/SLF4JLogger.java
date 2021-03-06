package org.SLF4J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLogger {
	
	private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
	
	public static int add(int a, int b)
	{
		logger.info("Entering add()");
		logger.debug("The first parameter is {}",a);
		logger.debug("The second parameter is {}",b);
		logger.info("Exiting add()");
		return a + b;
	}
	
	public static void main( String[] args )
    {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		logger.info("Entering Main");
		logger.debug("add(1,2) returned {}",add(1,2));
        
        logger.trace("This is a TRACE Message!");
		logger.debug("This is a DEBUG Message!");
		logger.error("This is an ERROR Message!");
		logger.info("This is an INFO Message!");
		logger.warn("This is a WARN Message!");
		
        logger.info("Exiting Main");
    }

}