package mainScreen

data class MainScreenState(
    val city: String = "",
    val lat: String = "",
    val latError: String = "",
    val lon: String = "",
    val lonError: String = "",
    val isLatLon: Boolean = false,
    val genKPD: String = "",
    val genKPDError: String = "",
    val screwD: String = "",
    val screwDError: String = "",
    val screwKPD: String = "",
    val screwKPDError: String = "",
    val multiKPD: String = "",
    val multiKPDError: String = "",
    val startDate: String = "",
    val startTime: String = "",
    val endDate: String = "",
    val endTime: String = "",
    val result: String = "",
)
