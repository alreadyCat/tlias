package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;
import com.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImplement implements EmpService {
  @Autowired private EmpMapper empMapper;

  @Override
  public PageBean<Emp> list(
      String name,
      Integer pageNo,
      Integer pageSize,
      Short gender,
      LocalDate startTime,
      LocalDate endTime) {

    PageHelper.startPage(pageNo, pageSize);

    List<Emp> empList = empMapper.list(name, gender, startTime, endTime);
    Page<Emp> p = (Page<Emp>) empList;

    PageBean<Emp> empPageBean = new PageBean<Emp>(p.getTotal(), p.getResult());
    return empPageBean;
  }

  @Override
  public void deleteEmp(List<Integer> ids) {
    empMapper.deleteEmp(ids);
  }
}
