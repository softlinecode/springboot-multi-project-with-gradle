CREATE DATABASE springboot DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'springbooter'@'localhost' IDENTIFIED BY 'springbooter123';

use mysql;

INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','springboot','springbooter','Y','Y','Y','Y','Y','Y','Y','Y');

FLUSH PRIVILEGES;


CREATE DATABASE springweb DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'springweber'@'localhost' IDENTIFIED BY 'springweber123';

use mysql;

INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','springweb','springweber','Y','Y','Y','Y','Y','Y','Y','Y');

#springbooter 에 다른 디비에서 권한을 준다
INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','springweb','springbooter','Y','Y','Y','Y','Y','Y','Y','Y');

FLUSH PRIVILEGES;