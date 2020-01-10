package com.qhm.example.test.json.trans;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class DustLive {
    /**
     * 主键uuid
     * @mbggenerated
     */
    private String dustyLiveId;

    /**
     * 来源id，上传者自己维护
     * @mbggenerated
     */
    private String sourceId;

    /**
     * 数据源类型
     * @mbggenerated
     */
    private Byte sourceType;

    /**
     * 项目id
     * @mbggenerated
     */
    private String projectId;

    /**
     * 设备sn
     * @mbggenerated
     */
    private String deviceSn;

    /**
     * 设备时间
     * @mbggenerated
     */
    private Date deviceTime;

    /**
     * @mbggenerated
     */
    private Float tsp;

    /**
     * @mbggenerated
     */
    private Float pmTen;

    /**
     * @mbggenerated
     */
    private Float pmTwoPiontFive;

    /**
     * 噪音
     * @mbggenerated
     */
    private Float noise;

    /**
     * 温度
     * @mbggenerated
     */
    private Float temperature;

    /**
     * 湿度
     * @mbggenerated
     */
    private Float humidity;

    /**
     * 风速
     * @mbggenerated
     */
    private Float windSpeed;

    /**
     * 大气压
     * @mbggenerated
     */
    private Float atmospheric;

    /**
     * 风向
     * @mbggenerated
     */
    private String windDirection;

    /**
     * 空气质量
     * @mbggenerated
     */
    private String airQuality;

    /**
     * 预警编码
     * @mbggenerated
     */
    private Integer warn;

    /**
     * 报警编码
     * @mbggenerated
     */
    private Integer alarm;

    /**
     * 设备状态编码
     * @mbggenerated
     */
    private Integer devAlarm;

    /**
     * 继电器输出控制编码
     * @mbggenerated
     */
    private Integer outControl;

    /**
     * 创建时间
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModify;

    /**
     * 插入人
     * @mbggenerated
     */
    private String insertUser;

    /**
     * 组织机构
     * @mbggenerated
     */
    private String groupCode;

    /**
     * 是否在线
     * @mbggenerated
     */
    private Byte isonline;

    /**
     * 状态
     * @mbggenerated
     */
    private Byte status;

    /**
     * 企业id
     * @mbggenerated
     */
    private Integer companyId;

    /**
     * 部门id
     * @mbggenerated
     */
    private Integer departmentId;

    /**
     * 分期id
     * @mbggenerated
     */
    private Integer sectionId;

    /**
     * 标段id
     * @mbggenerated
     */
    private Integer stageId;

    /**
     * 设备id
     * @mbggenerated
     */
    private String referId;

}