from LoginSystem import *

loginSystem = LoginSystem()

while(True):
    try:
        loginSystem.logIn(input("輸入帳號: "), input("輸入密碼: "))
    except PairInfoNotFoundException as err:
        print ("帳密不符合")
    except AccountNotFoundException as err:
        print ("帳號不符合")
    except PasswordNotFoundException as err:
        print ("密碼不符合")
    else:
        print ("登入成功！")

