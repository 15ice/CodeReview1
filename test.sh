#!/bin/sh
// 例: javac ***.java
for file in $(find ../data/in/*.txt); do
  out="../result/$(basename $file)"
  java Main $file > $out
  cat $out
done
