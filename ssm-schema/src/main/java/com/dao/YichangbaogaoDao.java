package com.dao;

import com.entity.YichangbaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YichangbaogaoVO;
import com.entity.view.YichangbaogaoView;


/**
 * 异常报告
 * 
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface YichangbaogaoDao extends BaseMapper<YichangbaogaoEntity> {
	
	List<YichangbaogaoVO> selectListVO(@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);
	
	YichangbaogaoVO selectVO(@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);
	
	List<YichangbaogaoView> selectListView(@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);

	List<YichangbaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);
	
	YichangbaogaoView selectView(@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);
	
}
