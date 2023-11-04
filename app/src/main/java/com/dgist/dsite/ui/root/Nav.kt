package com.dgist.dsite.ui.root

sealed class NavGroup(val group: String) {

    object Post: NavGroup("post") {
        const val POST = "post"
        const val POST_INFO = "info/{id}"
    }
}