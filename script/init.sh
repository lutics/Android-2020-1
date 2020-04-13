#!/bin/bash

rm -rf .git
git init
git add .
git commit -m "Initial Commit"
git remote add origin git@github.com:lutics/Android-Pre-interview-Assignment-1.git
git push -f -u origin master
