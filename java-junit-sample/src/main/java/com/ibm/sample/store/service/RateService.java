package com.ibm.sample.store.service;

import com.ibm.sample.store.model.Item;
import com.ibm.sample.store.repository.ItemRepository;
import com.ibm.sample.store.service.tools.StaticService;
import org.springframework.beans.factory.annotation.Autowired;

public class RateService {

    @Autowired
    private ItemRepository itemRepository;


    public int calculateRate(String itemId, int muliplicator) {

        Item item = itemRepository.findById(itemId);
        int rate = item.getPriceInCents() * StaticService.getMultiplicator();
        return rate;
    }

}
