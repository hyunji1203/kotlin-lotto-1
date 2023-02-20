package domain

class RandomLottoGenerator : LottoGenerator {
    override fun generateLottos(count: Int): Lottos {
        return Lottos(List(count) { generateLotto() })
    }

    private fun generateLotto(): Lotto {
        val randomNumbers = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).shuffled().subList(LOTTO_MIN_SIZE, LOTTO_LIMIT_SIZE).sorted()
        val lotto = randomNumbers.map { LottoNumber.from(it) }
        return Lotto(lotto)
    }

    companion object {
        const val LOTTO_LIMIT_SIZE = 6
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_MIN_SIZE = 0
    }
}
