create table springboot.hello (
    id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    message VARCHAR(255) NOT NULL COMMENT 'message',
    modifiedAt datetime(6) NOT NULL COMMENT 'modified time',
	  createdAt datetime(6) NOT NULL COMMENT 'created time',
    primary key (id)
) ENGINE=InnoDB;