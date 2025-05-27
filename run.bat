@echo off
mkdir out 2>nul

dir /S /B *.java > sources.txt
javac -d out @sources.txt
del sources.txt

java -cp out mazegenerator.Main

pause