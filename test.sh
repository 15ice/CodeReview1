#!/bin/bash
for file in `ls ../data/in/*.txt`; do
  cat $file
  java Main `cat $file` > ../result/`basename $file`
  cat ../result/`basename $file`
done