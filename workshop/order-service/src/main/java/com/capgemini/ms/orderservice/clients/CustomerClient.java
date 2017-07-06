package com.capgemini.ms.orderservice.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerClient {

  private final Logger log = LoggerFactory.getLogger(CustomerClient.class);

  @Value("${customer.service.url}")
  private String customerServiceUrl;

  private RestTemplate restTemplate = new RestTemplate();

  public List<Customer> getAllCustomers() {
    return restTemplate.getForObject(customerServiceUrl, List.class);
  }

  public Customer getCustomer(long id) {
    return restTemplate.getForObject(customerServiceUrl + id, Customer.class);
  }
}
