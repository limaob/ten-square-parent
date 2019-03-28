package com.ten.square.base.service;

import com.ten.square.base.pojo.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

/**
 * @Description: 标签业务逻辑接口
 * @Author: limaob
 * @CreateDate: 2019/3/26
 */
public interface LabelService {
    /**
     * 查询所有的列表
     * @return
     */
    List<Label> findAll();

    /**
     *  根据id查询标签
     * @param id
     * @return
     */
    Label findById(String id);

    /**
     * 添加标签
     * @param label
     */
    void add(Label label);

    /**
     * 修改标签
     * @param label
     */
    void update(Label label);

    /**
     * 根据id删除标签
     * @param id
     */
    void deleteById(String id);

    /**
     * 根据条件查询Label
     * @param searchMap
     * @return
     */
    public List<Label> findSearch(Map searchMap);

    public Page<Label> findSearch(Map searchMap, int page, int size);
}
