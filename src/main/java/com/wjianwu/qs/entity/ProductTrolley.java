package com.wjianwu.qs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
@TableName("qs_product_trolley")
public class ProductTrolley implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "trolley_id", type = IdType.AUTO)
    private Integer trolleyId;  // 主键ID
    private Integer accountId;  // 所属ID
    private Integer productId;  // 商品ID
    private Double price;       // 单价
    private Integer number;     // 数量
    private LocalDateTime createTime;   // 创建时间

    public Integer getTrolleyId() {
        return trolleyId;
    }

    public void setTrolleyId(Integer trolleyId) {
        this.trolleyId = trolleyId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
