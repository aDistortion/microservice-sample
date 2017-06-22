package com.example.billing.serializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.billing.api.Order;

public class OrderDeserializer extends JsonDeserializer<Order>{
	public OrderDeserializer(){
		super(Order.class);
	}
}
