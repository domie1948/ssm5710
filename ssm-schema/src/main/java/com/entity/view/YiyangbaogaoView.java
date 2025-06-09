package com.entity.view;

import com.entity.YiyangbaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 异样报告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@TableName("yiyangbaogao")
public class YiyangbaogaoView  extends YiyangbaogaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiyangbaogaoView(){
	}
 
 	public YiyangbaogaoView(YiyangbaogaoEntity yiyangbaogaoEntity){
 	try {
			BeanUtils.copyProperties(this, yiyangbaogaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
