# Ryan Christopher
# Dice Roll Simulator

import random

def roll1() :
    print("\n")
    print("\t      000     ")
    print("\t   000000     ")
    print("\t   000000     ")
    print("\t      000     ")
    print("\t      000     ")
    print("\t      000     ")
    print("\t      000     ")
    print("\t      000     ")

def roll2() :
    print("\n")
    print("\t   00000000   ")
    print("\t 000     000  ")
    print("\t        0000  ")
    print("\t       0000   ")
    print("\t    0000      ")
    print("\t  0000        ")
    print("\t 0000         ")
    print("\t 00000000000  ")

def roll3() :
    print("\n")
    print("\t   0000000    ")
    print("\t 000     000  ")
    print("\t         000  ")
    print("\t       0000   ")
    print("\t         000  ")
    print("\t         000  ")
    print("\t 000     000  ")
    print("\t  000000000   ")

def roll4() :
    print("\n")
    print("\t 000     000  ")
    print("\t 000     000  ")
    print("\t 000     000  ")
    print("\t 000     000  ")
    print("\t 00000000000  ")
    print("\t         000  ")
    print("\t         000  ")
    print("\t         000  ")

def roll5() :
    print("\n")
    print("\t 00000000000  ")
    print("\t 000          ")
    print("\t 000          ")
    print("\t 0000000000   ")
    print("\t         000  ")
    print("\t         000  ")
    print("\t 000     000  ")
    print("\t  000000000   ")

def roll6() :
    print("\n")
    print("\t  000000000   ")
    print("\t 000     000  ")
    print("\t 000          ")
    print("\t 0000000000   ")
    print("\t 000     000  ")
    print("\t 000     000  ")
    print("\t 000     000  ")
    print("\t  000000000   ")



def main() :
    # selection = input("Would you like to roll the dice?\n[Yes || No]\t")
    test = False
    while (test == False) :
        selection = input("\nWould you like to roll again?\n[Yes || No]\t")
        if (selection == "Yes" or selection == "No") :
            test = True
        else :
            print("\n" + selection + " was not a valid response.")

    print(selection)

    while (selection == "Yes") :    #Prints Dice Roll until user decides to stop
        print("\nDice Roll: ")
        num = random.randint(1, 6)     #Prints random number between 0 and 6

        if (num == 1) :
            roll1()
        elif (num == 2) :
            roll2()
        elif (num == 3) :
            roll3()
        elif (num == 4) :
            roll4()
        elif (num == 5) :
            roll5()
        else :
            roll6()

        test = False
        while (test == False) :
            selection = input("\nWould you like to roll again?\n[Yes || No]\t")
            if (selection == "Yes" or selection == "No") :
                test = True
            else :
                print("\n" + selection + " was not a valid response.")


    print("\nThank you for playing the Dice Roll Simulator!")


main()