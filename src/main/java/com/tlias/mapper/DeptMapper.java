package com.tlias.mapper;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select count(*) from tlias.dept")
    public Long count();
    public List<Dept> list(@Param("start") Integer start,@Param("pageSize") Integer pageSize,@Param("name") String name);

    public Integer deleteDept();
}
