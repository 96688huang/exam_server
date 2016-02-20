package com.tt.exam.exam_category.persistent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tt.exam.exam_category.bean.ExamCategory;

@Component
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ExamCategoryDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int add(ExamCategory examCategory) {
		String sql = "insert into exam_category(id, owner_id, parent_id, name, description) values (?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		int addRows = jdbcTemplate.update(sql,
				new Object[] { id, examCategory.getOwner_id(), examCategory.getParent_id(), examCategory.getName(),
						examCategory.getDescription() });
		return addRows;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(ExamCategory examCategory) {
		String sql = "update exam_category set name = ?, description = ? where id = ?";
		return jdbcTemplate.update(sql, new Object[] { examCategory.getName(), examCategory.getDescription(),
				examCategory.getId() });
	}

	public List<ExamCategory> list(ExamCategory examCategory) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(100);
		sql.append("select * from exam_category where 1=1 ");
		if (StringUtils.isNotBlank(examCategory.getId())) {
			sql.append(" and id = ? ");
			paramList.add(examCategory.getId());
		}

		if (StringUtils.isNotBlank(examCategory.getOwner_id())) {
			sql.append(" and owner_id = ? ");
			paramList.add(examCategory.getOwner_id());
		}

		if (StringUtils.isNotBlank(examCategory.getName())) {
			sql.append(" and name like '%?%' ");
			paramList.add(examCategory.getName());
		}

		if (StringUtils.isNotBlank(examCategory.getDescription())) {
			sql.append(" and description like '%?%' ");
			paramList.add(examCategory.getDescription());
		}
		sql.append(" order by modify_time desc");

		Object[] paramArr = new Object[paramList.size()];
		paramList.toArray(paramArr);

		return namedParameterJdbcTemplate.getJdbcOperations().query(sql.toString(),
				new BeanPropertyRowMapper<ExamCategory>(ExamCategory.class), paramArr);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete(String id, String ownerId) {
		String sql = "delete from exam_category where id = ? and owner_id = ?";
		return jdbcTemplate.update(sql, new Object[] { id, ownerId });
	}
}