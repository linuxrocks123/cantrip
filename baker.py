#! /usr/bin/env python

import os

FLAGS="-g"

flist = os.listdir(".")

def has_suffix(filename,suffix):
    if filename.rfind(suffix)==-1:
        return False
    return filename.rfind(suffix)+len(suffix)==len(filename)

def get_headers(fname):
    f = open(fname)
    lines = f.read().splitlines()
    for line in lines:
        if line.find("#include")==0:
            to_include = line.split()[1]
            if to_include[0]=='"':
                print to_include[1:len(to_include)-1]+" / "+fname
                print fname+" touch "+fname

common_objects = []
for fname in flist:
    if has_suffix(fname,".java"):
        base_name = fname[:len(fname)-5]
        print base_name+".java / "+base_name+".class"
        print base_name+".class javac "+FLAGS+" "+base_name+".java"
    elif has_suffix(fname,".y"):
        base_name = fname[:len(fname)-2]
        print base_name+".y / "+base_name+".java"
        print base_name+".java bison "+base_name+".y"
    elif has_suffix(fname,".l"):
        base_name = fname[:len(fname)-2]
        print base_name+".l / Yylex.java"
        print "Yylex.java ./jflex "+base_name+".l"
    elif has_suffix(fname,".xxd"):
        base_name = fname[:len(fname)-4]
        print base_name+".can / "+base_name+".xxd"
        print base_name+'.xxd sh -c "xxd -i < '+base_name+'.can > '+base_name+'.xxd"'
    elif has_suffix(fname,".jxxd"):
        get_headers(fname)
        base_name = fname[:len(fname)-5]
        print base_name+".jxxd / "+base_name+".java"
        print base_name+'.java sh -c "cpp -CC -P -nostdinc '+base_name+'.jxxd -o '+base_name+'.java"'
