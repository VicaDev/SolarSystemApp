package com.vicadev.solarsystemapp.data

import com.vicadev.solarsystemapp.R

fun ListObjects(): List<ItemsCelestials> {
    return listOf(
        ItemsCelestials(R.string.mercury_title, R.string.mercury_description, R.drawable.mercurio),
        ItemsCelestials(R.string.venus_title, R.string.venus_description, R.drawable.venus),
        ItemsCelestials(R.string.earth_title, R.string.earth_description, R.drawable.tierra),
        ItemsCelestials(R.string.mars_title, R.string.mars_description, R.drawable.marte),
        ItemsCelestials(R.string.jupiter_title, R.string.jupiter_description, R.drawable.jupiter),
        ItemsCelestials(R.string.satrun_title, R.string.saturn_description, R.drawable.saturno),
        ItemsCelestials(R.string.uranus_title, R.string.uranus_description, R.drawable.urano),
        ItemsCelestials(R.string.neptune_title, R.string.neptune_description, R.drawable.neptuno),


    )
}

fun ListMoons(): List<ItemsCelestials> {
    return listOf(//Lunas
        ItemsCelestials(R.string.moon_title, R.string.moon_description, R.drawable.luna),
        ItemsCelestials(R.string.deimos_title, R.string.deimos_description, R.drawable.deimos),
        ItemsCelestials(R.string.phobos_title, R.string.phobos_description, R.drawable.phobos),
        ItemsCelestials(R.string.callisto_title, R.string.callisto_description, R.drawable.callisto),
        ItemsCelestials(R.string.europe_title, R.string.europe_description, R.drawable.europa),
        ItemsCelestials(R.string.ganymede_title, R.string.ganymedes_description, R.drawable.ganymede),
        ItemsCelestials(R.string.io_title, R.string.io_description, R.drawable.io),
        ItemsCelestials(R.string.dione_title, R.string.dione_description, R.drawable.dione_saturn),
        ItemsCelestials(R.string.encelado_title, R.string.encelado_description, R.drawable.encelado_saturn),
        ItemsCelestials(R.string.febe_title, R.string.febe_description, R.drawable.febe_saturn),
        ItemsCelestials(R.string.japeto_title, R.string.japeto_description, R.drawable.japeto_saturn),
        ItemsCelestials(R.string.laomedeia_title, R.string.laomedeia_description, R.drawable.laomedeia_saturno),
        ItemsCelestials(R.string.mimas_title, R.string.mimas_description, R.drawable.mimas_saturn),
        ItemsCelestials(R.string.titan_title, R.string.titan_description, R.drawable.titan),
        ItemsCelestials(R.string.hyperion_title, R.string.hyperion_description, R.drawable.hyperion),
        ItemsCelestials(R.string.rea_title, R.string.rea_description, R.drawable.rea_saturn),
        ItemsCelestials(R.string.tethys_title, R.string.tethys_description, R.drawable.tethys_satrun),
        ItemsCelestials(R.string.ariel_title, R.string.ariel_description, R.drawable.ariel_urano),
        ItemsCelestials(R.string.miranda_title, R.string.miranda_description, R.drawable.miranda_urano),
        ItemsCelestials(R.string.oberon_title, R.string.oberon_description, R.drawable.oberon_urano),
        ItemsCelestials(R.string.titania_title, R.string.titania_description, R.drawable.titania_urano),
        ItemsCelestials(R.string.umbriel_title, R.string.umbriel_description, R.drawable.umbriel_urano),
        ItemsCelestials(R.string.neredia_title, R.string.neredia_description, R.drawable.neredia_neptuno),
        ItemsCelestials(R.string.neso_title, R.string.neso_description, R.drawable.neso_neptuno),
        ItemsCelestials(R.string.psamathe_title, R.string.psamathe_description, R.drawable.psamathe_neptuno),)
}