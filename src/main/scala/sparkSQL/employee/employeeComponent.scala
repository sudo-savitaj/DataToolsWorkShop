package sparkSQL.employee

import org.apache.spark.sql.SparkSession
import sparkSQL.DataFrameReader.DataFrameReaderComponent

trait EmployeeComponent extends DataFrameReaderComponent {
  val employeeService: EmployeeService;
  val employee = "employee"

  class EmployeeService(conf: SparkSession) {
    def print() {
      val employeeDF = dataFrameReaderService.get(employee)
      employeeDF.show()
    }
  }

}
