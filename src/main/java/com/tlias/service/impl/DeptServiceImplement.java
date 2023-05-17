package com.tlias.service.impl;

import com.tlias.mapper.DeptMapper;
import com.tlias.pojo.Dept;
import com.tlias.pojo.PageBean;
import com.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImplement implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public PageBean<Dept> list(Integer pageNo, Integer pageSize, String name) {
        Integer start = (pageNo -1) * pageSize;
        List<Dept> list = deptMapper.list(start, pageSize, name);
        Long count = deptMapper.count();
        PageBean<Dept> deptPageBean = new PageBean<>(count, list);
        return deptPageBean;
    }
}
