create database banking;
use banking;
create table customers(
	id bigint(20) not null primary key auto_increment,
    balance decimal(14,0) default null,
    email varchar(255) not null unique,
    full_name varchar(255) ,
    phone varchar(255)
);

create table tranfers(
	id bigint(20) primary key not null auto_increment,
    fees int(11) not null,
    fees_amount decimal(14,0),
    transaction_amount decimal(14,0),
    transfer_amount decimal(14,0),
    reicepts_id bigint(20),
    sender_id bigint(20)
);

ALTER TABLE tranfers
ADD FOREIGN KEY (reicepts_id) REFERENCES customers(id);
ALTER TABLE tranfers
ADD FOREIGN KEY (sender_id) REFERENCES customers(id);

-- truy vấn
SELECT tran.sender_id as `id nguoi gui`,
 sender.full_name as `ten ng gui`, 
 tran.reicepts_id as `id ng nhan`,  
 reicepts.full_name as `ten ng nhan`,
 tran.transfer_amount as `so tien chuyen`,
 tran.fees as `phan tram`,
 tran.fees_amount as `so tien phi `,
 tran.transaction_amount as `so tien giao dich`
FROM
	tranfers AS tran,
    customers AS sender,
    customers AS reicepts
WHERE
	(tran.sender_id = sender.id)
AND (tran.reicepts_id = reicepts.id);


--

SELECT
	tran.id AS 'ID',
	tran.sender_id AS 'Sender ID',
    (SELECT sender.full_name FROM customers sender WHERE sender.id = tran.sender_id) AS 'Sender Name',
	tran.recipient_id AS 'Recipicent ID',
    (SELECT recipient.full_name FROM customers recipient WHERE recipient.id = tran.recipient_id) AS 'Recipicent ID',
	tran.transfer_amount AS 'Transfer Amount($)',
	tran.fees AS 'Fees(%)',
	tran.fees_amount AS 'Fees Amount($)',
	tran.transaction_amount AS 'Total Amount($)'
FROM transfers AS tran
