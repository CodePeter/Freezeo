package com.sharp.freezeo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table("t_product")
@PK("id")
public class Product {
    @Column("id")
    private Long id;
    @Column("product_id")
    private String productId;
    @Column("product_name")
    private String productName;
    @Column("summary")
    private String summary;
    @Column("img_url")
    private String imgUrl;
    @Column("product_type")
    private Integer productType;
    @Column("sell_mode")
    private Integer sellMode;
    @Column("price")
    private BigDecimal price;
    @Column("status")
    private Integer status;
    @Column("order_weight")
    private Integer orderWeight;
    @Column("putaway_time")
    private Date putawayTime;
    @Column("create_time")
    private Date createTime;
    @Column("modify_time")
    private Date modifyTime;
    @Column("view_count")
    private Integer viewCount;
    @Column("subscribe_count")
    private Integer subscribeCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String id) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String id) {
        this.productName = productName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String id) {
        this.summary = summary;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String id) {
        this.imgUrl = imgUrl;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer id) {
        this.productType = productType;
    }

    public Integer getSellMode() {
        return sellMode;
    }

    public void setSellMode(Integer id) {
        this.sellMode = sellMode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal id) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer id) {
        this.status = status;
    }

    public Integer getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(Integer id) {
        this.orderWeight = orderWeight;
    }

    public Date getPutawayTime() {
        return putawayTime;
    }

    public void setPutawayTime(Date id) {
        this.putawayTime = putawayTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date id) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date id) {
        this.modifyTime = modifyTime;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer id) {
        this.viewCount = viewCount;
    }

    public Integer getSubscribeCount() {
        return subscribeCount;
    }

    public void setSubscribeCount(Integer id) {
        this.subscribeCount = subscribeCount;
    }
}
