package fr.dev.majdi.boxotop.core.presentation.navigation

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
sealed class NavRoute(val path: String) {

    object SplashScreen: NavRoute("splashScreen")

    object MovieCards: NavRoute("movieCards")

    object MovieDetail: NavRoute("movieDetail") {
        val id = "id"
    }

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }

}