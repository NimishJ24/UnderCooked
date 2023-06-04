package com.plcoding.bluetoothchat.presentation.components

fun countOccurrences(items: List<String>): Map<String, Int> {
    val itemCountMap = HashMap<String, Int>()

    for (item in items) {
        if (itemCountMap.containsKey(item)) {
            val count = itemCountMap[item]!!
            itemCountMap[item] = count + 1
        } else {
            itemCountMap[item] = 1
        }
    }

    return itemCountMap
}