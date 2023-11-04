import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {

}

fun main() = application {
    Window(
        title = "Нечаев Т12О-209М-22",
        state = WindowState(
            size = DpSize(800.dp, 820.dp)
        ),
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
