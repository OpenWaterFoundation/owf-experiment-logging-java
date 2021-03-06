import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDK14Logger {

	private static Logger logger = LoggerFactory.getLogger(JDK14Logger.class);

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
		try {
			while (true) {
				logger.info("MaxMemory=" + Math.random() + " TotalMemory=" + Math.random() + " FreeMemory=" + Math.random() + " AvailableProcessor=" + Math.random());
				Thread.sleep(5 * 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//		logger.info("Entering Main");
		//		logger.debug("add(1,2) returned {}",add(1,2));

		/* TRACE, DEBUG, INFO, WARN, ERROR, FATAL
		 * In order to display TRACE/DEBUG messages to the console
		 * add the line below into the VM arguments under the RUN 
		 * CONFIGURATION menu.
		 * 
		 * -Dorg.slf4j.simpleLogger.defaultLogLevel=TRACE
		 */
		//        logger.trace("This is a TRACE Message!");
		//		logger.debug("This is a DEBUG Message!");
		//		logger.error("This is an ERROR Message!");
		//		logger.info("This is an INFO Message!");
		//		logger.warn("This is a WARN Message!");
		//		
		//        logger.info("Exiting Main");
	}

}

/* Refer to link below for example configuration files for file rollover
 *  https://gist.github.com/fclairamb/5298705 (log4j2)
 *  https://gist.github.com/jcraane/5921329 (logback)
 *  
 */