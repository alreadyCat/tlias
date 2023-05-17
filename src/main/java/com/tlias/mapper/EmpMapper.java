package com.tlias.mapper;

import com.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
  //    public List<Emp> list(@Param("name") String name, @Param("start") Integer start,
  // @Param("pageSize") Integer pageSize);
//  @Select("select * from tlias.emp where name like concat('%',#{name},'%')")
  public List<Emp> list(
      @Param("name") String name,
      @Param("gender") Short gender,
      @Param("startTime") LocalDate startTime,
      @Param("endTime") LocalDate endTime);

  void deleteEmp(@Param("ids") List<Integer> ids);
}
