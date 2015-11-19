#QF 365 HW 4

##Running the program
In the current directory:
'make'
'./main'
Python should set up the virtual environment for you, but if not then just 'pip install -r requirements.txt' and pip should have the right files, just change the virtualenv name in run.py

##Files
+ run.py - runs 'getData.py' through the virtualenv
+ getData.y - pulls stock data through yahoo finance for the appropriate date range, dumps all the data into './data' in the form of TICKERNAME.csv
+ requirements.txt - the python modules for the virtual environment
+ ./venv - the virtual environment for python
+ main.cpp - the main C++ file
+ makefile - the makefile for the whole thing, allows compiling with 'make'
