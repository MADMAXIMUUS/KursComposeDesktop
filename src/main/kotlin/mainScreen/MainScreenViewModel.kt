package mainScreen

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import util.ViewModel

class MainScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state

    fun updateScrewD(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        screwD = newValue,
                        screwDError = ""
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        screwD = newValue,
                        screwDError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun updateScrewKPD(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        screwKPD = newValue,
                        screwKPDError = ""
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        screwKPD = newValue,
                        screwKPDError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun updateMultiKPD(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        multiKPD = newValue,
                        multiKPDError = ""
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        multiKPD = newValue,
                        multiKPDError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun updateGenKPD(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        genKPD = newValue,
                        genKPDError = ""
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        genKPD = newValue,
                        genKPDError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun updateCity(newValue: String) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    city = newValue
                )
            }
        }
    }

    fun updateLat(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        lat = newValue,
                        latError = "",
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        lat = newValue,
                        latError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun updateLon(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        lon = newValue,
                        lonError = ""
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch {
                _state.update { currentState ->
                    currentState.copy(
                        lon = newValue,
                        lonError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun updateCityChecked(newValue: Boolean) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    isLatLon = newValue
                )
            }
        }
    }

    fun updateStartDate(newValue: String) {
        //val date = LocalDate.parse(newValue, DateTimeFormatter.ofPattern("DD/MM/YYYY"))
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    startDate = newValue
                )
            }
        }
    }

    fun updateStartTime(newValue: String) {
        //val time = LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm"))
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    startTime = newValue
                )
            }
        }
    }

    fun updateEndDate(newValue: String) {
        //val date = LocalDate.parse(newValue, DateTimeFormatter.ofPattern("DD/MM/YYYY"))
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    endDate = newValue
                )
            }
        }
    }

    fun updateEndTime(newValue: String) {
        //val time = LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm"))
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    endTime = newValue
                )
            }
        }
    }

}