package com.entity.model;

import com.entity.XingdongguijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 行动轨迹
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
public class XingdongguijiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 出行地点
	 */
	
	private String chuxingdidian;
		
	/**
	 * 出行时间
	 */
	
	private String chuxingshijian;
		
	/**
	 * 现在状况
	 */
	
	private String xianzaizhuangkuang;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
				
	
	/**
	 * 设置：出行地点
	 */
	 
	public void setChuxingdidian(String chuxingdidian) {
		this.chuxingdidian = chuxingdidian;
	}
	
	/**
	 * 获取：出行地点
	 */
	public String getChuxingdidian() {
		return chuxingdidian;
	}
				
	
	/**
	 * 设置：出行时间
	 */
	 
	public void setChuxingshijian(String chuxingshijian) {
		this.chuxingshijian = chuxingshijian;
	}
	
	/**
	 * 获取：出行时间
	 */
	public String getChuxingshijian() {
		return chuxingshijian;
	}
				
	
	/**
	 * 设置：现在状况
	 */
	 
	public void setXianzaizhuangkuang(String xianzaizhuangkuang) {
		this.xianzaizhuangkuang = xianzaizhuangkuang;
	}
	
	/**
	 * 获取：现在状况
	 */
	public String getXianzaizhuangkuang() {
		return xianzaizhuangkuang;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
			
}
