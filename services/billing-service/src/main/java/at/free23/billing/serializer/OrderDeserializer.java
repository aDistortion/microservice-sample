package at.free23.billing.serializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import at.free23.billing.api.Order;

public class OrderDeserializer extends JsonDeserializer<Order>{
	public OrderDeserializer(){
		super(Order.class);
	}
}
