import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
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
import com.example.newapplication.model.PostResponse
import com.example.newapplication.viewmodel.PostViewModel


@Composable
fun PostScreen(viewModel: PostViewModel) {
    val posts by viewModel.post.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getPosts()
    }

    Column {
        if (posts == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            PostItem(posts!!)
        }
    }
}


@Composable
fun PostItem(post: PostResponse) {
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
                text = "ID: ${post.id}",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "UserId: ${post.userId}",
                style = MaterialTheme.typography.body1,
                color = Color.Blue,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Title: ${post.title}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Body: ${post.body}",
                style = MaterialTheme.typography.body1
            )
        }
    }
}