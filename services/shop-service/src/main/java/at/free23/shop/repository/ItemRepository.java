/**
 *
 */
package at.free23.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import at.free23.shop.api.msg.OrderItem;
import at.free23.shop.model.Item;
import at.free23.shop.model.ItemId;

/**
 * @author michael.vlasaty
 *
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, ItemId> {

	@Query("SELECT new at.free23.shop.api.msg.OrderItem(p.uuid, p.name, i.amount, p.netAmount) FROM Item i INNER JOIN i.product p where i.id.cartId=:cartId")
	public List<OrderItem> findOrderItemsByCartId(@Param("cartId") Long cartId);
}
