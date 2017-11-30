import User
import collections
class AccountDuplicatedException (Exception): pass
class AccountNotFoundException  (Exception): pass
class PasswordNotCorrectException (Exception): pass

Login = collections.namedtuple("Login", "account password name")
class LoginSystem:
    FILE_PATH = r'../../資源區/IO進階登入/帳密.txt'
    def __init__(self):
        self.__accountsMap = {}
        self.__prepareAccounts()

    def __prepareAccounts(self):
        with open(LoginSystem.FILE_PATH, 'r') as file:
            lines = file.readlines()
            for line in lines:
                login = Login(*line.split(" "))
                self.__accountsMap[login.account] = login
        print (self.__accountsMap)

    def signIn(self, account, password):
        if account not in self.__accountsMap:
            raise AccountNotFoundException()
        if self.__accountsMap[account].password != password:
            raise PasswordNotCorrectException()
        return User.User(self.__accountsMap[account].name)
    
    def signUp(self, account, password, name):
        if account in self.__accountsMap:
            raise AccountDuplicatedException()
        self.__addAndWriteMember(account, password, name)
        return User.User(name)
        
    def __addAndWriteMember(self, account, password, name):
        with open(LoginSystem.FILE_PATH, 'a+') as file:
            file.write(account + " " + password + " " + name + "\n")
            self.__accountsMap[account] = Login(account, password, name)

    
            
                