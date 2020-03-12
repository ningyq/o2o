package com.nzyjfw.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dao.GoodSetDao;
import com.nzyjfw.o2o.dao.OrderDao;
import com.nzyjfw.o2o.entity.GoodSet;
import com.nzyjfw.o2o.entity.Order;
import com.nzyjfw.o2o.service.GoodSetService;
import com.nzyjfw.o2o.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@Service("orderService")
@Transactional(rollbackFor=Exception.class)
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private GoodSetDao goodSetDao;

    @Resource
    private GoodSetService goodSetService;

    @Override
    public Order findByOrderId(String orderId) {
        Order order = orderDao.findByOrderId(orderId);
        if (order == null) {
            return null;
        }
        order.setGoodSetList(goodSetService.findByOrderId(orderId));
        return order;
    }

    @Override
    public List<Order> findByUserId(int userId) {
        List<Order> orderList = orderDao.findByUserId(userId);
        for (Order order : orderList) {
            order.setGoodSetList(goodSetService.findByOrderId(order.getId()));
        }
        return orderList;
    }

    @Override
    public boolean add(Order order) {
        List<GoodSet> goodSetList = order.getGoodSetList();
        int oInt = orderDao.insertSelective(order);
        int gInt = goodSetDao.insertList(goodSetList);
        return (oInt | gInt) > 0;
    }

    @Override
    public int selectCount() {
        return orderDao.count();
    }

    @Override
    public PageInfo<Order> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderDao.all();
        for (Order order : orderList) {
            order.setGoodSetList(goodSetService.findByOrderId(order.getId()));
        }
        return new PageInfo<>(orderList);
    }

    @Override
    public boolean cancel(String orderId) {
        Order order = findByOrderId(orderId);
        order.setStatus(-1);
        return update(order);
    }

    @Override
    public boolean update(Order order) {
        return orderDao.updateByPrimaryKeySelective(order) > 0;
    }
}