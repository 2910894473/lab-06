package com.example.lab_6

/**
 * Represents a wizard character that can cast spells using mana.
 *
 * A wizard has a name, current mana, and spell power stat. The
 * wizard needs sufficient mana to cast spells, and spell power
 * is used to calculate how much damage is dealt when a valid
 * spell is cast.
 *
 * @property name the name of the wizard
 * @property mana the current mana available for casting spells
 * @property spellPower the base power used for spell damage calculation
 */
class Wizard (val name:String,
              var mana:Int,
              var spellPower: Int
) {
    /**
     * Casts a spell and returns the damage dealt
     *
     * Supported spells:
     * - "Explosion": costs 10 mana, deals 3 × spellPower damage
     * - "Frostbite": costs 5 mana, deals 2 × spellPower damage
     *
     * If the wizard does not have enough mana or the spell name is invalid,
     * the spell fails and returns 0.
     *
     * @param spell the name of the spell to cast
     * @return the integer amount of damage dealt, or 0 if the spell fails
     */
    fun castSpell(spell: String): Int {
        when (spell) {
            "Explosion" -> {
                if (mana >= 10) {
                    mana -= 10
                    return spellPower *3
                } else return 0 //no enough mana
            }

            "Frostbite" -> {
                if (mana >= 5){
                    mana -= 5
                    return spellPower * 2
                } else return 0 //no enough mana
            }

            else -> {
                return 0 //invalid spell
            }
        }
    }
}