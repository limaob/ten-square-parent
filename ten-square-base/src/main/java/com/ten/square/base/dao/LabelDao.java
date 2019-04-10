package com.ten.square.base.dao;

import com.ten.square.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:    标签数据的访问接口
 *                  JpaRepository提供了基本的增删改查
 *                  JpaSpecificationExecutor用于做复杂的条件查询
 * @Author: limaob
 * @CreateDate: 2019/3/26
 */
public interface LabelDao extends
        JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {


}
