# Ryan Christopher
#Client.py Notebook

import socket
import sys 
import time 

# Create sock and port
x = socket.socket()
h_name = input(str(" Enter the hostname of the server"))
Port = 8080

# Connect the host to the port
x.conect((h_name,port))
print("Connected to chat server")

#Display the message
while 1:
    incoming_message = s.recv(1024)
    incoming_message = incoming message.decode()
    print(" Server :", incoming message)
    message = input(str(">>"))
    Message = message.encode()
    s.send(message)
    print(" message has been sent...")