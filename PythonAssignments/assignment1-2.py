# Numbers: Example code to add two numbers 50+50 and 100-10 and print it.
def first_assignment1():
    print(50 + 50)
    print(100 - 10)
    print("This was the first problem solved :)")


# 30+*6,6^6,6**6,6+6+6+6+6+6
def first_assignment2():
    print(30 * 6)
    print(6 ^ 6)
    print(6 ** 6)
    print(6 + 6 + 6 + 6 + 6 + 6)
    print("This was the second problem solved :)")

# Print “Hello World” on the console output. Print output “Hello World : 10”
# Make sure capitalization and spacing matches.
def first_assignment3():
    print("Hello World")
    print("Hello World : 10")

# For example, Joel takes P = $800,000 from bank with interest rate of R = 6%. He is willing to pay M = $10000 at the end of each month.
    # So after 103 months (which is about 8.5 years) the debt could be payed out. The last payment of course could be less than M (since P need not to become negative). Note that he will pay out about:
def mortgage_calc(numOfMonths):
    p = 800000
    r = 0.06 / 12
    payment = (p * r * (1 + r) ** numOfMonths) / ((1 + r) ** numOfMonths - 1)
    print(payment)

# Function Invocations
first_assignment1()
first_assignment2()
first_assignment3()
mortgage_calc(103)