package com.winter.api.client.fallback;

import cn.hutool.core.collection.CollUtil;
import com.winter.api.client.ItemClient;
import com.winter.api.dto.ItemDTO;
import com.winter.api.dto.OrderDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @program: winter-mall
 * @description: ItemClient异常失败工厂
 * @author: Mr.Ye
 * @create: 2023-12-23 20:56
 **/
@Slf4j
public class ItemClientFallbackFactory implements FallbackFactory<ItemClient> {
    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                log.error("查询商品失败，失败原因：", cause);
                return Collections.emptyList();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {
                log.error("扣减库存失败，失败原因：", cause);
                throw new RuntimeException(cause);
            }
        };
    }
}
