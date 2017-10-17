/**
 *
 */
package at.free23.shop.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author michael.vlasaty
 *
 */
// @Profile("!test")
@Configuration
@EnableDiscoveryClient
public class DiscoveryConfig {

}
