#!/bin/bash
for x in $(ls -1)
do
	if [ -f $x ]
	then
		echo "ROOT"
		wc -l $x
	fi
done

