package com.example.analog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AnalogDDLMapper {

    //查看analogInfo表是否存在
    @Select({"SELECT COUNT(*) FROM information_schema.TABLES WHERE table_name =#{tableName} "})
    int checkTable(@Param("tableName") String tableName);

    //创建analogInfo
    @Update({"create table ${tableName} (" +
            "id BIGINT(10) NOT NULL AUTO_INCREMENT," +
            "name_china VARCHAR(250) DEFAULT NULL," +
            "name_english VARBINARY(250) DEFAULT NULL," +
            "path VARBINARY(1024) DEFAULT NULL," +
            "return_code TEXT," +
            "create_date DATE DEFAULT NULL," +
            "create_user VARCHAR(250) DEFAULT NULL," +
            "update_date VARCHAR(250) DEFAULT NULL," +
            "update_user VARBINARY(250) DEFAULT NULL," +
            "status INT(1) NOT NULL DEFAULT '0'," +
            "error1 TEXT," +
            "error2 TEXT," +
            "error3 TEXT," +
            "PRIMARY KEY (`id`)" +
            ") ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 "})
    void createTableAnalogInfo(@Param("tableName") String tableName);
}
