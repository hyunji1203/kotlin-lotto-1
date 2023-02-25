package domain

class Lottos(val lottos: List<Lotto>) {
    fun matchLottos(winningNumber: WinningNumber): WinningResult {
        val winningResult = Rank.values().associateWith {
            rank ->
            lottos.count { rank == it.matchLotto(winningNumber.lotto, winningNumber.bonusNumber) }
        }
        return WinningResult(winningResult)
    }

    operator fun plus(other: Lottos): Lottos {
        return Lottos(lottos + other.lottos)
    }
}
