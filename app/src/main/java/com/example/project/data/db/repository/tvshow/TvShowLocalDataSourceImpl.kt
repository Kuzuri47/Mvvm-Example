package com.example.project.data.db.repository.tvshow

import com.example.project.data.db.TvDao
import com.example.project.model.Tv
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvDao: TvDao):TvShowLocalDataSource {
    override suspend fun getTvFromDB(): List<Tv> {
        return tvDao.getAllTvshows()
    }

    override suspend fun saveTvFromDb(tvshows: List<Tv>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTv(tvshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteAllTvshows()
        }
    }
}