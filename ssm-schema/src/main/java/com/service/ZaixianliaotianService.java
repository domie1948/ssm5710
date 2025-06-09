package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianliaotianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianliaotianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianliaotianView;


/**
 * 在线聊天
 *
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface ZaixianliaotianService extends IService<ZaixianliaotianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianliaotianVO> selectListVO(Wrapper<ZaixianliaotianEntity> wrapper);
   	
   	ZaixianliaotianVO selectVO(@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);
   	
   	List<ZaixianliaotianView> selectListView(Wrapper<ZaixianliaotianEntity> wrapper);
   	
   	ZaixianliaotianView selectView(@Param("ew") Wrapper<ZaixianliaotianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianliaotianEntity> wrapper);
   	
}

