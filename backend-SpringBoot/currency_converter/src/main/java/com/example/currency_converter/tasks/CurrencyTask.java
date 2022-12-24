package com.example.currency_converter.tasks;

import com.example.currency_converter.models.Currency;
import com.example.currency_converter.models.CurrencyDTO;
import com.example.currency_converter.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyTask {
    @Autowired
    CurrencyRepository currencyRepository;

    @Value("${apikey}")
    private String apikey;

    //runs every hour

    @Scheduled(fixedRate = 5*1000*60*60)
    public void getRatesTask(){
        try{
            RestTemplate restTemplate=new RestTemplate();
            CurrencyDTO forObject=restTemplate.getForObject(apikey,CurrencyDTO.class);
            forObject.getRates().forEach((key,value) -> {
                Currency currency=new Currency(key,value);
                this.currencyRepository.save(currency);

            });


        } catch (RestClientException ex){
            System.out.println(ex.getMessage());

        }
    }

}