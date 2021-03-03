package com.zxu;

import com.zxu.domain.UserDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BusinessMongo {
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void testSave() {
        // 新的数据库需要创建对应的用户
        UserDo userInfo = new UserDo();
        mongoTemplate.save(userInfo);

        Query query = Query.query(Criteria.where("name").is("大黄鸭"));
        List<UserDo> userInfos = mongoTemplate.find(query, UserDo.class);
        System.out.println(userInfos);
    }
}
