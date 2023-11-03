package com.dgist.dsite.ui.root

sealed class NavGroup(val id: String) {
    object Post: NavGroup("screen_post")
    object Test: NavGroup("screen_test")
}