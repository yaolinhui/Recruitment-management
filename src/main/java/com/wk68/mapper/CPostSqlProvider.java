package com.wk68.mapper;

import com.wk68.entity.CPost;
import org.apache.ibatis.jdbc.SQL;

public class CPostSqlProvider {

    public String insertSelective(CPost record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("c_post");
        
        if (record.getPostId() != null) {
            sql.VALUES("post_id", "#{postId,jdbcType=INTEGER}");
        }
        
        if (record.getpJobWantedUid() != null) {
            sql.VALUES("p_job_wanted_uid", "#{pJobWantedUid,jdbcType=VARCHAR}");
        }
        
        if (record.getpJobUid() != null) {
            sql.VALUES("p_job_uid", "#{pJobUid,jdbcType=VARCHAR}");
        }
        
        if (record.getpName() != null) {
            sql.VALUES("p_name", "#{pName,jdbcType=VARCHAR}");
        }
        
        if (record.getpCompanyName() != null) {
            sql.VALUES("p_company_name", "#{pCompanyName,jdbcType=VARCHAR}");
        }
        
        if (record.getpWorkplace() != null) {
            sql.VALUES("p_workplace", "#{pWorkplace,jdbcType=VARCHAR}");
        }
        
        if (record.getpType() != null) {
            sql.VALUES("p_type", "#{pType,jdbcType=VARCHAR}");
        }
        
        if (record.getpMonthlyPay() != null) {
            sql.VALUES("p_monthly_pay", "#{pMonthlyPay,jdbcType=VARCHAR}");
        }
        
        if (record.getpYears() != null) {
            sql.VALUES("p_years", "#{pYears,jdbcType=VARCHAR}");
        }
        
        if (record.getpJobNature() != null) {
            sql.VALUES("p_job_nature", "#{pJobNature,jdbcType=VARCHAR}");
        }
        
        if (record.getpScale() != null) {
            sql.VALUES("p_scale", "#{pScale,jdbcType=VARCHAR}");
        }
        
        if (record.getpWelfare() != null) {
            sql.VALUES("p_welfare", "#{pWelfare,jdbcType=VARCHAR}");
        }
        
        if (record.getpReply() != null) {
            sql.VALUES("p_reply", "#{pReply,jdbcType=VARCHAR}");
        }
        
        if (record.getpPhoto() != null) {
            sql.VALUES("p_photo", "#{pPhoto,jdbcType=VARCHAR}");
        }
        
        if (record.getpTime() != null) {
            sql.VALUES("p_time", "#{pTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getpOnline() != null) {
            sql.VALUES("p_online", "#{pOnline,jdbcType=VARCHAR}");
        }
        
        if (record.getpResponsibility() != null) {
            sql.VALUES("p_responsibility", "#{pResponsibility,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getpRequested() != null) {
            sql.VALUES("p_requested", "#{pRequested,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CPost record) {
        SQL sql = new SQL();
        sql.UPDATE("c_post");
        
        if (record.getpJobWantedUid() != null) {
            sql.SET("p_job_wanted_uid = #{pJobWantedUid,jdbcType=VARCHAR}");
        }
        
        if (record.getpJobUid() != null) {
            sql.SET("p_job_uid = #{pJobUid,jdbcType=VARCHAR}");
        }
        
        if (record.getpName() != null) {
            sql.SET("p_name = #{pName,jdbcType=VARCHAR}");
        }
        
        if (record.getpCompanyName() != null) {
            sql.SET("p_company_name = #{pCompanyName,jdbcType=VARCHAR}");
        }
        
        if (record.getpWorkplace() != null) {
            sql.SET("p_workplace = #{pWorkplace,jdbcType=VARCHAR}");
        }
        
        if (record.getpType() != null) {
            sql.SET("p_type = #{pType,jdbcType=VARCHAR}");
        }
        
        if (record.getpMonthlyPay() != null) {
            sql.SET("p_monthly_pay = #{pMonthlyPay,jdbcType=VARCHAR}");
        }
        
        if (record.getpYears() != null) {
            sql.SET("p_years = #{pYears,jdbcType=VARCHAR}");
        }
        
        if (record.getpJobNature() != null) {
            sql.SET("p_job_nature = #{pJobNature,jdbcType=VARCHAR}");
        }
        
        if (record.getpScale() != null) {
            sql.SET("p_scale = #{pScale,jdbcType=VARCHAR}");
        }
        
        if (record.getpWelfare() != null) {
            sql.SET("p_welfare = #{pWelfare,jdbcType=VARCHAR}");
        }
        
        if (record.getpReply() != null) {
            sql.SET("p_reply = #{pReply,jdbcType=VARCHAR}");
        }
        
        if (record.getpPhoto() != null) {
            sql.SET("p_photo = #{pPhoto,jdbcType=VARCHAR}");
        }
        
        if (record.getpTime() != null) {
            sql.SET("p_time = #{pTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getpOnline() != null) {
            sql.SET("p_online = #{pOnline,jdbcType=VARCHAR}");
        }
        
        if (record.getpResponsibility() != null) {
            sql.SET("p_responsibility = #{pResponsibility,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getpRequested() != null) {
            sql.SET("p_requested = #{pRequested,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("post_id = #{postId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}