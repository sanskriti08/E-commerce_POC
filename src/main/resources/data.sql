INSERT INTO USER (ID, ADDRESS , CREATED_AT, EMAIL, FULL_NAME,LAST_LOGIN_AT,
MODIFIED_AT,PASSWORD,PHONE,USER_NAME)
VALUES(1,'CHETAKPURI',sysdate(),'r@gmail.com','richa ladkani',sysdate(),sysdate(),
'Richa@123','9876543210','richa');

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(101,sysdate(),'Addidas Shoes','https://rukminim1.flixcart.com/image/300/300/kg9qbgw0-0/shoe/h/m/4/creta-12cnblred-9-asian-blue-original-imafwjtfzrsv5wgm.jpeg?q=70'
,sysdate(),sysdate(),
'Shoes',1500);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(102,sysdate(),'Iphone 11','https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iphone13_hero_09142021_inline.jpg.large_2x.jpg'
,sysdate(),sysdate(),
'Iphone',100000);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(103,sysdate(),'Boat Earphone ','https://images.pexels.com/photos/248510/pexels-photo-248510.jpeg?auto=compress&cs=tinysrgb&w=600'
,sysdate(),sysdate(),
'Earphone',2000);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(104,sysdate(),' Lenevo Laptop ','https://images.pexels.com/photos/303383/pexels-photo-303383.jpeg?auto=compress&cs=tinysrgb&w=600'
,sysdate(),sysdate(),
'Laptop',1000);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(105,sysdate(),'pencil Heels ','https://images.pexels.com/photos/3782788/pexels-photo-3782788.jpeg?auto=compress&cs=tinysrgb&w=600'
,sysdate(),sysdate(),
'Heels',1000);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(106,sysdate(),'Alexa ','https://images.pexels.com/photos/4790267/pexels-photo-4790267.jpeg?auto=compress&cs=tinysrgb&w=600'
,sysdate(),sysdate(),
'Alexa',1000);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(107,sysdate(),'Smart Tvs ','./images/SmartTv.png'
,sysdate(),sysdate(),
'Television',1000);

INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(108,sysdate(),'Watch ','https://images.pexels.com/photos/190819/pexels-photo-190819.jpeg?auto=compress&cs=tinysrgb&w=600'
,sysdate(),sysdate(),
'Watch',1000);


INSERT INTO PRODUCT (ID, CREATED_AT, DESCRIPTION,IMAGE,
LAST_LOGIN_AT,
MODIFIED_AT,NAME,PRICE)
VALUES(109,sysdate(),'Umbrella ','https://images.pexels.com/photos/751099/pexels-photo-751099.jpeg?auto=compress&cs=tinysrgb&w=600'
,sysdate(),sysdate(),
'umbrella',500);


INSERT INTO ADDRESS(ID, ADDRESS, CREATED_AT, MODIFIED_AT, USER_ID)
VALUES(1, 'Mysore', sysdate(), sysdate(), 1);
