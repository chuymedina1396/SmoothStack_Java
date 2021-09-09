-- Get the bookId by querying the tbl_book table WHERE the title it 'The Lost Tribe'
select bookId from tbl_book WHERE title="The Lost Tribe"; -- bookId for that book is 1
select branchId from tbl_library_branch WHERE branchName="Sharpstown"; -- branchId for Sharpstown is 1

-- This query will ask for the data in the noOfCopies column where the branchId and the bookId match.
select noOfCopies from tbl_book_copies WHERE branchId=1 AND bookId=1; 

-- How many copies of the book titled The Lost Tribe are owned by each library branch?
	-- I inserted a new record just so there could be multiple branches with the bookId that corresponds to "The Lost Tribe".
    -- Used the simple SUM aggregate function to add the total noOfCopies.
select SUM(noOfCopies) from tbl_book_copies WHERE bookId=1;

-- Retrieve the names of all borrowers who do not have any books checked out .
select * from tbl_borrower where not exists ( 
			select * from tbl_book_loans
			WHERE tbl_borrower.cardNo = tbl_book_loans.cardNo 
		);

-- simple test to see if any book_loans correspond with a borrower that is not in that table. Returns null :)
select * from tbl_book_loans WHERE cardNo = 4;

-- For each book that is loaned out from the "Sharpstown" branch and whose DueDate is today, retrieve the book title, the borrower's name, and the borrower's address.

select B.title, BO.name, BL.address
from tbl_book B, tbl_borrower BO, tbl_book_loans BL, tbl_library_branch LB
where LB.branchId='Sharpstown' and LB.branchId=BL.branchId and
BL.dueDate='today' and BL.cardNo=R.cardNo and BL.bookId=B.bookId

-- For each library branch, retrieve the branch name and the total number of books loaned out from that branch.

SELECT LB.branchName, COUNT(*)
FROM tbl_book_loans BL, tbl_library_branch LB
WHERE BL.branchId = LB.branchId
GROUP BY LB.branchId 

SELECT B.name, B.address, COUNT(*)
FROM tbl_borrower B, tbl_book_loans BL
WHERE B.cardNo = BL.cardNo
GROUP BY B.cardNo
HAVING COUNT(*) > 5

SELECT title, noOfCopies
FROM ( ( (tbl_author NATURAL JOIN tbl_book)
NATURAL JOIN tbl_book_copies)
NATURAL JOIN tbl_library_branch)
WHERE authorName = 'Stephen King' and branchName = 'Central'












 

 
 





