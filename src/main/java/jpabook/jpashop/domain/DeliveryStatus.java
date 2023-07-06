package jpabook.jpashop.domain;

public enum DeliveryStatus {
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERED,
    FAILED_DELIVERY_ATTEMPT,
    RETURNED,
    LOST,
    CANCELLED
}
