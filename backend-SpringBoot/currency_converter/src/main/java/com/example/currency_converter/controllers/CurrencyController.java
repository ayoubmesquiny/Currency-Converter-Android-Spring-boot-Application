package com.example.currency_converter.controllers;

import com.example.currency_converter.models.ConversionCurrency;
import com.example.currency_converter.models.Currency;
import com.example.currency_converter.services.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyController {

    CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService){
        this.currencyService =currencyService;
    }


    @RequestMapping(value = "/currency-converter",produces = {"application/json"},method = RequestMethod.POST)
    public ResponseEntity<Double> convertCurrencies(@RequestBody ConversionCurrency conversionCurrency){
        Optional<Double> resultOptional =this.currencyService.convert(conversionCurrency);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/currencies",produces = {"application/json"},method = RequestMethod.GET)
    public ResponseEntity<List<Currency>> getAllCurrencies(){
        return new ResponseEntity<>(this.currencyService.getAllCurrencies(), HttpStatus.OK);
    }
}
