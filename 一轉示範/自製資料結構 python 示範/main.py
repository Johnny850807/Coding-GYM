from MyStack import *
from Student import Student

mStack = MyStack()

try:
    for i in range(9,-1,-1):
        mStack.push(Student(i))

    for element in mStack:
        print (str(element), end=" ")
    
    print()
    while(True):
        print(str(mStack.pop()), end=" ")

except NoElementException as err:
    print ("The Stack is empty.")

