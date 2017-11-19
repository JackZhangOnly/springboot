package com.jackzhang.boot.service;

import com.jackzhang.boot.model.Goods;
import com.jackzhang.boot.model.ResponseData;

import java.util.List;

/**
 * Created by Jack
 */
public interface GoodsService {
    public ResponseData<Goods> findById(String goodsId);
    public ResponseData<List<Goods>> selectGoods();
}
