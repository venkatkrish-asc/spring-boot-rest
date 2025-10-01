package com.ascendion.cashcard;

import com.ascendion.cashcard.entity.CashCard;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CashCardApplicationTests {

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testFetchOneCashCard(){

        ResponseEntity<CashCard> response = restTemplate.getForEntity("/api/v1/cashcards/99", CashCard.class);


    }

    @Test
    public void myFirstTest(){
        assertThat(42).isEqualTo(42);
    }


}
