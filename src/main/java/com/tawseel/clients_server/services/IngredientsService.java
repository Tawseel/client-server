package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientsService {
    @Autowired
    IngredientsRepository ingredientsRepository;


}
