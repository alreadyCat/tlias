package com.tlias.mapper;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * from tlias.dept")
    public List<Dept> list();
}
