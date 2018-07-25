CREATE TABLE tw_cart (
  id bigint(20) primary key,
  total_price double
) default charset utf8;

insert into tw_cart values (
20000001, 120.00
);

CREATE TABLE tw_cart_item (
  id bigint(20) primary key,
  cart_id bigint(20) not null,
  good_name char(50),
  good_type char(50),
  num int,
  price double
) default charset utf8;

insert into tw_cart_item values (
1000000, 20000001, "thoughtworks T恤", "服装", 1, 100.00
);

insert into tw_cart_item values (
1000001, 20000001, "thoughtworks 马克笔", "文具", 2, 10.00
);

