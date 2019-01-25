package org.homeos.budget.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.homeos.budget.models.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@Slf4j
public class KafkaServiceIMPL implements KafkaService {

    private Properties props;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Budget> kafkaTemplate2;

    @Override
    public void send(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        kafkaTemplate.send(record);

    }

    @Override
    public void send(String topic, Budget budget) {
        kafkaTemplate2.send(topic, budget);
    }
}
