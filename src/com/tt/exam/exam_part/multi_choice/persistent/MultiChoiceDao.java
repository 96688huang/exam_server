package com.tt.exam.exam_part.multi_choice.persistent;

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

import com.tt.exam.exam_part.multi_choice.bean.MultiChoice;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class MultiChoiceDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(MultiChoice multiChoice) {
		String sql = "insert into exam_multi_choice(id, exam_id, content, options, answer, analysis, description, remark) values (?,?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(
				sql,
				new Object[] { id, multiChoice.getExam_id(), multiChoice.getContent(), multiChoice.getOptions(),
						multiChoice.getAnswer(), multiChoice.getAnalysis(), multiChoice.getDescription(),
						multiChoice.getRemark() });
		return addRows;
	}

	public int update(MultiChoice multiChoice) {
		String sql = "update exam_multi_choice set content = ?, answer = ?, analysis = ?, remark = ? where id = ?";
		return jdbcTemplate.update(sql,
				new Object[] { multiChoice.getContent(), multiChoice.getAnswer(), multiChoice.getAnalysis(),
						multiChoice.getRemark(), multiChoice.getId() });
	}

	public List<MultiChoice> list(String exam_id) {
		String sql = "select * from exam_multi_choice where exam_id = ? order by create_time asc";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<MultiChoice>(MultiChoice.class), exam_id);
	}

	public MultiChoice findBy(String id) {
		String sql = "select * from exam_multi_choice where id = ?";
		List<MultiChoice> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<MultiChoice>(MultiChoice.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from exam_multi_choice where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}