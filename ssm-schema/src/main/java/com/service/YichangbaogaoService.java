package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YichangbaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YichangbaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YichangbaogaoView;


/**
 * 异常报告
 *
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface YichangbaogaoService extends IService<YichangbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YichangbaogaoVO> selectListVO(Wrapper<YichangbaogaoEntity> wrapper);
   	
   	YichangbaogaoVO selectVO(@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);
   	
   	List<YichangbaogaoView> selectListView(Wrapper<YichangbaogaoEntity> wrapper);
   	
   	YichangbaogaoView selectView(@Param("ew") Wrapper<YichangbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YichangbaogaoEntity> wrapper);
   	
}

