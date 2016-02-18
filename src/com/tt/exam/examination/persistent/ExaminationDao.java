package com.tt.exam.examination.persistent;

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

import com.tt.exam.examination.bean.Examination;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ExaminationDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(Examination examination) {
		String sql = "insert into examination(id, category_id, name, description) values (?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql, new Object[] { id, examination.getCategory_id(), examination.getName(),
				examination.getDescription() });
		return addRows;
	}

	public int update(Examination examination) {
		String sql = "update examination set name = ?, description = ? where id = ?";
		return jdbcTemplate.update(sql,
				new Object[] { examination.getName(), examination.getDescription(), examination.getId() });
	}

	public List<Examination> list(String category_id) {
		String sql = "select * from examination where category_id = ? ";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Examination>(Examination.class), category_id);
	}

	public Examination findBy(String id) {
		String sql = "select * from examination where id = ?";
		List<Examination> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Examination>(Examination.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from examination where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}