#!/bin/sh
mkdir -p src/{main,test}/{java,resources,scala} #create project structure
mkdir lib project target #create sbt build folders
echo 'name := "hello"
version := "1.0"
scalaVersion := "2.13.0"' > build.sbt #create an initial build.sbt file
