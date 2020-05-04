# Github-artifacts-url
[![License: WTFPL](https://img.shields.io/badge/License-WTFPL-brightgreen.svg)](http://www.wtfpl.net/about/)
[![jitPack](https://jitpack.io/v/Ree-jp/GIthub-artifacts-url.svg)](https://jitpack.io/#Ree-jp/GIthub-artifacts-url)
![CI](https://github.com/Ree-jp/GIthub-artifacts-url/workflows/CI/badge.svg)
  
get github actions latest artifact url

# How to use
```Kotlin
val url = ArtifactUrl("https://api.github.com/repos/${owner}/${repo}").get(user, token)
```
