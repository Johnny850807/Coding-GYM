from Human import *

sexs = input().lower()
humans = [ Man() if sex == 'b' else Woman() 
                for sex in sexs ]
print (humans)
for human in humans:
    human.eat()

for human in humans:
    human.sleep()