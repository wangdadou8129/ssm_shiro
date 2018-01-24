package testlog;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog {
	
	@Test
	public void debug() {
		Logger log = Logger.getLogger(TestLog.class);
//		log.debug("这是一个调试信息");
//		log.info("这是一个info信息");
		log.warn("这是一个警告信息");
//		log.error("这是一个错误信息");
//		log.fatal("这是一个灾难信息");
	}
}
