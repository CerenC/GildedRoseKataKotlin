package com.gildedrose

class AgedBrieItemQualityUpdater : ItemQualityUpdater() {

    override fun update(item: Item) {
        item.sellIn -= 1

        item.quality = increase(quality = item.quality)
        if (item.sellIn < 0) item.quality = increase(quality = item.quality)
    }
}