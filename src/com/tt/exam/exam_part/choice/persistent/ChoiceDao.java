package com.tt.exam.exam_part.choice.persistent;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tt.exam.exam_part.choice.bean.Choice;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ChoiceDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(Choice choice) {
		String sql = "insert into exam_choice(id, exam_id, content, options, answer, analysis, description, remark) values (?,?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql,
				new Object[] { id, choice.getExam_id(), choice.getContent(), choice.getOptions(), choice.getAnswer(),
						choice.getAnalysis(), choice.getDescription(), choice.getRemark() });
		return addRows;
	}

	public int update(Choice choice) {
		String sql = "update exam_choice set content = ?, answer = ?, analysis = ?, remark = ? where id = ?";
		return jdbcTemplate.update(sql, new Object[] { choice.getContent(), choice.getAnswer(), choice.getAnalysis(),
				choice.getRemark(), choice.getId() });
	}

	public List<Choice> list(String exam_id) {
		String sql = "select * from exam_choice where exam_id = ? ";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Choice>(Choice.class), exam_id);
	}

	public Choice findBy(String id) {
		String sql = "select * from exam_choice where id = ?";
		List<Choice> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Choice>(Choice.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from choice where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}