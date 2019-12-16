package com.example.analog.dao;

import com.example.analog.model.AnalogInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.math.BigInteger;
import java.util.List;
@Mapper
@Component
public interface AnalogMapper {

    @Results(id = "analog",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "nameChina", column = "name_china"),
            @Result(property = "nameEnglish", column = "name_english"),
            @Result(property = "path", column = "path"),
            @Result(property = "returnCode", column = "return_code"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "updateUser", column = "update_user"),
            @Result(property = "status", column = "status"),
            @Result(property = "error1", column = "error1"),
            @Result(property = "error2", column = "error2"),
            @Result(property = "error3", column = "error3"),

    })
    //查询-根据路径
    @Select({"<script>" +
            "SELECT * FROM analog_info WHERE 1=1 " +
            "<if test='path != null '>" +
            "and path = #{path}" +
            "</if>" +
            "</script>"})
    List<AnalogInfo> queryByPath(@Param("path") String path);
    //查询所有
    @Select({"<script>" +
            "SELECT * FROM analog_info WHERE 1=1" +
            "<if test='path != null '>" +
            "and path like CONCAT('%',#{path},'%')" +
            "</if>" +
            "<if test='nameChina != null '>" +
            "and name_china like CONCAT('%',#{nameChina},'%')" +
            "</if>" +
            "</script>"})
    @ResultMap("analog")
    List<AnalogInfo> queryAllPath(AnalogInfo analogInfo);
    //新增
    @Insert({"<script>"+
            "insert into analog_info " +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">" +
            "<if test='nameChina != null '>" +
            "name_china," +
            "</if>" +
            "<if test='nameEnglish != null '>" +
            "name_english," +
            "</if>" +
            "<if test='path != null '>" +
            "path," +
            "</if>" +
            "<if test='returnCode != null '>" +
            "return_code," +
            "</if>" +
            "<if test='createDate != null '>" +
            "create_date," +
            "</if>" +
            "<if test='createUser != null '>" +
            "create_user," +
            "</if>" +
            "<if test='updateDate != null '>" +
            "update_date," +
            "</if>" +
            "<if test='updateUser != null '>" +
            "update_user," +
            "</if>" +

            "</trim>" +
            "values" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">" +
            "<if test='nameChina != null '>" +
            "#{nameChina}," +
            "</if>" +
            "<if test='nameEnglish != null '>" +
            "#{nameEnglish}," +
            "</if>" +
            "<if test='path != null '>" +
            "#{path}," +
            "</if>" +
            "<if test='returnCode != null '>" +
            "#{returnCode}," +
            "</if>" +
            "<if test='createDate != null '>" +
            "#{createDate}," +
            "</if>" +
            "<if test='createUser != null '>" +
            "#{createUser}," +
            "</if>" +
            "<if test='updateDate != null '>" +
            "#{updateDate}," +
            "</if>" +
            "<if test='updateUser != null '>" +
            "#{updateUser}," +
            "</if>" +
            "</trim>"+
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAnalogInfo(AnalogInfo analogInfo);
    //修改
    @Update({"<script>" +
            "update analog_info " +
            "<trim prefix=\"set\" suffixOverrides=\",\">" +
            "<if test='nameChina != null '>" +
            "name_china = #{nameChina}," +
            "</if>" +

            "<if test='nameEnglish != null '>" +
            "name_english = #{nameEnglish}," +
            "</if>" +

            "<if test='path != null '>" +
            "path = #{path}," +
            "</if>" +

            "<if test='returnCode != null '>" +
            "return_code = #{returnCode}," +
            "</if>" +

            "<if test='status != null '>" +
            "status = #{status}," +
            "</if>" +

            "<if test='updateDate != null '>" +
            "update_date = #{updateDate}," +
            "</if>" +

            "<if test='updateUser != null '>" +
            "update_user = #{updateUser}," +
            "</if>" +

            "<if test='error1 != null '>" +
            "error1 = #{error1}," +
            "</if>" +

            "<if test='error2 != null '>" +
            "error2 = #{error2}," +
            "</if>" +

            "<if test='error3 != null '>" +
            "error3 = #{error3}," +
            "</if>" +

            "</trim>" +
            "where id = #{id}" +
            "</script>"})
    int updateAnalogInfo(AnalogInfo analogInfo);
    //删除
    @Delete({"delete from analog_info where id =#{id}"})
    int deleteAnalogInfo(@Param("id") BigInteger id);




}
