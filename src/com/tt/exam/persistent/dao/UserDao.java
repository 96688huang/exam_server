package com.tt.exam.persistent.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tt.exam.persistent.entity.User;
import com.tt.exam.persistent.mapper.UserMapper;

@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserDao {

	@Resource
	private UserMapper userMapper;

	/**
	 * 查询视频列表: 仅查询简要的数据
	 */
	public List<User> listBrief(int page, int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		int offset = (page - 1) * count;
		params.put("offset", offset);
		params.put("count", count);
		return userMapper.findBriefBy(params);
	}

	/**
	 * 查询视频列表: 排除大数据量的字段
	 */
	public List<User> listExceptBigData(Integer sourceId, int page, int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		int offset = (page - 1) * count;
		params.put("sourceId", sourceId);
		params.put("offset", offset);
		params.put("count", count);
		return userMapper.findExceptBigDataBy(params);
	}

	/**
	 * 查询视频列表: 排除大数据量的字段
	 */
	public List<User> listExceptBigData(Integer sourceId, String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sourceId", sourceId);

		if (StringUtils.isNotBlank(name)) {
			params.put("name", name);
		}
		params.put("offset", 0);
		params.put("count", Integer.MAX_VALUE);
		return userMapper.findExceptBigDataBy(params);
	}

	/**
	 * 查询视频列表: 查询视频的所有的数据
	 */
	public List<User> list(int page, int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		int offset = (page - 1) * count;
		params.put("offset", offset);
		params.put("count", count);
		return userMapper.findBy(params);
	}

	/**
	 * 根据名称, 查询简要信息
	 * @param name
	 * @return
	 */
	public List<User> searchBriefByName(Integer sourceId, String name) {
		return findBriefBy(sourceId, null, name, null);
	}

	/**
	 * 根据名称, 查询简要信息
	 * @param name
	 * @return
	 */
	public List<User> searchBriefByName(String name) {
		return findBriefBy(null, null, name, null);
	}

	/**
	 * 根据条件, 查询简要信息
	 * @param name
	 * @return
	 */
	public List<User> findBriefByListPageUrl(Integer sourceId, String listPageUrl) {
		return findBriefBy(sourceId, null, null, listPageUrl, 1, Integer.MAX_VALUE);
	}

	/**
	 * 根据条件, 查询简要信息
	 * @param name
	 * @return
	 */
	public List<User> findBriefBy(Integer sourceId, String firstChar, String name, String listPageUrl) {
		return findBriefBy(sourceId, firstChar, name, listPageUrl, 1, Integer.MAX_VALUE);
	}

	/**
	 * 根据条件, 查询简要信息
	 * @param name	名称
	 * @param page	查询页码
	 * @param count	查询数量
	 * @return
	 */
	public List<User> findBriefBy(Integer sourceId, String firstChar, String name, String listPageUrl, int page,
			int count) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sourceId", sourceId);

		if (StringUtils.isNotBlank(firstChar)) {
			params.put("firstChar", firstChar);
		}
		if (StringUtils.isNotBlank(name)) {
			params.put("name", name);
		}
		if (StringUtils.isNotBlank(listPageUrl)) {
			params.put("listPageUrl", listPageUrl);
		}

		int offset = (page - 1) * count;
		params.put("offset", offset);
		params.put("count", count);
		return userMapper.findBriefBy(params);
	}

	/**
	 * 根据条件, 查询视频信息
	 *
	 * @param UserId	视频id
	 * @return	视频信息
	 */
	public User findById(Integer UserId) {
		return userMapper.selectByPrimaryKey(UserId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int save(User User) {
		User.setCreateTime(new Date());
		return userMapper.insertSelective(User);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int udpate(User User) {
		return userMapper.updateByPrimaryKeySelective(User);
	}

	public Integer countBy(String firstChar, String name) {
		Map<String, Object> params = new HashMap<String, Object>(1);
		if (StringUtils.isNotBlank(firstChar)) {
			params.put("firstChar", firstChar);
		}
		if (StringUtils.isNotBlank(name)) {
			params.put("name", name);
		}
		return userMapper.countBy(params);
	}

	/**
	 * 按首字母分组查询记录
	 * @param countPerFirstChar	每组字母查询前多少条记录
	 * @return	视频列表
	 */
	public List<User> listBriefGroupByFirstChar(int countPerFirstChar) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countPerFirstChar", countPerFirstChar);
		return userMapper.listBriefGroupByFirstChar(params);
	}

	/**
	 * 根据ID删除记录
	 * @param id
	 */
	public int deleteBy(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public int updateRank(Integer sourceId, int rank) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sourceId", sourceId);
		params.put("rank", rank);
		return userMapper.updateRank(params);
	}

	public List<User> listNoEpisodeUsers() {
		return userMapper.listNoEpisodeUsers();
	}

	public int delete(List<Integer> UserIds) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("UserIds", UserIds);
		return userMapper.delete(params);
	}
}
