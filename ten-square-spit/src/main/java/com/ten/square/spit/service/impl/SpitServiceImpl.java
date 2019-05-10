package com.ten.square.spit.service.impl;

import com.ten.square.spit.dao.SpitDao;
import com.ten.square.spit.pojo.Spit;
import com.ten.square.spit.service.SpitService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import uitl.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: limaob
 * @CreateDate: 2019/5/9
 */
@Service
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有Spit实体
     *
     * @return
     */
    @Override
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键id查询Spit实体
     *
     * @param id id
     * @return
     */
    @Override
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    /**
     * 发布吐槽评论
     *
     * @param spit
     */
    @Override
    public void add(Spit spit) {
        spit.set_id(String.valueOf(idWorker.nextId()));
        spit.setPublishtime(new Date());
        // 浏览量
        spit.setVisits(0);
        // 分享数
        spit.setShare(0);
        // 点赞数
        spit.setThumbup(0);
        // 回复数
        spit.setComment(0);
        // 状态
        spit.setState("1");
        if (StringUtils.isBlank(spit.getParentid())){
            // 存在父id评论
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        spitDao.save(spit);
    }

    /**
     * 根据id 修改spit 实体
     *
     * @param spit
     */
    @Override
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     *
     * @param parentId 父id
     * @param page     页面
     * @param size     页面大小
     * @return
     */
    @Override
    public Page<Spit> findByParentId(String parentId, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page - 1, size);

        return spitDao.findByParentId(parentId, pageRequest);
    }

    /**
     * 点赞
     *
     * @param id
     */
    @Override
    public void updateThumbUp(String id) {
        /*Spit spit = spitDao.findById(id).get();
        spit.setThumbup(spit.getThumbup()+1);
        spitDao.save(spit);*/
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }
}
