package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
  @Autowired EmpService empService;

  @GetMapping
  public Result emps(
      String name,
      Short gender,
      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startTime,
      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime,
      @RequestParam(defaultValue = "1") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    PageBean<Emp> data = empService.list(name, pageNo, pageSize,gender,startTime,endTime);
    return Result.success(data);
  }

  @DeleteMapping("/{ids}")
  public Result deleteEmps(@PathVariable List<Integer>ids){
    empService.deleteEmp(ids);
    return Result.success();
  }
}
