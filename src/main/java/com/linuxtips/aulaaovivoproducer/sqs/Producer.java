package com.linuxtips.aulaaovivoproducer.sqs;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.InvalidMessageContentsException;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private AmazonSQS amazonSQSClient;

    private final String finalizarCompra = "https://sqs.sa-east-1.amazonaws.com/771177158205/finaliza-compra-linux-tips-aula-ao-vivo";


    public Producer() {
    }

    public void finalizarCompra(String message) {
        try {
            amazonSQSClient.sendMessage(finalizarCompra,message );


        } catch (QueueDoesNotExistException | InvalidMessageContentsException e) {
            System.out.println("erro ao adiconar compra" + e);
        }
    }
}
