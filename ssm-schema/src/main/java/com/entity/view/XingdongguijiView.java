package com.entity.view;

import com.entity.XingdongguijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 行动轨迹
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@TableName("xingdongguiji")
public class XingdongguijiView  extends XingdongguijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XingdongguijiView(){
	}
 
 	public XingdongguijiView(XingdongguijiEntity xingdongguijiEntity){
 	try {
			BeanUtils.copyProperties(this, xingdongguijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
