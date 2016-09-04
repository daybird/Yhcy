package com.s.yhcy.dao;

import com.s.yhcy.entity.Gsxd;
import com.s.yhcy.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PawN on 2016/9/4.
 */
public class GsxdDao {

    public static List<Gsxd> queryAll() {
        List<Gsxd> list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            Gsxd gsxd = new Gsxd();
            gsxd.setZhang(new Item("第一章", "公司信贷"));
            gsxd.setJie(new Item("1.1", "公司信贷基础"));
            gsxd.setXiaoJie(new Item("1.1.1", "公司信贷相关概念"));
            gsxd.setNeiRong(new Item(i + " : 信贷", "信贷指一切以实现承诺为条件的价值运动形式，包括存款、贷款、担保、承兑、赊欠等活动。"));
            list.add(gsxd);
        }
        return list;
    }
}
