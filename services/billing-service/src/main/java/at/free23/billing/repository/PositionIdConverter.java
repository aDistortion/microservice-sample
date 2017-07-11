/**
 *
 */
package at.free23.billing.repository;

import org.springframework.core.convert.converter.Converter;

import at.free23.billing.model.PositionId;

/**
 * @author michael.vlasaty
 *
 */
public class PositionIdConverter implements Converter<String, PositionId> {

	@Override
	public PositionId convert(String source) {
		final String[] ids = source.split("-");
		return new PositionId(Long.valueOf(ids[0]), Long.valueOf(ids[1]));
	}

}
