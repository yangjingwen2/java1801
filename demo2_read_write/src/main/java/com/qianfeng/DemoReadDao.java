package com.qianfeng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 读
 */
@Repository
public class DemoReadDao extends SqlSessionDaoSupport {

    @Resource(name = "sqlSessionFactoryRead")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public DemoInfo queryOneById(int id){
        return getSqlSession().selectOne("com.qianfeng.DemoInfoMapper.selectOne",id);
    }
}
