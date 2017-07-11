/**
 *
 */
package at.free23.stock.repository;

import org.springframework.core.convert.converter.Converter;

import at.free23.stock.model.ReservedId;

/**
 * @author michael.vlasaty
 *
 */
public class ReservedIdConverter implements Converter<String, ReservedId> {

	@Override
	public ReservedId convert(String source) {
		final String[] ids = source.split("-");
		return new ReservedId(Long.valueOf(ids[1]), ids[0]);
	}

}
