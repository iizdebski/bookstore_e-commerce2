package com.bookstore.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book_order", catalog = "bookstoredb")
@NamedQueries({
        @NamedQuery(name = "BookOrder.findAll", query = "SELECT bo FROM BookOrder bo ORDER BY bo.orderDate DESC"),
        @NamedQuery(name = "BookOrder.countAll", query = "SELECT COUNT(*) FROM BookOrder"),
        @NamedQuery(name = "BookOrder.findByCustomer",
                query = "SELECT bo FROM BookOrder bo WHERE bo.customer.customerId =:customerId ORDER BY bo.orderDate DESC"),
        @NamedQuery(name = "BookOrder.findByIdAndCustomer",
                query = "SELECT bo FROM BookOrder bo WHERE bo.orderId =:orderId AND bo.customer.customerId =:customerId"),
        @NamedQuery(name = "BookOrder.countByCustomer",
                query = "SELECT COUNT(bo.orderId) FROM BookOrder bo WHERE bo.customer.customerId =:customerId")
})
public class BookOrder implements java.io.Serializable {

    private Integer orderId;
    private Customer customer;
    private Date orderDate;
    private String addressLine1;
    private String addressLine2;
    private String firstName;
    private String lastName;
    private String phone;
    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String paymentMethod;
    private float shippingFee;
    private float tax;
    private float subTotal;
    private float total;
    private String status;

    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

    public BookOrder() {
    }

    public BookOrder(Integer orderId, Customer customer, Date orderDate,
                     String addressLine1, String addressLine2, String firstName, String lastName,
                     String phone, String city, String state, String zipCode, String country,
                     String paymentMethod, float total, float subTotal, float shippingFee,
                     float tax, String status, Set<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.subTotal = subTotal;
        this.shippingFee = shippingFee;
        this.tax = tax;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", nullable = false, length = 19)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "r_address_line1", nullable = false, length = 256)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name = "r_address_line2", nullable = false, length = 256)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name = "r_firstname", nullable = false, length = 30)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "r_lastname", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "r_phone", nullable = false, length = 15)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "r_country", nullable = false, length = 4)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Transient
    public String getCountryName() {
        return new Locale("", this.country).getDisplayCountry();
    }

    @Column(name = "r_city", nullable = false, length = 32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "r_state", nullable = false, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "r_zipcode", nullable = false, length = 24)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "payment_method", nullable = false, length = 20)
    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Column(name = "shipping_fee", nullable = false, precision = 12, scale = 0)
    public float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(float shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Column(name = "tax", nullable = false, precision = 12, scale = 0)
    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 0)
    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Column(name = "total", nullable = false, precision = 12, scale = 0)
    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Transient
    public int getBookCopies() {
        int total = 0;

        for (OrderDetail orderDetail : orderDetails) {
            total += orderDetail.getQuantity();
        }

        return total;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookOrder other = (BookOrder) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        return true;
    }
}