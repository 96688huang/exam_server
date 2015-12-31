package com.tt.exam.persistent.entity;

import java.io.Serializable;
import java.util.Date;

public class ExamJudge implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.exam_id
     *
     * @mbggenerated
     */
    private String examId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.answer
     *
     * @mbggenerated
     */
    private String answer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_judge.modify_time
     *
     * @mbggenerated
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table exam_judge
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.id
     *
     * @return the value of exam_judge.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.id
     *
     * @param id the value for exam_judge.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.exam_id
     *
     * @return the value of exam_judge.exam_id
     *
     * @mbggenerated
     */
    public String getExamId() {
        return examId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.exam_id
     *
     * @param examId the value for exam_judge.exam_id
     *
     * @mbggenerated
     */
    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.content
     *
     * @return the value of exam_judge.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.content
     *
     * @param content the value for exam_judge.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.answer
     *
     * @return the value of exam_judge.answer
     *
     * @mbggenerated
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.answer
     *
     * @param answer the value for exam_judge.answer
     *
     * @mbggenerated
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.remark
     *
     * @return the value of exam_judge.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.remark
     *
     * @param remark the value for exam_judge.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.create_time
     *
     * @return the value of exam_judge.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.create_time
     *
     * @param createTime the value for exam_judge.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_judge.modify_time
     *
     * @return the value of exam_judge.modify_time
     *
     * @mbggenerated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_judge.modify_time
     *
     * @param modifyTime the value for exam_judge.modify_time
     *
     * @mbggenerated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}