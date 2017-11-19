package com.jackzhang.boot.controller;

import com.github.pagehelper.PageHelper;
import com.jackzhang.boot.model.Goods;
import com.jackzhang.boot.model.ResponseData;
import com.jackzhang.boot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jack
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("hello.do")
    public String testHello(){
        return "Hello,Spring Boot";
    }

    @RequestMapping(value = "findGoodsById.do",method = RequestMethod.GET)
    public ResponseData<Goods> findGoodsById(String goodsId){
        return goodsService.findById(goodsId);
    }

    @RequestMapping(value ="/page/{pageNo}", method = RequestMethod.GET)
    public ResponseData<List<Goods>> findGoodsById(@PathVariable("pageNo")Integer pageNo){
        if (pageNo>0){
            PageHelper.startPage(pageNo,5);
        }
        return goodsService.selectGoods();
    }




}
