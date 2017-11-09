class User:

    def __init__(self, name):
        self.__name = name
    
    @property
    def name(self):
        return self.__name
    
    def __str__(self):
        return "User: {0.name}".format(self)
