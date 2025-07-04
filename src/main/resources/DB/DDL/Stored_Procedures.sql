-- 查詢所有員工

`DELIMITER //`

`CREATE PROCEDURE` getAllEmp()

`BEGIN` 

select EMP_ID, NAME, EMAIL, FLOOR_SEAT_SEQ from Employee order by EMP_ID;

`END //`

`DELIMITER ;`


-- 查詢所有座位

`DELIMITER //`

`CREATE PROCEDURE` getAllSeats()

`BEGIN` 

select FLOOR_SEAT_SEQ, FLOOR_NO, SEAT_NO from SeatingChart order by FLOOR_NO, SEAT_NO;

`END //` 

`DELIMITER ;`


-- 更新座位

`DELIMITER //`

`CREATE PROCEDURE` updateEmpSeating(IN empId INT, IN seatSeq INT)

`BEGIN` 

update Employee set FLOOR_SEAT_SEQ = seatSeq where EMP_ID = empId;

`END //` 

`DELIMITER ;`

-- 刪除已佔用的座位

`DELIMITER //`

`CREATE PROCEDURE` deleteEmpSeating(IN empId INT)

`BEGIN` 

update Employee set FLOOR_SEAT_SEQ = NULL where EMP_ID = empId;

`END //` 

`DELIMITER ;`