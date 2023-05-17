package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean<Emp> list(String name , Integer pageNo, Integer pageSize, Short gender, LocalDate startTime,LocalDate endTime);

    void deleteEmp(List<Integer> ids);
}
