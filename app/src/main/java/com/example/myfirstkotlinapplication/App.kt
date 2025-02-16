import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstkotlinapplication.NavBarBottom
import com.example.myfirstkotlinapplication.Routes
import com.example.myfirstkotlinapplication.pages.InfoPage
import com.example.myfirstkotlinapplication.pages.MenuPage
import com.example.myfirstkotlinapplication.pages.OfferPage
import com.example.myfirstkotlinapplication.pages.OrderPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    onNavigationClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Navigation menu"
                )
            }
        },
        actions = {
            // Search icon
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }

            // Overflow menu
            IconButton(onClick = { showMenu = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options"
                )
            }

            // Dropdown menu
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        showMenu = false
                        // Handle settings click
                    }
                )
                DropdownMenuItem(
                    text = { Text("About") },
                    onClick = {
                        showMenu = false
                        // Handle about click
                    }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Composable
fun App() {

        var selectedRoute = remember {
            mutableStateOf(Routes.MenuPage.route)
        }

    Scaffold(
        topBar = {
            MyAppBar(
                onNavigationClick = { /* Handle navigation click */ },
                onSearchClick = { /* Handle search click */ },
                onMenuClick = { /* Handle menu click */ }
            )
        },
        bottomBar = {
            NavBarBottom(
                selectedRoute = selectedRoute.value,
                onChange = {
                selectedRoute.value = it
            } )
        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
           when (selectedRoute.value) {
               Routes.MenuPage.route -> MenuPage()
               Routes.OfferPage.route -> OfferPage()
               Routes.OrderPage.route -> OrderPage()
               Routes.InfoPage.route -> InfoPage()
           }
        }
    }
}