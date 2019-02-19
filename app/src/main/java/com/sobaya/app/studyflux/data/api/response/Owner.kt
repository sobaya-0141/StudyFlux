package sobaya.app.studyflux.data.api.response

import com.squareup.moshi.Json

data class Owner (@Json(name = "avatar_url") val avatar: String, val login: String)