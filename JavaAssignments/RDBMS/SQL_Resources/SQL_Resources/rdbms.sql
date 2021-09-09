-- Get the bookId by querying the tbl_book table WHERE the title it 'The Lost Tribe'
select bookId from tbl_book WHERE title="The Lost Tribe"; -- bookId for that book is 1
select branchId from tbl_library_branch WHERE branchName="Sharpstown"; -- branchId for Sharpstown is 1

-- This query will ask for the data in the noOfCopies column where the branchId and the bookId match.
select noOfCopies from tbl_book_copies WHERE branchId=1 AND bookId=1; 

-- How many copies of the book titled The Lost Tribe are owned by each library branch?
	-- I inserted a new record just so there could be multiple branches with the bookId that corresponds to "The Lost Tribe".
    -- Used the simple SUM aggregate function to add the total noOfCopies.
select SUM(noOfCopies) from tbl_book_copies WHERE bookId=1; -- Since 'The Lost Tribe' has id of 1

-- Retrieve the names of all borrowers who do not have any books checked out .
select * from tbl_borrower where not exists ( 
			select * from tbl_book_loans
			WHERE tbl_borrower.cardNo = tbl_book_loans.cardNo 
		);

-- simple test to see if any book_loans correspond with a borrower that is not in that table. Returns null :)
-- select * from tbl_book_loans WHERE cardNo = 4;

-- For each book that is loaned out from the "Sharpstown" branch and whose DueDate is today, retrieve the book title, the borrower's name, and the borrower's address.

select B.title, BO.name, BL.address
from tbl_book B, tbl_borrower BO, tbl_book_loans BL, tbl_library_branch LB -- using variables here cause listing the table names is too long.
where LB.branchId='Sharpstown' and LB.branchId=BL.branchId and
BL.dueDate='today' and BL.cardNo=R.cardNo and BL.bookId=B.bookId

-- For each library branch, retrieve the branch name and the total number of books loaned out from that branch.

SELECT tbl_library_branch.branchName, COUNT(*) FROM tbl_book_loans, tbl_library_branch
WHERE tbl_book_loans.branchId = tbl_library_branch.branchId
GROUP BY tbl_library_branch.branchId 

-- Retrieve the names, addresses, and number of books checked out for all borrowers who have more than five books checked out. 

select name, address, COUNT(*) from tbl_borrower, tbl_book_loans where tbl_borrower.cardNo = tbl_book_loans.cardNo
GROUP BY tbl_borrower.cardNo HAVING COUNT(*) > 5

-- For each book authored (or co-authored) by "Stephen King", retrieve the title and the number of copies owned by the library branch whose name is "Central"

	-- Natural Join joins two tables based on same attribute name and datatypes. The resulting table will contain all the attributes of both the table but keep only one copy of each common column.
	
SELECT title, noOfCopies FROM ( ( (tbl_author NATURAL JOIN tbl_book) NATURAL JOIN tbl_book_copies) NATURAL JOIN tbl_library_branch) WHERE authorName = 'Stephen King' and branchName = 'Central'












 

 
 





