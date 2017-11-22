from abc import ABCMeta, abstractmethod

# 抽象類別基本教學請至: https://openhome.cc/Gossip/Python/AbstractClass.html
class Human(metaclass=ABCMeta):

    @abstractmethod
    def eat(self):
        pass

    @abstractmethod
    def sleep(self):
        pass

class Man(Human):
    def eat(self):
        print ("好好吃")

    def sleep(self):
        print ("zzz")

class Woman(Human):
    def eat(self):
        print ("Orzz")

    def sleep(self):
        print (":)")


