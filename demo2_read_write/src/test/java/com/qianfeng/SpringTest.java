package com.qianfeng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class SpringTest {

    @Autowired
    private DemoReadDao readDao;
    @Autowired
    private DemoWriteDao writeDao;

    @Test
    public void testCase1(){
        writeDao.save("lisi");
    }

    @Test
    public void testCase2(){
        DemoInfo demoInfo = readDao.queryOneById(2);
        System.out.println(demoInfo.getId() + "/" + demoInfo.getName());
    }
}
