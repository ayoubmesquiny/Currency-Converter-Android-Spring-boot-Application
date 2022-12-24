package com.example.currency_converter.repositories;

import com.example.currency_converter.models.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, String> {

    @Override
    List<Currency> findAll();
}
