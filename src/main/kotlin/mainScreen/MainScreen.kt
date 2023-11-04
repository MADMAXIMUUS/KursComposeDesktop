package mainScreen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun MainScreen(viewModel: MainScreenViewModel) {

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Данные ветрогенератора",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Column {
                OutlinedTextField(
                    value = state.screwD,
                    label = { Text(text = "Длина винта") },
                    placeholder = { Text(text = "00.0000") },
                    onValueChange = { viewModel.updateScrewD(it) },
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    isError = state.screwDError.isNotEmpty(),
                )
                Text(
                    text = state.screwDError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                OutlinedTextField(
                    value = state.screwKPD,
                    label = { Text(text = "КПД винта") },
                    placeholder = { Text(text = "00.0000") },
                    onValueChange = { viewModel.updateScrewKPD(it) },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    isError = state.screwKPDError.isNotEmpty(),
                )
                Text(
                    text = state.screwKPDError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
        }
        Row {
            Column {
                OutlinedTextField(
                    value = state.multiKPD,
                    label = { Text(text = "КПД мультиплексора") },
                    placeholder = { Text(text = "00.0000") },
                    onValueChange = { viewModel.updateMultiKPD(it) },
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    isError = state.multiKPDError.isNotEmpty(),
                )
                Text(
                    text = state.multiKPDError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                OutlinedTextField(
                    value = state.genKPD,
                    label = { Text(text = "КПД электрогенератора") },
                    placeholder = { Text(text = "00.0000") },
                    onValueChange = { viewModel.updateGenKPD(it) },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    isError = state.genKPDError.isNotEmpty(),
                )
                Text(
                    text = state.genKPDError,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Данные местоположения",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Название")
            Spacer(modifier = Modifier.width(5.dp))
            Switch(checked = state.isLatLon, onCheckedChange = { viewModel.updateCityChecked(it) })
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Координаты")
        }
        if (!state.isLatLon) {
            OutlinedTextField(
                value = state.city,
                label = { Text(text = "Населенный пункт") },
                placeholder = { Text(text = "Москва") },
                onValueChange = { viewModel.updateCity(it) },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
            )
        } else {
            Row {
                Column {
                    OutlinedTextField(
                        value = state.lat,
                        label = { Text(text = "Широта") },
                        placeholder = { Text(text = "00.0000") },
                        onValueChange = { viewModel.updateLat(it) },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        isError = state.latError.isNotEmpty(),
                    )
                    Text(
                        text = state.latError,
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    OutlinedTextField(
                        value = state.lon,
                        label = { Text(text = "Долгота") },
                        placeholder = { Text(text = "00.0000") },
                        onValueChange = { viewModel.updateLon(it) },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        isError = state.lonError.isNotEmpty(),
                    )
                    Text(
                        text = state.lonError,
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Дата и время",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "С")
            OutlinedTextField(
                value = state.startDate,
                label = { Text(text = "Дата") },
                placeholder = { Text(text = "01/01/1970") },
                onValueChange = { viewModel.updateStartDate(it) },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
            )
            OutlinedTextField(
                value = state.startTime,
                label = { Text(text = "Время") },
                placeholder = { Text(text = "00:00") },
                onValueChange = { viewModel.updateStartTime(it) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "До")
            OutlinedTextField(
                value = state.endDate,
                label = { Text(text = "Дата") },
                placeholder = { Text(text = "01/01/1970") },
                onValueChange = { viewModel.updateEndDate(it) },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
            )
            OutlinedTextField(
                value = state.endTime,
                label = { Text(text = "Время") },
                placeholder = { Text(text = "00:00") },
                onValueChange = { viewModel.updateEndTime(it) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.width(200.dp).height(50.dp),
            shape = RoundedCornerShape(12.dp),
            onClick = {

            }
        ){
            Text("Расcчитать")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Результат:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = state.result)
    }
}