package com.ten.square.spit.service;

import com.ten.square.spit.pojo.Spit;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/5/9
 */
public interface SpitService {

    List<Spit> findAll();

    Spit findById(String id);

    void add(Spit spit);

    void update(Spit spit);

    void deleteById(String id);

    Page<Spit> findByParentId(String parentid, int page, int size);

    void updateThumbUp(String id);
}
