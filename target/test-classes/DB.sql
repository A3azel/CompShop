create database CompShop;

use CompShop;

##############################
create table USERData(
                         ID int primary key auto_increment,
                         user_name varchar(20) not null unique,
                         user_password varchar(30) not null,
                         user_email varchar(100) unique,
                         user_phone varchar(20) unique,
                         user_age int default null,
                         user_sex_ID int,
                         user_status_ID int,
                         constraint dell_user_sex_ID foreign key(user_sex_ID) references UserSex(ID),
                         constraint dell_user_status_ID foreign key(user_status_ID) references UserStatus(ID)
);


select * from UserSex;


drop table USERData;

##############################
create table UserStatus(
                           ID int primary key auto_increment,
                           user_status varchar(50)
);

insert into UserStatus(user_status)
    value
    ('user'),
    ('admin');



drop table UserStatus;

##############################
create table UserSex(
                        ID int primary key auto_increment,
                        user_sex varchar(20) default null
);


insert into UserSex(user_sex)
    value
    ('man'),
    ('women'),
    ('not specified');

drop table UserSex;

##############################
create table ComputerComponents(
                                   ID int primary key auto_increment,
                                   computer_components_category_ID int,
                                   computer_components_name varchar(200),
                                   computer_components_description varchar(5000),
                                   computer_components_URL varchar(200),
                                   computer_components_prise double,
                                   computer_components_count int,
                                   constraint dell_computer_components_category_ID foreign key(computer_components_category_ID) references Category(ID)
);

drop table ComputerComponents;



##############################
create table Category(
                         ID int primary key auto_increment,
                         category varchar(100)
);

drop table Category;

##############################



##############################

create table Orders(
                       ID int primary key auto_increment,
                       user_orders_ID int,
                       computer_components_orders_ID int,
                       order_status_ID int,
                       order_count int,
                       order_create_time date,
                       order_prise double,
                       constraint dell_user_orders_ID foreign key(user_orders_ID) references USERData(ID),
                       constraint dell_computer_components_orders_ID foreign key(computer_components_orders_ID) references ComputerComponents(ID),
                       constraint dell_order_status_ID foreign key(order_status_ID) references OrderStatus(ID)
);

drop table Orders;


create table OrderStatus(
                            ID int primary key,
                            order_status varchar(50)
);



drop table OrderStatus;

insert into Category(category) value ('Motherboards'),('Processors'),('RAM'),('VideoCards');

insert into OrderStatus(order_status) value ('processed'),('sent'),('arrived');


insert into ComputerComponents(computer_components_category_ID,computer_components_name,computer_components_description,computer_components_URL,
                               computer_components_prise,computer_components_count)
    value (2,'Процессор Intel Core i5-10400 2.9GHz/12MB',
           'Сімейство процесорів
• Intel Core i5
Тип роз''єму
• Socket 1200
кількість ядер
• 6
Покоління процесорів Intel
• 10 покоління (Comet Lake)
Інтегрована графіка
• Intel UHD Graphics 630
Тактова частота процесора
• 2900 МГц
Об''єм кеш пам''яті 3 рівня
• 12 МБ',
           'Intel Core i5-10400',
           5800,
           100
    );