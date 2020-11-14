package org.fivt.atp.bigdata

import org.apache.spark.sql.SparkSession

object DummyMain {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .getOrCreate()
    import spark.implicits._
    val data = spark.createDataset(0 until 10)
      .toDF("value")
    data.show(false)
  }

}
