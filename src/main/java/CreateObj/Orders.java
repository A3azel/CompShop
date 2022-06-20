package CreateObj;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Orders implements Serializable {
    private int ID;
    private String userOrder;
    private String orderComp;
    private String orderStatus;
    private int orderCount;
    private Date orderCreateTime;
    private BigDecimal orderPrise;

    public Orders(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(String userOrder) {
        this.userOrder = userOrder;
    }

    public String getOrderComp() {
        return orderComp;
    }

    public void setOrderComp(String orderComp) {
        this.orderComp = orderComp;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public BigDecimal getOrderPrise() {
        return orderPrise;
    }

    public void setOrderPrise(BigDecimal orderPrise) {
        this.orderPrise = orderPrise;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", userOrder='" + userOrder + '\'' +
                ", orderComp='" + orderComp + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCount=" + orderCount +
                ", orderCreateTime=" + orderCreateTime +
                ", orderPrise=" + orderPrise +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return ID == orders.ID && orderCount == orders.orderCount && Objects.equals(userOrder, orders.userOrder) && Objects.equals(orderComp, orders.orderComp) && Objects.equals(orderStatus, orders.orderStatus) && Objects.equals(orderCreateTime, orders.orderCreateTime) && Objects.equals(orderPrise, orders.orderPrise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, userOrder, orderComp, orderStatus, orderCount, orderCreateTime, orderPrise);
    }
}
