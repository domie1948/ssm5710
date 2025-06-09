package com.dao;

import com.entity.LiaotianhuifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiaotianhuifuVO;
import com.entity.view.LiaotianhuifuView;


/**
 * 聊天回复
 * 
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface LiaotianhuifuDao extends BaseMapper<LiaotianhuifuEntity> {
	
	List<LiaotianhuifuVO> selectListVO(@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);
	
	LiaotianhuifuVO selectVO(@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);
	
	List<LiaotianhuifuView> selectListView(@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);

	List<LiaotianhuifuView> selectListView(Pagination page,@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);
	
	LiaotianhuifuView selectView(@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);
	
}
