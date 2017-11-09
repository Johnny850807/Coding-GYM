from LoginSystem import *
import User

SIGN_IN, SIGN_UP, LEAVE = (1, 2, 3)
loginSystem = LoginSystem()

def signUp():
    name = input("Input name: ")
    account = input("Input account: ")
    password = input("Input password: ")
    user = loginSystem.signUp(account, password, name)
    print (str(user))

def signIn():
    account = input("Input account: ")
    password = input("Input password: ")
    user = loginSystem.signIn(account, password)
    print (str(user))

def doActions(action):
    if action == SIGN_IN:
        signIn()
    elif action == SIGN_UP:
        signUp()

def main():
    while(True):
        try:
            action = int(input("(1) Sign In (2) Sign Up (3) Leave :"))
            if (action == LEAVE):
                break
            doActions(action)
        except AccountDuplicatedException as err:
            print ("Account is duplicated !")
        except AccountNotFoundException as err:
            print ("Accout not found !")
        except PasswordNotCorrectException as err:
            print ("Password is not correct !")

main()