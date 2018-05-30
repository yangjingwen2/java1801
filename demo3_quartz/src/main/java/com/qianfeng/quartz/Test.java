package com.qianfeng.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

public class Test {

    public static void main(String[] args) {
        //创建一个具体的job任务
        JobDetail jobDetail = JobBuilder
                .newJob() //创建新任务
                .ofType(CleanImagesJob.class) //指定创建的新任务的类型
                .withIdentity("images") //给当前的job指定一个唯一标识
                .build(); //完成创建新的job

        //创建触发器
        CronTriggerImpl trigger = new CronTriggerImpl("trigger");
        try {
            //设置触发条件（每个三秒执行一次）
            trigger.setCronExpression("0/3 * * * * ? *");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //创建一个调度者，用来部署这个触发器
        //调度者工厂（用来创建调度者）
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        //获取一个调度者
        try {
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            //配置调度的任务和执行的触发器
            scheduler.scheduleJob(jobDetail,trigger);
            //启动定时任务
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
