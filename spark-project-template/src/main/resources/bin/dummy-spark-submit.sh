#!/usr/bin/env bash

# TODO log config
# TODO Spark config - via file
# TODO fat jar is in lib/
spark2-submit \
  --master yarn \
  --deploy-mode cluster \
  --name Dummy \
  --class org.fivt.atp.bigdata.DummyMain \
  @{project.artifactId}-@{project.version}.jar
