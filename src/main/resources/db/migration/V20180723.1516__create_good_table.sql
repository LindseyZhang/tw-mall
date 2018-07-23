CREATE TABLE tw_good (
  id bigint(20) primary key,
  title char(50),
  good_type char(50),
  price double
) default charset utf8;

insert into tw_good values (
1000000, "thoughtworks T恤", "服装", 100.00
);

insert into tw_good values (
1000001, "thoughtworks 马克笔", "文具", 10.00
);
