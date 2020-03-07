package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public  class CheckItemServiceImpl implements CheckItemService {
    //注入dao对象
    @Autowired
    private CheckItemDao checkItemDao;
    //新增检查项
    public void add(CheckItem checkItem) {

        checkItemDao.add(checkItem);
    }



    //检查项分页查询

    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //完成分页查询，基于mybatis框架提供分页插件完成
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();

        return new PageResult(total,rows);
    }

    @Override
    public void deleteById(Integer id) {
       //判断当前的检查项是否已经关联到检查组
        long count = checkItemDao.findCountByCheckItemId(id);
        if (count>0){
            //当前的检查项已经被检查组关联，不允许删除
            new RuntimeException();
        }
        checkItemDao.deleteById(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
            checkItemDao.edit(checkItem);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

}
