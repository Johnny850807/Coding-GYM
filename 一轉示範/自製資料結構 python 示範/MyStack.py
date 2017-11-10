
class MyStack{
    def __init__(self):
        self.__elements = []
        self.
    
    def push(self, data):
        pass
    
    def pop(self):
        pass
    
    def __iter__(self):
        return iter(self.__elements)

    def __next__(self):
        pass

    def __delitem__(self, index):
        raise NotImplementedError()

    def __getitem__(self, index):
        return self.__elements[index]
    
    def __setitem__(self, index):
        raise NotImplementedError()

    def __len__(self):
        return len(self.__elements)
    
    def __contains__(self, value):
        return value in self.__elements
    
    def __str__(self):
        return str(self.__elements)

    def __eq__(self, other):
        if other not isinstance MyStack:
            return False
        return self.__elements == other.__elements
}