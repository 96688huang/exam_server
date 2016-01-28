package com.tt.exam.examinee.persistent;

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

import com.tt.exam.examinee.bean.Examinee;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ExamineeDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(Examinee examinee) {
		//		String id = UUID.randomUUID().toString();
		//		String sql = "insert into examinee(id, account, password, name) values ('" + id + "','" + examinee.getAccount()
		//				+ "','" + examinee.getPassword() + "','" + examinee.getName() + "')";
		//		jdbcTemplate.execute(sql);

		String sql = "insert into examinee(id, account, password, name) values (?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql, new Object[] { id, examinee.getAccount(), examinee.getPassword(),
				examinee.getName() });
		return addRows;

		//		String sql = "insert into examinee(id, account, password, name) values (:id, :account, :password, :name)";
		//		KeyHolder keyHolder = new GeneratedKeyHolder();
		//		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(examinee), keyHolder);
		//		return keyHolder.getKey().intValue();
	}

	public int update(Examinee examinee) {
		String sql = "update examinee set account = ?, password = ?, name = ? where id = ?";
		return jdbcTemplate.update(sql,
				new Object[] { examinee.getAccount(), examinee.getPassword(), examinee.getName(), examinee.getId() });
	}

	public List<Examinee> list() {
		String sql = "select * from examinee where 1=1 ";
		return namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Examinee>(Examinee.class));
	}

	public Examinee findBy(String id) {
		String sql = "select * from examinee where id = ?";
		List<Examinee> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Examinee>(Examinee.class), id);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public Examinee findBy(String account, String pwdMd5) {
		String sql = "select * from examinee where account = ? and password = ? limit 1";
		List<Examinee> result = namedParameterJdbcTemplate.getJdbcOperations().query(sql,
				new BeanPropertyRowMapper<Examinee>(Examinee.class), account, pwdMd5);
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(0);
	}

	public int delete(String id) {
		String sql = "delete from examinee where id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
}