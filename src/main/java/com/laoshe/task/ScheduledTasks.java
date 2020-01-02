package com.laoshe.task;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks{
	
	private static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	

//    @Scheduled(fixedRate = 1000 * 30)
//    public void reportCurrentTime(){
//        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
//    }

    //每1分钟执行一次
//    @Scheduled(cron = "0 */1 *  * * * ")
//    public void reportCurrentByCron() throws InterruptedException{
//    	logger.info("分组任务开始时间：" + dateFormat ().format (new Date ()));
//    	distribuerGroupService.distribuer();
//    	logger.info("分组任务结束时间："+dateFormat ().format (new Date ()));
//    }
//    //每1分钟执行一次
//    @Scheduled(cron = "10 * *  * * * ")
//    public void fission() throws InterruptedException{
//    	logger.info("创业组裂变任务开始时间：" + dateFormat ().format (new Date ()));
//    	businessService.selectByCount();
//    	logger.info("创业组裂变任务结束时间："+dateFormat ().format (new Date ()));
//    }
//  //每1分钟执行一次
//    @Scheduled(cron = "40 */1 *  * * * ")
//    public void moneyFission() throws InterruptedException{
//    	logger.info("财富组裂变任务开始时间：" + dateFormat ().format (new Date ()));
//    	moneyService.selectByCount();
//    	logger.info("财富组裂变任务结束时间："+dateFormat ().format (new Date ()));
//    }
    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
    
}
