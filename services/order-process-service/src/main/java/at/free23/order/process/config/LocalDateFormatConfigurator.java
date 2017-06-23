/**
 *
 */
package at.free23.order.process.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.camunda.spin.impl.json.jackson.format.JacksonJsonDataFormat;
import org.camunda.spin.spi.DataFormatConfigurator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class LocalDateFormatConfigurator implements DataFormatConfigurator<JacksonJsonDataFormat> {

	@Override
	public Class<JacksonJsonDataFormat> getDataFormatClass() {
		return JacksonJsonDataFormat.class;
	}

	@Override
	public void configure(JacksonJsonDataFormat dataFormat) {
		final ObjectMapper mapper = dataFormat.getObjectMapper();
		final JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
		javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE));
		mapper.registerModule(javaTimeModule);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

}
