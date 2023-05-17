package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer pageNo,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(required = false) String name){
        log.info("查询全部部门数据");

        PageBean<Dept> data = deptService.list(pageNo, pageSize, name);
        return Result.success(data);
    }
}
