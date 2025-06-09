package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyishengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyishengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyishengView;


/**
 * 医生评论表
 *
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface DiscussyishengService extends IService<DiscussyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyishengVO> selectListVO(Wrapper<DiscussyishengEntity> wrapper);
   	
   	DiscussyishengVO selectVO(@Param("ew") Wrapper<DiscussyishengEntity> wrapper);
   	
   	List<DiscussyishengView> selectListView(Wrapper<DiscussyishengEntity> wrapper);
   	
   	DiscussyishengView selectView(@Param("ew") Wrapper<DiscussyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyishengEntity> wrapper);
   	
}

