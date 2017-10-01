--product
create sequence product_id_sequence start with 1 increment by 1;
--create table product (id bigint not null, description varchar(255), gross_amount double, img_url varchar(255), name varchar(255), net_amount double, tax_rate bigint, uuid varchar(255), primary key (id));
create table product (id bigint not null, description varchar(255), gross_amount double, img_url varchar(255), name varchar(255), net_amount double, tax_rate bigint, type varchar(255), uuid varchar(255), vendor_id bigint, primary key (id));

--cart
create sequence cart_id_sequence start with 1 increment by 1;
create table cart (id bigint not null, tenant_id varchar(255), primary key (id));

--cart items
create table item (amount integer, cart_id bigint not null, product_id bigint not null, primary key (cart_id, product_id));
alter table item add constraint FK4g2q77pbbf0faqae5uywbsodk foreign key (cart_id) references cart;
alter table item add constraint FKd1g72rrhgq1sf7m4uwfvuhlhe foreign key (product_id) references product;

--vendor
create sequence vendor_id_sequence start with 1 increment by 1;
create table vendor (id bigint not null, country varchar(255), name varchar(255), primary key (id));
alter table product add constraint FK9tnjxr4w1dcvbo2qejikpxpfy foreign key (vendor_id) references vendor;