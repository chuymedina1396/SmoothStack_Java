-- Basics
-- What query would you run to get all of the users?
SELECT * 
FROM users;

-- What query would you run to only get the first names of all of the users?
SELECT first_name 
FROM users;

-- What query would you run to only get the first and last names of all of the users?
SELECT first_name, last_name
FROM users;

-- SELECT w/ Conditionals
-- What query would you run to only get the first name of users with id of 2?
SELECT first_name
FROM users
WHERE id = 2;

-- What query would you run to get the last names of users with id of 2 or 3?
SELECT last_name
FROM users
WHERE id = 2 OR id = 3;

-- What query would you run to get all of the users with id greater than 2?
FROM users
WHERE id > 2;

-- What query would you run to get all of the users with id less than or equal to 3?
SELECT *
FROM users
WHERE id <= 3;

-- What query would you run to get all of the users with first names ending in "e"?
SELECT * 
FROM users
WHERE first_name LIKE "%e";

-- What query would you run to get all of the users with first names starting in "K"?
SELECT * 
FROM users
WHERE first_name LIKE "K%";

-- SELECT w/ Sorting
-- What query would you run to get all of the users with the youngest users at the top of the table?

-- What query would you run to get all of the users with the youngest users at the top of the table?

SELECT *
FROM users
ORDER BY birthday DESC;

-- What query would you run to get all of the users with the oldest users at the top of the table?

-- default for order by is ascending.
SELECT *
FROM users
ORDER BY birthday ASC;

-- What query would you run to get all of the users with the first name that ends with "e" with the youngest users at the top of the table?

SELECT *
FROM users
WHERE first_name LIKE "%e"
ORDER BY birthday DESC;

-- What query would you run to get only the first names of all of the users in alphabetical order?

SELECT first_name
FROM users
ORDER BY first_name;

-- SELECT w/ LIMIT and OFFSET
-- What query would you run to get the first 3 users?
SELECT *
FROM users
LIMIT 3;

-- What query would you run to get user records 3-5?
SELECT *
FROM users
LIMIT 3
OFFSET 2;

-- You could also combine LIMIT and OFFSET like this:
SELECT *
FROM users
LIMIT 2,3;

-- Inserting Records
-- The SQL command pattern for INSERTing records is as follows:

INSERT INTO table_name (column_name1, column_name2) 
VALUES('column1_value', 'column2_value');

insert into users (first_name, last_name, handle, birthday)
values('Chuy','Medina', 'chuymedina96', '1996-07-13');

-- Updating Records
-- The SQL command pattern for updating/editing records is as follows:

UPDATE table_name SET column_name1 = 'some_value', column_name2='another_value' 
WHERE condition(s)

-- Deleting Records
-- The SQL command pattern for deleting/removing records is as follows:

DELETE FROM table_name WHERE condition(s)

-- Functions can be applied to the selected columns. There can be a variety of reasons why you might want to use functions. Below are some of the most commonly used functions separated by the purpose for using them. Get familiar with how to use some of these functions, but DO NOT TRY TO MEMORIZE ALL OF THESE. If you understand how functions work, then you should be able to quickly reference a function and understand how to use it.

-- When calling a function on a column, make sure that column is the appropriate Data Type for that function.

-- Text Functions Data Types (VARCHAR, TEXT, CHAR etc.)

-- Numeric Functions Data Types (INT, BIGINT, FLOAT etc.)

-- Date and Time Functions Data Types (DATETIME)

-- Format for running functions on a table
SELECT FUNCTION (column) FROM table_name


-- Joins
-- Joining Tables
    -- Objectives:
    -- What is a JOIN?
    -- Which tables from a database may be joined?
    -- How are tables joined?
    -- What purpose does joining tables serve?

-- Remember foreign keys from the last chapter? We now get to put them to use! We JOIN two tables on the ids that match each other. This means that we can't JOIN tables together that don't have a relationship with each other (e.g. One to One, One to Many, Many to Many). A foreign key in a table matches up directly with an id in another table. Let's take a peek at what this looks like.




















































