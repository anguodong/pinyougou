package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {
    public List<TbBrand> findAll();

    PageResult findPage(int pageNo, int pageSize);

    void save(TbBrand tbBrand);

    TbBrand findOne(long id);

    void update(TbBrand tbBrand);

    void delete(long[] newArr);
}
