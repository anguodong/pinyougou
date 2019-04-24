package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @RequestMapping("findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("findPage")
    public PageResult findPage(int pageNo, int pageSize){
        return brandService.findPage(pageNo,pageSize);
    }

    @RequestMapping("save")
    public Result save(@RequestBody TbBrand tbBrand){
        try{
            brandService.save(tbBrand);
            return new Result(true,"新建成功");
        }catch (Exception e){
            return new Result(false,"新建失败");
        }
    }

    @RequestMapping("findOne")
    public TbBrand findOne(long id){
        return brandService.findOne(id);
    }

    @RequestMapping("update")
    public Result update(@RequestBody TbBrand tbBrand){
        try{
            brandService.update(tbBrand);
            return new Result(true,"编辑成功");
        }catch (Exception e){
            return new Result(false,"编辑失败");
        }
    }

    @RequestMapping("delete")
    public Result delete(@RequestBody long[] newArr){
        System.out.println(Arrays.toString(newArr));
        try{
            brandService.delete(newArr);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }

}
