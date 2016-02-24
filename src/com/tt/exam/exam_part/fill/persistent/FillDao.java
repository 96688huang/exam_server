package com.tt.exam.exam_part.fill.persistent;

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

import com.tt.exam.exam_part.fill.bean.Fill;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class FillDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(Fill fill) {
		String sql = "insert into exam_fill(id, exam_id, content, answer, analysis, description, remark) values (?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql,
				new Object[] { id, fill.getExam_id(), fill.getContent(), fill.getAnswer(), fill.getAnalysis(),
						fill.getDescription(), fill.getRemark() });
		return addRows;
	}

	public int update(Fill fill) {
		String sql = "update exam_fill set content = ?, answer = ?, analysis = ?, remark = ? where id = ?";
		return jdbcTemplate.update(sql, new Object[] { fill.getContent(), fill.getAnswer(), fill.getAnalysis(),
				fill.getRemark(), fill.getId() });
	}

	public List<Fill> list(String exam_id) {
		String sql = "select * from exam_fill where exam_id = ? order by create_time asc";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Fill>(Fill.class),
				exam_id);
	}

	public Fill findBy(String id) {
		String sql = "select * from exam_fill where id = ?";
		List<Fill> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Fill>(Fill.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from exam_fill where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}