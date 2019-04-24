package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        PageInfo<TbBrand> info = new PageInfo(tbBrands);
        return new PageResult(info.getTotal(),info.getList());

    }

    @Override
    public void save(TbBrand tbBrand) {
        tbBrandMapper.insertSelective(tbBrand);
    }

    @Override
    public TbBrand findOne(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKeySelective(tbBrand);
    }

    @Override
    public void delete(long[] newArr) {
        for(int i = 0;i<newArr.length;i++){
            tbBrandMapper.deleteByPrimaryKey(newArr[i]);
        }
    }
}
