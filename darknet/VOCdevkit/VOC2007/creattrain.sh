# /usr/bin/env sh
DATA=JPEGImages
rm -rf $DATA/train.txt
echo "Create。。"
find $DATA -name *.jpg | cut -d '/' -f2-2 >>$DATA/train.txt
echo "DONE"
