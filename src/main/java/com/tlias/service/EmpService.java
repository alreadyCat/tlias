package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.PageBean;

import java.util.List;

public interface EmpService {

    PageBean<Emp> list(String name ,Integer pageNo, Integer pageSize);
}
