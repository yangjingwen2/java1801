package com.qianfeng.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Job是定时器需要执行的一个任务。
 * 一个定时器，可以同时执行多个任务（Job）
 */
public class CleanImagesJob implements Job {

    /**
     * 具体的执行方法
     * 当定时任务被触发时，会执行execute中的业务逻辑。
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("-------------");
    }
}
