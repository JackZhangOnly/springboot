package com.jackzhang.boot.service.impl;

import com.jackzhang.boot.mapper.GoodsMapper;
import com.jackzhang.boot.model.Goods;
import com.jackzhang.boot.model.ResponseData;
import com.jackzhang.boot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jack
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ResponseData<Goods> findById(String goodsId) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        if (goods==null){
            return new ResponseData<Goods>().isOk(0).msg("未查到对应商品").data(null);
        }
        return new ResponseData<Goods>().isOk(1).msg("查询成功").data(goods);
    }

    @Override
    public ResponseData<List<Goods>> selectGoods() {
        List<Goods> goodsList=goodsMapper.selectGoods();
        if (goodsList==null){
            return new ResponseData<List<Goods>>().isOk(0).msg("未查到对应商品").data(null);
        }
        return new ResponseData<List<Goods>>().isOk(1).msg("查询成功").data(goodsList);
    }
}
