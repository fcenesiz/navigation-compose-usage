### dependency

``implementation "androidx.navigation:navigation-compose:2.5.3"``

### control of your navigation

````kotlin
@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Fatih"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(
                name = entry.arguments?.getString("name")
            )
        }
    }

}
````

### navigating

- ````kotlin
    navController.navigate(Screen.DetailScreen.withArgs(text))
    ````
  or u can use
- ````kotlin
    navController.navigate(Screen.DetailScreen.route + "/$name")
    ````

<img src="navigation-compose.gif" width=40%>

### to handle screens

````kotlin
sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
````