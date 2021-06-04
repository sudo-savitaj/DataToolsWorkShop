import config.AppConfigComponent
import sparkSQL.employee.EmployeeComponent

object AppComponentRegistery extends AppConfigComponent
  with EmployeeComponent
{
  override val appConfigService = new AppConfigService()
  private val dbURL = "jdbc:sqlserver://localhost:1433;database=InputDB"
  private val username = "sa"
  private val password = "p@ssw0rd"
  override val dataFrameReaderService: AppComponentRegistery.DataFrameReaderService = new DataFrameReaderService(appConfigService.sparkSession,dbURL,username,password)
  override val employeeService: AppComponentRegistery.EmployeeService = new EmployeeService(appConfigService.sparkSession)
}
