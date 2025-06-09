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
 * 医院信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-09-23 17:33:51
 */
@TableName("yiyuanxinxi")
public class YiyuanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YiyuanxinxiEntity() {
		
	}
	
	public YiyuanxinxiEntity(T t) {
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
	 * 编号
	 */
					
	private String bianhao;
	
	/**
	 * 医院名称
	 */
					
	private String yiyuanmingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 医院风采
	 */
					
	private String yiyuanfengcai;
	
	/**
	 * 出名度
	 */
					
	private String chumingdu;
	
	/**
	 * 始建日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shijianriqi;
	
	/**
	 * 工作时间
	 */
					
	private String gongzuoshijian;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 详细地址
	 */
					
	private String xiangxidizhi;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
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
	 * 设置：编号
	 */
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	/**
	 * 获取：编号
	 */
	public String getBianhao() {
		return bianhao;
	}
	/**
	 * 设置：医院名称
	 */
	public void setYiyuanmingcheng(String yiyuanmingcheng) {
		this.yiyuanmingcheng = yiyuanmingcheng;
	}
	/**
	 * 获取：医院名称
	 */
	public String getYiyuanmingcheng() {
		return yiyuanmingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：医院风采
	 */
	public void setYiyuanfengcai(String yiyuanfengcai) {
		this.yiyuanfengcai = yiyuanfengcai;
	}
	/**
	 * 获取：医院风采
	 */
	public String getYiyuanfengcai() {
		return yiyuanfengcai;
	}
	/**
	 * 设置：出名度
	 */
	public void setChumingdu(String chumingdu) {
		this.chumingdu = chumingdu;
	}
	/**
	 * 获取：出名度
	 */
	public String getChumingdu() {
		return chumingdu;
	}
	/**
	 * 设置：始建日期
	 */
	public void setShijianriqi(Date shijianriqi) {
		this.shijianriqi = shijianriqi;
	}
	/**
	 * 获取：始建日期
	 */
	public Date getShijianriqi() {
		return shijianriqi;
	}
	/**
	 * 设置：工作时间
	 */
	public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
	}
	/**
	 * 获取：工作时间
	 */
	public String getGongzuoshijian() {
		return gongzuoshijian;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：详细地址
	 */
	public void setXiangxidizhi(String xiangxidizhi) {
		this.xiangxidizhi = xiangxidizhi;
	}
	/**
	 * 获取：详细地址
	 */
	public String getXiangxidizhi() {
		return xiangxidizhi;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}
