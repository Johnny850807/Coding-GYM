class Student:
    def __init__(self, value):
        self._value = int(value)

    @property
    def value(self):
        return self._value

    def __lt__(self, other):
        return self.value < other.value

    def __hash__(self):
        return id(self)
    
    def __eq__(self, other):
        return self.value == other.value

    def __str__(self):
        return str(self.value)