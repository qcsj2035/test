package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

public interface CheckItemService {
        //新增检查项
        public void add(CheckItem checkItem);
        //检查项分页查询
        public PageResult pageQuery(QueryPageBean queryPageBean);
}
