package com.start.domain_driven_design.order.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @Nested
    class beforePayment {

        private static final OrderStatus ORDER_STATUS = OrderStatus.BEFORE_PAYMENT;

        @Test
        @DisplayName("OrderStatus BEFORE_PAYMENT 상태에서 정상 상태변경")
        void BEFORE_PAYMENT_정상상태변경() {
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PAYMENT);
            boolean canceledResult = ORDER_STATUS.isAvailableStatus(OrderStatus.CANCELED);
            Assertions.assertThat(paymentResult).isTrue();
            Assertions.assertThat(canceledResult).isTrue();
        }

        @Test
        @DisplayName("OrderStatus BEFORE_PAYMENT 상태에서 비정상 상태 변경")
        void BEFORE_PAYMENT_비정상상태변경() {
            boolean preparingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PREPARING);
            boolean completedResult = ORDER_STATUS.isAvailableStatus(OrderStatus.COMPLETED);
            boolean shippingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.SHIPPING);
            boolean beforePaymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.BEFORE_PAYMENT);
            Assertions.assertThat(preparingResult).isFalse();
            Assertions.assertThat(completedResult).isFalse();
            Assertions.assertThat(shippingResult).isFalse();
            Assertions.assertThat(beforePaymentResult).isFalse();
        }
    }

    @Nested
    class payment {

        private static final OrderStatus ORDER_STATUS = OrderStatus.PAYMENT;

        @Test
        @DisplayName("OrderStatus PAYMENT 상태에서 정상 상태변경")
        void PAYMENT_정상상태변경() {
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PREPARING);
            boolean canceledResult = ORDER_STATUS.isAvailableStatus(OrderStatus.CANCELED);
            Assertions.assertThat(paymentResult).isTrue();
            Assertions.assertThat(canceledResult).isTrue();
        }

        @Test
        @DisplayName("OrderStatus PAYMENT 상태에서 비정상 상태 변경")
        void PAYMENT_비정상상태변경() {
            boolean beforePaymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.BEFORE_PAYMENT);
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PAYMENT);
            boolean completedResult = ORDER_STATUS.isAvailableStatus(OrderStatus.COMPLETED);
            boolean shippingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.SHIPPING);
            Assertions.assertThat(paymentResult).isFalse();
            Assertions.assertThat(beforePaymentResult).isFalse();
            Assertions.assertThat(completedResult).isFalse();
            Assertions.assertThat(shippingResult).isFalse();
        }
    }

    @Nested
    class preparing {

        private static final OrderStatus ORDER_STATUS = OrderStatus.PREPARING;

        @Test
        @DisplayName("OrderStatus PREPARING 상태에서 정상 상태변경")
        void PREPARING_정상상태변경() {
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.SHIPPING);
            boolean canceledResult = ORDER_STATUS.isAvailableStatus(OrderStatus.CANCELED);
            Assertions.assertThat(paymentResult).isTrue();
            Assertions.assertThat(canceledResult).isTrue();
        }

        @Test
        @DisplayName("OrderStatus PREPARING 상태에서 비정상 상태 변경")
        void PREPARING_비정상상태변경() {
            boolean beforePaymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.BEFORE_PAYMENT);
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PAYMENT);
            boolean completedResult = ORDER_STATUS.isAvailableStatus(OrderStatus.COMPLETED);
            boolean preparingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PREPARING);
            Assertions.assertThat(paymentResult).isFalse();
            Assertions.assertThat(beforePaymentResult).isFalse();
            Assertions.assertThat(completedResult).isFalse();
            Assertions.assertThat(preparingResult).isFalse();
        }
    }

    @Nested
    class shipping {

        private static final OrderStatus ORDER_STATUS = OrderStatus.SHIPPING;

        @Test
        @DisplayName("OrderStatus SHIPPING 상태에서 정상 상태변경")
        void PREPARING_정상상태변경() {
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.COMPLETED);
            boolean canceledResult = ORDER_STATUS.isAvailableStatus(OrderStatus.CANCELED);
            Assertions.assertThat(paymentResult).isTrue();
            Assertions.assertThat(canceledResult).isTrue();
        }

        @Test
        @DisplayName("OrderStatus SHIPPING 상태에서 비정상 상태 변경")
        void PREPARING_비정상상태변경() {
            boolean beforePaymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.BEFORE_PAYMENT);
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PAYMENT);
            boolean shippingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.SHIPPING);
            boolean preparingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PREPARING);
            Assertions.assertThat(paymentResult).isFalse();
            Assertions.assertThat(beforePaymentResult).isFalse();
            Assertions.assertThat(shippingResult).isFalse();
            Assertions.assertThat(preparingResult).isFalse();
        }
    }

    @Nested
    class completed {

        private static final OrderStatus ORDER_STATUS = OrderStatus.COMPLETED;

        @Test
        @DisplayName("OrderStatus COMPLETED_상태에서는_다른상태로_변경_불가")
        void COMPLETED_상태에서는_다른상태로_변경_불가() {
            boolean canceledResult = ORDER_STATUS.isAvailableStatus(OrderStatus.CANCELED);
            boolean beforePaymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.BEFORE_PAYMENT);
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PAYMENT);
            boolean shippingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.SHIPPING);
            boolean preparingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PREPARING);
            Assertions.assertThat(canceledResult).isFalse();
            Assertions.assertThat(beforePaymentResult).isFalse();
            Assertions.assertThat(paymentResult).isFalse();
            Assertions.assertThat(shippingResult).isFalse();
            Assertions.assertThat(preparingResult).isFalse();
        }
    }

    @Nested
    class canceled {

        private static final OrderStatus ORDER_STATUS = OrderStatus.CANCELED;

        @Test
        @DisplayName("OrderStatus CANCELED_상태에서는_다른상태로_변경_불가")
        void CANCELED_상태에서는_다른상태로_변경_불가() {
            boolean completedResult = ORDER_STATUS.isAvailableStatus(OrderStatus.COMPLETED);
            boolean beforePaymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.BEFORE_PAYMENT);
            boolean paymentResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PAYMENT);
            boolean shippingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.SHIPPING);
            boolean preparingResult = ORDER_STATUS.isAvailableStatus(OrderStatus.PREPARING);
            Assertions.assertThat(completedResult).isFalse();
            Assertions.assertThat(beforePaymentResult).isFalse();
            Assertions.assertThat(paymentResult).isFalse();
            Assertions.assertThat(shippingResult).isFalse();
            Assertions.assertThat(preparingResult).isFalse();
        }
    }
}