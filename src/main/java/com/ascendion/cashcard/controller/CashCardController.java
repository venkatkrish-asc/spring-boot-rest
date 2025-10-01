package com.ascendion.cashcard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ascendion.cashcard.entity.CashCard;

@RestController
@RequestMapping("/api/v1/cashcards")
public class CashCardController {

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> getCashCardById(@PathVariable Long requestedId) {

        CashCard newCashCard = new CashCard(99L, 125.45);

        // Implementation here
        return ResponseEntity.ok(newCashCard);
    }

}
