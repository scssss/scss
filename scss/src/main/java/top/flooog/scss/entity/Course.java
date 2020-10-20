package top.flooog.scss.entity;

import java.util.Date;

public class Course {

    private Long id;

    private String cId;


    private String cName;


    private String cPicture;


    private Byte scoure;


    private Byte isDeleted;


    private Date createTime;


    private Date updateTime;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }


    public String getcPicture() {
        return cPicture;
    }

    public void setcPricturre(String cPicture) {
        this.cPicture = cPicture == null ? null : cPicture.trim();
    }


    public Byte getScoure() {
        return scoure;
    }

    public void setScoure(Byte scoure) {
        this.scoure = scoure;
    }


    public Byte getIsDeleted() {
        return isDeleted;
    }


    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}