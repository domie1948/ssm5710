package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiyangbaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiyangbaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiyangbaogaoView;


/**
 * 异样报告
 *
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface YiyangbaogaoService extends IService<YiyangbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiyangbaogaoVO> selectListVO(Wrapper<YiyangbaogaoEntity> wrapper);
   	
   	YiyangbaogaoVO selectVO(@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);
   	
   	List<YiyangbaogaoView> selectListView(Wrapper<YiyangbaogaoEntity> wrapper);
   	
   	YiyangbaogaoView selectView(@Param("ew") Wrapper<YiyangbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiyangbaogaoEntity> wrapper);
   	
}

