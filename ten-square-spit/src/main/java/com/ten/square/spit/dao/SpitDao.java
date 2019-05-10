package com.ten.square.spit.dao;

import com.ten.square.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/5/9
 */
@Repository
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 根据上级ID查询吐槽列表（分页查询）
     * @param parentId 父id
     * @param pageable
     * @return
     */
    Page<Spit> findByParentId(String parentId, Pageable pageable);
}
