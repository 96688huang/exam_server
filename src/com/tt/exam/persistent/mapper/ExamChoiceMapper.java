package com.tt.exam.persistent.mapper;

import com.tt.exam.persistent.entity.ExamChoice;

public interface ExamChoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_choice
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_choice
     *
     * @mbggenerated
     */
    int insert(ExamChoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_choice
     *
     * @mbggenerated
     */
    int insertSelective(ExamChoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_choice
     *
     * @mbggenerated
     */
    ExamChoice selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_choice
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ExamChoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_choice
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ExamChoice record);
}