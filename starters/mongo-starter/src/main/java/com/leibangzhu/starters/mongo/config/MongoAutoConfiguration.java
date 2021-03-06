package com.leibangzhu.starters.mongo.config;

import com.leibangzhu.starters.mongo.IMongoClient;
import com.leibangzhu.starters.mongo.MongoClient;
import com.leibangzhu.starters.mongo.properties.MongoProperties;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableConfigurationProperties({MongoProperties.class})
public class MongoAutoConfiguration {

    @Autowired
    private MongoProperties mongoProperties;

    @Bean
    public com.mongodb.MongoClient mongo(){
        MongoClientURI uri = new MongoClientURI(mongoProperties.getUri());
        return new com.mongodb.MongoClient(uri);
    }

    @Bean
    public IMongoClient mongoClient(com.mongodb.MongoClient mongo){
        return new MongoClient(mongo,mongoProperties.getDb());
    }
}
