package com.linuxtips.aulaaovivoproducer.controller;

import com.linuxtips.aulaaovivoproducer.sqs.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoCheckoutController {


    @Autowired
    private Producer producer;

    @PostMapping("/finalizar")
    @ResponseStatus(HttpStatus.CREATED)
    public void finalizarCompra(@RequestBody String pedidoId) {
        producer.finalizarCompra(pedidoId);
    }
}
