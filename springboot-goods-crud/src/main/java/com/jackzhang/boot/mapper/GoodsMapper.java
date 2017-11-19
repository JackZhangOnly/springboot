package com.jackzhang.boot.mapper;
import com.jackzhang.boot.model.Goods;

import java.util.List;
/**
 * Created by Jack
 */
public interface GoodsMapper {
    int deleteByPrimaryKey(String goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectGoods();
}