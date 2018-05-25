package com.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserDynaSqlProvider {

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
