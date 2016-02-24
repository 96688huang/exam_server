package com.tt.exam.exam_part.essay.persistent;

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

import com.tt.exam.exam_part.essay.bean.Essay;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class EssayDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(Essay essay) {
		String sql = "insert into exam_essay(id, exam_id, content, answer, analysis, description, remark) values (?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql,
				new Object[] { id, essay.getExam_id(), essay.getContent(), essay.getAnswer(), essay.getAnalysis(),
						essay.getDescription(), essay.getRemark() });
		return addRows;
	}

	public int update(Essay essay) {
		String sql = "update exam_essay set content = ?, answer = ?, analysis = ?, remark = ? where id = ?";
		return jdbcTemplate.update(sql, new Object[] { essay.getContent(), essay.getAnswer(), essay.getAnalysis(),
				essay.getRemark(), essay.getId() });
	}

	public List<Essay> list(String exam_id) {
		String sql = "select * from exam_essay where exam_id = ? order by create_time asc";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Essay>(Essay.class),
				exam_id);
	}

	public Essay findBy(String id) {
		String sql = "select * from exam_essay where id = ?";
		List<Essay> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Essay>(Essay.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from exam_essay where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}