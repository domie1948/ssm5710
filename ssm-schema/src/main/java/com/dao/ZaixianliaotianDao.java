package com.dao;

import com.entity.ZaixianliaotianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianliaotianVO;
import com.entity.view.ZaixianliaotianView;


/**
 * 在线聊天
 * 
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface ZaixianliaotianDao extends BaseMapper<ZaixianliaotianEntity> {
	
	List<ZaixianliaotianVO> selectListVO(@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);
	
	ZaixianliaotianVO selectVO(@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);
	
	List<ZaixianliaotianView> selectListView(@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);

	List<ZaixianliaotianView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);
	
	ZaixianliaotianView selectView(@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);
	
}
