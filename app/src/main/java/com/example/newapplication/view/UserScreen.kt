import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newapplication.model.UserResponse
import com.example.newapplication.viewmodel.UserViewModel


@Composable
fun UserScreen(viewModel: UserViewModel) {
    val user by viewModel.user.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }

    Column {
        if (user == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            UserItem(user!!)
        }
    }
}


@Composable
fun UserItem(user: UserResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "ID: ${user.id}",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "First Name: ${user.firstName}",
                style = MaterialTheme.typography.body1,
                color = Color.Blue,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Last Name: ${user.lastName}",
                style = MaterialTheme.typography.body1
            )
        }
    }
}