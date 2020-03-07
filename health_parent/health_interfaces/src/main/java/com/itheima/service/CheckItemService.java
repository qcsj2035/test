package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

public interface CheckItemService {
        //新增检查项
        public void add(CheckItem checkItem);
        //检查项分页查询
        public PageResult pageQuery(QueryPageBean queryPageBean);
        //删除检查项
        public void deleteById(Integer id);
        //编辑检查项
        public   void edit(CheckItem checkItem);
        //回显数据
        public CheckItem findById(Integer id);
}
