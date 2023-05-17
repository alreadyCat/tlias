package com.tlias.service;

import com.tlias.pojo.Dept;
import com.tlias.pojo.PageBean;

import java.util.List;

public interface DeptService {
    public PageBean<Dept> list(Integer start, Integer pageSize, String name);
}
