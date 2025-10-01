package com.ascendion.cashcard;

import com.ascendion.cashcard.entity.CashCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> jsonTester;

    @Test
    public void cashCardSerializationTest() throws IOException {

        CashCard cashCard = new CashCard(99L, 125.45);

        // Assert statements
        assertThat(jsonTester.write(cashCard)).isEqualToJson("expected-cashcard.json");
        assertThat(jsonTester.write(cashCard))
                .hasJsonPathNumberValue("@.id")
                .extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(jsonTester.write(cashCard))
                .hasJsonPathNumberValue("@.amount")
                .extractingJsonPathNumberValue("@.amount").isEqualTo(125.45);
    }

    @Test
    public void cashCardDeserializationTest() throws IOException {

        String expectedJson = """
                {
                    "id": 99,
                    "amount": 125.45
                }
                """;

        // Assert statements
        assertThat(jsonTester.parse(expectedJson))
                .isEqualTo(new CashCard(99L, 125.45));
        assertThat(jsonTester.parseObject(expectedJson).id()).isEqualTo(99);
        assertThat(jsonTester.parseObject(expectedJson).amount()).isEqualTo(125.45);
    }

}
