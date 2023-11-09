package com.example.its.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAll();

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("select * from issues where id = #{issueId}")
    IssueEntity findById(long issueId);

    // 編集
    @Update("update issues set summary = #{summary}, description = #{description} where id = #{issueId}")
    void update(String summary, String description, long issueId);

    // 削除
    @Delete("delete from issues where id = #{issueId}")
    void deleteById(long issueId);

}
