package com.hhf.springcloud.service;

import com.hhf.springcloud.model.Dept;

import java.util.List;

/**
 * Created by cw on 2018/7/30.
 */
public interface DeptService {


    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
