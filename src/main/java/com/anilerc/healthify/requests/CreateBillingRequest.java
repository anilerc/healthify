package com.anilerc.healthify.requests;

public record CreateBillingRequest(Long reservationId, Double amount, Boolean isPaid) {
}
