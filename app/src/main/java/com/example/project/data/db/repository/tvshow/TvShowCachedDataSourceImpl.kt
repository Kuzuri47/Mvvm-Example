package com.example.project.data.db.repository.tvshow

import com.example.project.model.Tv

class TvShowCachedDataSourceImpl:TvShowCachedDataSource {
    private var tvlist = ArrayList<Tv>()
    override suspend fun getTvShowsFromCache(): List<Tv> {
        return tvlist
    }

    override suspend fun saveTvToCache(tvshow: List<Tv>) {
        tvlist.clear()
        tvlist = ArrayList(tvshow)
    }
}