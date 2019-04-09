package com.ten.square.article.qa.base.service.impl;

import com.ten.square.qa.base.dao.LabelDao;
import com.ten.square.qa.base.pojo.Label;
import com.ten.square.qa.base.service.LabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 标签业务逻辑类
 * @Author: limaob
 * @CreateDate: 2019/3/26
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDao labelDao;

    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void add(Label label) {
        labelDao.save(label);
    }

    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    @Override
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }


    @Override
    public List<Label> findSearch(Map searchMap) {

        return labelDao.findAll(createSpecification(searchMap));
    }

    /**
     * 根据条件组合查询
     *
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                String labelname = (String) searchMap.get("labelname");
                if (StringUtils.isNotBlank(labelname)) {
                    // label模糊查询
                    predicates.add(criteriaBuilder.like(root.get("labelname").as(String.class),
                            "%" + labelname + "%"));
                }
                String state = (String) searchMap.get("state");
                if (StringUtils.isNotBlank(state)) {
                    predicates.add(criteriaBuilder.equal(root.get("state").as(String.class), state));
                }
                String remcommend = (String) searchMap.get("remcommend");
                if (StringUtils.isNotBlank(remcommend)) {
                    predicates.add(criteriaBuilder.equal(root.get("remcommend").as(String.class), remcommend));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    @Override
    public Page<Label> findSearch(Map searchMap, int page, int size) {
        return labelDao.findAll(createSpecification(searchMap), PageRequest.of(page, size));
    }
}
