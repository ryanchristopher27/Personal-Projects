# Ryan Christopher
# Dice Roll Simulator

import random

selection = input("Would you like to roll the dice?\n[Yes || No]\t")

print(selection)

while (selection == "Yes") :    #Prints Dice Roll until user decides to stop
    print("\nDice Roll: ")
    print(random.randint(1, 6))     #Prints random number between 0 and 6
    selection = input("\nWould you like to roll again?\n[Yes || No]\t")


print("\nThank you for playing the Dice Roll Simulator!")