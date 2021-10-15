import string

# Write a string that returns just the letter ‘r’ from ‘Hello World’
def return_r():
    print("Hello World"[8])

# String slicing to grab the word ‘ink’ from the word  ‘thinker’
def grab_word_from(word):
    print(word[2:5])

# S=’Sammy’ what is the output of s[2:]”
def sammy_output():
    print("Sammy"[2:])

# With a single set function can you turn the word ‘Mississippi’ to distinct character word.
def distinct_char_word():
    print(''.join(set('Mississippi')))

def palindrome():
    phrases = ["Stars",
                "O, a kak Uwakov lil vo kawu kakao!",
                "Some men interpret nine memos"
            ]
    for phrase in phrases:
        cleaned = phrase.strip(string.punctuation).replace(",", "").replace(" ", "").lower()
        reverse = cleaned[::-1]
        if cleaned == reverse:
            print('Y')
        else:
            print('N')

# Function Invocations
if(True):
    return_r()
    grab_word_from("thinker")
    sammy_output()
    distinct_char_word()
    palindrome()


