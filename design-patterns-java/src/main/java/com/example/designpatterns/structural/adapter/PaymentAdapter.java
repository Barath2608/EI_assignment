package com.example.designpatterns.structural.adapter;

public class PaymentAdapter {
    private final OldPaymentGateway legacy;

    public static class PaymentRequest { public final double amount; public final String currency; public PaymentRequest(double a, String c){ amount=a; currency=c; } }
    public static class PaymentResult { public final boolean success; public final String txId; public PaymentResult(boolean s, String t){ success=s; txId=t; } }

    public PaymentAdapter(OldPaymentGateway legacy) { this.legacy = legacy; }

    public PaymentResult pay(PaymentRequest req) {
        int cents = (int)Math.round(req.amount * 100);
        try {
            OldPaymentGateway.PaymentResponse r = legacy.makePayment(cents, req.currency);
            return new PaymentResult(r.success, r.txId);
        } catch (Exception e) {
            return new PaymentResult(false, null);
        }
    }
}
