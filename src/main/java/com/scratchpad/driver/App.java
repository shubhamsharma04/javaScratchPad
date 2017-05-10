package com.scratchpad.driver;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scratchpad.service.ServiceForSmallTasks;
import com.scratchpad.service.Watson;

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
		
		/*ServiceForSmallTasks serviceForSmallTasks = (ServiceForSmallTasks) context.getBean("serviceForSmallTasks");
		serviceForSmallTasks.convertHexToInt();
		*/
		//ReadStupidLogsService readStupidLogsService = (ReadStupidLogsService) context.getBean("readStupidLogsService");
		//readStupidLogsService.getInconsisLogs();
		//ArrayHelper.process();
		//BSTHelper bSTHelper = new BSTHelper();
		//bSTHelper.initailize();
		//bSTHelper.getHeight();
		//bSTHelper.checkIfBalanced();
		//QDAMean.getMean();
		//LModelService.printModelsOutput();
		/*ServiceImpl serviceImpl = new ServiceImpl();
		int base = 5554;
		for(int i=0;i<=8;i=i+2){
			try {
				serviceImpl.genHash(String.valueOf(base+i));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}*/
		//serviceImpl.sortedList();
		
	/*	TweetCleanService tweetCleanService = (com.scratchpad.service.TweetCleanService) context.getBean("tweetCleanService");
		try {	
			tweetCleanService.formatTweets();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*ClientServer cs = new ClientServer();
		try {
			cs.start();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ServiceForSmallTasks serviceForSmallTasks = (ServiceForSmallTasks) context.getBean("serviceForSmallTasks");
		serviceForSmallTasks.convertHexToInt();
		//AnotherServiceForSmallTasks anotherServiceForSmallTasks = (AnotherServiceForSmallTasks) context.getBean("anotherServiceForSmallTasks");
		//anotherServiceForSmallTasks.performTaks();
		//ServiceImpl serviceImpl = (ServiceImpl) context.getBean("serviceImpl");
		//serviceImpl.combinations();
		
		//SenderRec SenderRec = (com.scratchpad.service.SenderRec) context.getBean("senderRec");
		//SenderRec.start(null);
		//ServiceImpl serviceImpl = (ServiceImpl) context.getBean("serviceImpl");
		//serviceImpl.cartesianProduct();
		//ServicePartThree servicePartThree = (ServicePartThree) context.getBean("servicePartThree");
		//servicePartThree.compareStrings();
		
		/*try {
			ObjectStream obj = new ObjectStream();
			obj.start();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//Watson watson = (Watson) context.getBean("watson");
//watson.doPersonality();
		//ServiceImpl serviceImpl = (ServiceImpl) context.getBean("serviceImpl");
		//serviceImpl.watsonJsonApiReader();
	}
}
