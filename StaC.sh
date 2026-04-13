#!/bin/bash
# StaC build and run script
# Usage: ./StaC.sh <source_file.stac>

ANTLR_JAR="lib/antlr-4.5-complete.jar"
SRC_DIR="src"
OUT="out"

if [ -z "$1" ]; then
    echo "Usage: $0 <source_file.stac>"
    exit 1
fi

# generate parser from grammar
echo "Generating parser..."
cd src/stac
java -jar ../../$ANTLR_JAR -package stac.parser -no-listener -o parser StaC.g
if [ $? -ne 0 ]; then
    cd ../..
    echo "Error generating parser"
    exit 1
fi
cd ../..

# compile
echo "Compiling..."
mkdir -p $OUT
javac -cp $ANTLR_JAR -d $OUT $(find $SRC_DIR -name "*.java")
if [ $? -ne 0 ]; then
    echo "Error compiling"
    exit 1
fi

echo "Running..."
java -cp "$OUT:$ANTLR_JAR" stac.Interpreter $1