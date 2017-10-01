insert into vendor (id, country, name)
	values (nextval('vendor_id_sequence'), 'Austria', 'Golser Brauerei');
insert into vendor (id, country, name)
	values (nextval('vendor_id_sequence'), 'Belgium', 'De Brabandere');
	insert into vendor (id, country, name)
	values (nextval('vendor_id_sequence'), 'Germany', 'Hacker-Pschorr');
	
insert into product (id, uuid, name, description, type, gross_amount, net_amount, tax_rate, img_url, vendor_id)
	values (nextval('product_id_sequence'), 'green-goose', 'Green Goose', 'Magnificant beer creation of the top notch manufacturers these days.', 'Craft Beer', 7.50, 4.99, 20, 'http://change.me', 1);
insert into product (id, uuid, name, description, type, gross_amount, net_amount, tax_rate, img_url, vendor_id)
	values (nextval('product_id_sequence'), 'petrus', 'Petrus', 'Beautiful handcrafted beer with note of cabagge.', 'Aged Pale Ale', 4.50, 7.99, 20, 'http://change.me', 2);
insert into product (id, uuid, name, description, type, gross_amount, net_amount, tax_rate, img_url, vendor_id)
	values (nextval('product_id_sequence'), 'muenchner-hell', 'Münchner Hell', 'All day long.', 'Light Lager', 2.50, 2.99, 20, 'http://change.me', 3);