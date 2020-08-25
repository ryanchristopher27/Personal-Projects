# Ryan Christopher
# Guess The Number

import random

selection = input("Would You like to play Guess the Number?\n[Yes || No]\t")

while (selection == "Yes") :    # Continues to play the game until the user specifies to end it
    num = random.randint(0, 100)
    guess = int(input("\nGuess a number between 0 and 100\n"))

    if (guess == num) :     # Checks if your first guess was the correct number
        print("\nYou got it first try! The number was ", num)
    else :
        while (guess != num) :      # Repeats until the number is guessed
            if (guess > num) :
                print("The number is less than:", guess)
                guess = int(input("\nGuess again: \t"))
            elif (guess < num) :
                print("The number is greater than:", guess)
                guess = int(input("\nGuess again: \t"))
            else :
                print("\nYou guessed it! The number was:", guess)

    print("\nYou guessed it! The number was:", guess)

    selection = input("\nWould you like to play again?\n[Yes || No]\t")

print("\nThanks for playing Guess The Number!\n")
