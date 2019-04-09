package com.ten.square.article.qa.recruit.dao;

import com.ten.square.qa.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * recruit数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    /**
     * 最新职位列表
     * @return
     */
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);

    /**
     * 推荐职位列表
     * @param state
     * @return
     */
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);
}
