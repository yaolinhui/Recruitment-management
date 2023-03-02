package com.wk68.mapper;

import com.wk68.entity.CPost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;
import java.util.List;

public interface CPostMapper {
    @Delete({
        "delete from c_post",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer postId);

    @Insert({
        "insert into c_post (post_id, p_job_wanted_uid, ",
        "p_job_uid, p_name, ",
        "p_company_name, p_workplace, ",
        "p_type, p_monthly_pay, ",
        "p_years, p_job_nature, ",
        "p_scale, p_welfare, ",
        "p_reply, p_photo, ",
        "p_time, p_online, ",
        "p_responsibility, p_requested)",
        "values (#{postId,jdbcType=INTEGER}, #{pJobWantedUid,jdbcType=VARCHAR}, ",
        "#{pJobUid,jdbcType=VARCHAR}, #{pName,jdbcType=VARCHAR}, ",
        "#{pCompanyName,jdbcType=VARCHAR}, #{pWorkplace,jdbcType=VARCHAR}, ",
        "#{pType,jdbcType=VARCHAR}, #{pMonthlyPay,jdbcType=VARCHAR}, ",
        "#{pYears,jdbcType=VARCHAR}, #{pJobNature,jdbcType=VARCHAR}, ",
        "#{pScale,jdbcType=VARCHAR}, #{pWelfare,jdbcType=VARCHAR}, ",
        "#{pReply,jdbcType=VARCHAR}, #{pPhoto,jdbcType=VARCHAR}, ",
        "#{pTime,jdbcType=TIMESTAMP}, #{pOnline,jdbcType=VARCHAR}, ",
        "#{pResponsibility,jdbcType=LONGVARCHAR}, #{pRequested,jdbcType=LONGVARCHAR})"
    })
    int insert(CPost record);

    @InsertProvider(type=CPostSqlProvider.class, method="insertSelective")
    int insertSelective(CPost record);

    @Select({
        "select",
        "post_id, p_job_wanted_uid, p_job_uid, p_name, p_company_name, p_workplace, p_type, ",
        "p_monthly_pay, p_years, p_job_nature, p_scale, p_welfare, p_reply, p_photo, ",
        "p_time, p_online, p_responsibility, p_requested",
        "from c_post",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="p_job_wanted_uid", property="pJobWantedUid", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_job_uid", property="pJobUid", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_name", property="pName", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_company_name", property="pCompanyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_workplace", property="pWorkplace", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_type", property="pType", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_monthly_pay", property="pMonthlyPay", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_years", property="pYears", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_job_nature", property="pJobNature", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_scale", property="pScale", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_welfare", property="pWelfare", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_reply", property="pReply", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_photo", property="pPhoto", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_time", property="pTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="p_online", property="pOnline", jdbcType=JdbcType.VARCHAR),
        @Result(column="p_responsibility", property="pResponsibility", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="p_requested", property="pRequested", jdbcType=JdbcType.LONGVARCHAR)
    })
    CPost selectByPrimaryKey(Integer postId);

    @Select({
            "select",
            "post_id, p_job_wanted_uid, p_job_uid, p_name, p_company_name, p_workplace, p_type, ",
            "p_monthly_pay, p_years, p_job_nature, p_scale, p_welfare, p_reply, p_photo, ",
            "p_time, p_online, p_responsibility, p_requested",
            "from c_post"
    })
    @Results({
            @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="p_job_wanted_uid", property="pJobWantedUid", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_job_uid", property="pJobUid", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_name", property="pName", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_company_name", property="pCompanyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_workplace", property="pWorkplace", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_type", property="pType", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_monthly_pay", property="pMonthlyPay", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_years", property="pYears", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_job_nature", property="pJobNature", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_scale", property="pScale", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_welfare", property="pWelfare", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_reply", property="pReply", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_photo", property="pPhoto", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_time", property="pTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="p_online", property="pOnline", jdbcType=JdbcType.VARCHAR),
            @Result(column="p_responsibility", property="pResponsibility", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="p_requested", property="pRequested", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArrayList<CPost> selectAll();

    @UpdateProvider(type=CPostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CPost record);

    @Update({
        "update c_post",
        "set p_job_wanted_uid = #{pJobWantedUid,jdbcType=VARCHAR},",
          "p_job_uid = #{pJobUid,jdbcType=VARCHAR},",
          "p_name = #{pName,jdbcType=VARCHAR},",
          "p_company_name = #{pCompanyName,jdbcType=VARCHAR},",
          "p_workplace = #{pWorkplace,jdbcType=VARCHAR},",
          "p_type = #{pType,jdbcType=VARCHAR},",
          "p_monthly_pay = #{pMonthlyPay,jdbcType=VARCHAR},",
          "p_years = #{pYears,jdbcType=VARCHAR},",
          "p_job_nature = #{pJobNature,jdbcType=VARCHAR},",
          "p_scale = #{pScale,jdbcType=VARCHAR},",
          "p_welfare = #{pWelfare,jdbcType=VARCHAR},",
          "p_reply = #{pReply,jdbcType=VARCHAR},",
          "p_photo = #{pPhoto,jdbcType=VARCHAR},",
          "p_time = #{pTime,jdbcType=TIMESTAMP},",
          "p_online = #{pOnline,jdbcType=VARCHAR},",
          "p_responsibility = #{pResponsibility,jdbcType=LONGVARCHAR},",
          "p_requested = #{pRequested,jdbcType=LONGVARCHAR}",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(CPost record);

    @Update({
        "update c_post",
        "set p_job_wanted_uid = #{pJobWantedUid,jdbcType=VARCHAR},",
          "p_job_uid = #{pJobUid,jdbcType=VARCHAR},",
          "p_name = #{pName,jdbcType=VARCHAR},",
          "p_company_name = #{pCompanyName,jdbcType=VARCHAR},",
          "p_workplace = #{pWorkplace,jdbcType=VARCHAR},",
          "p_type = #{pType,jdbcType=VARCHAR},",
          "p_monthly_pay = #{pMonthlyPay,jdbcType=VARCHAR},",
          "p_years = #{pYears,jdbcType=VARCHAR},",
          "p_job_nature = #{pJobNature,jdbcType=VARCHAR},",
          "p_scale = #{pScale,jdbcType=VARCHAR},",
          "p_welfare = #{pWelfare,jdbcType=VARCHAR},",
          "p_reply = #{pReply,jdbcType=VARCHAR},",
          "p_photo = #{pPhoto,jdbcType=VARCHAR},",
          "p_time = #{pTime,jdbcType=TIMESTAMP},",
          "p_online = #{pOnline,jdbcType=VARCHAR}",
        "where post_id = #{postId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CPost record);
}