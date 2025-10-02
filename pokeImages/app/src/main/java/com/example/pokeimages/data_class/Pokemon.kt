package com.example.pokeimages.data_class

data class PokemonResponse(
    val results: List<PokemonItem>
)

data class PokemonItem(
    val name: String,
    val url: String
)

data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val artwork: Artwork,
    val weight: Int
)

data class Sprites(
    val front_default: String,
)

data class Versions(
    val generationvii: Generationvii
)

data class Generationvii(
    val ultrasunultramoon: Ultrasunultramooon
)

data class Ultrasunultramooon(
    val front_default:String
)

data class Artwork(
    val versions: Versions
)

data class AbilitiesResponse(
    val abilities: List<AbilitySlot>
)

data class AbilitySlot(
    val ability: AbilityDetail,
    val isHidden: Boolean,
    val slot: Int
)

data class AbilityDetail(
    val name: String,
    val url: String
)