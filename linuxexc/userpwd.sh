#!/bin/bash
echo Executing $0 ...
echo -n Enter username:;
read username
echo $?
echo -n Enter password:;
stty -echo;
read password;
echo $?
stty echo;
echo
echo Your username is: $username and password is:$password
source sample.sh
echo Execution of $0 is completed.

