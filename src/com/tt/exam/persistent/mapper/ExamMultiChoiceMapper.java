package com.tt.exam.persistent.mapper;

import com.tt.exam.persistent.entity.ExamMultiChoice;

public interface ExamMultiChoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_multi_choice
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_multi_choice
     *
     * @mbggenerated
     */
    int insert(ExamMultiChoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_multi_choice
     *
     * @mbggenerated
     */
    int insertSelective(ExamMultiChoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_multi_choice
     *
     * @mbggenerated
     */
    ExamMultiChoice selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_multi_choice
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ExamMultiChoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exam_multi_choice
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ExamMultiChoice record);
}