package com.hhf.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by cw on 2018/7/30.
 */
@Slf4j
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Dept {

    //主键
    private Long deptno;
    //部门名称
    private String 	dname;
    //来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库。
    private String 	db_source;

    public Dept(String dname)
    {
        super();
        this.dname = dname;
    }

}
