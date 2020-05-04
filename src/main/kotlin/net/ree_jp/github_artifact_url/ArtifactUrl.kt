package net.ree_jp.github_artifact_url

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.*

class ArtifactUrl(private val url: URL) {

    fun getUrl(): URL {
        return getUrl("", "")
    }

    fun getUrl(user: String, token: String): URL {
        val json = getList(url, "$user:$token".toByteArray())
        val list = Gson().fromJson(json, GithubArtifactList::class.java)
        return URL(list.artifacts.first().archive_download_url)
    }

    private fun getList(url: URL, authorization: ByteArray): String {
        val con = url.openConnection()

        con.addRequestProperty("User-Agent", "Mozilla/5.0")
        con.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString(authorization))

        val reader = BufferedReader(InputStreamReader(con.getInputStream()))
        var line: String?
        val builder = StringBuilder()

        while (reader.readLine().also { line = it } != null) builder.append(line)

        return builder.toString()
    }
}