package com.zhangyiming.mapper;

import com.zhangyiming.dto.Goods;
import com.zhangyiming.utils.MyMapper;

import java.util.List;

public interface GoodsMapper extends MyMapper<Goods> {

    List<Goods> get(Goods goods);

}