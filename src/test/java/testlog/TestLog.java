package testlog;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog {
	
	@Test
	public void debug() {
		Logger log = Logger.getLogger(TestLog.class);
//		log.debug("����һ��������Ϣ");
//		log.info("����һ��info��Ϣ");
		log.warn("����һ��������Ϣ");
//		log.error("����һ��������Ϣ");
//		log.fatal("����һ��������Ϣ");
	}
}
