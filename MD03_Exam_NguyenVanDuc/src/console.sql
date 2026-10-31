USE db_degree_management;

CREATE TABLE degrees(
    degree_id INT PRIMARY KEY AUTO_INCREMENT,
    degree_name VARCHAR(150) NOT NULL ,
    emp_id VARCHAR(15) NOT NULL ,
    degree_date DATETIME NOT NULL ,
    school_name VARCHAR(100) NOT NULL ,
    degree_year INT NOT NULL ,
    degree_classification VARCHAR(20) NOT NULL
);

-- lấy all degree
DELIMITER //

CREATE PROCEDURE get_all_degrees()
BEGIN
    SELECT * FROM degrees;
END //

DELIMITER ;

-- thêm degree
DELIMITER //

CREATE PROCEDURE add_degrees(
    IN in_degree_name VARCHAR(150),
    IN in_emp_id VARCHAR(15),
    IN in_degree_date DATETIME,
    IN in_school_name VARCHAR(100),
    IN in_degree_year INT,
    IN in_degree_classification VARCHAR(20)
)
BEGIN
    INSERT INTO degrees(degree_name, emp_id, degree_date, school_name, degree_year, degree_classification)
    VALUES (in_degree_name, in_emp_id, in_degree_date, in_school_name, in_degree_year, in_degree_classification);
END //

DELIMITER ;

-- update degree
DELIMITER //

CREATE PROCEDURE update_degrees(
    IN in_degree_id INT,
    IN in_degree_name VARCHAR(150),
    IN in_emp_id VARCHAR(15),
    IN in_degree_date DATETIME,
    IN in_school_name VARCHAR(100),
    IN in_degree_year INT,
    IN in_degree_classification VARCHAR(20)
)
BEGIN
    UPDATE degrees
    SET
        degree_name = in_degree_name,
        emp_id = in_emp_id,
        degree_date = in_degree_date,
        school_name = in_school_name,
        degree_year = in_degree_year,
        degree_classification = in_degree_classification
    WHERE degree_id = in_degree_id;
END //

DELIMITER ;

-- xóa bằng id
DELIMITER //

CREATE PROCEDURE delete_degree(IN delete_id INT)
BEGIN
    DELETE FROM degrees
    WHERE degree_id = delete_id;
END //

DELIMITER ;

-- lấy degree theo emp_id
DELIMITER //

CREATE PROCEDURE get_by_emp_id(IN emp_id_search VARCHAR(15))
BEGIN
    SELECT * FROM degrees
    WHERE emp_id = emp_id_search;
END //

DELIMITER ;

-- lấy degree theo degree_name(tìm gần đúng)
DELIMITER //

CREATE PROCEDURE get_by_degree_name(IN degree_name_search VARCHAR(150))
BEGIN
    SELECT * FROM degrees
    WHERE degree_name LIKE CONCAT('%', degree_name_search, '%');
END //

DELIMITER ;

-- test
# INSERT INTO degrees(degree_name, emp_id, degree_date, school_name, degree_year, degree_classification)
# VALUES
#     ('degree 1', 'emp 1', '2024-10-20 08:00:00', 'school 1', 2024,'giỏi' ),
#     ('degree 2', 'emp 2', '2023-05-20 13:00:00', 'school 2', 2023,'trung bình' ),
#     ('degree 3', 'emp 3', '2022-07-20 16:00:00', 'school 3', 2022,'khá' );
# CALL get_all_degrees();
# CALL add_degrees('degree 4', 'emp 4', '2022-07-20 16:00:00', 'school 4', 2021,'khá' )
# CALL update_degrees(4, 'degree 4 update', 'emp 4', '2022-07-20 16:00:00', 'school 4', 2021,'khá' )
# CALL delete_degree(4)
# CALL get_by_emp_id('emp 2');
# CALL get_by_degree_name('gree 2')