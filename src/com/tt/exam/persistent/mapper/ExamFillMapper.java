package com.tt.exam.persistent.mapper;

import com.tt.exam.persistent.entity.ExamFill;

public interface ExamFillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_fill
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_fill
     *
     * @mbggenerated
     */
    int insert(ExamFill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_fill
     *
     * @mbggenerated
     */
    int insertSelective(ExamFill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_fill
     *
     * @mbggenerated
     */
    ExamFill selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_fill
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ExamFill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_fill
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ExamFill record);
}