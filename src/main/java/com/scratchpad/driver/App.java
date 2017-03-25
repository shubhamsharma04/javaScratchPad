package com.scratchpad.driver;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scratchpad.service.ArrayHelper;
import com.scratchpad.service.ReadStupidLogsService;

public class App {
	
	@Value("${tweet.language}")
	static String[] languages;
	 
	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		/*TwitterStreamingService twitterStreamingService = (TwitterStreamingService) context
				.getBean("twitterStreamingService");
		twitterStreamingService.twitterStreamingService();*/
		
		//ServiceImpl serviceImpl = (ServiceImpl) context.getBean("serviceImpl");
		//serviceImpl.arrayHop();
		//serviceImpl.breakString();
		//serviceImpl.exceptionTest();
		/*Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			Integer.parseInt("");//sc.nextInt();
		}*/
		/*try {
			serviceImpl.sortStats();
		} catch (IOException e) {
			logger.error("",e);
		}*/
		
		//PriorityQImplService priorityQImplService = (PriorityQImplService) context.getBean("priorityQImplService");
		//priorityQImplService.process();
		
		//ServiceForSmallTasks serviceForSmallTasks = (ServiceForSmallTasks) context.getBean("serviceForSmallTasks");
		//serviceForSmallTasks.convertHexToInt();
		
		//ReadStupidLogsService readStupidLogsService = (ReadStupidLogsService) context.getBean("readStupidLogsService");
		//readStupidLogsService.getInconsisLogs();
		ArrayHelper.process();
	}
}
