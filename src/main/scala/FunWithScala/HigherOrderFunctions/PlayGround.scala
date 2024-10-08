package FunWithScala.HigherOrderFunctions

object PlayGround {
  val salaries = Seq(20_000, 70_000, 40_000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
  println(salaries)
  println(newSalaries)

  val salaries2 = Seq(20_000, 70_000, 40_000)
  val newSalaries2 = salaries2.map(x => x * 2) // List(40000, 140000, 80000)
  println(salaries2)
  println(newSalaries2)

  val salaries3 = Seq(20_000, 70_000, 40_000)
  val newSalaries3 = salaries.map(_ * 2)
  println(salaries3)
  println(newSalaries3)

  case class WeeklyWeatherForecast(temperatures: Seq[Double]):
    private def convertCtoF(temp: Double) = temp * 1.8 + 32

    def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  end WeeklyWeatherForecast

  object SalaryRaiser:

    def smallPromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * 1.1)

    def greatPromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * salary)
  end SalaryRaiser

  object SalaryRaiser2:

    private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
      salaries.map(promotionFunction)

    def smallPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * 1.1)

    def greatPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * salary)
  end SalaryRaiser2

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String =

    val schema = if ssl then "https://" else "http://"
    (endpoint: String, query: String) =>
      s"$schema$domainName/$endpoint?$query"

  val domainName = "www.example.com"

  def getURL = urlBuilder(ssl = true, domainName)

  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
  println(url)


}
