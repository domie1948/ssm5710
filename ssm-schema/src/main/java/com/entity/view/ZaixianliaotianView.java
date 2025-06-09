package com.entity.view;

import com.entity.ZaixianliaotianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线聊天
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@TableName("zaixianliaotian")
public class ZaixianliaotianView  extends ZaixianliaotianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianliaotianView(){
	}
 
 	public ZaixianliaotianView(ZaixianliaotianEntity zaixianliaotianEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianliaotianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
