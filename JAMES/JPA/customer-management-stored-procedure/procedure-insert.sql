SELECT * FROM cms.customers;
use cms;
DELIMITER //
CREATE PROCEDURE Insert_Customer(
								IN first_Name varchar(255),
                                IN last_Name varchar(255)
								)
BEGIN
	INSERT INTO customers(firstName, lastName) 
    VALUES (first_Name, last_Name);
END//
DELIMITER ;