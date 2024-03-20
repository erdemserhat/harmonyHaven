package com.erdemserhat.harmonyhaven.presentation.home

import com.erdemserhat.harmonyhaven.domain.model.rest.Category
import com.erdemserhat.harmonyhaven.domain.usecase.article.Categories

data class HomeState(
    var categories: List<Category> = listOf(),
    var isCategoryReady:Boolean = false
)