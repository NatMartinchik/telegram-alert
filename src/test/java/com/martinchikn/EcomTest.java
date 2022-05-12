package com.martinchikn;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EcomTest extends TestBase{

    @Test
    @DisplayName("Placing an order")
    void orderTest() {
        step("Open the home page", () -> {
            open("");
        });

        step("Go to the item page", () -> {
            $(byText("ГРАДВИС Керамическая ваза")).click();
        });

        step("Add the item in cart", () -> {
            $("[name=\"add-to-cart\"]").click();
            $(byText("Оформение заказа")).click();
        });

        step("Fill in customer data", () -> {
            $("#billing_first_name").setValue("Тест");
            $("#billing_last_name").setValue("Тестов");
            $("#billing_address_1").setValue("ул Тестовая 5");
            $("#billing_city").setValue("Москва");
            $("#billing_state").setValue("Хамовники");
            $("#billing_postcode").setValue("101010");
            $("#billing_phone").setValue("79369363636");
            $("#billing_email").setValue("test@test.ru");
            $("#place_order").click();
        });

        step("Successful checkout page", () -> {
            $(".woocommerce-order").shouldHave(text("Ваш заказ принят. Благодарим вас."));
        });
    }

    @Test
    @DisplayName("Adding to wishlist")
    void favTest() {
        step("Open the home page", () -> {
            open("");
        });

        step("Go to the item page", () -> {
            $(byText("БРОММС Двухместная кровать")).click();
        });

        step("Click the heart icon", () -> {
            $(".yith-wcwl-add-button").click();
        });

        step("Go back to home page", () -> {
            $(".logo-dark").click();
        });

        step("Go to wishlist", () -> {
            $(".wishlist-icon").click();
        });

        step("Successfully added to wishlist", () -> {
            $(".wishlist-title-container").shouldHave(text("Список желаний"));
            $(".wishlist-items-wrapper").shouldHave(text("БРОММС Двухместная кровать"));
        });
    }

    @Test
    @Disabled
    @DisplayName("Sending feedback")
    void contactForm() {
        step("Open the home page", () -> {
            open("");
        });

        step("Go to the feedback form", () -> {
            $(byText("Контакты")).click();
            $(".page-header__title ").shouldHave(text("Контакты"));
        });

        step("Fill in feedback form", () -> {
            $("[placeholder=\"Ваше имя *\"]").setValue("Тест");
            $("[placeholder=\"Ваш заголовок *\"]").setValue("Тест");
            $("[placeholder=\"Сообщение *\"]").setValue("Тест");
            $("[type=email]").setValue("test@test.ru");
            $("[placeholder=\"Ваше имя *\"]").shouldHave(text("Тест"));

        });
    }

    @Test
    @Disabled
    void test00() {
        assertTrue(false);
    }
}

