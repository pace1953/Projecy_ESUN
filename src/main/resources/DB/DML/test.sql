-- 預設從10000開始
ALTER TABLE Employee AUTO_INCREMENT = 10000;
-- 先插入資料測試
insert into employee (emp_id, email, name) values ('10000', 'pace1953@gmail.com', 'Pace');
insert into seating_chart (floor_no, seat_no) values (1, 1);
insert into employee (emp_id, email, name) values ('10001', 'box1019@gmail.com', 'Box');
insert into seating_chart (floor_no, seat_no) values (1, 2);

-- 查看目前的資料跟狀況
CALL getAllEmp();-
CALL getAllSeats();
CALL getSeatingOccupancy();
CALL getSeatingSeq(floorNo, seatNo)
CALL updateEmpSeating(empId, seatSeq);
CALL deleteEmpSeating(empId);

-- 先建立空座位
INSERT INTO seating_chart (floor_no, seat_no) VALUES 
(1, 3), (1, 4),
(2, 1), (2, 2), (2, 3), (2, 4),
(3, 1), (3, 2), (3, 3), (3, 4),
(4, 1), (4, 2), (4, 3), (4, 4);

-- 測試update
CALL updateEmpSeating(10000, 6);
CALL updateEmpSeating(10001, 1);
CALL getSeatingOccupancy();

-- 測試刪除
CALL deleteEmpSeating(10000);
CALL getSeatingOccupancy();

