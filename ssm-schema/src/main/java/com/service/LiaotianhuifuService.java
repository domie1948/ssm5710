package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiaotianhuifuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiaotianhuifuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiaotianhuifuView;


/**
 * 聊天回复
 *
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface LiaotianhuifuService extends IService<LiaotianhuifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiaotianhuifuVO> selectListVO(Wrapper<LiaotianhuifuEntity> wrapper);
   	
   	LiaotianhuifuVO selectVO(@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);
   	
   	List<LiaotianhuifuView> selectListView(Wrapper<LiaotianhuifuEntity> wrapper);
   	
   	LiaotianhuifuView selectView(@Param("ew") Wrapper<LiaotianhuifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiaotianhuifuEntity> wrapper);
   	
}

