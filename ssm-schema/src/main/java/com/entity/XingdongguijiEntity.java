package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 行动轨迹
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@TableName("xingdongguiji")
public class XingdongguijiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XingdongguijiEntity() {
		
	}
	
	public XingdongguijiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
					
	private String mingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：名称
	 */
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	/**
	 * 获取：名称
	 */
	public String getMingcheng() {
		return mingcheng;
	}
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
