package com.tt.exam.persistent.entity;

import java.io.Serializable;
import java.util.Date;

public class ExamEssay implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.exam_id
     *
     * @mbggenerated
     */
    private String examId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.modify_time
     *
     * @mbggenerated
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam_essay.answer
     *
     * @mbggenerated
     */
    private String answer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table exam_essay
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.id
     *
     * @return the value of exam_essay.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.id
     *
     * @param id the value for exam_essay.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.exam_id
     *
     * @return the value of exam_essay.exam_id
     *
     * @mbggenerated
     */
    public String getExamId() {
        return examId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.exam_id
     *
     * @param examId the value for exam_essay.exam_id
     *
     * @mbggenerated
     */
    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.content
     *
     * @return the value of exam_essay.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.content
     *
     * @param content the value for exam_essay.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.remark
     *
     * @return the value of exam_essay.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.remark
     *
     * @param remark the value for exam_essay.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.create_time
     *
     * @return the value of exam_essay.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.create_time
     *
     * @param createTime the value for exam_essay.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.modify_time
     *
     * @return the value of exam_essay.modify_time
     *
     * @mbggenerated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.modify_time
     *
     * @param modifyTime the value for exam_essay.modify_time
     *
     * @mbggenerated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam_essay.answer
     *
     * @return the value of exam_essay.answer
     *
     * @mbggenerated
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam_essay.answer
     *
     * @param answer the value for exam_essay.answer
     *
     * @mbggenerated
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}