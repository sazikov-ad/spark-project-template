# Apache Spark application template project

This template project demonstrates how to build, test and package an application
written in [Scala](https://www.scala-lang.org/) programming language
and using [Apache Spark](https://spark.apache.org/) framework.
The project uses [Maven](https://maven.apache.org/) as a build tool.
The Spark application runs in YARN.

The `spark-project-template-apps` sub-module contains Spark applications.
Initially there is only a dummy Scala application `DummyMain`.
There is also a dummy unit test.

The `spark-project-template` sub-module packages the distribution archive.
It also provides default configuration files and the application launcher.

## Build, run unit tests, package

Run a Maven command:
```shell script
mvn clean install
```
The command will compile the Scala code, run unit tests and assemble the distribution.
The distribution will be generated here:
```
spark-project-template/target/spark-project-template-<version>.zip
```

## Deploy and run

1. Copy the distribution to an edge node of your Hadoop cluster.
   This node should have connectivity to HDFS and YARN.
   ```shell script
   scp spark-project-template/target/spark-project-template-<version>.zip <username>@<edgenode hostname>:
   ```

1. Login to the edge node:
   ```shell script
   ssh <username>@<edgenode hostname>
   ```
   
1. Unpack the distribution:
   ```shell script
   test -d spark-project-template && rm -r spark-project-template ; unzip spark-project-template-<version>.zip
   ```

1. Make sure that `spark2-submit` is in your PATH:
   ```shell script
   command -v spark2-submit
   ```

1. Make sure the `HADOOP_CONF_DIR` environment variable
   points to the directory with Hadoop configuration files:
   ```shell script
   echo $HADOOP_CONF_DIR
   ```
   The output should look like `/etc/hadoop/conf`.
   Consult with the administrator of your Hadoop cluster for the correct path.
   
1. Run the application:
   ```shell script
   ./spark-project-template/bin/dummy-spark-submit.sh
   ```
   
1. Go to Spark UI and see the application progress
   The dummy Spark application will run for a few minutes.
