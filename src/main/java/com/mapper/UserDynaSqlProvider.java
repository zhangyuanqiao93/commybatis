package com.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class UserDynaSqlProvider {
    //mybatis日志
    private static final Logger log = LoggerFactory.getLogger(UserDynaSqlProvider.class);

    /**
     * 基于动态SQL的CRUD
     * @param param map对象
     * @return tb_user查询结果
     */
    public String selectWithParam(final Map<String,Object> param){
        return new SQL(){
            {
                SELECT ("*");
                FROM("tb_user");
                if(param.get("id") != null){
                    WHERE("id = #{id}");
                }
                if(param.get("name") != null){
                    WHERE("name = #{name}");
                }
                if(param.get("age") != null){
                    WHERE("age = #{age}");
                }
            }
        }.toString();

    }
}
