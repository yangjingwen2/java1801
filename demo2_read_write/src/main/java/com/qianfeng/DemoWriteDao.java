package com.qianfeng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 写
 */
@Repository
public class DemoWriteDao extends SqlSessionDaoSupport {

    @Resource(name = "sqlSessionFactoryWrite")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public void save(String name){
        getSqlSession().insert("com.qianfeng.DemoInfoMapper.saveOne",name);
    }
}
