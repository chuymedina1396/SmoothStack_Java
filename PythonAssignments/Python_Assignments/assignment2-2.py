# Create a list with one number, one word and one float value. Display the output of the list.
def print_list():
    myList = [1,"word",2.50]
    print(myList)

# I have a nested list [1,1[1,2]], how to grab the value of 2 from the list.

def get_nester():
    list = [1,1,[1,2]]
    print(list[2][1])

# lst=['a','b','c'] What is the result of lst[1:]?

def result_in_list():
    lst=['a','b','c']
    print(lst[1:])
    # Output = ['b', 'c']

# Create a dictionary with weekdays as keys and week index numbers as values.do assign dictionary to a variable

def weekdays_dict(day):
    weekdays = {
        'SUNDAY': 1,
        'MONDAY': 2,
        'TUESDAY': 3,
        'WEDNESDAY': 4,
        'THURSDAY': 5,
        'FRIDAY': 6,
        'SATURDAY': 7}
    print(weekdays[day])

# D={‘k1’:[1,2,3]} what is the output of d[k1][1]

def get_output_dict():
    D={"k1":[1,2,3]}
    print(D["k1"][1])

# Can you create a list [1,[2,3]] into a tuple

def list_to_tuple():
    list = [1, [2, 3]]
    print(tuple(list))

# With a single set function can you turn the word ‘Mississippi’ to distinct character word.
def turn_word_distinct():
    print(''.join(set('Mississippi')))

# Can you add an element ‘X’ to the above created set
def add_x_to_list(word):
    distinct = set(word)
    distinct.add('X')
    print(distinct)

# Output of set([1,1,2,3])
def out_this_list():
    list = [1, 1, 2, 3]
    print(set(list))

# Write a program which will find all such numbers which are divisible by 7 but are not a multiple of 5,between 2000 and 3200 (both included).
def find_nums():
    list = []
    for num in range(2000,3200):
        if(num % 7 == 0) and (num % 5 != 0):
            list.append(num)
    print(list)

# Write a program which can compute the factorial of a given numbers.
	# The results should be printed in a comma-separated sequence on a single line.
	# Suppose the following input is supplied to the program:
    # 8
        # Then, the output should be:
        # 40320
# Solution:
	# def fact(x):
	#     if x == 0:
	#         return 1
	#     return x * fact(x - 1)

# My Solution
def factorial(num):
    total = num
    while num > 1:
        num -= 1
        total *= num
    print(total)

# Question:
	# With a given integral number n, write a program to generate a dictionary that contains (i, i*i) such that is an integral number between 1 and n (both included). and then the program should print the dictionary.
	# Suppose the following input is supplied to the program:
	# 8
	# Then, the output should be:
	# {1: 1, 2: 4, 3: 9, 4: 16, 5: 25, 6: 36, 7: 49, 8: 64}

# def gen_dict(n):
    


if __name__ == '__main__':
    print_list()
    get_nester()
    result_in_list()
    get_output_dict()
    list_to_tuple()
    turn_word_distinct()
    add_x_to_list("Mississippi")
    out_this_list()
    find_nums()
    factorial(4)




    