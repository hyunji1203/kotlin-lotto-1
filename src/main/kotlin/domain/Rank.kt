package domain

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000) {
        override fun toString(): String {
            return RANK_BONUS_MESSAGE.format(countOfMatch, winningMoney)
        }
    },
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    override fun toString(): String {
        return RANK_MESSAGE.format(countOfMatch, winningMoney)
    }

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank? {
            val rank = values().find { it.countOfMatch == countOfMatch }
            return when (rank) {
                SECOND, THIRD -> divideBonusRank(matchBonus)
                FIRST, FOURTH, FIFTH, MISS -> rank
                null -> rank
            }
        }

        fun divideBonusRank(matchBonus: Boolean): Rank {
            return when (matchBonus) {
                true -> SECOND
                false -> THIRD
            }
        }

        const val RANK_MESSAGE = "%d개 일치 (%d원)- "
        const val RANK_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- "
    }
}
