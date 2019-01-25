package org.homeos.budget.services;

import org.homeos.budget.models.Budget;

public interface KafkaService {

    void send(String topic, String key, String value);
    void send(String topic, Budget budget);
}
