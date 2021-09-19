package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            ItemTypes.getUpdater(item.name).update(item)
        }
    }
}

