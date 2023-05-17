package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emps")
public class EmpController {
  @Autowired EmpService empService;

  @GetMapping
  public Result emps(
      @RequestParam(required = false) String name,
      @RequestParam(defaultValue = "1") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    PageBean<Emp> data = empService.list(name, pageNo, pageSize);
    return Result.success(data);
  }
}
