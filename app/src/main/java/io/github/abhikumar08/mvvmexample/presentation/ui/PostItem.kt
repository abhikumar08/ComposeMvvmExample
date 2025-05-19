package io.github.abhikumar08.mvvmexample.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PostItem(
    title: String = "Post Title",
    body: String = "Post body content goes here."
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(text = body, style = androidx.compose.material3.MaterialTheme.typography.bodyLarge)
    }
}

