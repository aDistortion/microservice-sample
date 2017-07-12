/**
 *
 */
package at.free23.shipping.listener;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.common.math.DoubleMath;

import at.free23.shipping.api.ShippingEvent;
import at.free23.shipping.api.ShippingPayload;
import at.free23.shipping.model.ShippingNote;
import at.free23.shipping.repository.ShippingNoteRepository;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class ShippingListener {

	private static final Logger logger = LoggerFactory.getLogger(ShippingListener.class);

	@Autowired
	private ShippingNoteRepository repo;

	@KafkaListener(topics = "shipping", containerFactory = "jsonKafkaListenerContainerFactory")
	public void shipping(ShippingPayload payload) {
		final ShippingEvent event = ShippingEvent.valueOf(payload.getEvent());
		switch (event) {
		case ITEM_WONT_SHIP:
			break;
		case SHIPPING_DELAYED:
			break;
		case SHIPPING_READY:
			final ShippingNote note = this.repo.findByOrderRef(payload.getOrderRef());
			final LocalDate expectedDate = LocalDate.now()
					.plusDays(DoubleMath.roundToLong(payload.getTimeAmount(), RoundingMode.UP));
			if (note.getExpectedArrival() == null) {
				note.setExpectedArrival(expectedDate);
			} else {
				final Period period = Period.between(note.getExpectedArrival(), expectedDate);
				note.setExpectedArrival(note.getExpectedArrival().plusDays(period.getDays()));
			}
			logger.info(
					String.format("Shipping %s expected arrival %s", payload.getOrderRef(), note.getExpectedArrival()));
			this.repo.save(note);
			break;
		default:
			break;
		}
	}
}
