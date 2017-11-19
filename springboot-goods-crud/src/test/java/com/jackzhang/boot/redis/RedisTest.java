package com.jackzhang.boot.redis;

import com.jackzhang.boot.SpringbootGoodsCrudApplicationTests;
import com.jackzhang.boot.model.Goods;

import org.junit.Test;


public class RedisTest extends SpringbootGoodsCrudApplicationTests {

    @Test
    public void setValue(){
        Goods goods = new Goods();
        goods.setGoodsId("11111111111124455");
        goods.setName("商品1");
        goods.setTypeId("1");
        goods.setDescription("===============");
        RedisUtils.set("goods1", goods, 10000L);
    }

    @Test
    public void getValue(){
        System.out.println("====getValue====" + RedisUtils.get("goods1"));
    }
}
