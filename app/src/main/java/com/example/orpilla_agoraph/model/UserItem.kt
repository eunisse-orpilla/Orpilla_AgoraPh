package com.example.orpilla_agoraph.model


import com.squareup.moshi.Json

data class UserItem(
    @Json(name = "login")
    var login: String? = "",
    @Json(name = "id")
    var id: Int? = 0,
    @Json(name = "node_id")
    var nodeId: String? = "",
    @Json(name = "avatar_url")
    var avatarUrl: String? = "",
    @Json(name = "gravatar_id")
    var gravatarId: String? = "",
    @Json(name = "url")
    var url: String? = "",
    @Json(name = "html_url")
    var htmlUrl: String? = "",
    @Json(name = "followers_url")
    var followersUrl: String? = "",
    @Json(name = "following_url")
    var followingUrl: String? = "",
    @Json(name = "gists_url")
    var gistsUrl: String? = "",
    @Json(name = "starred_url")
    var starredUrl: String? = "",
    @Json(name = "subscriptions_url")
    var subscriptionsUrl: String? = "",
    @Json(name = "organizations_url")
    var organizationsUrl: String? = "",
    @Json(name = "repos_url")
    var reposUrl: String? = "",
    @Json(name = "events_url")
    var eventsUrl: String? = "",
    @Json(name = "received_events_url")
    var receivedEventsUrl: String? = "",
    @Json(name = "type")
    var type: String? = "",
    @Json(name = "site_admin")
    var siteAdmin: Boolean? = false
)