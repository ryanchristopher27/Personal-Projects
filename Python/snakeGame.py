# Snake Game
# Ryan Christopher

import random
from turtle import Turtle
import keyboard  # using module keyboard

def moveTurtle(turtle, direction, quantity):
    while True:  # making a loop
        try:  # used try so that if user pressed other than the given key error will not be shown
            if keyboard.is_pressed('w'):  # if key 'w' is pressed (up)
                print('You Pressed A Key!')
                break  # finishing the loop
            elif keyboard.is_pressed('a'): # if key 'a' is pressed (left)
                print('a')
                break
            elif keyboard.is_pressed('s'): # if key 's' is pressed (down)
                print('s')
                break
            elif keyboard.is_pressed('d'): # if key 'd' is pressed (right)
                print('d')
                break
        except:
            break  # if user pressed a key other than the given key the loop will break

from pynput.keyboard import Key, Listener

def on_press(key):
    print('{0} pressed'.format(
        key))

def on_release(key):
    print('{0} release'.format(
        key))
    if key == Key.esc:
        # Stop listener
        return False

# Collect events until released
with Listener(
        on_press=on_press,
        on_release=on_release) as listener:
    listener.join()