package com.example.currency_converter.services;

import com.example.currency_converter.models.ConversionCurrency;
import com.example.currency_converter.models.Currency;
import com.example.currency_converter.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;

    }

    public List<Currency> getAllCurrencies(){
        return currencyRepository.findAll();
    }

    public Optional<Double> convert(ConversionCurrency conversionCurrency){
        Optional<Currency> toOp= currencyRepository.findById(conversionCurrency.getTo());
        Optional<Currency> fromOp=currencyRepository.findById(conversionCurrency.getFrom());

        if(toOp.isPresent() && fromOp.isPresent()){
            Currency to = toOp.get();
            Currency from = fromOp.get();

            Double toValue= to.getValueInUSD();
            Double fromValue=from.getValueInUSD();

            Double result = toValue * conversionCurrency.getValue() / fromValue ;

            return Optional.of(result);

        }
        return Optional.empty();

    }


}


