package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XingdongguijiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XingdongguijiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XingdongguijiView;


/**
 * 行动轨迹
 *
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public interface XingdongguijiService extends IService<XingdongguijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XingdongguijiVO> selectListVO(Wrapper<XingdongguijiEntity> wrapper);
   	
   	XingdongguijiVO selectVO(@Param("ew") Wrapper<XingdongguijiEntity> wrapper);
   	
   	List<XingdongguijiView> selectListView(Wrapper<XingdongguijiEntity> wrapper);
   	
   	XingdongguijiView selectView(@Param("ew") Wrapper<XingdongguijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XingdongguijiEntity> wrapper);
   	
}

