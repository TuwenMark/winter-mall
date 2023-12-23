package com.winter.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winter.api.dto.ItemDTO;
import com.winter.api.dto.OrderDetailDTO;
import com.winter.common.exception.BizIllegalException;
import com.winter.common.utils.BeanUtils;
import com.winter.item.domain.po.Item;
import com.winter.item.mapper.ItemMapper;
import com.winter.item.service.IItemService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author 虎哥
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Override
    public void deductStock(List<OrderDetailDTO> items) {
        String sqlStatement = "com.hmall.item.mapper.ItemMapper.updateStock";
        boolean r = false;
        try {
            r = executeBatch(items, (sqlSession, entity) -> sqlSession.update(sqlStatement, entity));
        } catch (Exception e) {
            log.error("更新库存异常", e);
            return;
        }
        if (!r) {
            throw new BizIllegalException("库存不足！");
        }
    }

    @Override
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("报错了");
        }
        return BeanUtils.copyList(listByIds(ids), ItemDTO.class);
    }
}
