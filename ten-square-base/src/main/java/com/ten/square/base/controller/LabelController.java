package com.ten.square.base.controller;

import com.ten.square.base.pojo.Label;
import com.ten.square.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 标签控制层
 * @Author: limaob
 * @CreateDate: 2019/3/26
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "success", labelService.findAll());
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "success", labelService.findById(id));
    }

    @PostMapping
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "success");
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Label label, @PathVariable String id) {
        labelService.update(label);
        return new Result(true, StatusCode.OK, "success");
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "success");
    }


    @GetMapping("/search")
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "success"
                , labelService.findSearch(searchMap));
    }


    @GetMapping("/search/{page}/{size}")
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Label> labels = labelService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "success"
                , new PageResult<Label>(labels.getTotalElements(), labels.getContent()));
    }

}
