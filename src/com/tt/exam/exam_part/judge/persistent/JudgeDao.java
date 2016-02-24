package com.tt.exam.exam_part.judge.persistent;

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

import com.tt.exam.exam_part.judge.bean.Judge;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class JudgeDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(Judge judge) {
		String sql = "insert into exam_judge(id, exam_id, content, answer, analysis, description, remark) values (?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql,
				new Object[] { id, judge.getExam_id(), judge.getContent(), judge.getAnswer(), judge.getAnalysis(),
						judge.getDescription(), judge.getRemark() });
		return addRows;
	}

	public int update(Judge judge) {
		String sql = "update exam_judge set content = ?, answer = ?, analysis = ?, remark = ? where id = ?";
		return jdbcTemplate.update(sql, new Object[] { judge.getContent(), judge.getAnswer(), judge.getAnalysis(),
				judge.getRemark(), judge.getId() });
	}

	public List<Judge> list(String exam_id) {
		String sql = "select * from exam_judge where exam_id = ? order by create_time asc";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Judge>(Judge.class),
				exam_id);
	}

	public Judge findBy(String id) {
		String sql = "select * from exam_judge where id = ?";
		List<Judge> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Judge>(Judge.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from exam_judge where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}