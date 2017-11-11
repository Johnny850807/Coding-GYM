import copy

class NoElementException(StopIteration): pass
class FullStackException(Exception): pass

class MyStack:
    FRONT, END = (False, True) # used for iteration
    def __init__(self, maxSize=40, elements=None):
        self.__top = -1
        self.__front = 0
        self.__header = MyStack.FRONT
        self.__maxSize = maxSize
        self.__elements = [0] * self.maxSize if elements == None else elements

    def push(self, data):
        if self.top == self.maxSize - 1:
                raise FullStackException()
        self.top += 1
        self.__elements[self.top] = data
        self.__elements[0:self.top+1] = sorted(self.__elements[0:self.top+1]) # such as [std1, std2, 0, 0, 0], we need avoiding sorts between  object and int
    
    def pop(self):
        if self.front > self.top:
            raise NoElementException()
        if self.header == MyStack.FRONT:
            element = self.__elements[self.front]
            self.front += 1
        else:
            element = self.__elements[self.top]
            self.top -= 1
        
        self.header = not self.header # reverse to another side
        return element
    
    def __iter__(self):
        return Iterator(self) # the class iterator created for iterating the copied stack.

    def __delitem__(self, index): # no supports 'del list[index]'
        raise NotImplementedError()

    def __getitem__(self, index): # supports 'list[index]'
        return self.__elements[index]
    
    def __setitem__(self, index): # no supports 'list[index] = data'
        raise NotImplementedError()

    def __len__(self): # supports 'len(list)'
        return len(self.__elements)
    
    def __contains__(self, value): # supports 'data in list'
        return value in self.__elements
    
    def __str__(self): # supports 'str(object)'
        return str(self.__elements)

    def __eq__(self, other): # supports 'object1 == object2'
        if not isinstance(other, MyStack):
            return False
        return self.__elements == other.__elements

    @property
    def top(self): ## the getter of top
        return self.__top
    
    @top.setter  ## the setter of top
    def top(self, value):
        self.__top = value

    @property
    def front(self): ## the getter of top
        return self.__front

    @front.setter  ## the setter of front
    def front(self, value):
        self.__front = value

    
    @property ## the getter of maxSize
    def maxSize(self):
        return self.__maxSize

    @property
    def header(self):
        return self.__header

    @header.setter
    def header(self, value):
        self.__header = value

class Iterator:
    def __init__(self, stack):
        self.stack = copy.deepcopy(stack)

    def __next__(self):
        return self.stack.pop()