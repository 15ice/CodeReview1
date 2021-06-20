#!/bin/bash

rm -rf result
mkdir result
cd src
javac Main.java

time bash ../test.sh

echo -e "\n### 期待値との差異 ###"
diff ../data/out ../result

qnum=$(ls ../data/in/ | wc -l)
oknum=$(($qnum - $(diff ../data/out/ ../result/ | grep -o -i diff | wc -l)))
if [ $oknum -eq $qnum ]; then
  echo "差異なし"
fi

echo -e "\n### 正答数 ###"
echo $oknum / $qnum