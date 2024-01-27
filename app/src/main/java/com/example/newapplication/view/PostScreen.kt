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
    val posts by viewModel.posts.observeAsState(null)

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
fun PostItem(posts: List<PostResponse>) {
    for (post in posts) {
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
                    style = MaterialTheme.typography.body1,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "UserId: ${post.userId}",
                    style = MaterialTheme.typography.h6,
                    color = Color.Blue,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Title: ${post.title}",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Body: ${post.body}",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}