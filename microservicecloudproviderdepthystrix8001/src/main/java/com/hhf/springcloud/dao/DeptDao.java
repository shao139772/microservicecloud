package com.hhf.springcloud.dao;

import com.hhf.springcloud.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cw on 2018/7/30.
 */
@Mapper
public interface DeptDao {


    public Dept findById(Long id);

    public List<Dept> findAll();

    public boolean addDept(Dept dept);
}
