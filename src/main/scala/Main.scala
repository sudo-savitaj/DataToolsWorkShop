import java.util.Properties

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    var sparkSession = SparkSession
      .builder()
      .appName("first")
      .getOrCreate()

    val driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver"

    var connectionProperties = new Properties()
    connectionProperties.put("user", s"sa")
    connectionProperties.put("password", s"p@ssw0rd")
    connectionProperties.setProperty("driver",  s"${driverClass}")

    val jdbcUrl = "jdbc:sqlserver://localhost:1433;database=InputDB"

    val employeeDF= sparkSession.read.jdbc(jdbcUrl,"employee",connectionProperties)

    employeeDF.show()

  }

}
