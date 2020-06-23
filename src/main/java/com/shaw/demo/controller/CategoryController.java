package com.shaw.demo.controller;

import com.shaw.demo.common.CommonResult;
import com.shaw.demo.model.InfoSort;
import com.shaw.demo.service.ArticleInfoService;
import com.shaw.demo.service.ArticleSortService;
import com.shaw.demo.service.InfoSortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Category Controller")
@RequestMapping(value = "/category")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private InfoSortService infoSortService;

    @Autowired
    private ArticleSortService articleSortService;

    @Autowired
    private ArticleInfoService articleInfoService;

    @ApiOperation("Create a new category.")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public CommonResult createSort(@RequestBody InfoSort infoSort){
        infoSortService.createInfoSort(infoSort);
        return CommonResult.success(infoSort, "");
    }

    @ApiOperation("List all categories.")
    @RequestMapping(value = "/listSort", method = RequestMethod.GET)
    public CommonResult listSort(){
        return CommonResult.success(infoSortService.listAll(), "");
    }

    @ApiOperation("Delete category by id.")
    @RequestMapping(value = "/deleteSort/{id}", method = RequestMethod.DELETE)
    public CommonResult deleteSort(@PathVariable long id){
        if(infoSortService.findById(id) == null){
            return CommonResult.failed("No such sort.");
        }
        infoSortService.deleteInfoSort(id);
        return CommonResult.success(null,"");
    }

    @ApiOperation("Get category by id.")
    @RequestMapping(value = "/getSort/{id}", method = RequestMethod.GET)
    public CommonResult getSort(@PathVariable long id) {
        InfoSort result = infoSortService.findById(id);
        if (result == null) {
            return CommonResult.failed("No such sort");
        }
        return CommonResult.success(result, "");
    }

    @ApiOperation("Update category by id.")
    @RequestMapping(value = "/updateSort/{id}", method = RequestMethod.PUT)
    public CommonResult updateSort(@PathVariable long id, @RequestBody InfoSort infoSort){
        infoSortService.modifyInfoSort(id, infoSort);
        return CommonResult.success(infoSort, String.format("Update {} sort.", id));
    }
}
