package com.tt.exam.examinee.persistent;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tt.exam.examinee.bean.Examinee;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ExamineeDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void add(Examinee examinee) {
		String id = UUID.randomUUID().toString();
		String sql = "insert into examinee(id, account, password, name) values ('" + id + "','" + examinee.getAccount()
				+ "','" + examinee.getPassword() + "','" + examinee.getName() + "')";
		jdbcTemplate.execute(sql);

		//		String sql = "insert into examinee(id, account, password, name) values (?,?,?,?)";
		//		String id = UUID.randomUUID().toString();
		//		int addRows = jdbcTemplate.update(sql, new Object[] { id, examinee.getAccount(), examinee.getPassword(),
		//				examinee.getName() });
		//		return addRows;

		//		String sql = "insert into examinee(id, account, password, name) values (:id, :account, :password, :name)";
		//		KeyHolder keyHolder = new GeneratedKeyHolder();
		//		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(examinee), keyHolder);
		//		return keyHolder.getKey().intValue();
	}
}